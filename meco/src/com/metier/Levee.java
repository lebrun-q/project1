package com.metier;

import java.util.Date;

public class Levee {
	private int idLevee;
	private Date laDate;
	private double poids;
	private String idPoubelle;
	private String immatriculation;
	private String idChauffeur;

	public Levee(int idLevee, Date laDate, double poids, String idPoubelle, String immatriculation,
			String idChauffeur) {
		super();
		this.idLevee = idLevee;
		this.laDate = laDate;
		this.poids = poids;
		this.idPoubelle = idPoubelle;
		this.immatriculation = immatriculation;
		this.idChauffeur = idChauffeur;
	}
	

	public Levee(Date laDate, double poids, String idPoubelle, String immatriculation, String idChauffeur) {
		super();
		this.laDate = laDate;
		this.poids = poids;
		this.idPoubelle = idPoubelle;
		this.immatriculation = immatriculation;
		this.idChauffeur = idChauffeur;
	}


	public int getIdLevee() {
		return idLevee;
	}

	public void setIdLevee(int idLevee) {
		this.idLevee = idLevee;
	}

	public Date getLaDate() {
		return laDate;
	}

	public void setLaDate(Date laDate) {
		this.laDate = laDate;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public String getIdPoubelle() {
		return idPoubelle;
	}

	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getIdChauffeur() {
		return idChauffeur;
	}

	public void setIdChauffeur(String idChauffeur) {
		this.idChauffeur = idChauffeur;
	}

	public Levee(int idLevee, Date laDate, double poids) {
		super();
		this.idLevee = idLevee;
		this.laDate = laDate;
		this.poids = poids;
	}
	@Override
	public String toString() {
		return "Levee [idLevee=" + idLevee + ", laDate=" + laDate + ", poids=" + poids + "]";
	}

}
