package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MobiliteMembre implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@Embedded
private Adresse adresse;

@Temporal(TemporalType.TIMESTAMP)
private Date dateModification;
public MobiliteMembre(Adresse adresse, Date dateModification, CompteMembre noCompte) {
	super();
	this.adresse = adresse;
	this.dateModification = dateModification;
	this.noCompte = noCompte;
}

public Date getDateModification() {
	return dateModification;
}

public void setDateModification(Date dateModification) {
	this.dateModification = dateModification;
}

public CompteMembre getNoCompte() {
	return noCompte;
}

public void setNoCompte(CompteMembre noCompte) {
	this.noCompte = noCompte;
}

@ManyToOne
@JoinColumn
private CompteMembre noCompte;
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public MobiliteMembre(Adresse adresse) {
	super();
	this.adresse = adresse;
}

public MobiliteMembre() {
	super();
	// TODO Auto-generated constructor stub
}

public Adresse getAdresse() {
	return adresse;
}

public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}


}
