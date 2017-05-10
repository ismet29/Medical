package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.domain.Medecin;
import com.example.domain.Patient;
import com.example.domain.Rdv;

public class Service {
	
	EntityManager entityManager;
	
	public Service(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
	}
	
	public List<com.example.web.Medecin> listerMedecins(){
		List medecinsJPA = entityManager.createQuery("select m from Medecin m").getResultList();
		List<com.example.web.Medecin> medecinsDTO = new ArrayList<com.example.web.Medecin>();
			
		com.example.domain.Medecin jpa;
		for(int i=0; i<medecinsJPA.size(); i++){
			jpa = (com.example.domain.Medecin) medecinsJPA.get(i);
			com.example.web.Medecin dto = new com.example.web.Medecin(jpa.getid(),jpa.getNom(),
					jpa.getPrenom(),jpa.getSexe(),jpa.getStatut(),jpa.getVille(),jpa.getAdresse(),jpa.getCodePostale(),jpa.getPhoneNumber(),
					jpa.getEmail(),jpa.getPhotos(),jpa.getPassword(),jpa.getPrix(),jpa.getPresentation(), jpa.getModepayement(),jpa.getSpc());
			
			
			medecinsDTO.add(dto);
	
	}
		return medecinsDTO;

}
	
	public void ajouterMedecins(com.example.web.Medecin medecin){
		
		com.example.domain.Medecin medecinJPA=new com.example.domain.Medecin(medecin);
		EntityTransaction tx=entityManager.getTransaction();
		tx.begin();
		entityManager.persist(medecinJPA);	
		tx.commit();
	}
	
	public com.example.domain.Medecin modifierMedecin(int id,com.example.web.Medecin medecin){
		
		EntityTransaction tx=entityManager.getTransaction();
		
		com.example.domain.Medecin medecinJPA=new com.example.domain.Medecin(medecin);
		tx.begin();
		List<com.example.domain.Medecin>ListMedecin=entityManager.createQuery("select m from Medecin m where m.id like :id").setParameter("id", id).getResultList();
		
		medecinJPA=ListMedecin.get(0);
		medecinJPA.setNom(medecin.getNom());
		medecinJPA.setPrenom(medecin.getPrenom());
		medecinJPA.setSexe(medecin.getSexe());
		medecinJPA.setVille(medecin.getVille());
		medecinJPA.setAdresse(medecin.getAdresse());
		medecinJPA.setPhoneNumber(medecin.getPhoneNumber());
		medecinJPA.setEmail(medecin.getEmail());
		medecinJPA.setPhotos(medecin.getPhotos());
		medecinJPA.setPassword(medecin.getPassword());
		medecinJPA.setSpc(medecin.getSpc());
		medecinJPA.setPrix(medecin.getPrix());
		medecinJPA.setPresentation(medecin.getPresentation());
		medecinJPA.setModepayement(medecin.getModepayement());
		
	
		com.example.web.Medecin medWeb=new com.example.web.Medecin(medecinJPA);
		
		//supprimerMedecin(medWeb.getId());
		//entityManager.persist(medecinJPA);
		tx.commit();
		return medecinJPA;
	}
	
	public List<com.example.web.Medecin> supprimerMedecin(int id){
		//entityManager.createQuery("DELETE FROM Medecin m WHERE m.nom LIKE :nom").setParameter("nom", medecin.getNom());
		
		
		EntityTransaction tx=entityManager.getTransaction();
		
		 List patientsJPA=entityManager.createQuery("select p from Medecin p where p.id like :id").setParameter("id", id).getResultList();
		 
		List<com.example.web.Medecin> listWeb=new ArrayList<com.example.web.Medecin>();
		com.example.domain.Medecin jpa;
		com.example.web.Medecin web;
		for(int i=0;i<patientsJPA.size();i++){
			 jpa=(com.example.domain.Medecin) patientsJPA.get(i);
			// jpa=new Patient(web);
			 web=new com.example.web.Medecin(jpa);
			 listWeb.add(web);
			 tx.begin();
			 entityManager.remove(jpa);
			 tx.commit();
		}
		
		
		return  listWeb;
	}
	
	public com.example.domain.Medecin chercherMedecinParNom(String nom){
		EntityTransaction tx=entityManager.getTransaction();
		
		com.example.domain.Medecin medecinJPA=(com.example.domain.Medecin) entityManager.createQuery("select m from Medecin m where m.nom like :nom").setParameter("nom", nom).getSingleResult();
		
		System.out.println("hello: "+medecinJPA.getNom());
		return medecinJPA;
	
	}
	
	public com.example.domain.Medecin chercherMedecinParId(int id){
		EntityTransaction tx=entityManager.getTransaction();
		
		com.example.domain.Medecin medecinJPA=(com.example.domain.Medecin) entityManager.createQuery("select m from Medecin m where m.id like :id").setParameter("id", id).getSingleResult();
		
		System.out.println("hello: "+medecinJPA.getNom());
		return medecinJPA;
	
	}
	
	
	
	public List<com.example.web.Medecin> chercherMedecinParNom2(String nom){
	List medecinsJPA = entityManager.createQuery("select m from Medecin m where m.nom like :nom").setParameter("nom", nom).getResultList();

	List<com.example.web.Medecin> medecinsDTO = new ArrayList<com.example.web.Medecin>();
		
	com.example.domain.Medecin jpa;
	for(int i=0; i<medecinsJPA.size(); i++){
		jpa = (com.example.domain.Medecin) medecinsJPA.get(i);
		com.example.web.Medecin dto = new com.example.web.Medecin(jpa);
		
		System.out.println(dto.getId());
		medecinsDTO.add(dto);

}
	return medecinsDTO;
	}	
	
	
	public List<com.example.web.Medecin> chercherMedecinParville(String ville){
		
		List medecinsJPA = entityManager.createQuery("select m from Medecin m where m.ville like :ville").setParameter("ville", ville).getResultList();
	
		List<com.example.web.Medecin> medecinsDTO = new ArrayList<com.example.web.Medecin>();
			
		com.example.domain.Medecin jpa;
		for(int i=0; i<medecinsJPA.size(); i++){
			jpa = (com.example.domain.Medecin) medecinsJPA.get(i);
			com.example.web.Medecin dto = new com.example.web.Medecin(jpa.getid(),jpa.getNom(),
					jpa.getPrenom(),jpa.getSexe(),jpa.getStatut(),jpa.getVille(),jpa.getAdresse(),jpa.getCodePostale(),jpa.getPhoneNumber(),
					jpa.getEmail(),jpa.getPhotos(),jpa.getPassword(),jpa.getPrix(),jpa.getPresentation(), jpa.getModepayement(),jpa.getSpc());
			
			
			medecinsDTO.add(dto);
	
	}
		return medecinsDTO;

	
		
		/*com.example.domain.Medecin medecinJPA=(com.example.domain.Medecin) entityManager.createQuery("select m from Medecin m where m.ville like :nom").setParameter("ville", medecin.getNom()).getSingleResult();
		return medecinJPA;*/
	
	}
	
	public List<com.example.web.Medecin> chercherMedecinParSpc(String spc){
		List <com.example.domain.Medecin>listMedecinJPA=entityManager.createQuery("select m from Medecin m where m.spc like :spc").setParameter("spc", spc).getResultList();
		List<com.example.web.Medecin> listMedecinWeb=new ArrayList<>();
		com.example.web.Medecin medecinWeb;
		com.example.domain.Medecin medecinJPA;
		for (int i=0;i<listMedecinJPA.size();i++){
			medecinJPA = listMedecinJPA.get(i);
			medecinWeb=new com.example.web.Medecin(listMedecinJPA.get(i));
			listMedecinWeb.add(medecinWeb);
		}
		
		return listMedecinWeb;
	
	}
	
	public void ajouterPatient(com.example.web.Patient patient){
		com.example.domain.Patient patientJPA=new com.example.domain.Patient(patient);
		EntityTransaction tx=entityManager.getTransaction();
		tx.begin();
		entityManager.persist(patientJPA);	
		tx.commit();	
	}
	
	public List<com.example.web.Patient> listePatient(){
		 List patientsJPA=entityManager.createQuery("select p from Patient p").getResultList();
		 List<com.example.web.Patient> patientsDTO = new ArrayList<com.example.web.Patient>();
			
			com.example.domain.Patient jpa;
			for(int i=0; i<patientsJPA.size(); i++){
				jpa = (com.example.domain.Patient) patientsJPA.get(i);
				com.example.web.Patient dto = new com.example.web.Patient(jpa.getid(),jpa.getNom(),
						jpa.getPrenom(),jpa.getSexe(),jpa.getStatut(),jpa.getVille(),jpa.getAdresse(),  jpa.getCodePostale(),
						jpa.getPhoneNumber(),jpa.getEmail(),jpa.getPhotos(),jpa.getPassword(),jpa.getRdv()
						,jpa.getNumeroSecu(),jpa.getCmu());
			
				patientsDTO.add(dto);
			
			
		
		}
			return patientsDTO;
		 
	}
	
	public List<com.example.web.Patient> supprimerPatient(int id){
		EntityTransaction tx=entityManager.getTransaction();
		
		 List patientsJPA=entityManager.createQuery("select p from Patient p where p.id like :id").setParameter("id", id).getResultList();
		 
		List<com.example.web.Patient> listWeb=new ArrayList<com.example.web.Patient>();
		com.example.domain.Patient jpa;
		com.example.web.Patient web;
		for(int i=0;i<patientsJPA.size();i++){
			 jpa=(com.example.domain.Patient) patientsJPA.get(i);
			// jpa=new Patient(web);
			 web=new com.example.web.Patient(jpa);
			 listWeb.add(web);
			 tx.begin();
			 entityManager.remove(jpa);
			 tx.commit();	 
		}
		
		//com.example.domain.Patient patientJPA=(Patient) entityManager.createQuery("delete from Patient p where p.nom like: nom").setParameter("nom", patient.getNom()).getSingleResult();
		return listWeb;
	}
	
	public com.example.domain.Patient chercherPatientParNom(String nom){
		com.example.domain.Patient patientJPA=(Patient) entityManager.createQuery("select p from Patient p where p.nom like :nom").setParameter("nom", nom).getSingleResult();
		return patientJPA;
	}
	
	
	public List<com.example.web.Patient> chercherPatientParNom2(String nom){
		 List patientsJPA=entityManager.createQuery("select p from Patient p where p.nom like :nom").setParameter("nom", nom).getResultList();
		 List<com.example.web.Patient> patientsDTO = new ArrayList<com.example.web.Patient>();
			
			com.example.domain.Patient jpa;
			for(int i=0; i<patientsJPA.size(); i++){
				jpa = (com.example.domain.Patient) patientsJPA.get(i);
				com.example.web.Patient dto = new com.example.web.Patient(jpa.getid(),jpa.getNom(),
						jpa.getPrenom(),jpa.getSexe(),jpa.getStatut(),jpa.getVille(),jpa.getAdresse(),  jpa.getCodePostale(),
						jpa.getPhoneNumber(),jpa.getEmail(),jpa.getPhotos(),jpa.getPassword(),jpa.getRdv()
						,jpa.getNumeroSecu(),jpa.getCmu());
			
				patientsDTO.add(dto);
		
		}
			return patientsDTO;
	}
	
	
	public com.example.domain.Patient chercherPatientParId(int id){
		EntityTransaction tx=entityManager.getTransaction();
		
		com.example.domain.Patient medecinJPA=(com.example.domain.Patient) entityManager.createQuery("select m from Patient m where m.id like :id").setParameter("id", id).getSingleResult();
		
		System.out.println("hello: "+medecinJPA.getNom());
		return medecinJPA;
	
	}
	
	
	public com.example.domain.Patient modifierPatient(int id,com.example.web.Patient pat){
		
		EntityTransaction tx=entityManager.getTransaction();
		tx.begin();
		
		List<com.example.domain.Patient> listPatient=entityManager.createQuery("select m from Patient m where m.id like :id ").setParameter("id", id).getResultList();
		com.example.domain.Patient patientJPA=listPatient.get(0);
		
		System.out.println(pat.getSexe());
		
		patientJPA.setNom(pat.getNom());
		patientJPA.setPrenom(pat.getPrenom());
		patientJPA.setSexe(pat.getSexe());
		patientJPA.setVille(pat.getVille());
		patientJPA.setAdresse(pat.getAdresse());
		patientJPA.setPhoneNumber(pat.getPhoneNumber());
		patientJPA.setEmail(pat.getEmail());
		patientJPA.setPhotos(pat.getPhotos());
		patientJPA.setPassword(pat.getPassword());
		patientJPA.setNumeroSecu(pat.getNumeroSecu());
		patientJPA.setCmu(pat.getCmu());
		tx.commit();
		

		return patientJPA;
	}
	
	public List<com.example.web.Rdv> listeRdvMedecin(String nom,String date){
		List rdvJPA=entityManager.createQuery("select r from Rdv r where r.nomMedecin like :nom").setParameter("nom",nom).getResultList();
		 List<com.example.web.Rdv> rdvDTO = new ArrayList<com.example.web.Rdv>();
			
			com.example.domain.Rdv jpa;
			for(int i=0; i<rdvJPA.size(); i++){
				jpa = (com.example.domain.Rdv) rdvJPA.get(i);
				
				
				if (jpa.getDate().equals(date))
		           { 
		        	 
		        	   com.example.web.Rdv dto = new com.example.web.Rdv(jpa);
		        	   rdvDTO.add(dto);
		           }
				
				
			
				
			
			
		
		}
		return rdvDTO;
	}
	
	public List<com.example.web.Rdv> listeRdvPatient(String nom){
		List rdvJPA=entityManager.createQuery("select r from Rdv r where r.nomPatient like :nom").setParameter("nom",nom).getResultList();
		 List<com.example.web.Rdv> rdvDTO = new ArrayList<com.example.web.Rdv>();
			
			com.example.domain.Rdv jpa;
			for(int i=0; i<rdvJPA.size(); i++){
				jpa = (com.example.domain.Rdv) rdvJPA.get(i);
				com.example.web.Rdv dto = new com.example.web.Rdv(jpa);
			
				rdvDTO.add(dto);
			
			
		
		}
		return rdvDTO;
	
	}	
	
	public com.example.web.Rdv ajouterRdv(com.example.web.Rdv rdv){
		EntityTransaction tx=entityManager.getTransaction();
		com.example.domain.Rdv rdvJPA=new com.example.domain.Rdv(rdv);
		
		tx.begin();
		entityManager.persist(rdvJPA);
		tx.commit();
		
		return rdv;
	}
	
	public com.example.web.Rdv rechercherRdv(int key){
		List<com.example.domain.Rdv>listRdv=entityManager.createQuery("select r from Rdv r where r.key like :key").setParameter("key", key).getResultList();
		com.example.web.Rdv rdvWeb=new com.example.web.Rdv(listRdv.get(0));
		
		List<com.example.web.Rdv> rdvWebb=new ArrayList<>();
		com.example.web.Rdv rdv1;
		for(int i=0;i<listRdv.size();i++){
			rdv1=new com.example.web.Rdv(listRdv.get(i));
			rdvWebb.add(rdv1);
			
		}
	
		System.out.println(rdvWeb.getKey());
		return rdvWeb;
	}
	
	public List<com.example.web.Rdv> supprimerRdv(int key){
		System.out.println("voila la clé: "+key);
		
		List listRdv=entityManager.createQuery("select r from Rdv r where r.key like :key").setParameter("key", key).getResultList();
		
		List<com.example.web.Rdv>listRdvWeb=new ArrayList<>();
		EntityTransaction tx=entityManager.getTransaction();
		com.example.domain.Rdv rdvJPA;
		com.example.web.Rdv rdvWeb;
		System.out.println(listRdv.size());
		for(int i=0;i<listRdv.size();i++){
			
		System.out.println("je rentre");
		rdvJPA=(com.example.domain.Rdv) listRdv.get(i);
		System.out.println(rdvJPA.getKey());
		rdvWeb=new com.example.web.Rdv(rdvJPA);
		tx.begin();
		entityManager.remove(rdvJPA);
		tx.commit();
		}
		return listRdvWeb;
	}
	
	public List<com.example.web.Rdv> listRdv(){
		List medecinsJPA = entityManager.createQuery("select m from Rdv m").getResultList();
		List<com.example.web.Rdv> medecinsDTO = new ArrayList<com.example.web.Rdv>();
			
		com.example.domain.Rdv jpa;
		com.example.web.Rdv web = null;
		for(int i=0; i<medecinsJPA.size(); i++){
			web=new com.example.web.Rdv((Rdv) medecinsJPA.get(i));
			System.out.println(web.getHeure());
			medecinsDTO.add(web);
	}
		return medecinsDTO;

	}

	public com.example.web.Medecin authentificationMedecin(String email,String password){
		
		System.out.println("################################################");
		List<com.example.domain.Medecin>ListMedecin=entityManager.createQuery("select m from Medecin m where m.email like :email").setParameter("email", email).getResultList();
		for (int i=0;i<ListMedecin.size();i++)
        {
			
			com.example.domain.Medecin medecinJPA=ListMedecin.get(i);
			System.out.println(medecinJPA.getPassword());
			if (medecinJPA.getPassword().equals(password))
	           { 
	        	   System.out.println("trouver"+medecinJPA.getNom());
	        	   com.example.web.Medecin medecinWeb=new com.example.web.Medecin(medecinJPA);
	        	   return medecinWeb;
	           }
			

        }
              return null;
	}
	
public com.example.web.Patient authentificationPatient(String email,String password){
		
		System.out.println("################################################");
		List<com.example.domain.Patient>ListMedecin=entityManager.createQuery("select m from Patient m where m.email like :email").setParameter("email", email).getResultList();
		System.out.println(ListMedecin.size());
		for (int i=0;i<ListMedecin.size();i++)
        {
			com.example.domain.Patient medecinJPA=ListMedecin.get(i);
			System.out.println(medecinJPA.getPassword());
			if (medecinJPA.getPassword().equals(password))
	           { 
	        	   System.out.println("trouver"+medecinJPA.getNom());
	        	   com.example.web.Patient medecinWeb=new com.example.web.Patient(medecinJPA);
	        	   return medecinWeb;
	           }
			

        }
              return null;
	}
}