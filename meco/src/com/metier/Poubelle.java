package com.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Poubelle {
	private String idPoubelle;
	private String idHabitation;
	private ArrayList<Levee> listeLevees;
	private TypeDechet typeDechet;

	public Poubelle(String idPoubelle, String idHabitation, TypeDechet td) {
		super();
		this.idPoubelle = idPoubelle;
		this.idHabitation = idHabitation;
		this.listeLevees = new ArrayList<Levee>();
		this.typeDechet = td;
	}

	public ArrayList<Levee> getLesLevee(int an, int mois){
		ArrayList<Levee> leveeFilt = new ArrayList<Levee>();;
		Calendar date = Calendar.getInstance();
		for(Levee l : listeLevees)
		{
			date.setTime(l.getLaDate());
			int anTmp = date.get(Calendar.YEAR);
			int moisTmp = date.get(Calendar.MONTH)+1;
			if((anTmp == an) && (moisTmp == mois)) 
			{
				leveeFilt.add(l);
			}
		}
		return leveeFilt;
	}
	public double getCout(int an , int mois){
		double cout = 0;
		ArrayList<Levee> lstLevee = new ArrayList<Levee>();
		lstLevee = getLesLevee(an, mois);
		for(Levee l : lstLevee){
			cout += (l.getPoids() * typeDechet.getTarif());
			
		}
		return cout;
	}



	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", idHabitation=" + idHabitation + ", listeLevees=" + listeLevees
				+ ", typeDechet=" + typeDechet + "]";
	}

	public String getIdPoubelle() {
		return idPoubelle;
	}

	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}

	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public ArrayList<Levee> getLesLevees() {
		return listeLevees;
	}

	public void setLesLevees(ArrayList<Levee> lesLevees) {
		this.listeLevees = lesLevees;
	}

	public TypeDechet getTypeDechet() {
		return typeDechet;
	}

	public void setTypeDechet(TypeDechet typeDechet) {
		this.typeDechet = typeDechet;
	}

	public Poubelle(String idPoubelle) {
		super();
		this.idPoubelle = idPoubelle;
	}

	public void addLevee(Levee le1) {
		this.listeLevees.add(le1);
	}

}
