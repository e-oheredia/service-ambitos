package com.exact.ambito.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.exact.ambito.entity.SubAmbito;
import com.exact.ambito.service.interfaces.ISubAmbitoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/subambitos")
public class SubAmbitoController {

	@Autowired
	ISubAmbitoService subambitoService;
	
	@GetMapping
	public ResponseEntity<Iterable<SubAmbito>> listarAll() {
		return new ResponseEntity<Iterable<SubAmbito>>(subambitoService.listarAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SubAmbito> guardar(@RequestBody String subambito) {
		
		ObjectMapper mapper = new ObjectMapper();
		SubAmbito subambitoBD= new SubAmbito();
		try {
			subambitoBD = mapper.readValue(subambito, SubAmbito.class);
			subambitoBD.setActivo(true);
			return new ResponseEntity<SubAmbito>(subambitoService.guardar(subambitoBD) , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<SubAmbito> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SubAmbito> modificar(@PathVariable Long id, @RequestBody String subambito) {
		
		ObjectMapper mapper = new ObjectMapper();
		SubAmbito subambitoBD=null;
		try {
			subambitoBD = mapper.readValue(subambito, SubAmbito.class);
			subambitoBD.setId(id);
			return new ResponseEntity<SubAmbito>(subambitoService.guardar(subambitoBD) , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<SubAmbito> (HttpStatus.BAD_REQUEST);
		}
	}
	
}
