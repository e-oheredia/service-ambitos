package com.exact.ambito.controller;


import java.io.IOException;

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

import com.exact.ambito.entity.Ambito;
import com.exact.ambito.entity.SubAmbito;
import com.exact.ambito.service.interfaces.IAmbitoService;
import com.exact.ambito.service.interfaces.ISubAmbitoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/ambitos")
public class AmbitoController {

	@Autowired
	IAmbitoService ambitoService;
	
	@Autowired
	ISubAmbitoService subambitoService;
	
	@GetMapping
	public ResponseEntity<Iterable<Ambito>> listarAll() {
		return new ResponseEntity<Iterable<Ambito>>(ambitoService.listarAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/subambitos")
	public ResponseEntity<Iterable<SubAmbito>> listarBySubAmbitoId(@PathVariable Long id){
		return new ResponseEntity<Iterable<SubAmbito>>(subambitoService.listarSubAmbitosByAmbitoId(id) , HttpStatus.OK);
	}
	
	
}
