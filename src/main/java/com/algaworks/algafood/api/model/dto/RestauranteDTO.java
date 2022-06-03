package com.algaworks.algafood.api.model.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RestauranteDTO {

	private Long id;
	private String nomeRestaurante;
	private BigDecimal taxaFrete;
	private CozinhaDTO cozinha;
	
}
