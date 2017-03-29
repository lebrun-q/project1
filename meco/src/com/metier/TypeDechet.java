package com.metier;

public class TypeDechet {
	private String idTypeDechet;
	private String libelle;
	private double tarif;
	@Override
	public String toString() {
		return "TypeDechet [idTypeDechet=" + idTypeDechet + ", libelle=" + libelle + ", tarif=" + tarif + "]";
	}
	public String getIdTypeDechet() {
		return idTypeDechet;
	}
	public void setIdTypeDechet(String idTypeDechet) {
		this.idTypeDechet = idTypeDechet;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public TypeDechet(String idTypeDechet, String libelle, double tarif) {
		super();
		this.idTypeDechet = idTypeDechet;
		this.libelle = libelle;
		this.tarif = tarif;
	}

}
