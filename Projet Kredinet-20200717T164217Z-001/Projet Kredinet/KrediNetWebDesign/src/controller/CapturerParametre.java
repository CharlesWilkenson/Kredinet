package controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import controller.login.Connexion;

import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import entities.Adresse;
import entities.CompteMembre;
import entities.Membre;
import entities.Operation;
import entities.ProfileMembre;
import entities.service.ServiceLocal;

@ManagedBean(name="captureMB")
@SessionScoped
public class CapturerParametre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


private String email;
private String dateP;
private String idSession;
	public String getIdSession() {
	return map.get("id");
}

public void setIdSession(String idSession) {
	this.idSession = idSession;
}

	public String getDateP() {
	return map.get("dateMap");
}

public void setDateP(String dateP) {
	this.dateP = dateP;
}

	public String getEmail() {
	return map.get("emailMap");
}


public void setEmail(String email) {
	this.email = email;
}



private static Map<String, String> map=new HashMap<>();


public void add(String email,String date,String id){
	map.put("emailMap", email);
	map.put("dateMap", date);
	map.put("id",id);
}


public static Map<String, String> getMap() {
	return map;
}

public static void setMap(Map<String, String> map) {
	CapturerParametre.map = map;
}

public static void clear(){
	
	map.clear();
	
}

	public CapturerParametre() {
		super();
		
	}



	private String getParamDate(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	String datep=request.getParameter("date");
    return datep;
	}
	
	
	private String getParamEmail(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	String emailParam=request.getParameter("email");	
	return emailParam;
	}

	private String getIdSess(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	String emailParam=request.getParameter("id");	
	return emailParam;
	}
}
