package com.example.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.domain.Medecin;

@Entity
public class Rdv {
	
	
	private int key;
	private String date;
	private String heure;
	
	private Medecin medecin;
	private Patient patient;
	private String nomMedecin;
	private String nomPatient;
	
	
	public Rdv(com.example.web.Rdv rdv) {
		super();
		this.key=rdv.getKey();
		this.date = rdv.getDate();
		this.heure = rdv.getHeure();
		this.medecin = rdv.getMedecin();
		this.patient=rdv.getPatient();
		this.nomMedecin=rdv.getNomMedecin();
		this.nomPatient=rdv.getNomPatient();
		//this.person = person;
	}
	
	public Rdv(com.example.domain.Rdv rdv) {
		super();
		this.date = rdv.getDate();
		this.heure = rdv.getHeure();
		this.medecin = rdv.getMedecin();
		this.patient=rdv.getPatient();
		this.nomMedecin=rdv.getNomMedecin();
		this.nomPatient=rdv.getNomPatient();
		//this.person = person;
	}
	
	public Rdv(String date, String heure, Medecin medecin,Patient p,String nomMedecin,String nomPatient) {
		super();
		this.date = date;
		this.heure = heure;
		this.medecin = medecin;
		this.patient=p;
		this.nomMedecin=nomMedecin;
		this.nomPatient=nomPatient;
		//this.person = person;
	}
	
	@ManyToOne
	@JoinColumn(name="CODE_MEDECIN")
	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
	@ManyToOne
	@JoinColumn(name="CODE_PATIENT")
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Rdv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id @GeneratedValue
	public int getKey() {
		return key;
	}


	public void setKey(int key) {
		this.key = key;
	}

	//@Temporal(TemporalType.DATE)
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}
	
}
