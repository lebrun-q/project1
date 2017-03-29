package com.metier;

public class Facture {
	private int idFac;
	private int moisF;
	private int anF;
	private String nomFacture;
	private String idHabitation;
	public Facture(int idFac, int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.idFac = idFac;
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	
	public Facture(int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}

	public int getMoisF() {
		return moisF;
	}
	public void setMoisF(int moisF) {
		this.moisF = moisF;
	}
	public int getAnF() {
		return anF;
	}
	public void setAnF(int anF) {
		this.anF = anF;
	}
	public String getNomFacture() {
		return nomFacture;
	}
	public void setNomFacture(String nomFacture) {
		this.nomFacture = nomFacture;
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	public int getIdFac() {
		return idFac;
	}
	
	
	
	

}
