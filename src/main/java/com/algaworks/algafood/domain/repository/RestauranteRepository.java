package com.algaworks.algafood.domain.repository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;


@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
	
	// Busca a Taxa Frete entre valores
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal); 
	
	// Busca pelo Nome do Restaurante que contem a variavel, e pelo Id da Cozinha atraves de consulta JPQL
	@Query("from Restaurante where nome like %:nomeRestaurante% and cozinha.id = :id")
	List<Restaurante> consultaPorNome(String nomeRestaurante, @Param("id") Long cozinha);
		
	// Busca pelo Nome do Restaurante que contem a variavel, e pelo Id da Cozinha
	List<Restaurante> findByNomeRestauranteContainingAndCozinhaId(String nomeRestaurante, Long cozinha); 

	// Busca o primeiro restaurante que contem parte do filtro no nome 
	Optional<Restaurante> findFirstRestauranteByNomeRestauranteContaining(String nome);
	
	// Retorna os dois primeiros restaurantes que contem parte do filtro no nome
	List<Restaurante> findTop2ByNomeRestauranteContaining(String nome);
	
	// soma a quanditede de Restaurante que tem de determinada Cozinha
	int countByCozinhaId(Long cozinha);
	
	
	
}
