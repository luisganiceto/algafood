package com.algaworks.algafood;

import static org.hamcrest.CoreMatchers.equalTo;

import org.flywaydb.core.Flyway;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.DatabaseCleaner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
class CadastroCozinhaIT {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;

	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";
		
		databaseCleaner.clearTables();
		prepararDados();
	}
	
	@Test
	public void deveRetornarStatus200_QuandosConsultarCozinha() {
		
		RestAssured.given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(200);
	}
	
	@Test
	public void deveConterDuasCozinhas_QuandosConsultarCozinhas() {
		
		RestAssured.given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.body("", Matchers.hasSize(2));
	}
	
	@Test
	public void deveRetornarStatus201_QuandosCadastrarCozinha() {

		RestAssured.given()
			.body("{ \"nomeCozinha\": \"Chinesa\" }")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(201);
	}
	
	@Test
	public void deveRetornarRespostarEStatusCorretos_QuandoConsultarCozinhaExistente() {
		
		RestAssured.given()
			.pathParam("cozinhaId", 2)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(200)
			.body("nomeCozinha", equalTo("Americana"));
	}
	
	@Test
	public void deveRetornarCodigoNotFound_QuandoConsultarCozinhaNaoExistente() {
		
		RestAssured.given()
			.pathParam("cozinhaId", 200)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(404);
	}
	
	private void prepararDados() {
		Cozinha coz1 = new Cozinha();
		coz1.setNomeCozinha("Portuguesa");
		cozinhaRepository.save(coz1);
		
		Cozinha coz2 = new Cozinha();
		coz2.setNomeCozinha("Americana");
		cozinhaRepository.save(coz2);
		
	}
	
}
