package com.example.web;

import java.util.Date;

import com.example.domain.Medecin;
import com.example.domain.Patient;

public class Rdv {
	
	private int key;
	private String date;
	private String heure;
	
	private Medecin medecin;
	private Patient patient;
	private String nomMedecin;
	private String nomPatient;
	
	
	public Rdv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rdv(com.example.domain.Rdv rdv) {
		super();
		this.key=rdv.getKey();
		this.date= rdv.getDate();
		this.heure = rdv.getHeure();
		this.medecin = rdv.getMedecin();
		this.patient=rdv.getPatient();
		this.nomMedecin=rdv.getNomMedecin();
		this.nomPatient=rdv.getNomPatient();
		//this.person = person;
	}

	

	public Rdv(String date, String heure, Medecin medecin, Patient patient, String nomMedecin, String nomPatient) {
		super();
		this.date = date;
		this.heure = heure;
		this.medecin = medecin;
		this.patient = patient;
		this.nomMedecin = nomMedecin;
		this.nomPatient = nomPatient;
	}
	

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}


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


	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
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
