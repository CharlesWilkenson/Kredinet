package entities.service;

import java.util.List;

import javax.ejb.Local;

import entities.Adresse;
import entities.CompteMembre;
import entities.Depot;
import entities.DepotMoncash;
import entities.DesactiverLien;
import entities.Membre;
import entities.MobiliteMembre;
import entities.Operation;
import entities.Placement;
import entities.Pret;
import entities.ProfileMembre;
import entities.Remboursement;
import entities.Retrait;
import entities.Transfert;

@Local
public interface ServiceLocal {
//Les services de l'interface Membre	
public void enregistrer(Membre mb);
public Membre rechercher(String email);
public void modifier(Membre mb);
public List<Membre> listerMembre();



//Les services de l'interface CompteMembre	
public String enregistrer(CompteMembre cp,ProfileMembre pm,DesactiverLien d);
public CompteMembre getCompte(String noCompte);
public void modifier(CompteMembre cp,ProfileMembre pm);
public List<CompteMembre> listerCompte();
public List<CompteMembre> listerCompte(String critere);


//Les interfaces de la classe ProfileMembre
public void enregistrer(ProfileMembre auth);
public ProfileMembre rechercherAuth(String cin_nif);
public List<ProfileMembre> lister();
public List<ProfileMembre> lister(String tel);
public void modifier(ProfileMembre auth,MobiliteMembre m);
public void modifier(ProfileMembre auth);

//Les interfaces de la classe Placement
public double calculer();
public double caluler();

//Les interfaces de la classe Operation
	public void placement(Placement pl,String noCompte);
	public List<Placement> listerPlacement(String numeroCompte,String critere);
	public List<Placement> listerPlacement(Boolean etat,String critere,double montant);

	
	
	public void depot(Depot dp,DepotMoncash dm,String noCompte );
	public List<Depot> listerDepot(String numeroCompte,String critere);
	
	public void pret(Pret pt);
	
	public List<Pret> listerPret(String numeroCompte,String critere,Boolean etat);
	public List<Pret> listerPret(String critere,String etat);
	
	
	
	
	
	
	
	public void remboursement(Remboursement rb);
	public List<Remboursement> listerRemboursement(String numeroCompte,String critere);
	
	public void retrait(Retrait rt);
	public List<Retrait> listerRetrait(String numeroCompte,String critere);
	
	public void saveDepotMoncash(DepotMoncash d);
	public DepotMoncash getDepotMoncash(Long id);
	public void deletDepotMonCash(Long id);
    public double calculer(CompteMembre solde);
    
    public List<Transfert> listerTransfert(String noCompte,String critere);
    public void tranfere(String noCompte1,String noCompte2,double montant);
	
public ProfileMembre getNoCompte(String id);

public DesactiverLien getLien(String id);
}
