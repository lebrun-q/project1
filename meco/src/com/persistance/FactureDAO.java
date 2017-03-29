package com.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Poubelle;


public class FactureDAO extends DAO<Facture> {

	@Override
	public boolean create(Facture obj) {
		Connection con = null;
		con = AccesBd.getInstance();
		Statement requete;;
		try {
			requete = con.createStatement();
			int idF = obj.getIdFac();
			int moisF = obj.getMoisF();
			int anF = obj.getAnF();
			String nomF = obj.getNomFacture();
			String idHab = obj.getIdHabitation();
			String sqlSelect = "SELECT * FROM Facture WHERE moisF='" + moisF + "'AND anF='" + anF + "' AND nomFacture='" + nomF + "'AND idHabitation='" + idHab + "'";
			ResultSet rs = requete.executeQuery(sqlSelect);
			if(!rs.next())
			{
				requete.executeUpdate("INSERT INTO Facture (moisF,anF,nomFacture,idHabitation) VALUES('"+moisF+"','"+anF+"','"+nomF+"','"+idHab+"');");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Facture find(int id) {
		Facture f = null;
		String sqlFac;
		ResultSet rsFac;
		sqlFac = "SELECT * FROM Facture WHERE idFacture = '" + id + "'";
		try {
			rsFac = con.createStatement().executeQuery(sqlFac);
			if (rsFac.next()) {
				f = new Facture(id, rsFac.getInt(2), rsFac.getInt(3), rsFac.getString(4), rsFac.getString(5));
			}
			
		}

		catch (SQLException e) {
			System.out.println("erreur");
		}
		return f;
	}

	@Override
	public Facture find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Facture> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Facture> retrieveFactureParHabitation(String idHab) {
		ArrayList<Facture> lesFactures = new ArrayList<Facture>();
		String sqlFac = "SELECT * FROM Facture WHERE idHabitation='" + idHab + "'";
		ResultSet rsFacture;
		try {
			rsFacture = con.createStatement().executeQuery(sqlFac);
			while (rsFacture.next()) {
				lesFactures.add((this.find(rsFacture.getString(1))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lesFactures;
		
	}

}