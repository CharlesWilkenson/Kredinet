package entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Role implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String role;

@ManyToOne
@JoinColumn(name="email_me",nullable=false)
private Membre email_me;

public Role(String role, Membre email_me) {
	super();
	this.role = role;
	this.email_me = email_me;
}

public Role() {
	super();
	// TODO Auto-generated constructor stub
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public Membre getEmail_me() {
	return email_me;
}

public void setEmail_me(Membre email_me) {
	this.email_me = email_me;
}

}
