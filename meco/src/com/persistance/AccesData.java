package com.persistance;

import java.util.ArrayList;

import com.metier.Camion;
import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;

public class AccesData {
	
	public static ArrayList<Habitation> getLesHabitations(){
		HabitationDAO hDAO = new HabitationDAO();
		return hDAO.retrieve();
	}
	public static Usager getUsager(String id){
		UsagerDAO udao = new UsagerDAO();
		return udao.find(id);
		
	}
	public static Habitation getHabitation(String id){
		HabitationDAO hdao = new HabitationDAO();
		return hdao.find(id);
	}
	public static boolean ajoutLevee(Levee uneLevee){
		leveeDAO ldao = new leveeDAO();
		return ldao.create(uneLevee);
	}
	public static boolean ajoutFacture(Facture uneFacture){
		FactureDAO fdao = new FactureDAO();
		return fdao.create(uneFacture);
	}
	public static Levee getLevee(int id){
		leveeDAO ldao = new leveeDAO();
		return ldao.find(id);
	}
	public static ArrayList<Levee> getLesLevees(String idPoub){
		leveeDAO ldao = new leveeDAO();
		return ldao.retrieveParPoubelle(idPoub);
	}
	public static TypeDechet getTypeDechet(String id){
		TypeDechetDAO tdao = new TypeDechetDAO();
		return tdao.find(id);
	}
	public static Poubelle getPoubelle(String id){
		PoubelleDAO pdao = new PoubelleDAO();
		return pdao.find(id);
	}
	public static ArrayList<Poubelle> getLesPoubelles(String idHab){
		PoubelleDAO pdao = new PoubelleDAO();
		return pdao.retrieveParHabitation(idHab);
	}
	public static boolean ajoutCamion(Camion unCamion){
		CamionDAO cdao = new CamionDAO();
		return cdao.create(unCamion);
	}
	public static Camion getCamion(String id){
		CamionDAO cdao = new CamionDAO();		
		return cdao.find(id);
	}
	public static ArrayList<Camion> getLesCamions(){
		CamionDAO cdao = new CamionDAO();
		return cdao.retrieve();
	}
	
}
