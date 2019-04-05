package com.exact.ambito.service.interfaces;


import com.exact.ambito.entity.Ambito;
import com.exact.ambito.entity.SubAmbito;

public interface ISubAmbitoService {

	public Iterable<SubAmbito> listarAll();
	SubAmbito listarById(Long id);
	SubAmbito guardar(SubAmbito subambito);
	public Iterable<SubAmbito> listarSubAmbitosActivosByAmbitoId(Long id);
	
}
