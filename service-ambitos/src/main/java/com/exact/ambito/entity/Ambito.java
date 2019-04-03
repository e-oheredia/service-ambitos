package com.exact.ambito.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Ambito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ambito_id")
	private Long id;
	@Column(nullable=false)
	private String nombre;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="ambito")
	@JsonIgnore
	private Set<SubAmbito> subAmbito;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<SubAmbito> getSubAmbito() {
		return subAmbito;
	}
	public void setSubAmbito(Set<SubAmbito> subAmbito) {
		this.subAmbito = subAmbito;
	}

	
	
}
