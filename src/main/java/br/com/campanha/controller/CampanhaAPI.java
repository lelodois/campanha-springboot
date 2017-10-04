package br.com.campanha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanha.message.Result;
import br.com.campanha.message.CampanhaMessage;
import br.com.campanha.service.CampanhaSearchServiceImpl;
import br.com.campanha.service.CampanhaServiceImpl;

@RestController
@RequestMapping("campanha")
public class CampanhaAPI {

	@Autowired
	private CampanhaServiceImpl service;

	@Autowired
	private CampanhaSearchServiceImpl searchService;

	@PostMapping(value = "/adicionar")
	public ResponseEntity<Result<CampanhaMessage>> adicionar(
			@RequestBody(required = true) CampanhaMessage campanha) {
		return this.getResponseEntity(service.putNewCampanha(campanha));
	}

	@PutMapping(value = "/alterar")
	public ResponseEntity<Result<CampanhaMessage>> alterar(@RequestBody(required = true) CampanhaMessage campanha) {
		return this.getResponseEntity(service.putUpdateCampanha(campanha));
	}

	@GetMapping(value = "/listar/programadas/{timeId}")
	public ResponseEntity<Result<List<CampanhaMessage>>> listarProgramadas(
			@PathVariable(name = "timeId", required = true) Long timeId) {
		return this.getResponseEntityByList(searchService.listCampanhasProgramadas(timeId));
	}

	@DeleteMapping(value = "/inativar/{campanhaId}")
	public ResponseEntity<Result<CampanhaMessage>> inativar(
			@PathVariable(name = "campanhaId", required = true) Long campanhaId) {
		return this.getResponseEntity(service.inativarCampanha(campanhaId));
	}

	@GetMapping(value = "/listar/alteradas")
	public ResponseEntity<Result<List<CampanhaMessage>>> listarAlteradas() {
		return this.getResponseEntityByList(searchService.listAlteradas());
	}

	private ResponseEntity<Result<CampanhaMessage>> getResponseEntity(Result<CampanhaMessage> baseResult) {
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<Result<CampanhaMessage>>(baseResult, httpHeaders, HttpStatus.OK);
	}

	private ResponseEntity<Result<List<CampanhaMessage>>> getResponseEntityByList(
			Result<List<CampanhaMessage>> baseResult) {
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<Result<List<CampanhaMessage>>>(baseResult, httpHeaders, HttpStatus.OK);
	}

}