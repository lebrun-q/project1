package com.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.metier.Levee;

public class leveeDAO extends DAO<Levee> {

	@Override
	public boolean create(Levee obj) {
		Connection con = null;
		con = AccesBd.getInstance();
		Statement requete;
		try {
			Date laDate = obj.getLaDate();
			java.sql.Date sqlDate = new java.sql.Date(laDate.getTime());
			double lePoids = obj.getPoids();
			String idPoubelle = obj.getIdPoubelle();
			String immatriculation = obj.getImmatriculation();
			String idChauffeur = obj.getIdChauffeur();

			requete = con.createStatement();
			requete.executeUpdate(
					"INSERT INTO Levee(laDate,poids,idPoubelle,immatriculation,idChauffeur) VALUES('" + sqlDate + "','"
							+ lePoids + "','" + idPoubelle + "','" + immatriculation + "','" + idChauffeur + "');");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Levee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Levee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Levee find(int id) {
		ResultSet listeLevee;
		Levee uneLevee = null;
		try {
			String sql = "SELECT * FROM levee WHERE idLevee=" + id;
			listeLevee = con.createStatement().executeQuery(sql);
			if (listeLevee.next()) {
				uneLevee = new Levee(id, new Date(listeLevee.getDate("laDate").getTime()), listeLevee.getDouble(3),
						listeLevee.getString(4), listeLevee.getString(5), listeLevee.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("erreur");
		}
		return uneLevee;
	}

	@Override
	public Levee find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Levee> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Levee> retrieveParPoubelle(String idPoub) {
		ArrayList<Levee> lesLevees = new ArrayList<Levee>();
		String sqlLevee = "SELECT idLevee FROM levee WHERE idPoubelle='" + idPoub + "'";
		ResultSet rsLevee;
		try {
			rsLevee = con.createStatement().executeQuery(sqlLevee);
			
			while (rsLevee.next()) {
				lesLevees.add(find(rsLevee.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lesLevees;
	}
}
