package com.algaworks.algafood.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.sun.net.httpserver.HttpsServer;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> handleEntidadeNaoEcontradaException(EntidadeNaoEncontradaException e, WebRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Problem problem = Problem.builder()
				.status(status.value())
				.type("https://api.algafood.com.br/entidade-nao-encontrada")
				.title("Entidade não Encontrada")
				.detail(e.getMessage())
				.build();
		
		return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<?> tratarEntidadeEmUsoException(EntidadeEmUsoException e, WebRequest request){
		
		return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> tratarNegocioException(NegocioException e, WebRequest request){
		
		return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
		
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		if (body == null) {
			body = Problem.builder()
					.status(status.value())
					.title(status.getReasonPhrase()).build();
		} else if (body instanceof String) {
			body = Problem.builder()
					.status(status.value())
					.title((String) body).build();
		}
		
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
}
