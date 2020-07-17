package webservice;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.Query;

import entities.Adresse;
import entities.CompteMembre;
import entities.Membre;
import entities.ProfileMembre;
import entities.service.ServiceLocal;

@WebService
@Stateless
public class KredinetService {
/*
	@EJB
	private ServiceLocal metier;
	@WebMethod(operationName="ListerComptes")
	public List<CompteMembre> listerComptesMembre(){
	return metier.listerCompte();
	}
	
	@WebMethod(operationName="ListerCompte")
	public List<CompteMembre> listerCompteMembre(@WebParam(name="noCompte")String noCompte){
	return metier.listerCompte();
	}
	
	@WebMethod(operationName="rechercherCompte")
	public CompteMembre getCompte(@WebParam(name="noCompte") String noCompte){
		CompteMembre cm=metier.getCompte(noCompte);
return cm;	
	}*/
	
/*	
	@WebMethod(operationName="creerCompte")
	public void enregistrerCompte(@WebParam(name="departement") String departement,
			@WebParam(name="ville")String ville,@WebParam(name="numero")String numero,
			@WebParam(name="rue")String rue,
			@WebParam(name="email") String email,@WebParam(name="cin_nif")String cin_nif_me,
			@WebParam(name="nom")String nom_me,@WebParam(name="prenom")String prenom_me,
			@WebParam(name="sexe")String sexe_me,@WebParam(name="phone")String phone_me,
			@WebParam(name="naissance")String datenais_me){
			
			
			Adresse ad=new Adresse(departement, ville, numero, rue);
				CompteMembre cp=new CompteMembre(numCompte(),"Gourde",0.0,
						"Actif",new Date(),new Membre(email));
				ProfileMembre pm=new ProfileMembre(cin_nif_me,
						nom_me, prenom_me, sexe_me, phone_me, datenais_me,
						"Actif", new Date(), ad, cp);
						
		metier.enregistrer(cp, pm);
}
	@WebMethod(operationName="modifierCompte")
	public void mofifierCompte(@WebParam(name="departement") String departement,
			@WebParam(name="ville")String ville,@WebParam(name="numero")String numero,
			@WebParam(name="rue")String rue,@WebParam(name="noCompte") String noCompte,
			@WebParam(name="email") String email,@WebParam(name="cin_nif")String cin_nif_me,
			@WebParam(name="nom")String nom_me,@WebParam(name="prenom")String prenom_me,
			@WebParam(name="sexe")String sexe_me,@WebParam(name="phone")String phone_me,
			@WebParam(name="naissance")String datenais_me){
			
			
			Adresse ad=new Adresse(departement, ville, numero, rue);
				CompteMembre cp=new CompteMembre(noCompte,"Gourde",0.0,
						"Actif",new Date(),new Membre(email));
				ProfileMembre pm=new ProfileMembre(cin_nif_me,
						nom_me, prenom_me, sexe_me, phone_me, datenais_me,
						"Actif", new Date(), ad, cp);
						
		metier.modifier(cp, pm);
}
	
	//Membre
	
	
	@WebMethod(operationName="saveMembre")
	public void enregistrer(@WebParam(name="email")String email_me,
			@WebParam(name="password")String motdePasse) {
	metier.enregistrer(new Membre(email_me,motdePasse,new Date()));

	}*/

	/*@WebMethod(operationName="getMembre")
	public Membre rechercher(@WebParam(name="email")String email_me) {
		Membre mb=metier.rechercher(email_me);
		return mb;
	}



	@WebMethod(operationName="listerMembre")
	public List<Membre> listerMembre() {
 return metier.listerMembre();
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  String numCompte(){
		Random rd=new Random();
	
	String co=String.format("%s-%s-%s-%s", rd.nextInt(9999), 
			rd.nextInt(9999), rd.nextInt(9999), rd.nextInt(9999));
	return	co;
	}
}
