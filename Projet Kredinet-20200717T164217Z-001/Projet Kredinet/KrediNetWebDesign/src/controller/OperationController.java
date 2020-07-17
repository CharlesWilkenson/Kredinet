package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import controller.login.Connexion;
import dao.ServiceImplementation;
import entities.CompteMembre;
import entities.Depot;
import entities.DepotMoncash;
import entities.Operation;
import entities.Placement;
import entities.Pret;
import entities.Retrait;
import entities.SendEmail;
import entities.Transfert;
import entities.service.ServiceLocal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@ManagedBean(name="operationMB")
public class OperationController {

	@EJB
	private ServiceLocal dao;
	private double montantTransfere=0.0;
	private double montantDepot=0.0;
	private double montantPlacement=0.0;
	private double montantPret=0.0;
	private double montantRetrait=0.0;
	private String etat_Pla;
	private String etat_pret;
	private String noComptePlacement;
	private String noCompteDepot;
	private String noCompteRetrait;
	private String noComptePret;
	private String noCompteBeneficiaire;
	private String noCompteDonateur;
    private String categorie_pla;	
	private double taux_pla;
	private String duree_pla;
	private double tca;
	private double interetAnnuel_pla;
	private double interetMens_pla;
	private double fraisServiceAnn_pla;
	private double fraisServiceMens_pla;
	private String type_Operation;
	private String codeConfRetrait;
	private String codeConfTrans;
	public String getCodeConfTrans() {
		return codeConfTrans;
	}



	public void setCodeConfTrans(String codeConfTrans) {
		this.codeConfTrans = codeConfTrans;
	}


	private String codeConfirmation;
	public String getCodeConfirmation() {
		return codeConfirmation;
	}



	public void setCodeConfirmation(String codeConfirmation) {
		this.codeConfirmation = codeConfirmation;
	}


	//private String codeConfRetrait;
	private double tauxRemb;
	private double Remb_Ann;
	private double Remb_Mens;
	private List<String> lstCategorie=new ArrayList<String>();
	public double getMontantRetrait() {
		return montantRetrait;
	}



	public void setMontantRetrait(double montantRetrait) {
		this.montantRetrait = montantRetrait;
	}



	public String getNoCompteRetrait() {
		return noCompteRetrait;
	}



	public void setNoCompteRetrait(String noCompteRetrait) {
		this.noCompteRetrait = noCompteRetrait;
	}




	public double getMontantPret() {
		return montantPret;
	}



	public void setMontantPret(double montantPret) {
		this.montantPret = montantPret;
	}



	public String getNoComptePret() {
		return noComptePret;
	}



	public void setNoComptePret(String noComptePret) {
		this.noComptePret = noComptePret;
	}


	public double getFraisServiceAnn_pla() {
		return fraisServiceAnn_pla;
	}



	public void setFraisServiceAnn_pla(double fraisServiceAnn_pla) {
		this.fraisServiceAnn_pla = fraisServiceAnn_pla;
	}

	
	public double getRemb_Ann() {
		return Remb_Ann;
	}



	public void setRemb_Ann(double remb_Ann) {
		Remb_Ann = remb_Ann;
	}



	public double getRemb_Mens() {
		return Remb_Mens;
	}



	public void setRemb_Mens(double remb_Mens) {
		Remb_Mens = remb_Mens;
	}


	public String getEtat_Pla() {
		return etat_Pla;
	}



	public void setEtat_Pla(String etat_Pla) {
		this.etat_Pla = etat_Pla;
	}



	public String getEtat_pret() {
		return etat_pret;
	}



	public void setEtat_pret(String etat_pret) {
		this.etat_pret = etat_pret;
	}

	
public List<String> getLstCategorie() {
		return lstCategorie;
	}



	public void setLstCategorie(List<String> lstCategorie) {
		this.lstCategorie = lstCategorie;
	}
	
	
	public String getCodeConfRetrait() {
		return codeConfRetrait;
	}
	public void setCodeConfRetrait(String codeConfRetrait) {
		this.codeConfRetrait = codeConfRetrait;
	}


	private Long idTransfere;
	
	public double getMontantTransfere() {
		return montantTransfere;
	}
	public void setMontantTransfere(double montantTransfere) {
		this.montantTransfere = montantTransfere;
	}
	public String getNoCompteBeneficiaire() {
		return noCompteBeneficiaire;
	}
	public void setNoCompteBeneficiaire(String noCompteBeneficiaire) {
		this.noCompteBeneficiaire = noCompteBeneficiaire;
	}
	public String getNoCompteDonateur() {
		return noCompteDonateur;
	}
	public void setNoCompteDonateur(String noCompteDonateur) {
		this.noCompteDonateur = noCompteDonateur;
	}

public Long getIdTransfere() {
		return idTransfere;
	}
	public void setIdTransfere(Long idTransfere) {
		this.idTransfere = idTransfere;
	}


	private Long idTransaction;
	private String tel;
	public double getTauxRemb() {
		return tauxRemb;
	}
	public void setTauxRemb(double tauxRemb) {
		this.tauxRemb = tauxRemb;
	}


	
	public double getInteretAnnuel_pla() {
		return interetAnnuel_pla;
	}
	public void setInteretAnnuel_pla(double interetAnnuel_pla) {
		this.interetAnnuel_pla = interetAnnuel_pla;
	}


	private Date dateTrans;
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
	public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Connexion getC() {
		return c;
	}
	public void setC(Connexion c) {
		this.c = c;
	}
	
	public String getType_Operation() {
		return type_Operation;
	}
	public void setType_Operation(String type_Operation) {
		this.type_Operation = type_Operation;
	}
	public double getTca() {
		return tca;
	}
	public void setTca(double tca) {
		this.tca = tca;
	}

	public double getMontantDepot() {
		return montantDepot;
	}
	public void setMontantDepot(double montantDepot) {
		this.montantDepot = montantDepot;
	}
	public double getMontantPlacement() {
		return montantPlacement;
	}
	public void setMontantPlacement(double montantPlacement) {
		this.montantPlacement = montantPlacement;
	}
	public String getNoComptePlacement() {
		return noComptePlacement;
	}
	public void setNoComptePlacement(String noComptePlacement) {
		this.noComptePlacement = noComptePlacement;
	}
	public String getNoCompteDepot() {
		return noCompteDepot;
	}
	public void setNoCompteDepot(String noCompteDepot) {
		this.noCompteDepot = noCompteDepot;
	}
	public String getCategorie_pla() {
		return categorie_pla;
	}
	public void setCategorie_pla(String categorie_pla) {
		this.categorie_pla = categorie_pla;
	}
	public double getTaux_pla() {
		return taux_pla;
	}
	public void setTaux_pla(double taux_pla) {
		this.taux_pla = taux_pla;
	}
	public String getDuree_pla() {
		return duree_pla;
	}
	public void setDuree_pla(String duree_pla) {
		this.duree_pla = duree_pla;
	}
	public double getInteretMens_pla() {
		return interetMens_pla;
	}
	public void setInteretMens_pla(double interetMens_pla) {
		this.interetMens_pla = interetMens_pla;
	}
	public double getFraisServiceMens_pla() {
		return fraisServiceMens_pla;
	}
	public void setFraisServiceMens_pla(double fraisServiceMens_pla) {
		this.fraisServiceMens_pla = fraisServiceMens_pla;
	}
	
	public String pret(){
		tauxRemb=0.07;
		String NumCompte;
		FacesMessage msg;
		 CompteMembre compteMembre =dao.getCompte(noComptePlacement);
	     
		if(compteMembre==null ){
			msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le numero de compte est invalide","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
		
		
		else if(!compteMembre.getEmail_me().getEmail_me().equals(c.getEmail())){
			 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez vous connecter sur votre compte","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
	List<Pret>listPret=dao.listerPret(noComptePret, "Pret", true);	
	if(listPret.size()>0){
		msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Desole vous avez deja un pret en cours","");
		FacesContext.getCurrentInstance().addMessage(null,msg);
	}	
	 List<Placement>listPlacement=dao.listerPlacement(false, "Placement",montantPret);
	if(listPlacement.size()==1){
		try{
			dao.pret(new Pret(montantPret, new Date(),new CompteMembre(noComptePret),  0.07*montantPret, "1 an", true, "Effectue"));
			
					
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(String.format("Pret effectue avec succes")));	
		}catch(Exception e){
			msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce pret n'a pas s'effectuer","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			
		}
	}
	
	
	
	
		return "transaction";
	}
	
	public String placement(){
		taux_pla=0.05;
		tauxRemb=0.07;
	    interetAnnuel_pla=montantPlacement*0.05;	    
		interetMens_pla=montantPlacement*0.05/12;
		
		Remb_Ann=tauxRemb*montantPlacement;
		Remb_Mens=tauxRemb*montantPlacement/12;
		
		fraisServiceAnn_pla =0.02*montantPlacement;
		fraisServiceMens_pla=0.02*montantPlacement/12;
		 
		 
		        FacesMessage msg;
				Placement placement;
                CompteMembre compteMembre =dao.getCompte(noComptePlacement);
		     
            	if(compteMembre==null ){
        			msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le numero de compte est invalide","");
        			FacesContext.getCurrentInstance().addMessage(null,msg);
        			return "profile";
        		}
        		
        		
        		else if(!compteMembre.getEmail_me().getEmail_me().equals(c.getEmail())){
        			 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez vous connecter sur votre compte","");
        			FacesContext.getCurrentInstance().addMessage(null,msg);
        			return "profile";
        		}
					if(montantPlacement<5000){
						 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR," Vous ne pouvez pas placez une somme au dessous de 5000 gourdes","");
						FacesContext.getCurrentInstance().addMessage(null,msg);
						return "transaction";
					}
					
					//double soldeRestant=compteMembre.getSolde_compte()-montant_op;
					if(compteMembre.getSolde_compte()-montantPlacement<100){
						 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le reste de votre solde doit etre superieur ou egal 100 gourdes","");
						FacesContext.getCurrentInstance().addMessage(null,msg);
						return "transaction";
					}
					
					if(compteMembre.getSolde_compte()<=5000){
						 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR," Votre solde n'est pas suffisant pour faire ce placement","");
						FacesContext.getCurrentInstance().addMessage(null,msg);
						return "transaction";
					}

					else{
						try{
	placement=new Placement(montantPlacement, new Date(), 
	new CompteMembre(compteMembre.getNoCompte_me()),
	categorie_pla, taux_pla,"1 an", interetMens_pla, fraisServiceMens_pla,Remb_Ann,false) ;
				
	dao.placement(placement, compteMembre.getNoCompte_me());
					
	compteMembre =dao.getCompte(compteMembre.getNoCompte_me());
	c.setSolde_compte(compteMembre.getSolde_compte());
						
	msg=new FacesMessage("Placement effectue avec succes");
	montantPlacement=0.0;
	noComptePlacement="";
	FacesContext.getCurrentInstance().addMessage(null,msg);
	}
	catch(Exception e){System.out.print(e.getMessage());
							e.printStackTrace();
							 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR," Le placement n'a pas pu etre effectue :","");
							FacesContext.getCurrentInstance().addMessage(null,msg);
							}}
							return "transaction";
					}

	public String transfere(){
		
		CompteMembre donateur=dao.getCompte(noCompteDonateur);
	
		FacesMessage msg;
		if(donateur==null ){
			 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le numero de compte est invalide","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
		
		
		else if(!donateur.getEmail_me().getEmail_me().equals(c.getEmail())){
			 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez vous connecter sur votre compte","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
		
		CompteMembre beneficiaire=dao.getCompte(noCompteBeneficiaire);
		if(beneficiaire==null){
			msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le numero de compte du beneficiaire est invalide","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "transaction";
		}
		
		if(donateur.getSolde_compte()-montantTransfere<100){
			 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le reste de votre doit etre superieur ou egal 100 gourdes","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "transaction";
		}

		if(!codeConfTrans.equals(c.getCodeConf())){
			 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code de confirmation incorrecte","");
				FacesContext.getCurrentInstance().addMessage(null,msg);	
		}
	try{
		dao.tranfere(noCompteDonateur, noCompteBeneficiaire, montantTransfere);
		CompteMembre donat=dao.getCompte(noCompteDonateur);
		c.setSolde_compte(donat.getSolde_compte());
		c.setCodeConf(null);
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(String.format("Transfere effectue avec succes")));
	}catch(Exception e){
		msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le Transfert n'a pas pu etre effectue :","");
		FacesContext.getCurrentInstance().addMessage(null,msg);
	}	
	return "transaction";
	}
	
	Connexion c=new Connexion();
	
	public List<Placement> listerPlacement(){
		return dao.listerPlacement(c.getNoCompte_me(),"Placement");
		}

	public List<Depot> listerDepot(){
		 List<Depot>list=dao.listerDepot(c.getNoCompte_me(), "Depot");
		System.out.println("Size="+list.size());
		return list;
	}

	public List<Transfert> listerTransfert(){
		return dao.listerTransfert(c.getNoCompte_me(),"Transfert");
	}	
	
	@PostConstruct
	public void init(){
		CompteMembre comp=dao.getCompte(c.getNoCompte_me());
		c.setSolde_compte(comp.getSolde_compte());
		System.out.println("Solde"+c.getSolde_compte());
	}
	
	public String retrait(){
		FacesMessage msg;
		 CompteMembre compteMembre =dao.getCompte(noCompteRetrait);
	     
		if(compteMembre==null ){
			msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le numero de compte est invalide","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
		
		
		else if(!compteMembre.getEmail_me().getEmail_me().equals(c.getEmail())){
			 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez vous connecter sur votre compte","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "profile";
		}
		
		if(compteMembre.getSolde_compte()-montantPlacement<100){
			 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Solde insuffisant","");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "transaction";
		}
		
		if(!codeConfRetrait.equals(c.getCodeConf())){
			 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Code de confirmation incorrecte","");
				FacesContext.getCurrentInstance().addMessage(null,msg);	
		}
		else{
			try{
			dao.retrait(new Retrait(montantRetrait, new Date(), new CompteMembre(noCompteRetrait)));	
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(String.format("Transaction reussie ")));
			
			}catch(Exception e){
				 msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Transaction echoue","");
			FacesContext.getCurrentInstance().addMessage(null,msg);	}
		}
		return"";
	}
	
	public String sendEmail(){
		codeConfirmation=codeConfirmation();
		SendEmail.sendEmail(codeConfirmation, c.getEmail());
		c.setCodeConf(codeConfirmation);
		return"";
	}
	
	
	
	public static  String codeConfirmation(){
		Random rd=new Random();
        String conf=String.format("%s", rd.nextInt(999999));
	return	conf;
	}
	
	public void motantCategorie(AjaxBehaviorEvent event){
		switch(categorie_pla){
		//categorie 1
		case "1":
			lstCategorie.add("5000.00");
			lstCategorie.add("10000.00");
			lstCategorie.add("15000.00");
			lstCategorie.add("20000.00");
			lstCategorie.add("25000.00");
			break;
		//categorie 2	
		case "2":
			lstCategorie.add("30000.00");
			lstCategorie.add("35000.00");
			lstCategorie.add("40000.00");
			lstCategorie.add("45000.00");
			lstCategorie.add("50000.00");
			break;
		}
	}
}
