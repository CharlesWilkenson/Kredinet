package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DesactiverLien implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
private String id;
private Date date;
public DesactiverLien(String id, Date date) {
	super();
	this.id = id;
	this.date = date;
}

public DesactiverLien() {
	super();
	// TODO Auto-generated constructor stub
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}






}
