package com.persistance;

import java.sql.*;

import com.util.Parametre;
//nom de compte : trisel
//mot de passe 	: trisel
//	 classe permettant l'ouverture, la fermeture de la base //mysql bd_trisel sur localhost 
public class AccesBd {
	// description des propriétés
	private  static Connection con=null;
	private static String url;
	public static Connection  getInstance() {
		// accès direct sans source de données odbc
		url=Parametre.getCheminBd();
		if (con==null)
		{
			try
			{// chargement du driver, librairie mysql connector liée au projet
				Class.forName("com.mysql.jdbc.Driver");
				// connexion utilisateur root ou changer avec votre code utilisateur
				con=DriverManager.getConnection(url,"trisel","trisel");
			}
			// ouverture de la connexion
			catch (ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
				System.out.println("échec driver");
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage());
				System.out.println("échec de connexion bd ");
			}
		}

		return con;
	}
	//	 fermeture de la connexion
	public static void close(){
		try { 
			con.close();
		}
		catch(Exception e) {e.printStackTrace();
		System.out.println("problème lors de la fermeture");}
	}
}


