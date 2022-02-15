package com.algaworks.algafood.domain.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
	
	// Busca o nome exato
	List<Cozinha> findByNomeCozinha(String nomeCozinha); 
	
	// Busca pelo nome da Cozinha, onde contem os mesmo caracteres do filtro.
	List<Optional<Cozinha>> findByNomeCozinhaContaining(String nomeCozinha); 
	
	// retorna true ou false para o filtro de nome da cozinha
	boolean existsByNomeCozinha(String nome);

}
