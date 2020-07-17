package controller.login;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import entities.Adresse;
import entities.CompteMembre;
import entities.Depot;
import entities.Membre;
import entities.Operation;
import entities.Placement;
import entities.Pret;
import entities.ProfileMembre;
import entities.Remboursement;
import entities.Retrait;
import entities.service.ServiceLocal;

@ManagedBean(name="navigationMembre")
@RequestScoped
public class NavigationMembre {
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

private String categorie_pla;

private double taux_pla;

private String duree_pla;

private double interetMens_pla;

private double fraisServiceMens_pla;

private double tca;

private double montant_op;


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



public String getCategorie_pla() {
	return categorie_pla;
}



public void setCategorie_pla(String categorie_pla) {
	this.categorie_pla = categorie_pla;
}



public double getTaux_pla() {
	return taux_pla;
}



public void setTaux_pla(double taux_pla) {
	this.taux_pla = taux_pla;
}



public String getDuree_pla() {
	return duree_pla;
}



public void setDuree_pla(String duree_pla) {
	this.duree_pla = duree_pla;
}



public double getInteretMens_pla() {
	return interetMens_pla;
}



public void setInteretMens_pla(double interetMens_pla) {
	this.interetMens_pla = interetMens_pla;
}



public double getFraisServiceMens_pla() {
	return fraisServiceMens_pla;
}



public void setFraisServiceMens_pla(double fraisServiceMens_pla) {
	this.fraisServiceMens_pla = fraisServiceMens_pla;
}



public double getTca() {
	return tca;
}



public void setTca(double tca) {
	this.tca = tca;
}



public double getMontant_op() {
	return montant_op;
}



public void setMontant_op(double montant_op) {
	this.montant_op = montant_op;
}

private Operation operation;
public Operation getOperation() {
	return operation;
}



public void setOperation(Operation operation) {
	this.operation = operation;
}

private double solde_compte;
private String noCompte;




public NavigationMembre() {
	super();

}



public String getNoCompte_me() {
	return c.getNoCompte_me();
}


public double getSolde_compte() {
	return c.getSolde_compte();
}

public void setSolde_compte(double solde_compte) {
	this.solde_compte = solde_compte;
}



public String getNoCompte() {
	return noCompte;
}



public void setNoCompte(String noCompte) {
	this.noCompte = noCompte;
}


public Connexion getC() {
	return c;
}

public void setC(Connexion c) {
	this.c = c;
}

Connexion c=new Connexion();



public String acceuil(){
	CompteMembre compteMembre=dao.getCompte(noCompte);
	
	FacesMessage msg = null;

	if(compteMembre==null ){
	 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le numero de compte est invalide","");
		FacesContext.getCurrentInstance().addMessage(null,msg);
		return "connexionCompteMembre";
	}
	
	
	else if(!compteMembre.getEmail_me().getEmail_me().equals(c.getEmail())){
		msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez vous connecter sur votre compte","");
		FacesContext.getCurrentInstance().addMessage(null,msg);
	
		return"connexionCompteMembre";
	}
 else {
		   System.out.println("Email:"+c.getEmail());
				c.setNoCompte_me(compteMembre.getNoCompte_me());
				c.setSolde_compte(compteMembre.getSolde_compte());
				return"acceuil?faces-redirect=true";
 }
	
}


public String acceuil1(){

return "acceuil?faces-redirect=true" ;	
}

public String activite(){
return "activite?faces-redirect=true";	
}

public String transaction(){
	return "transaction?faces-redirect=true";	
}


public String AfficherProfile(){

return "profile?faces-redirect=true";	
}


}
