package controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import controller.login.Connexion;

import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import entities.Adresse;
import entities.CompteMembre;
import entities.DesactiverLien;
import entities.Membre;
import entities.Operation;
import entities.ProfileMembre;
import entities.service.ServiceLocal;

@ManagedBean(name="compteMB")
@RequestScoped
public class CompteMembreController {
	@EJB
private ServiceLocal dao;
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
private String email;
private String test;
private String dateP;
private String testPhone;
private String testCin;
	public String getDateP() {
	return getParamDate();
}





public void setDateP(String dateP) {
	this.dateP = dateP;
}





	public String getTest() {
	return test;
}





public void setTest(String test) {
	this.test = test;
}





	public String getEmail() {
	return getParamEmail();
}





public void setEmail(String email) {
	this.email = email;
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

public String getNoCompte() {
	return noCompte;
}

public void setNoCompte(String noCompte) {
	this.noCompte = noCompte;
}

	public CompteMembreController() {
		super();
	}
	
	CapturerParametre ca=new CapturerParametre();
	
	private String getIdSess(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	String emailParam=request.getParameter("id");	
	return emailParam;
	}
	
	private String getParamDate(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	String datep=request.getParameter("date");
    return datep;
	}
	
	
	private String getParamEmail(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	String emailParam=request.getParameter("email");	
	return emailParam;
	}
	
	
	@PostConstruct
	public void init(){
	
		if(getIdSess()==null){
          test="cacher";
        
                   }
		
		if(getIdSess()!=null){
			DesactiverLien d=dao.getLien(getIdSess());
			
			if(d==null){
				
				test="afficher";
			}
			if(d!=null){
			test="cacher";		
				
			}	
			ca.add(getParamEmail(),getParamDate(),getIdSess());
		}
	
		
		}
		
	private void register(){
		 Membre	membre=new Membre(ca.getEmail());
			Adresse adresse =new Adresse(departement, ville, numero, rue);
			CompteMembre compteMembre =new CompteMembre(numCompte(),"Gourde",0.0,500,"Actif",new Date(),membre);
			ProfileMembre profilemembre =new ProfileMembre(cin_nif_me, nom_me, prenom_me, sexe_me, phone_me, datenais_me, "Actif",  adresse, compteMembre);
			DesactiverLien desactiverLien=new DesactiverLien(ca.getIdSession(), new Date());	

		try{
            dao.enregistrer(compteMembre, profilemembre,desactiverLien);
				
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(String.format("Compte Finalement cree.Verifiez votre e-mail",numCompte())));
			CapturerParametre.clear();
			ca.setDateP(null);
			ca.setEmail(null);
			ca.setIdSession(null);
				}catch(Exception e){System.out.print(e.getMessage());
				e.printStackTrace();
				FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR," echec de creation de compte:","");
				FacesContext.getCurrentInstance().addMessage(null,msg);
				}

	}	

public String enregistrerCompte(){
	  List<ProfileMembre>list= dao.lister(phone_me);
	
	ProfileMembre profilemembre=dao.rechercherAuth(cin_nif_me);
	FacesMessage msg;
  

	if(!profilemembre.equals(null)){
		 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cin deja utilise","");
			FacesContext.getCurrentInstance().addMessage(null,msg); 
               }else if(list.size()>0){
            	   msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Phone deja utilise","");
       			FacesContext.getCurrentInstance().addMessage(null,msg); 
           }else{
        	   register();
           }
		
	return"success";
}


public Connexion getC() {
	return c;
}

public void setC(Connexion c) {
	this.c = c;
}

Connexion c=new Connexion();
	public  String numCompte(){
		Random rd=new Random();
	
	String co=String.format("%s-%s-%s-%s", rd.nextInt(9999), 
			rd.nextInt(9999), rd.nextInt(9999), rd.nextInt(9999));
	return	co;
	}	


}
