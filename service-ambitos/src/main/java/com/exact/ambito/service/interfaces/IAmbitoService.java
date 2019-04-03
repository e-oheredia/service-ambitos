package com.exact.ambito.service.interfaces;

import com.exact.ambito.entity.Ambito;


public interface IAmbitoService {
	
	public Iterable<Ambito> listarAll();
	Ambito listarBySubAmbitoId(Long id);
	
}
