package com.util;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.metier.Levee;
import com.persistance.AccesData;

public class InsertionLevee {

	/**
	 * Prend le nom du fichier en paramètre puis récupère son contenu dans un
	 * tableau
	 * @param cheminlevee
	 */
	public static void traitementFicTexte(String cheminlevee) {

		String ligne = " ";

		// ouverture du fichier texte
		FichierTexte fichier = new FichierTexte();
		fichier.openFileReader(cheminlevee);
		// lecture de la première ligne
		ligne = fichier.readLigne();
		/* System.out.println("1 ere ligne" + ligne); */
		// décompose la premire ligne
		String data[] = ligne.split(":");
		String immatriculation = data[0];
		String codeChauffeur = data[1];
		String date = data[2];
		// Affichage des lignes
		System.out.println("Immatricule: " + immatriculation);
		System.out.println("Code du chauffeur: " + codeChauffeur);
		System.out.println("Date: " + date);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d = sdf.parse(date);
			// tant qu'il ya toujours des lignes dans le fichier
			while ((ligne = fichier.readLigne()) != null) {
				String dataLevee[] = ligne.split(":");

				String idPoubelle = dataLevee[0];
				double p = Double.parseDouble(dataLevee[1]);
				Levee uneLevee = new Levee(d,p,idPoubelle,immatriculation,codeChauffeur);
				AccesData.ajoutLevee(uneLevee);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			fichier.closeFileReader();
		}

	}

	/**
	 * Prend le nom du fichier en paramètre puis récupère son contenu à l'aide
	 * du racine.getChild
	 * 
	 * @param cheminlevee
	 */
	public static void traitementFicXml(String cheminlevee) {
		// déclaration document xml
		Document document = null;
		// déclaration élément racine
		Element racine = null;
		// On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();

		// convertion de la date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			document = sxb.build(new File("pesee.xml"));
			// On initialise un nouvel élément racine avec l'élément racine du
			// document.
			racine = document.getRootElement();
			System.out.print("immatriculation :  ");
			System.out.println(racine.getChild("immatriculation").getText());
			System.out.print("codechauffeur :  ");
			System.out.println(racine.getChild("codechauffeur").getText());
			System.out.print("date :  ");
			System.out.println(racine.getChild("date").getText());

			Date d = sdf.parse(racine.getChild("date").getText());
			// On crée une List contenant tous les noeuds "Levee"
			List<Element> listLevee = racine.getChildren("levee");
			// parcours
			for (Element e : listLevee) {
				System.out.print("Poubelle :  ");
				System.out.println(e.getChild("poubelle").getText() + "  ");
				System.out.print("Poids :  ");
				System.out.println(e.getChild("poids").getText() + "  ");
				double p = Double.parseDouble(e.getChildText("poids"));

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------------");
	}

	/**
	 * 
	 */
	public static void traitementLevee() {
		String atraiter = Parametre.getCheminLeveeATraiter();
		String traiter = Parametre.getCheminLeveeTraites();
		String log = Parametre.getCheminLeveeLog();

		File fileAtraiter = new File(atraiter);
		File fileTraiter = new File(traiter);
		File fileLog = new File(log);
		File[] listeAtraiter = fileAtraiter.listFiles();

		if (listeAtraiter.length == 0) {
			System.out.println("aucun fichier à traiter");
		} else {
			int i = 0;

			while (i < listeAtraiter.length) {
				if (listeAtraiter[i].isFile()) {
					File nouvCh = new File(fileTraiter + "\\" + listeAtraiter[i].getName());
					File nouvChBug = new File(fileLog + "\\" + listeAtraiter[i].getName());
					String ext = Parametre.getExtensionFichier(listeAtraiter[i].getName());
					System.out.println(ext);
					switch (ext) {
					case "txt":
						traitementFicTexte(listeAtraiter[i].getAbsolutePath());

						listeAtraiter[i].renameTo(nouvCh);
						break;
					case "xml":
						traitementFicXml(listeAtraiter[i].getAbsolutePath());
						listeAtraiter[i].renameTo(nouvCh);
						break;

					default:
						System.out.println("Fichier incorrect");
						listeAtraiter[i].renameTo(nouvChBug);

					}

				}

				i++;
			}

		}
	}
}