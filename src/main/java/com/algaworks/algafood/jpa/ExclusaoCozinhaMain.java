package com.algaworks.algafood.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class ExclusaoCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha coz = cadastroCozinha.buscar(1L);
		
		List<Cozinha> cozinhas = cadastroCozinha.listar();
		
		for (Cozinha cozinha : cozinhas) {
			System.out.println(cozinha.getNomeCozinha());
		}
		
		cadastroCozinha.remover(coz.getId());
					
		System.out.println("Após Exclusão.");				
		cozinhas = cadastroCozinha.listar();
		
		for (Cozinha cozinha : cozinhas) {
			System.out.println(cozinha.getNomeCozinha());
		}
		
	
	}
}
