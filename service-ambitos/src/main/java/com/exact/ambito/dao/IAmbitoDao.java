package com.exact.ambito.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.ambito.entity.Ambito;


@Repository
public interface IAmbitoDao extends CrudRepository<Ambito, Long>{

	
	
}
