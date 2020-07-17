package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="Retrait")
public class Retrait extends Operation implements Serializable{

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(double montant_op, Date date_Op, CompteMembre noCompte_me) {
		super(montant_op, date_Op, noCompte_me);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

}
