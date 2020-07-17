package controller;

import java.util.Date;
import java.util.List;
import java.util.Random;
import entities.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.ejb.EJB;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


import entities.Adresse;
import entities.CompteMembre;
import entities.Membre;
import entities.service.ServiceLocal;

@ManagedBean(name="membreMB")
@RequestScoped
public class MembreController {

	@EJB
	private ServiceLocal dao;
	private Membre membre;
	private String motdePasse;
	private String email_me;
	private String confirmerPassword;
	
	public String getEmail_me() {
		return email_me;
	}

	public void setEmail_me(String email_me) {
		this.email_me = email_me;
	}

	public String getMotdePasse() {
		return motdePasse;
	}

	public void setMotdePasse(String motdePasse) {
		this.motdePasse = motdePasse;
	}
	
	public String getConfirmerPassword() {
		return confirmerPassword;
	}

	public void setConfirmerPassword(String confirmerPassword) {
		this.confirmerPassword = confirmerPassword;
	}

	public MembreController() {
		super();
		membre=new Membre();
	}
	
	public String enregistrerMembre(){
		
		if (Utility.validate(email_me)) {
			
			membre =dao.rechercher(email_me);
			
			if(membre!=null) {
				FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cette adresse email est déjà utilisée ","");
				FacesContext.getCurrentInstance().addMessage(null,msg);		
				return"inscription";
			}
			else{
				 if(motdePasse.length()<8){
						FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le mot de passe doit avoir au moins 8 caractère","");
						FacesContext.getCurrentInstance().addMessage(null,msg);
						return"inscription";
				}
				else{
					if(!motdePasse.equals(confirmerPassword)){
						FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"les mots de passe ne correspondent pas","");
						FacesContext.getCurrentInstance().addMessage(null,msg);
						return"inscription";
					}
					else{
						try{
							
							//dao.enregistrer(new Membre(email_me,motdePasse,new Date()));
							dao.enregistrer(new Membre(email_me,motdePasse,"Actif",new Date()));
							FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(String.format("Membre Créé. Veuillez vérifier votre Adresse Email")));
							}
						catch(Exception e){
							System.out.print(e.getMessage());
							e.printStackTrace();
							FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de création de compte","");
							FacesContext.getCurrentInstance().addMessage(null,msg);
						}
					}
				}	
			}	
		}
		
		else{
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Merci de saisir une adresse mail valide","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return"inscription";
		}
		
	
	return"inscription";
}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public List<Membre> ListerMembre(){
		return dao.listerMembre();
	}

}
