package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

		@Autowired
		private CidadeRepository cidadeRepository;
		
		@Autowired
		private CadastroCidadeService cidadeService;
		
		@GetMapping
		public List<Cidade> listar(){
			return cidadeRepository.findAll();
		}
		
		@GetMapping(value = "/{id}")
		public Cidade buscar(@PathVariable Long id){
			return cidadeService.buscarOuFalhar(id);
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Cidade salvar(@RequestBody @Validated(Groups.CadastroCidade.class) Cidade cidade) {
			try {
				return cidadeService.salvar(cidade);
			} catch (EstadoNaoEncontradaException e) {
				throw new NegocioException(e.getMessage());
			}
		}
		
		@PutMapping(value = "/{id}")
		public Cidade atualizar(@PathVariable Long id, @RequestBody @Validated(Groups.CadastroCidade.class) Cidade cidade){
			Cidade cidadeAtualizado = cidadeService.buscarOuFalhar(id);

			BeanUtils.copyProperties(cidade, cidadeAtualizado, "id"); 
			try {
				return cidadeService.salvar(cidadeAtualizado);				
			} catch (EstadoNaoEncontradaException e) {
				throw new NegocioException(e.getMessage());
			}
		}
		
		@DeleteMapping(value = "/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void remover(@PathVariable Long id){
			cidadeService.remover(id);
		}

}
