package com.example.web;

import java.util.Collection;

import com.example.domain.Rdv;

public class Medecin extends Personne {
	private Collection<Rdv> rdv;
	private double prix;
	private String presentation;
	private String modepayement;
	private String spc;
	
	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Medecin(com.example.domain.Medecin medecin){
		super(medecin.getid(),medecin.getNom(), medecin.getPrenom(), medecin.getSexe(),medecin.getStatut(), medecin.getVille(), 
				medecin.getAdresse(), medecin.getCodePostale(), medecin.getPhoneNumber(),
				medecin.getEmail(),medecin.getPhotos(), medecin.getPassword());
		
		this.rdv=medecin.getRdv();
		
		this.prix=medecin.getPrix();
		this.presentation=medecin.getPresentation();
		this.modepayement=medecin.getModepayement();
		this.spc=medecin.getSpc();
	}
	
	public Medecin(int id,String nom, String prenom, String sexe, String Statut,String ville, String adresse, String codePostale,
			String phoneNumber, String email,String photos, String password,double prix, String presentation, String modepayement, String spc) {
		super(id,nom, prenom, sexe,Statut, ville, adresse, codePostale, phoneNumber, email,photos, password);
		// TODO Auto-generated constructor stub
		
		this.prix = prix;
		this.presentation = presentation;
		this.modepayement = modepayement;
		this.spc = spc;
	}
	public Medecin(com.example.web.Medecin medecin){
		super(medecin.getId(),medecin.getNom(), medecin.getPrenom(), medecin.getSexe(),medecin.getStatut(), medecin.getVille(), 
				medecin.getAdresse(), medecin.getCodePostale(), medecin.getPhoneNumber(),
				medecin.getEmail(),medecin.getPhotos(), medecin.getPassword());
		
		this.rdv=medecin.getRdv();
		
		this.prix=medecin.getPrix();
		this.presentation=medecin.getPresentation();
		this.modepayement=medecin.getModepayement();
		this.spc=medecin.getSpc();
	}
	
	
	public Collection<Rdv> getRdv() {
		return rdv;
	}
	public void setRdv(Collection<Rdv> rdv) {
		this.rdv = rdv;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public String getModepayement() {
		return modepayement;
	}
	public void setModepayement(String modepayement) {
		this.modepayement = modepayement;
	}
	public String getSpc() {
		return spc;
	}
	public void setSpc(String spc) {
		this.spc = spc;
	}
	
	
}