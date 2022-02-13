package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
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
			return cidadeRepository.listar();
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Cidade> buscar(@PathVariable Long id){
			Cidade cidade = cidadeRepository.buscar(id);
			
			if (cidade != null) {
				return ResponseEntity.ok(cidade);
			}
			
			return ResponseEntity.notFound().build();
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Cidade salvar(@RequestBody Cidade cidade) {
			return cidadeService.salvar(cidade);
		}
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @RequestBody Cidade cidade){
			Cidade cidadeAtualizado = cidadeRepository.buscar(id);

			if (cidadeAtualizado != null) {
				BeanUtils.copyProperties(cidade, cidadeAtualizado, "id"); 
				cidadeService.salvar(cidadeAtualizado);
				return ResponseEntity.ok(cidadeAtualizado);
			} else {
				return ResponseEntity.notFound().build();
			}	
		}
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Cidade> remover(@PathVariable Long id){
			try {
				cidadeService.remover(id);
				return ResponseEntity.noContent().build();
			} catch (EntidadeNaoEncontradaException e) {
				return ResponseEntity.notFound().build();
			} catch (EntidadeEmUsoException e) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}
}
