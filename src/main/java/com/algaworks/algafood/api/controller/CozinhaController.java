package com.algaworks.algafood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.Groups;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@RestController
@RequestMapping(value = "/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cozinhaService;
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.findAll();
	}
	
	
	@GetMapping(value = "/{id}")
	public Cozinha buscar(@PathVariable Long id){
		return cozinhaService.buscarOuFalhar(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha salvar(@RequestBody @Validated(Groups.CadastroCozinha.class) Cozinha cozinha){
		return cozinhaService.salvar(cozinha);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha atualizar(@PathVariable Long id, @RequestBody @Validated(Groups.CadastroCozinha.class) Cozinha cozinha){
		Cozinha cozinhaAtual = cozinhaService.buscarOuFalhar(id);

		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id"); 
		return cozinhaService.salvar(cozinhaAtual);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id){
		cozinhaService.excluir(id);
	}
			
}
