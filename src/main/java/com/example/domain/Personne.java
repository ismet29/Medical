package com.example.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.example.domain.Rdv;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING,length=3)
public abstract class Personne {
	
	@Id @GeneratedValue
	private int id;
	
	private String nom;
	private String prenom;
	private String sexe;
	private String statut;
	private String ville;
	private String adresse;
	private String codePostale;
	private String phoneNumber;
	private String email;
	private String photos;
	private String password;
	

	public Personne(int id, String nom, String prenom, String sexe,String statut, String ville, String adresse, String codePostale,
			String phoneNumber, String email,String photos, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.statut=statut;
		this.ville = ville;
		this.adresse = adresse;
		this.codePostale = codePostale;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.photos=photos;
		this.password = password;
	}
	
	
	
	public Personne(String nom, String prenom, String sexe, String statut,String ville, String adresse, String codePostale,
			String phoneNumber, String email, String photos,String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.statut=statut;
		this.ville = ville;
		this.adresse = adresse;
		this.codePostale = codePostale;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.photos=photos;
		this.password = password;
	}
	public Personne(com.example.web.Personne personne){
		this.nom = personne.getNom();
		this.prenom = personne.getPrenom();
		this.sexe = personne.getSexe();
		this.statut=personne.getStatut();
		this.ville = personne.getVille();
		this.adresse = personne.getAdresse();
		this.codePostale = personne.getCodePostale();
		this.phoneNumber = personne.getPhoneNumber();
		this.email = personne.getEmail();
		this.photos=personne.getPhotos();
		this.password = personne.getPassword();
	}
	





	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCodePostale() {
		return codePostale;
	}


	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Personne(int id) {
		super();
		this.id = id;
	}
	

	public int getid() {
		return id;
	}



	public void setid(int id) {
		this.id = id;
	}
	
	public String getPhotos() {
		return photos;
	}


	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}



}
