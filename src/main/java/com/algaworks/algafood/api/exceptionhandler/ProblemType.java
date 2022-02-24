package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada."),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso."),
	ERRO_NEGOCIO("/erro-negocio", "Violação da regra de negócio"),
	MENSAGEM_INCOMPREENCIVEL("/mensagem-incompreensivel", "Mensagem incompreensivel");
	
	
	private String title;
	private String url;
	
	private ProblemType(String path, String title) {
		this.url = "https://api.algafood.com.br" + path;
		this.title = title;
	}
}
