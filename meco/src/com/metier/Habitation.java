package com.metier;

import java.util.ArrayList;

public class Habitation {
	private String idHabitation;
	private String adrRueHab;
	private String cpHab;
	private String adrVilleHab;
	private int nbPersonne;
	private Usager usager;
	private ArrayList<Poubelle> lesPoubelles;
	private ArrayList<Facture> lesFactures;
	


	public Habitation(String idHabitation, String adrRueHab, String cpHab, String adrVilleHab, int nbPersonne,
			Usager usager) {
		super();
		this.idHabitation = idHabitation;
		this.adrRueHab = adrRueHab;
		this.cpHab = cpHab;
		this.adrVilleHab = adrVilleHab;
		this.nbPersonne = nbPersonne;
		this.usager = usager;
		this.lesPoubelles = new ArrayList<Poubelle>();
		this.lesFactures = new ArrayList<Facture>();
	}

	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public String getAdrRueHab() {
		return adrRueHab;
	}

	public void setAdrRueHab(String adrRueHab) {
		this.adrRueHab = adrRueHab;
	}

	public String getCpHab() {
		return cpHab;
	}

	public void setCpHab(String cpHab) {
		this.cpHab = cpHab;
	}

	public String getAdrVilleHab() {
		return adrVilleHab;
	}

	public void setAdrVilleHab(String adrVilleHab) {
		this.adrVilleHab = adrVilleHab;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	
	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	public ArrayList<Poubelle> getLesPoubelles() {
		return lesPoubelles;
	}

	public void setLesPoubelles(ArrayList<Poubelle> lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}

	public void AjoutPoubelle(Poubelle unePoubelle){
		lesPoubelles.add(unePoubelle);
	}
	public void SupprimerPoubelle(Poubelle unePoubelle){
		lesPoubelles.remove(unePoubelle);		
	}
	public double getCout(int an,int mois){
		double cout = 0;
		for(Poubelle p : lesPoubelles)
		{
			cout += p.getCout(an, mois);
		}
		
		return cout;
	}
	public ArrayList<Facture> getLesFactures(){
		return lesFactures;
	}
	
	public void setLesFactures(ArrayList<Facture> lesFactures){
		this.lesFactures=lesFactures;
	}
	public void addFacture(Facture f){
		lesFactures.add(f);
	}

	@Override
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adrRueHab=" + adrRueHab + ", cpHab=" + cpHab
				+ ", adrVilleHab=" + adrVilleHab + ", nbPersonne=" + nbPersonne + "]";
	}

}
