package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import org.hibernate.validator.constraints.NotEmpty;
@Entity
@DiscriminatorValue(value="Placement")
public class Placement extends Operation {

	private static final long serialVersionUID = 1L;

	//private static final long serialVersionUID = 1L;
	@Column(name="Categorie",nullable=false)
//	@NotEmpty(message="Choisir la categorie")
	private String categorie_pla;
	
	@Column(name="Taux")
	private double taux_pla;
	
	@Column(name="Duree")
	private String duree_pla;
	
	@Column(name="InteretMensuel",nullable=false)
	 private double interetMens_pla;
	
	@Column(name="fraisMensuel",nullable=false)
	private double fraisServiceMens_pla;
	@Column(name="Remb_Ann",nullable=false)
 double Remb_Ann;
	
	public double getRemb_Ann() {
		return Remb_Ann;
	}

	public void setRemb_Ann(double Remb_Ann) {
		this.Remb_Ann = Remb_Ann;
	}

	@Column(name="TCA")
	 private double tca;
	
	private Boolean etat_Pla;


	public Boolean getEtat_Pla() {
		return etat_Pla;
	}

	public void setEtat_Pla(Boolean etat_Pla) {
		this.etat_Pla = etat_Pla;
	}

	public Placement() {
		super();
		// TODO Auto-generated constructor stub
	} 

	public Placement(double montant_op, Date date_Op, CompteMembre noCompte_me) {
		super(montant_op, date_Op, noCompte_me);
		// TODO Auto-generated constructor stub
	}

	public Placement(double montant_op, Date date_Op, CompteMembre noCompte_me, String categorie_pla, double taux_pla,
			String duree_pla, double interetMens_pla, double fraisServiceMens_pla,double Remb_Ann,Boolean etat_Pla) {
		super(montant_op, date_Op, noCompte_me);
		this.categorie_pla = categorie_pla;
		this.taux_pla = taux_pla;
		this.duree_pla = duree_pla;
		this.interetMens_pla = interetMens_pla;
		this.fraisServiceMens_pla = fraisServiceMens_pla;
		this.etat_Pla=etat_Pla;
		this.Remb_Ann=Remb_Ann;
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

	



	 

}
