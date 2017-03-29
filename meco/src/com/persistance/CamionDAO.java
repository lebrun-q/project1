package com.persistance;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import com.metier.Camion;

public class CamionDAO extends DAO<Camion> {

	@Override
	public boolean create(Camion obj) {
		Connection con = null;
		con = AccesBd.getInstance();
		Statement requete;
		Date laDate = obj.getDateMiseEnCirculation();
		java.sql.Date sqlDate = new java.sql.Date(laDate.getTime());
		Camion unCamion = new Camion(obj.getImmatriculation(),obj.getDateMiseEnCirculation());
		try {
			requete = con.createStatement();
			String immatriculation = obj.getImmatriculation();
			Date dateMiseEnCirculation = obj.getDateMiseEnCirculation();
			requete.executeUpdate("INSERT INTO Camion VALUES('"+immatriculation+"','"+sqlDate+"');");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Camion obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Camion obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Camion find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Camion find(String id) {
		ResultSet rsCamion;
		Camion unCamion = null;
		try {
			String sql = "SELECT * FROM camion WHERE immatriculation='"+id+"'";
			rsCamion = con.createStatement().executeQuery(sql);
			if (rsCamion.next()) {
				unCamion = new Camion(id,new Date(rsCamion.getDate("dateMiseEnCirculation").getTime()));
				System.out.println(unCamion.toString());
			}
		} catch (SQLException e) {
			System.out.println("SELECT * FROM camion WHERE immatriculation='"+id+"'");
		}
		return unCamion;
	}

	@Override
	public ArrayList<Camion> retrieve() {
		ResultSet rsCamion;
		ArrayList<Camion> lesCamion = null;
		Camion unCamion = null;
		try {
			String sql = "SELECT * FROM camion";
			rsCamion = con.createStatement().executeQuery(sql);
			while (rsCamion.next()) {
				unCamion = new Camion(rsCamion.getString("immatriculation"),new Date(rsCamion.getDate("dateMiseEnCirculation").getTime()));
				System.out.println(lesCamion.toString());
			}
		} catch (SQLException e) {
			System.out.println("SELECT * FROM camion WHERE");
		}
		return lesCamion;
	}

}
