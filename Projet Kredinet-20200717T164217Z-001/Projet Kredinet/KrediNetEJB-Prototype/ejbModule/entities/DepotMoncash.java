package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DepotMoncash implements Serializable{
public DepotMoncash() {
		super();
		// TODO Auto-generated constructor stub
	}
public DepotMoncash(Long idTransaction, double montant, String tel, Date dateTrans,String etat) {
		super();
		this.idTransaction = idTransaction;
		this.montant = montant;
		this.tel = tel;
		this.dateTrans = dateTrans;
		this.etat=etat;
	}
@Id
private Long idTransaction;
private double montant;
private String etat;
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public Long getIdTransaction() {
	return idTransaction;
}
public void setIdTransaction(Long idTransaction) {
	this.idTransaction = idTransaction;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public Date getDateTrans() {
	return dateTrans;
}
public void setDateTrans(Date dateTrans) {
	this.dateTrans = dateTrans;
}
private String tel;
public DepotMoncash(Long idTransaction) {
	super();
	this.idTransaction = idTransaction;
}
@Temporal(TemporalType.TIMESTAMP)
private Date dateTrans;

}
