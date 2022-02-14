package com.algaworks.algafood.domain.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;


@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
	
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal); // Busca a Taxa Frete entre valores
	
	List<Restaurante> findByNomeRestauranteContainingAndCozinhaId(String nomeRestaurante, Long cozinha); // Busca pelo Nome do Restaurante que contem a variavel, e pelo Id da Cozinha
}
