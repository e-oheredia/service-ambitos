package com.exact.ambito.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.ambito.entity.Ambito;
import com.exact.ambito.entity.SubAmbito;

@Repository
public interface ISubAmbitoDao extends CrudRepository<SubAmbito, Long>{

	@Query("FROM SubAmbito sa WHERE sa.ambito.id=?1")
	public Iterable<SubAmbito> listarSubAmbitoByAmbitoId(Long id);
	
}
