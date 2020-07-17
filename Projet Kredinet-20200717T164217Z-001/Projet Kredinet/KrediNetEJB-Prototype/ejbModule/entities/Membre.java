package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Membre implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotEmpty(message="Entrer l'email")
	@Email(message="Email incorrecte")
	private String email_me;
	
	@NotEmpty(message="Entrer le password")
	@Column(name="password")
    private String	motdePasse;
		
	@Temporal(TemporalType.DATE)
	@Column(name="dateAjout", nullable=true)
	private Date dateAjout;
	
	@Column(name="Etat")
    private String etat;
	public Membre(String email_me) {
		super();
		this.email_me = email_me;
	}

	@OneToMany(mappedBy="email_me")
	private List<Role> role;

	public List<Role> getRole() {
		return role;
	}


	public void setRole(List<Role> role) {
		this.role = role;
	}

	@OneToOne(mappedBy="email_me")
	private CompteMembre compteMembre;


	public Membre() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Membre(String email_me, String motdePasse,String etat, Date dateAjout) {
		super();
		this.email_me = email_me;
		this.motdePasse = motdePasse;
		this.dateAjout = dateAjout;
	this.etat=etat;
	}


	public String getEmail_me() {
		return email_me;
	}


	public void setEmail_me(String email_me) {
		this.email_me = email_me;
	}


	public String getMotdePasse() {
		return motdePasse;
	}


	public void setMotdePasse(String motdePasse) {
		this.motdePasse = motdePasse;
	}


	public Date getDateAjout() {
		return dateAjout;
	}


	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}


	public CompteMembre getCompteMembre() {
		return compteMembre;
	}


	public void setCompteMembre(CompteMembre compteMembre) {
		this.compteMembre = compteMembre;
	}
	
 

	

	
}
