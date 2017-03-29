package com.util;

import java.io.File;
import com.metier.Habitation;
import com.metier.Usager;

/**
 * @author lebrun-q Class pour accéder aux différents chemins d'accès aux
 *         différents dossiers
 */
public class Parametre {
	/**
	 * Déclaration de la variable nomFichier contenant le nom du fichier de
	 * paramètre
	 */
	private static String nomFichier = "paramAppli.ini";

	/**
	 * Récupère sous un tableau les chemins d'accès dans le fichier
	 * paramAppli.ini
	 * 
	 * @param id
	 *            On donne l'index du chemin tel qu'il est indexé dans le
	 *            tableau
	 * @return On retourne la ligne souhaité en fonction de l'index
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
	 * On appel la fonction getParametres avec l'index du chemin souhaité
	 * 
	 * @return On retourne le résultat de getParamètre de l'index donné
	 */
	public static String getCheminBd() {

		return getParametres(2);

	}

	/**
	 * On appel la fonction getParametres avec l'index du chemin souhaité
	 * 
	 * @return On retourne le résultat de getParamètre de l'index donné
	 */
	public static String getCheminLeveeATraiter() {
		return getParametres(4);

	}

	/**
	 * On appel la fonction getParametres avec l'index du chemin souhaité
	 * 
	 * @return On retourne le résultat de getParamètre de l'index donné
	 */
	public static String getCheminLeveeLog() {
		return getParametres(10);

	}

	/**
	 * On appel la fonction getParametres avec l'index du chemin souhaité
	 * 
	 * @return On retourne le résultat de getParamètre de l'index donné
	 */
	public static String getCheminLeveeTraites() {
		return getParametres(6);

	}

	/**
	 * On appel la fonction getParametres avec l'index du chemin souhaité
	 * 
	 * @return On retourne le résultat de getParamètre de l'index donné
	 */
	public static String getCheminFacturePdf() {
		return getParametres(8);

	}

	/**
	 * Récupère l'extension d'un fichier
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
