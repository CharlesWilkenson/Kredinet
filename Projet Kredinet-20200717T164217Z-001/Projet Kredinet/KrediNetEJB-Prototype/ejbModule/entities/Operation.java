package entities;

import java.io.Serializable;
import java.util.Date;
import entities.Placement;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeOperation",discriminatorType=DiscriminatorType.STRING)
public  class Operation implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdOperation")
	private Long id_op;

	@Column(name="Montant",nullable=false )
	private double montant_op;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_Op;

	@ManyToOne
	@JoinColumn(name="NoCompte")
	private CompteMembre noCompte_me;



public Operation( double montant_op, Date date_Op, CompteMembre noCompte_me) {
	super();
	this.montant_op = montant_op;
	this.date_Op = date_Op;
	this.noCompte_me = noCompte_me;
}



public Long getId_op() {
	return id_op;
}



public void setId_op(Long id_op) {
	this.id_op = id_op;
}



public double getMontant_op() {
	return montant_op;
}



public void setMontant_op(double montant_op) {
	this.montant_op = montant_op;
}



public Date getDate_Op() {
	return date_Op;
}



public void setDate_Op(Date date_Op) {
	this.date_Op = date_Op;
}



public CompteMembre getNoCompte_me() {
	return noCompte_me;
}



public void setNoCompte_me(CompteMembre noCompte_me) {
	this.noCompte_me = noCompte_me;
}



public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}




}
