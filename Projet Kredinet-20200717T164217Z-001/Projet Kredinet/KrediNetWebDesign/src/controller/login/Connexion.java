package controller.login;

import java.io.IOException;
import java.security.Principal;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.security.identity.Role;

import entities.CompteMembre;
import entities.Membre;
import entities.service.ServiceLocal;

@SessionScoped
@ManagedBean(name="connect")
public class Connexion {
@EJB
private ServiceLocal service;
		private String email_me;
		private String emailSession;
		private String motdePasse;
		private double solde_compte;
		 private String noCompte_me;
		 private String email;
		 private String parameterEmail;
		 private String codeConf;
		 
		public String getCodeConf() {
			return ((String)get("codeConf"));
		}

		public void setCodeConf(String codeConf) {
			set("codeConf", codeConf);
		}

		public String getParameterEmail() {
			return ((String)get("sessionParam"));
		}

		public void setParameterEmail(String parameterEmail) {
			set("sessionParam", parameterEmail);
		}

		public String getEmailSession() {
			return( (String)get("mailSession"));
		}

		public void setEmailSession(String emailSession) {
			this.emailSession = emailSession;
		}



		

		public String getEmail() {
			return getUsername();
		}

		public void setEmail(String email) {
			set("sessionEmail", email);
		}

		public ServiceLocal getService() {
			return service;
		}

		public void setService(ServiceLocal service) {
			this.service = service;
		}

		public double getSolde_compte() {
			return( (double)get("sessionSolde"));
		}

		public void setSolde_compte(double solde_compte) {
			set("sessionSolde", solde_compte);
		}

		
		public String getMotdePasse() {
			return motdePasse;
		}
		public void setMotdePasse(String motdePasse) {
			this.motdePasse = motdePasse;
		}

		public String getEmail_me() {
			return email_me;
			
		}
		public void setEmail_me(String email_me) {
		this.email_me = email_me;
			
		}
		
	public String getNoCompte_me() {
		return ((String)get("sessionCompte"));
	}
	public void setNoCompte_me(String noCompte_me) {
		set("sessionCompte", noCompte_me);
	}

	
	public String getUsername(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		 String username = request.getRemoteUser();
	
	return username;	
	}	
	
		
		private static void set(String cle, Object valeur){
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
			HttpSession session = request.getSession(false);
			session.setAttribute(cle, valeur);
	        }
	
	    private static Object get(String cle){
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
	    	HttpSession session = request.getSession(false);
	    	 Object res = null;
	       
	        res = session.getAttribute(cle);
	        
	        return res;
	    }

		
		
	public void submit() throws IOException {
			FacesContext context =
			FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest)
			context.getExternalContext().getRequest();
			try {
			request.login(email_me,motdePasse);
			if(request.isUserInRole("MEMBRE")){

			 context = FacesContext.getCurrentInstance();
				    context.getExternalContext().redirect("/KrediNetWebDesign/faces/Page/connexionCompteMembre.xhtml");  
	            }
			
			} catch (ServletException e) {
			context.addMessage(null, new FacesMessage("Email ou mot de passe invalide"));
			}
		
			
		}
		
	
		
		   public String logout() {
		        FacesContext.getCurrentInstance().
		        getExternalContext().invalidateSession();
		        email_me="";
		        return "/faces/static/main.xhtml";
		    }
		
	
		   /*String	uri = (String) FacesContext.getCurrentInstance()
			.getExternalContext().getRequestMap()
			.get(RequestDispatcher.INCLUDE_PATH_INFO);*/
}

