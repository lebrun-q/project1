package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleDAO extends DAO<Poubelle> {

	@Override
	public boolean create(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Poubelle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Poubelle find(String id) {
		ResultSet rsPoubelle;
		Poubelle unPoubelle = null;
		TypeDechet typeD = null;
		try {
			String sql = "SELECT * FROM Poubelle WHERE idPoubelle='" + id + "'";
			rsPoubelle = con.createStatement().executeQuery(sql);
			if (rsPoubelle.next()) {
				typeD = AccesData.getTypeDechet(rsPoubelle.getString(2));
				unPoubelle = new Poubelle(id, rsPoubelle.getString(2), typeD);
				unPoubelle.setLesLevees(AccesData.getLesLevees(id));
			}
		} catch (SQLException e) {
			System.out.println("ERREUR");
		}
		return unPoubelle;
	}

	@Override
	public ArrayList<Poubelle> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Poubelle> retrieveParHabitation(String idHab) {
		ArrayList<Poubelle> lesPoubelles = new ArrayList<Poubelle>();
		String sqlPoub = "SELECT idPoubelle FROM poubelle WHERE idHabitation='" + idHab + "'";
		ResultSet rsPoubelle;
		try {
			rsPoubelle = con.createStatement().executeQuery(sqlPoub);
			while (rsPoubelle.next()) {
				lesPoubelles.add((this.find(rsPoubelle.getString(1))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lesPoubelles;
		
	}

}
