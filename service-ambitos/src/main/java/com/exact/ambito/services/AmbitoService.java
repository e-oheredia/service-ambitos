package com.exact.ambito.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.ambito.dao.IAmbitoDao;
import com.exact.ambito.entity.Ambito;
import com.exact.ambito.service.interfaces.IAmbitoService;

@Service
public class AmbitoService implements IAmbitoService{

	@Autowired
	IAmbitoDao ambitoDao;
	
	@Override
	public Iterable<Ambito> listarAll() {
		return ambitoDao.findAll();
	}

	@Override
	public Ambito listarBySubAmbitoId(Long id) {
		Optional<Ambito> ambitoBD =	ambitoDao.findById(id);
		 if(ambitoBD.isPresent()) {
			 Ambito ambito = ambitoBD.get();
			 return ambito;
		 }
		 return null;
	}

}
