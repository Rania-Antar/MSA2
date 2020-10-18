package com.esprit.microservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Job implements Serializable {
	private static final long serialVersionUID = 6;
			
	@Id
	@GeneratedValue
	private int id;
    private String service;
    private boolean etat;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Job(String service) {
		super();
		this.service = service;
	}
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
