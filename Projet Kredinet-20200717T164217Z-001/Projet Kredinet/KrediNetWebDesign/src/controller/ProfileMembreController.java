package controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.sun.org.apache.bcel.internal.generic.DSTORE;

import controller.login.Connexion;
import entities.Adresse;
import entities.CompteMembre;
import entities.MobiliteMembre;
import entities.ProfileMembre;
import entities.service.ServiceLocal;

@ManagedBean(name="profilMB")
@RequestScoped
public class ProfileMembreController {

	@EJB
	private ServiceLocal dao;
	
private boolean showSearchButton;
private boolean showUpdateButton;

	public boolean isShowSearchButton() {
	return showSearchButton;
}
public void setShowSearchButton(boolean showSearchButton) {
	this.showSearchButton = showSearchButton;
}
public boolean isShowUpdateButton() {
	return showUpdateButton;
}
public void setShowUpdateButton(boolean showUpdateButton) {
	this.showUpdateButton = showUpdateButton;
}

	private String cin_nif_me;
	private String nom_me;
	private String prenom_me;
	private String sexe_me;
	private String phone_me;
	private String datenais_me;
	private String departement;
	private String ville;
	private String numero;
	private String rue;
	private String noCompte;
	
	public String getNoCompte() {
		return noCompte;
	}
	public void setNoCompte(String noCompte) {
		this.noCompte = noCompte;
	}
	public String getCin_nif_me() {
		return cin_nif_me;
	}
	public void setCin_nif_me(String cin_nif_me) {
		this.cin_nif_me = cin_nif_me;
	}
	public String getNom_me() {
		return nom_me;
	}
	public void setNom_me(String nom_me) {
		this.nom_me = nom_me;
	}
	public String getPrenom_me() {
		return prenom_me;
	}
	public void setPrenom_me(String prenom_me) {
		this.prenom_me = prenom_me;
	}
	public String getSexe_me() {
		return sexe_me;
	}
	public void setSexe_me(String sexe_me) {
		this.sexe_me = sexe_me;
	}
	public String getPhone_me() {
		return phone_me;
	}
	public void setPhone_me(String phone_me) {
		this.phone_me = phone_me;
	}
	public String getDatenais_me() {
		return datenais_me;
	}
	public void setDatenais_me(String datenais_me) {
		this.datenais_me = datenais_me;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public Connexion getC() {
		return c;
	}

	public void setC(Connexion c) {
		this.c = c;
	}

	Connexion c=new Connexion();
	

	public String getInfos(){
		CompteMembre compteMembre=dao.getCompte(noCompte);
	if(compteMembre==null ){
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le numero de compte est invalide","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
			
		else if(!compteMembre.getEmail_me().getEmail_me().equals(c.getEmail())){
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez vous connecter sur votre compte","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
		else
			System.out.println("cin_nif_me="+compteMembre.getProfileMembre().getCin_nif_me());
		    cin_nif_me=compteMembre.getProfileMembre().getCin_nif_me();
			nom_me=compteMembre.getProfileMembre().getNom_me();
			prenom_me=compteMembre.getProfileMembre().getPrenom_me();
			sexe_me=compteMembre.getProfileMembre().getSexe_me();
			phone_me=compteMembre.getProfileMembre().getPhone_me();
			datenais_me=compteMembre.getProfileMembre().getDatenais_me();
			departement=compteMembre.getProfileMembre().getAdresse().getDepartement();
		    ville=compteMembre.getProfileMembre().getAdresse().getVille();
			numero=compteMembre.getProfileMembre().getAdresse().getNumero();
			rue=compteMembre.getProfileMembre().getAdresse().getRue();
			showUpdateButton=true;
			showSearchButton=false;
	return "profile";	
	}


	public String modifierProfil(){
		CompteMembre compteMembre=dao.getCompte(noCompte);
		if(compteMembre==null ){
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le numero de compte est invalide","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
		
		
		 if(!compteMembre.getEmail_me().getEmail_me().equals(c.getEmail())){
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez vous connecter sur votre compte","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
	
		try{
			
			if(numero.equals(null)){
				numero=compteMembre.getProfileMembre().getAdresse().getNumero();		
				System.out.println("numero="+numero);	
			}
			if(ville.equals(null)){
				ville=compteMembre.getProfileMembre().getAdresse().getVille();
				System.out.println("Ville="+ville);
			}
			if(rue.equals(null)){
				rue=compteMembre.getProfileMembre().getAdresse().getRue();	
				System.out.println("rue="+rue);
			}
			if(phone_me.equals(null)){
				phone_me=compteMembre.getProfileMembre().getPhone_me();
				System.out.println("Phone="+phone_me);
			}
			if(getDatenais_me().equals(null)){
				datenais_me=compteMembre.getProfileMembre().getDatenais_me();
				System.out.println("Naissance="+datenais_me);
			}
	
			Adresse	adresse=new Adresse(departement, ville, numero, rue);	
			ProfileMembre	profilemembre =new ProfileMembre(cin_nif_me, nom_me, prenom_me, sexe_me, phone_me, datenais_me, "Actif",  adresse, compteMembre);
			
			
		if(!departement.equals(compteMembre.getProfileMembre().getAdresse().getDepartement())||
				!ville.equals(compteMembre.getProfileMembre().getAdresse().getVille())||
				!numero.equals(compteMembre.getProfileMembre().getAdresse().getNumero())||
						!rue.equals(compteMembre.getProfileMembre().getAdresse().getRue())){

			dao.modifier(profilemembre,new MobiliteMembre(adresse,new Date(),new CompteMembre(noCompte)));
			vider();
			showUpdateButton=false;
			showSearchButton=true;
		}


		else
      dao.modifier(compteMembre,profilemembre);
		vider();
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(String.format("Profile Modifie avec succes")));
	showUpdateButton=false;
	showSearchButton=true;
		}catch(Exception e){System.out.print(e.getMessage());
		e.printStackTrace();
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR," echec de modification de compte:","");
		FacesContext.getCurrentInstance().addMessage(null,msg);
		showUpdateButton=true;
		showSearchButton=false;
		}
		
		return "profile";
	}
	
	public void vider(){
		cin_nif_me="";
		nom_me="";
		prenom_me="";
		sexe_me="";
		phone_me="";
		datenais_me="";
		departement="";
	    ville="";
		numero="";
		rue="";
		noCompte="";
		
		
	}
	
	@PostConstruct
	private void hiddeButton(){
        showUpdateButton=false;
		showSearchButton=true;
	}
}
