package br.com.campanha.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanha.domain.Result;
import br.com.campanha.stream.ProcuraVogalStream;

@RestController
@RequestMapping("stream")
public class StreamAPI {

	@GetMapping(value = "/findVogal/{stream}")
	public ResponseEntity<Result<String>> findVogal(@PathVariable(name = "stream", required = true) String stream) {
		String charr = ProcuraVogalStream.findFirstChar(stream);
		if (charr == null) {
			return this.getResponseEntity(new Result<String>(false, "Infelizmente n�o encontramos a vogal..."));
		}
		return this.getResponseEntity(new Result<String>(true, charr));
	}

	private ResponseEntity<Result<String>> getResponseEntity(Result<String> baseResult) {
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<Result<String>>(baseResult, httpHeaders, HttpStatus.OK);
	}

}