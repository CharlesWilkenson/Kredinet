package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Adresse implements Serializable{
	public Adresse(String departement, String ville, String numero, String rue) {
		super();
		this.departement = departement;
		this.ville = ville;
		this.numero = numero;
		this.rue = rue;
		
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




	private static final long serialVersionUID = 1L;

	
@Column(name="Departement",length=25,nullable=false)
@NotEmpty(message="Entrer le departement")
private String departement;

@Column(name="Ville",length=25,nullable=false)
@NotEmpty(message="Entrer la ville")
private String ville;


@Column(name="Numero_Rue",length=10,nullable=false)
@NotEmpty(message="Entrer le numero")
private String numero;

@Column(name="Rue",length=30,nullable=false)
@NotEmpty(message="Entrer la rue")
private String rue;



public Adresse() {
	super();
	// TODO Auto-generated constructor stub
}

}
