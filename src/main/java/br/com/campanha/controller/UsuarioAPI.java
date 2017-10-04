package br.com.campanha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanha.message.Result;
import br.com.campanha.message.UsuarioMessage;
import br.com.campanha.service.UsuarioServiceImpl;

@RestController
@RequestMapping("usuario")
public class UsuarioAPI {

	@Autowired
	private UsuarioServiceImpl service;

	@PostMapping(value = "/adicionar")
	public ResponseEntity<Result<UsuarioMessage>> adicionar(@RequestBody UsuarioMessage usuario) {
		return this.getResponseEntity(service.putNewUsuario(usuario));
	}

	@PutMapping(value = "/alterar")
	public ResponseEntity<Result<UsuarioMessage>> alterar(@RequestBody UsuarioMessage usuario) {
		return this.getResponseEntity(service.putUpdateUsuario(usuario));
	}

	@DeleteMapping(value = "/inativar/{usuarioId}")
	public ResponseEntity<Result<UsuarioMessage>> inativar(
			@PathVariable(name = "usuarioId", required = true) Long usuarioId) {
		return this.getResponseEntity(service.inativarUsuario(usuarioId));
	}

	private ResponseEntity<Result<UsuarioMessage>> getResponseEntity(Result<UsuarioMessage> baseResult) {
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<Result<UsuarioMessage>>(baseResult, httpHeaders, HttpStatus.OK);
	}
}