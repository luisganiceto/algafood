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

import com.algaworks.algafood.core.validation.Groups;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

		@Autowired
		private EstadoRepository estadoRepository;
		
		@Autowired
		private CadastroEstadoService estadoService;
		
		@GetMapping
		public List<Estado> listar(){
			return estadoRepository.findAll();
		}
		
		@GetMapping(value = "/{id}")
		public Estado buscar(@PathVariable Long id){
			return estadoService.buscarOuFalhar(id);
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Estado salvar(@RequestBody @Validated(Groups.CadastroEstado.class) Estado estado) {
			return estadoService.salvar(estado);
		}
		
		@PutMapping(value = "/{id}")
		public Estado atualizar(@PathVariable Long id, @RequestBody @Validated(Groups.CadastroEstado.class) Estado estado){
			Estado estadoAtualizado = estadoService.buscarOuFalhar(id);

			BeanUtils.copyProperties(estado, estadoAtualizado, "id"); 
			return estadoService.salvar(estadoAtualizado);
				
		}
		
		@DeleteMapping(value = "/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void remover(@PathVariable Long id){
			estadoService.remover(id);
		}
}
