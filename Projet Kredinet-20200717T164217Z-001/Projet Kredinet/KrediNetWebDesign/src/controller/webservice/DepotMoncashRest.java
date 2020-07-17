package controller.webservice;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import entities.CompteMembre;
import entities.Depot;
import entities.DepotMoncash;
import entities.ProfileMembre;
import entities.service.ServiceLocal;

@Path("/")
public class DepotMoncashRest {

	@EJB
	private ServiceLocal metier;

	
	@GET
	@Path("saveDepotMoncash")
	@Produces(MediaType.APPLICATION_JSON)
	public String saveDepotMoncash(@QueryParam(value="idTrans")Long id,
			@QueryParam(value="montant")double montant,
			@QueryParam(value="tel")String tel){
		String response="";
	    String noCompte ="c";
	    
	  
			 List<ProfileMembre>list= metier.lister(tel);
			 for(ProfileMembre p:list){
				noCompte=p.getNoCompte_me().getNoCompte_me();
			 }
	    
	    if(montant<500){
			response="MI";
		
	    }else{
	    	  try{
		
			
			 
			 
			 DepotMoncash dpm=new DepotMoncash(id,montant,tel,new Date(),"Actif");
			Depot dp=new Depot(montant, new Date(),new CompteMembre(noCompte) );
			
			metier.depot(dp, dpm, noCompte);
			 
			response="success";
		}catch(Exception e){
			
		}
	    }
		return response;
	}
}
