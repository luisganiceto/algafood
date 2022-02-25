package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada."),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso."),
	ERRO_NEGOCIO("/erro-negocio", "Violação da regra de negócio"),
	MENSAGEM_INCOMPREENCIVEL("/mensagem-incompreensivel", "Mensagem incompreensivel"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos");
	
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) {
		this.uri = "https://api.algafood.com.br" + path;
		this.title = title;
	}
}
