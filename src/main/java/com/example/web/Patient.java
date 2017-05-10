package com.example.web;

import java.util.Collection;

import com.example.domain.Rdv;

public class Patient extends Personne {
	
private Collection<Rdv> rdv;
	
	private int numeroSecu;
	private String cmu;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(com.example.domain.Patient patient){
		super(patient.getid(),patient.getNom(),patient.getPrenom(),patient.getSexe(),patient.getStatut(), patient.getVille(), 
				patient.getAdresse(), patient.getCodePostale(), patient.getPhoneNumber(),
				patient.getEmail(),patient.getPhotos(), patient.getPassword());
		this.rdv = patient.getRdv();
		this.numeroSecu = patient.getNumeroSecu();
		this.cmu = patient.getCmu();
		
	}
	
	public Patient(int id,String nom, String prenom, String sexe,String Statut, String ville, String adresse, String codePostale,
			String phoneNumber, String email,String photos, String password,Collection<Rdv> rdv, int numeroSecu, String cmu) {
		super(id,nom, prenom, sexe,Statut, ville, adresse, codePostale, phoneNumber, email,photos, password);
		// TODO Auto-generated constructor stub
		this.rdv = rdv;
		this.numeroSecu = numeroSecu;
		this.cmu = cmu;
	}
	
	public Patient(com.example.web.Patient patient){
		super(patient.getId(),patient.getNom(),patient.getPrenom(),patient.getSexe(),patient.getStatut(), patient.getVille(), 
				patient.getAdresse(), patient.getCodePostale(), patient.getPhoneNumber(),
				patient.getEmail(),patient.getPhotos(), patient.getPassword());
		this.rdv = patient.getRdv();
		this.numeroSecu = patient.getNumeroSecu();
		this.cmu = patient.getCmu();
		
	}
	
	public Collection<Rdv> getRdv() {
		return rdv;
	}
	public void setRdv(Collection<Rdv> rdv) {
		this.rdv = rdv;
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
	
	
	
	

}
