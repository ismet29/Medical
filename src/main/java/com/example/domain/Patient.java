package com.example.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.example.domain.Rdv;
import com.example.domain.Personne;

@Entity
@DiscriminatorValue("Patient")
public class Patient extends Personne {
	
	@OneToMany(mappedBy="patient",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Collection<Rdv> rdv;
	
	private int numeroSecu;
	private String cmu;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Patient(int id, String nom, String prenom, String sexe,String statut, String ville, String adresse, String codePostale,
			String phoneNumber, String email,String photos, String password, int numeroSecu, String cmu) {
		super(id,nom,prenom,sexe,statut,ville,adresse,codePostale,phoneNumber,email,photos,password);
		// TODO Auto-generated constructor stub
		
		this.numeroSecu = numeroSecu;
		this.cmu = cmu;
	}


	public Patient(Collection<Rdv> rdv, int numeroSecu, String cmu) {
		super();
		this.rdv = rdv;
		this.numeroSecu = numeroSecu;
		this.cmu = cmu;
	}

	
	public Patient(com.example.web.Patient patient){
		super(patient);
		this.rdv=patient.getRdv();
		this.numeroSecu=patient.getNumeroSecu();
		this.cmu=patient.getCmu();
	}
	
	
	
	
	
	public int getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(int numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public String getCmu() {
		return cmu;
	}

	public void setCmu(String cmu) {
		this.cmu = cmu;
	}
	
	public Collection<Rdv> getRdv() {
		return rdv;
	}

	public void setRdv(Collection<Rdv> rdv) {
		this.rdv = rdv;
	}

	






}