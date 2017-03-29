package com.persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.metier.Usager;

public class UsagerDAO extends DAO<Usager> {
	
	@Override
	public boolean create(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usager find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usager find(String id) {
		ResultSet rsUsager;
		Usager unUsager = null;
		try {
			String sql = "SELECT * FROM usager WHERE idUsager='"+id+"'";
			rsUsager = con.createStatement().executeQuery(sql);
			if (rsUsager.next()) {
				unUsager = new Usager(id,rsUsager.getString(2),rsUsager.getString(3),rsUsager.getString(4),rsUsager.getString(5),rsUsager.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("erreur");
		}
		return unUsager;
	}

	@Override
	public ArrayList<Usager> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
