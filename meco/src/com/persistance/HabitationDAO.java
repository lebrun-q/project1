package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.metier.Habitation;

public class HabitationDAO extends DAO<Habitation> {

	@Override
	public boolean create(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Habitation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Habitation find(String id) {
		Habitation hab = null;
		String sqlHab;
		ResultSet rsHab;
		sqlHab = "SELECT * FROM habitation WHERE idHabitation = '" + id + "'";
		try {
			rsHab = con.createStatement().executeQuery(sqlHab);
			if (rsHab.next()) {
				hab = new Habitation(id, rsHab.getString(2), rsHab.getString(3), rsHab.getString(4), rsHab.getInt(5),
						AccesData.getUsager(rsHab.getString(6)));
				hab.setLesPoubelles(AccesData.getLesPoubelles(id));
			}
		}

		catch (SQLException e) {
			System.out.println("erreur");
		}
		return hab;
	}

	@Override
	public ArrayList<Habitation> retrieve() {
		ResultSet rs;
		String sql;
		ArrayList<Habitation> listeHab = new ArrayList<Habitation>();
		try {
			sql = "SELECT idHabitation FROM Habitation ";
			rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				listeHab.add(this.find(rs.getString("idHabitation")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeHab;
	}

}
