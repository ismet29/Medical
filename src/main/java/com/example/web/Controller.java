package com.example.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.Service;

@RestController
public class Controller {
	
	Service service=new Service();
	
	@RequestMapping(value="/medecins", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Medecin> getListeVoiture(){		
		return service.listerMedecins();
	}
	
	@RequestMapping(value="/medecin", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void ajoutMedecin(@RequestBody com.example.web.Medecin medecin){		
		 service.ajouterMedecins(medecin);
	}
	
	
	@RequestMapping(value="/medecin/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public com.example.domain.Medecin modifierMedecin(@PathVariable("id") int id, @RequestBody com.example.web.Medecin medecin){
		
		return service.modifierMedecin(id,medecin);
	}
	
	@RequestMapping(value="/medecin/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public List<Medecin> supprimerMedecin(@PathVariable("id") int id ){
		
		return service.supprimerMedecin(id);
	}
	
	@RequestMapping(value="/medecinNom/{nom}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Medecin> chercherMedecinParNom(@PathVariable("nom") String nom){
		
		return service.chercherMedecinParNom2(nom);
	}
	
	@RequestMapping(value="/medecin/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public com.example.domain.Medecin chercherMedecinParId(@PathVariable("id") int id){
		
		return service.chercherMedecinParId(id);
	}
	
	
	@RequestMapping(value="/medecinVille/{ville}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Medecin> chercherMedecinParville(@PathVariable("ville") String ville){
		return service.chercherMedecinParville(ville);
	}
	
	@RequestMapping(value="/medecinSpc/{spc}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<com.example.web.Medecin> chercherMedecinParSpc(@PathVariable("spc") String spc){
		return service.chercherMedecinParSpc(spc);
	}
	
	@RequestMapping(value="/patients",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<com.example.web.Patient>listePatient(){
		
		return service.listePatient();
		
	}
	@RequestMapping(value="/patient", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void ajoutPatient(@RequestBody com.example.web.Patient patient){		
		 service.ajouterPatient(patient);
	}
	
	@RequestMapping(value="/patient/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public List<Patient> supprimerPatient(@PathVariable("id") int id){
		
		return service.supprimerPatient(id);
		
	}
	@RequestMapping(value="/patientNom/{nom}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Patient> chercherPatientParNom(@PathVariable("nom") String nom){
		
		return service.chercherPatientParNom2(nom);	
	}
	
	@RequestMapping(value="/patient/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public com.example.domain.Patient chercherPatientParId(@PathVariable("id") int id){
		
		return service.chercherPatientParId(id);
	}
	
	@RequestMapping(value="/patient/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public com.example.domain.Patient modifierPatient(@PathVariable("id") int id, @RequestBody com.example.web.Patient patient){
		
		return service.modifierPatient(id,patient);
		
	}
	
	
	@RequestMapping(value="/rdvmedecin/{nom}/{date}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<com.example.web.Rdv> listeRdvMedecin(@PathVariable("nom") String nom,@PathVariable("date") String date){
		return service.listeRdvMedecin(nom,date);
	}
	

	@RequestMapping(value="/rdvpatient/{nom}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<com.example.web.Rdv> listeRdvPatient(@PathVariable("nom") String nom){
		return service.listeRdvPatient(nom);
	}
	
	
	@RequestMapping(value="/rdv", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void ajoutRdv(@RequestBody com.example.web.Rdv rdv){		
		 service.ajouterRdv(rdv);
	}
	
	@RequestMapping(value="/rdv/{key}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public List<com.example.web.Rdv> supprimerRdv(@PathVariable("key") int key){	
		
		 return service.supprimerRdv(key);
	}
	
	
	@RequestMapping(value="/rdv", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<com.example.web.Rdv> listRdv(){		
		return service.listRdv();
	}
	
	
	@RequestMapping(value="/rdv/{key}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public com.example.web.Rdv rechercherRdv(@PathVariable("key") int key){		
		 return service.rechercherRdv(key);
	}
	
	@RequestMapping(value="/Authentification/{email}/{password}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public com.example.web.Medecin authentificationMedecin(@PathVariable("email") String email,@PathVariable("password") String password){
		return service.authentificationMedecin(email,password);
	}
	
	
	
	@RequestMapping(value="/AuthentificationPatient/{email}/{password}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public com.example.web.Patient authentificationPatient(@PathVariable("email") String email,@PathVariable("password") String password){
		System.out.println("hello");
		return service.authentificationPatient(email,password);
	}
}
