package com.example.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.example.domain.Rdv;
import com.example.domain.Personne;

@Entity
@DiscriminatorValue("Medecin")
public class Medecin extends Personne {
	private double prix;
	private String presentation;
	private String modepayement;
	private String spc;
	
	@OneToMany(mappedBy="medecin",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Collection<Rdv> rdv;
	

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


	
	
	public Collection<Rdv> getRdv() {
		return rdv;
	}

	public void setRdv(Collection<Rdv> rdv) {
		this.rdv = rdv;
	}

	


	
	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medecin(int id, String nom, String prenom, String sexe,String statut, String ville, String adresse, String codePostale,
			String phoneNumber, String email,String photos, String password) {
		super(id, nom, prenom, sexe,statut, ville, adresse, codePostale, phoneNumber, email,photos, password);
		// TODO Auto-generated constructor stub
	}

	public Medecin(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Medecin(int id, String nom, String prenom, String sexe,String statut, String ville, String adresse, String codePostale,
			String phoneNumber, String email,String photos, String password, double prix, String presentation, String modepayement,
			String spc) {
		super(id, nom, prenom, sexe,statut, ville, adresse, codePostale, phoneNumber, email,photos, password);
		this.prix = prix;
		this.presentation = presentation;
		this.modepayement = modepayement;
		this.spc = spc;
	}

	public Medecin(com.example.web.Medecin medecin){
		super(medecin.getNom(), medecin.getPrenom(), medecin.getSexe(),medecin.getStatut(), medecin.getVille(), 
				medecin.getAdresse(), medecin.getCodePostale(), medecin.getPhoneNumber(),
				medecin.getEmail(),medecin.getPhotos(), medecin.getPassword());
		
		this.rdv=medecin.getRdv();
		this.prix=medecin.getPrix();
		this.presentation=medecin.getPresentation();
		this.modepayement=medecin.getModepayement();
		this.spc=medecin.getSpc();
	}
	


}
