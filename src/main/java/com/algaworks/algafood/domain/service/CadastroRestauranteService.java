package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

//import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	private static final String MSG_RESTAURANTE_EM_USO = "Restaurante de código %d não pode ser removido, pois esta em uso com outra cidade.";
	private static final String MSG_RESTAURANTE_NAO_ENCONTRADO = "Não existe um cadastro de Restaurante com o código %d ";
	
	@Autowired
	private RestauranteRepository restauranteRepository;
		
	@Autowired
	private CadastroCozinhaService cozinhaService;
	
	public Restaurante salvar(Restaurante restaurante) {
		Cozinha cozinha = cozinhaService.buscarOuFalhar(restaurante.getCozinha().getId());
		
		restaurante.setCozinha(cozinha);
 		
		return restauranteRepository.save(restaurante);
	}
	
	public Restaurante buscarOuFalhar(Long id) {
		return restauranteRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, id)));
	}
	
/*	
	public void excluir(Long id) {
		try {
			cozinhaRepository.remover(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de Cozinha com o código %d ", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removida, pois esta em uso", id));
		}		
	}
*/	
}
