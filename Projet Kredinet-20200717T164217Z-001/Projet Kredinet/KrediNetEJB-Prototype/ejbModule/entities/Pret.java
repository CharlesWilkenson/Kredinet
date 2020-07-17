package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Pret")
public class Pret extends Operation implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name="categorie_pret",nullable=true)
	private String categorie_pret;
	@Column(name="rembMens",nullable=false)
	private double taux_rembMens;
	private String duree_pret;
	private Boolean etat_pret;
	private String statut_pret;
public String getStatut_pret() {
		return statut_pret;
	}
	public void setStatut_pret(String statut_pret) {
		this.statut_pret = statut_pret;
	}
public Boolean getEtat_pret() {
		return etat_pret;
	}
	public void setEtat_pret(Boolean etat_pret) {
		this.etat_pret = etat_pret;
	}
public Pret() {
		super();
	
	}



public Pret(double montant_op, Date date_Op, CompteMembre noCompte_me, String categorie_pret, double taux_rembMens,
		String duree_pret, Boolean etat_pret,String statut_pret) {
	super(montant_op, date_Op, noCompte_me);
	this.categorie_pret = categorie_pret;
	this.taux_rembMens = taux_rembMens;
	this.duree_pret = duree_pret;
	this.etat_pret = etat_pret;
	this.statut_pret=statut_pret;
}
public Pret(double montant_op, Date date_Op, CompteMembre noCompte_me, double taux_rembMens, String duree_pret,
		Boolean etat_pret, String statut_pret) {
	super(montant_op, date_Op, noCompte_me);
	this.taux_rembMens = taux_rembMens;
	this.duree_pret = duree_pret;
	this.etat_pret = etat_pret;
	this.statut_pret = statut_pret;
}
public String getCategorie_pret() {
	return categorie_pret;
}
public void setCategorie_pret(String categorie_pret) {
	this.categorie_pret = categorie_pret;
}
public double getTaux_rembMens() {
	return taux_rembMens;
}
public void setTaux_rembMens(double taux_rembMens) {
	this.taux_rembMens = taux_rembMens;
}
public String getDuree_pret() {
	return duree_pret;
}
public void setDuree_pret(String duree_pret) {
	this.duree_pret = duree_pret;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
