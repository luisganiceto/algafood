package com.algaworks.algafood.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class AlteracaoCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha coz1 = new Cozinha();
		coz1.setNomeCozinha("Japonesa");
		
		Cozinha coz2 = new Cozinha();
		coz2.setNomeCozinha("Chinesa");
		
		cadastroCozinha.salvar(coz1);
		cadastroCozinha.salvar(coz2);
		
		List<Cozinha> cozinhas = cadastroCozinha.listar();
		
		for (Cozinha cozinha : cozinhas) {
			System.out.println(cozinha.getNomeCozinha());
		}
		
	
	}
}
