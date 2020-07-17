package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Depot")
public class Depot extends Operation {
	private static final long serialVersionUID = 1L;
	public Depot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Depot(double montant_op, Date date_Op, CompteMembre noCompte_me) {
		super(montant_op, date_Op, noCompte_me);
	}

	

}
