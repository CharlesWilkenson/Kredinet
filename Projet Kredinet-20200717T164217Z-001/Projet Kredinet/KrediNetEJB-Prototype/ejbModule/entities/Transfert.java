package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="Transfert")
public class Transfert extends Operation implements Serializable{
 private String noCompteBeneficiaire;

public Transfert() {
	super();
	// TODO Auto-generated constructor stub
}



public Transfert(double montant_op, Date date_Op, CompteMembre noCompte_me,
		String noCompteBeneficiaire) {
	super(montant_op, date_Op, noCompte_me);
	this.noCompteBeneficiaire = noCompteBeneficiaire;
}



public String getNoCompteBeneficiaire() {
	return noCompteBeneficiaire;
}

public void setNoCompteBeneficiaire(String noCompteBeneficiaire) {
	this.noCompteBeneficiaire = noCompteBeneficiaire;
}
 
}
