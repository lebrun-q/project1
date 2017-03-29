package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.TypeDechet;

public class TypeDechetDAO extends DAO<TypeDechet> {

	@Override
	public boolean create(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypeDechet find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDechet find(String id) {
		ResultSet rsTypeDechet;
		TypeDechet unTypeDechet = null;
		try {
			String sql = "SELECT * FROM typedechet WHERE idTypeDechet='"+id+"'";
			rsTypeDechet = con.createStatement().executeQuery(sql);
			
			if (rsTypeDechet.next()) {
				unTypeDechet = new TypeDechet(id,rsTypeDechet.getString(2),rsTypeDechet.getDouble(3));
			}
		} catch (SQLException e) {
			System.out.println("erreur");
		}
		return unTypeDechet;
	}

	@Override
	public ArrayList<TypeDechet> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
