package com.exact.ambito.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.ambito.dao.ISubAmbitoDao;
import com.exact.ambito.entity.SubAmbito;
import com.exact.ambito.service.interfaces.ISubAmbitoService;


@Service
public class SubAmbitoService implements ISubAmbitoService {
	
	@Autowired
	ISubAmbitoDao subambitoDao;
	
	@Override
	public Iterable<SubAmbito> listarAll() {
		return subambitoDao.findAll();
	}

	@Override
	public SubAmbito listarById(Long id) {
		 Optional<SubAmbito> subambitobd =	subambitoDao.findById(id);
		 if(subambitobd.isPresent()) {
			 SubAmbito subambito = subambitobd.get();
			 return subambito;
		 }
		 return null;
	}

	@Override
	public SubAmbito guardar(SubAmbito subambito) {
		if(subambito.getNombre()!=null) {
			return subambitoDao.save(subambito);
		}
		return null;
	}

	@Override
	public Iterable<SubAmbito> listarSubAmbitosActivosByAmbitoId(Long id) {
		Iterable<SubAmbito> subambitos = subambitoDao.listarSubAmbitoByAmbitoId(id);
		List<SubAmbito> subambitolst = StreamSupport.stream(subambitos.spliterator(), false).collect(Collectors.toList());
		subambitolst.removeIf(subambito -> !subambito.isActivo());
		return subambitolst;
	}

}
