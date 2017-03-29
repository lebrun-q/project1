package com.metier;

import java.util.ArrayList;

public class Usager {
	private String idUsager;
	private String nom;
	private String prenom;
	private String adrRueUsager;
	private String cpUsager;
	private String adrVilleUsager;
	private ArrayList<Habitation> lesHabitations;

	public Usager(String idUsager, String nom, String prenom, String adrRueUsager, String cpUsager,
			String adrVilleUsager) {
		super();
		this.idUsager = idUsager;
		this.nom = nom;
		this.prenom = prenom;
		this.adrRueUsager = adrRueUsager;
		this.cpUsager = cpUsager;
		this.adrVilleUsager = adrVilleUsager;
	}

	public String getIdUsager() {
		return idUsager;
	}

	public void setIdUsager(String idUsager) {
		this.idUsager = idUsager;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdrRueUsager() {
		return adrRueUsager;
	}

	public void setAdrRueUsager(String adrRueUsager) {
		this.adrRueUsager = adrRueUsager;
	}

	public String getCpUsager() {
		return cpUsager;
	}

	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}

	public String getAdrVilleUsager() {
		return adrVilleUsager;
	}

	public void setAdrVilleUsager(String adrVilleUsager) {
		this.adrVilleUsager = adrVilleUsager;
	}
	public void AjoutHabitation(Habitation uneHabitation){
		lesHabitations.add(uneHabitation);
	}
	public void SupprimerHabitation(Habitation uneHabitations){
		lesHabitations.remove(uneHabitations);
	}

	@Override
	public String toString() {
		return "Usager [idUsager=" + idUsager + ", nom=" + nom + ", prenom=" + prenom + ", adrRueUsager=" + adrRueUsager
				+ ", cpUsager=" + cpUsager + ", adrVilleUsager=" + adrVilleUsager + "]";
	}
	
	

}
