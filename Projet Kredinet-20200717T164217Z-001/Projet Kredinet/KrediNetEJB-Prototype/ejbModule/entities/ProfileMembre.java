package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ProfileMembre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CIN_NIF",length=50,nullable=false)
	private String cin_nif_me;
	

	public ProfileMembre(String nom_me, String prenom_me, String sexe_me) {
		super();
		this.nom_me = nom_me;
		this.prenom_me = prenom_me;
		this.sexe_me = sexe_me;
	}


	@Column(name="Nom",length=25,nullable=false)
	private String nom_me;
	
	@Column(name="Prenom",length=25,nullable=false)
	private String prenom_me;

	@Column(name="Sexe",length=15,nullable=false)
	private String sexe_me;
	
	@Column(name="Phone",length=15,nullable=false)
	private String phone_me;
	
	@Column(name="DateNaissance",nullable=false,length=30)
	private String datenais_me;
	
	@Column(name="Etat",nullable=false,length=10)
    private String etat;
	
    @Column(name="Date_Ajout",nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
	private Date dateAjout;
    
    @Embedded
    private Adresse adresse;
    
    
    @OneToOne
    @JoinColumn(name="NoCompte")
    private CompteMembre noCompte_me;
	
	
	public ProfileMembre(String cin_nif_me, String nom_me, String prenom_me, String sexe_me, String phone_me,
			String datenais_me, String etat,  Adresse adresse, CompteMembre noCompte_me) {
		super();
		this.cin_nif_me = cin_nif_me;
		this.nom_me = nom_me;
		this.prenom_me = prenom_me;
		this.sexe_me = sexe_me;
		this.phone_me = phone_me;
		this.datenais_me = datenais_me;
		this.etat = etat;
		
		this.adresse = adresse;
		this.noCompte_me = noCompte_me;
	}
    
	public ProfileMembre(String cin_nif_me, String nom_me, String prenom_me, String sexe_me, String phone_me,
			String datenais_me, String etat,  Adresse adresse, CompteMembre noCompte_me,Date dateAjout) {
		super();
		this.cin_nif_me = cin_nif_me;
		this.nom_me = nom_me;
		this.prenom_me = prenom_me;
		this.sexe_me = sexe_me;
		this.phone_me = phone_me;
		this.datenais_me = datenais_me;
		this.etat = etat;
		this.dateAjout=dateAjout;
		this.adresse = adresse;
		this.noCompte_me = noCompte_me;
	}


	public ProfileMembre(String cin_nif_me, String nom_me, String prenom_me, String sexe_me, String phone_me,
			String datenais_me, String etat, Adresse adresse) {
		super();
		this.cin_nif_me = cin_nif_me;
		this.nom_me = nom_me;
		this.prenom_me = prenom_me;
		this.sexe_me = sexe_me;
		this.phone_me = phone_me;
		this.datenais_me = datenais_me;
		this.etat = etat;
		this.adresse = adresse;
	}


	public ProfileMembre() {
		super();
		// TODO Auto-generated constructor stub
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


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public CompteMembre getNoCompte_me() {
		return noCompte_me;
	}


	public void setNoCompte_me(CompteMembre noCompte_me) {
		this.noCompte_me = noCompte_me;
	}


    
}
