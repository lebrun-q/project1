package com.util;

import java.io.File;
import com.metier.Habitation;
import com.metier.Usager;

/**
 * @author lebrun-q Class pour acc�der aux diff�rents chemins d'acc�s aux
 *         diff�rents dossiers
 */
public class Parametre {
	/**
	 * D�claration de la variable nomFichier contenant le nom du fichier de
	 * param�tre
	 */
	private static String nomFichier = "paramAppli.ini";

	/**
	 * R�cup�re sous un tableau les chemins d'acc�s dans le fichier
	 * paramAppli.ini
	 * 
	 * @param id
	 *            On donne l'index du chemin tel qu'il est index� dans le
	 *            tableau
	 * @return On retourne la ligne souhait� en fonction de l'index
	 */
	private static String getParametres(int id) {
		FichierTexte Fichier = new FichierTexte();
		Fichier.openFileReader(nomFichier);
		String[] lignes = new String[10];
		for (int i = 0; i < 10; i++) {
			lignes[i] = Fichier.readLigne();
		}
		return lignes[id - 1].toString();
	}

	/**
	 * On appel la fonction getParametres avec l'index du chemin souhait�
	 * 
	 * @return On retourne le r�sultat de getParam�tre de l'index donn�
	 */
	public static String getCheminBd() {

		return getParametres(2);

	}

	/**
	 * On appel la fonction getParametres avec l'index du chemin souhait�
	 * 
	 * @return On retourne le r�sultat de getParam�tre de l'index donn�
	 */
	public static String getCheminLeveeATraiter() {
		return getParametres(4);

	}

	/**
	 * On appel la fonction getParametres avec l'index du chemin souhait�
	 * 
	 * @return On retourne le r�sultat de getParam�tre de l'index donn�
	 */
	public static String getCheminLeveeLog() {
		return getParametres(10);

	}

	/**
	 * On appel la fonction getParametres avec l'index du chemin souhait�
	 * 
	 * @return On retourne le r�sultat de getParam�tre de l'index donn�
	 */
	public static String getCheminLeveeTraites() {
		return getParametres(6);

	}

	/**
	 * On appel la fonction getParametres avec l'index du chemin souhait�
	 * 
	 * @return On retourne le r�sultat de getParam�tre de l'index donn�
	 */
	public static String getCheminFacturePdf() {
		return getParametres(8);

	}

	/**
	 * R�cup�re l'extension d'un fichier
	 * 
	 * @param nomFichier
	 *            On donne le nom du fichier
	 * @return On retourne l'extension du fichier
	 */
	public static String getExtensionFichier(String nomFichier) {
		String infoFic;
		File f = new File(nomFichier);
		infoFic = f.getName().substring(f.getName().indexOf(".") + 1);
		if (f.getName().indexOf(".") != -1) {
			return infoFic.toString();
		} else {
			if (infoFic.toString() != "txt" && infoFic.toString() != "xml") {
				return "Fichier incorrect";

			}
			else {
				return "error";
			}
		}
	}
	
	/**
	 * 
	 * 
	 *
	 */
	public static String getNomFichier(Habitation h, int a,int m) {
		Usager u = h.getUsager();
		String[] mois = {"","Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
		String nomFic = h.getIdHabitation()+"-"+u.getIdUsager()+"-Facture-"+mois[m]+"-"+a+".pdf";
		return nomFic;
		

	}
	public static String getCheminFichier(Habitation h,int a,int m) {
		String cheminComplet = null;
		String nomFic = getNomFichier(h, a,m);
		String[] mois = {"","Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
		cheminComplet = getCheminFacturePdf()+"\\"+mois[m]+"\\"+nomFic;
		return cheminComplet;

	}
}
