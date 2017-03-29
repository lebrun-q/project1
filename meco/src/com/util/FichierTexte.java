package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FichierTexte {
	// buffer de lecture
	private BufferedReader br;
	// buffer d'écriture
	private BufferedWriter bw;
	public FichierTexte()
	{
		br=null;
		bw=null;
	}
	// ouverture du fichier en lecture
	/**
	 * ouvre un fichier en lecture
	 * @param nom
	 * On le donne le nom du fichier concerné 
	 * @return
	 * On retourne un bool : true si le fichier est bien ouvert, false sinon
	 */
	public boolean openFileReader(String nom)
	{
		boolean open;
		FileInputStream fichier=null;
		try
		{
			fichier=new FileInputStream(new File(nom));
			br=new BufferedReader(new InputStreamReader(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	// ouverture du fichier en écriture
	/**
	 * Ouverture du fichier en écriture
	 * @param nom
	 * On donne le nom du fichier concerné
	 * @return
	 * on retourne un bool true si le fichier est ouvert, false sinon
	 */
	public boolean openFileWriter(String nom)
	{ 
		boolean open;
		FileOutputStream fichier=null;
		try
		{
			fichier=new FileOutputStream(nom);
			bw=new BufferedWriter(new OutputStreamWriter(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	// fermeture du flux d'écriture
	/**
	 * On ferme le flux d'écriture
	 * @return
	 * On retourne un bool si le flux est ferlé true, false sinon
	 */
	public boolean closeFileWriter()
	{
		boolean ok = true;
		try
		{
			bw.close();
		}
		catch (IOException e)
		{
			ok = false;
		}
		return ok;
	}
// fermeture du flux de lecture
	/**
	 * Fermeture du flux de lecture
	 */
	public void closeFileReader()
	{
		try
		{
			br.close();}
		catch (IOException e)
		{
			System.out.println("pb fermeture");
		}
	}
	// écriture d'une ligne
	/**
	 * On écrit une ligne dans le fichier texte
	 * @param ligne
	 * On donne la ligne à écrire dans le fichier
	 */
	public void writeLigne(String ligne)
	{
		try
		{
			bw.write(ligne+"\n");
		}
		catch (IOException e)
		{
			System.out.println("pb ecriture");
		}
	}
	// lecture d'une ligne
	/**
	 * On lit une ligne du fichier
	 * @return
	 * on retourne la ligne
	 */
	public String readLigne()
	{
		String ligne=null;
		try
		{
			ligne= br.readLine();
		}
		catch (IOException e)
		{
			System.out.println("pb lecture");
		}
		return ligne;
	}
}