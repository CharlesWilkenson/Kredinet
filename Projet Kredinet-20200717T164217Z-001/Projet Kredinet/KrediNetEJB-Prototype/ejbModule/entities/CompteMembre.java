package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
@Entity
public class CompteMembre implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NoCompte")
    private String noCompte_me;

	@NotEmpty(message="Entrer la Devise")
	@Column(name="Devise", length=25)
	private String devise_compte;
	
	@Column(name="FraisCloture")
	private double frais_Cloture;

	public double getFrais_Cloture() {
		return frais_Cloture;
	}

	public void setFrais_Cloture(double frais_Cloture) {
		this.frais_Cloture = frais_Cloture;
	}

	@OneToMany(mappedBy="noCompte")
	private Collection<MobiliteMembre> mobilite;

	public Collection<MobiliteMembre> getMobilite() {
		return mobilite;
	}

	public void setMobilite(Collection<MobiliteMembre> mobilite) {
		this.mobilite = mobilite;
	}

	@Column(name="Solde")
	private double solde_compte;
	
	@NotEmpty
	private String etat;
	
	@Column(name="Date_Creation", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAjout;

	@OneToOne(mappedBy="noCompte_me",fetch=FetchType.EAGER)
	private ProfileMembre profileMembre;
		
		
	@OneToOne()
	@JoinColumn(name="Email",nullable=false)
	private Membre email_me;

	@OneToMany(mappedBy="noCompte_me")
	private Collection<Operation> operations; 

	
public CompteMembre(String noCompte_me, String devise_compte, double solde_compte,double frais_Cloture, String etat, Date dateAjout,
			Membre email_me) {
		super();
		this.noCompte_me = noCompte_me;
		this.devise_compte = devise_compte;
		this.solde_compte = solde_compte;
		this.etat = etat;
		this.dateAjout = dateAjout;
		this.frais_Cloture=frais_Cloture;
		this.email_me = email_me;
	}

public CompteMembre(String noCompte_me) {
	super();
	this.noCompte_me = noCompte_me;
}

public CompteMembre(String noCompte_me, String devise_compte, double solde_compte, String etat, Date dateAjout,
		ProfileMembre profileMembre, Membre email_me, Collection<Operation> operations) {
	super();
	this.noCompte_me = noCompte_me;
	this.devise_compte = devise_compte;
	this.solde_compte = solde_compte;
	this.etat = etat;
	this.dateAjout = dateAjout;
	this.profileMembre = profileMembre;
	this.email_me = email_me;
	this.operations = operations;
}

public CompteMembre(String noCompte_me, String devise_compte, double solde_compte, String etat, Date dateAjout,
		ProfileMembre profileMembre, Membre email_me) {
	super();
	this.noCompte_me = noCompte_me;
	this.devise_compte = devise_compte;
	this.solde_compte = solde_compte;
	this.etat = etat;
	this.dateAjout = dateAjout;
	this.profileMembre = profileMembre;
	this.email_me = email_me;
}



public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

public String getNoCompte_me() {
		return noCompte_me;
	}

	public void setNoCompte_me(String noCompte_me) {
		this.noCompte_me = noCompte_me;
	}

	public String getDevise_compte() {
		return devise_compte;
	}

	public void setDevise_compte(String devise_compte) {
		this.devise_compte = devise_compte;
	}

	public double getSolde_compte() {
		return solde_compte;
	}

	public void setSolde_compte(double solde_compte) {
		this.solde_compte = solde_compte;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public ProfileMembre getProfileMembre() {
		return profileMembre;
	}

	public void setProfileMembre(ProfileMembre profileMembre) {
		this.profileMembre = profileMembre;
	}

	public Membre getEmail_me() {
		return email_me;
	}

	public void setEmail_me(Membre email_me) {
		this.email_me = email_me;
	}


public CompteMembre() {
	super();
	// TODO Auto-generated constructor stub
}


}


