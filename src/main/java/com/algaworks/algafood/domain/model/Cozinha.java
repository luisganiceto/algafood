package com.algaworks.algafood.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.algaworks.algafood.core.validation.Groups;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@JsonRootName("cozinha") // Muda o nome do List XML
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {

	@NotNull(groups = Groups.CozinhaId.class )
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@JsonIgnore // Não mostra no arquivo JSON
	//@JsonProperty("titulo") // Muda o nome da propriedade no arquivo JSON
	@NotBlank
	@Column(length = 60)
	private String nomeCozinha;
	
	@OneToMany(mappedBy = "cozinha")
	private List<Restaurante> restaurantes;
	
}
