package com.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.Usager;
import com.persistance.AccesData;
import com.util.Parametre;

public class EditionFacture {

	public void creationFacture(int a,int m) {
		ArrayList<Habitation> lesHabitations = AccesData.getLesHabitations();
		if (lesHabitations.size() != 0) {
			for (Habitation h : lesHabitations) {
				CreerFacture(h, a, m);
			}
		}
	}

	public void EditionElemFacture(Habitation h, int a, int m) {
		double somme = 0;
		double tarif = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date sysDate = new Date();
		Usager u = h.getUsager();
		ArrayList<Poubelle> pbs = h.getLesPoubelles();
		pbs = AccesData.getLesPoubelles(h.getIdHabitation());
		System.out.println(sdf.format(sysDate));
		System.out.println(u.getNom() + " " + u.getPrenom());
		System.out.println(u.getAdrRueUsager() + " " + u.getCpUsager() + " " + u.getAdrVilleUsager());
		System.out.println(h.getAdrRueHab());
		System.out.println(h.getCpHab() + " " + h.getAdrVilleHab());
		System.out.println("Code usager : " + u.getIdUsager());
		System.out.println("Nb personnes : " + h.getNbPersonne());
		System.out.println("Taux part fixe : 3");
		tarif = h.getNbPersonne() * 3;
		System.out.println("Total ht : " + tarif); 
		somme = somme+tarif;
		
		for (Poubelle p : pbs) {
			ArrayList<Levee> levees = p.getLesLevee(a, m);
			System.out.println("----------------------");
			System.out.println("Poubelle : "+p.getIdPoubelle()+" Nature des déchets : "+p.getTypeDechet().getLibelle());
			System.out.println("----------------------");
			for(Levee l : levees){
				Date laDate = l.getLaDate();
				tarif = (l.getPoids())*p.getTypeDechet().getTarif();
				System.out.println("	Date de pesee : "+sdf.format(laDate)+" | NB KG : "+l.getPoids()+" | Prix / KG : "+p.getTypeDechet().getTarif()+" | Total HT "+tarif);
				System.out.println("Total HT : "+Math.round(tarif * 100.0) / 100.0 );
				System.out.println("");
				somme = somme + tarif;
				
			}
		}
		System.out.println("-_-_-_-_-_-_-_-_-_");
		double totalht = Math.round(somme * 100.0) / 100.0  ;
		double tva = (Math.round((somme*0.2) * 100.0) / 100.0);
		double totalpay = totalht+tva;
		System.out.println("Total HT : "+totalht);
		System.out.println("Montant TVA : "+tva);
		System.out.println("Total à payer : "+totalpay);
		System.out.println("_________________________");
		CreerFacture(h,a,m);
		
	}
	public void CreerFacture(Habitation h,int a, int m){
		Date laDate = new Date();
		Document doc = new Document();
		double somme = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM yyyy");
		SimpleDateFormat sdft = new SimpleDateFormat("dd/MM/yyyy");
		Usager u = h.getUsager();
		ArrayList<Poubelle> pbs = h.getLesPoubelles();
		String chemin = Parametre.getCheminFichier(h, a, m);
		String nomFic = Parametre.getNomFichier(h, a, m);
		try{
			PdfWriter.getInstance(doc, new FileOutputStream(chemin));
			doc.open();
			//ENTETE + Line Separator //
			Font font1 = new Font(Font.FontFamily.HELVETICA, 15,Font.BOLD);
			String[] mois = {"","Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
			doc.add(new Paragraph("Facture du mois de "+mois[m]+"-"+a,font1));
			Chunk linebreak = new Chunk(new LineSeparator());
			doc.add(linebreak);
			// IMAGE + DATE SYS//
			Paragraph sysDate = new Paragraph(sdf.format(laDate));
			sysDate.setAlignment(Element.ALIGN_RIGHT);
			Image trisel = Image.getInstance("trisel.jpg");
			doc.add(sysDate);
			doc.add(trisel);
			// INFOS USAGER //
			Paragraph infoUsager = new Paragraph(u.getNom()+" "+u.getPrenom()+"\n"+u.getAdrRueUsager()+"\n"+u.getCpUsager()+""+u.getAdrVilleUsager());
			infoUsager.setIndentationLeft(400);
			doc.add(infoUsager);
			// INFOS HAB //
			Paragraph infoHab = new Paragraph("\n Adreese du logement concerné : \n\n"+h.getAdrRueHab()+"\n"+h.getCpHab()+" "+h.getAdrVilleHab()+"\n\nCode usager : "+u.getIdUsager()+"\nNombre de personnes déclarées : "+h.getNbPersonne());
			infoHab.setSpacingAfter(20);
			doc.add(infoHab);
			// TABLEAU 1 //
			PdfPTable tabInfosHab = new PdfPTable(3);
			PdfPCell cell1 = new PdfPCell (new Paragraph("Taux part fixe"));
			PdfPCell cell2 = new PdfPCell (new Paragraph("Nombre de personnes"));
			PdfPCell cell3 = new PdfPCell (new Paragraph("Total HT"));
			PdfPCell cell4 = new PdfPCell (new Paragraph("3"));
			String intStr = toString().valueOf(h.getNbPersonne());
			PdfPCell cell5 = new PdfPCell (new Paragraph(intStr));
			intStr = toString().valueOf(h.getNbPersonne()*3);
			somme = somme + (h.getNbPersonne() * 3);
			PdfPCell cell6 = new PdfPCell (new Paragraph(intStr));
			cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell1.setBackgroundColor (BaseColor.LIGHT_GRAY);
			cell2.setBackgroundColor (BaseColor.LIGHT_GRAY);
			cell3.setBackgroundColor (BaseColor.LIGHT_GRAY);
			tabInfosHab.addCell (cell1);
			tabInfosHab.addCell (cell2);
			tabInfosHab.addCell (cell3);
			tabInfosHab.addCell (cell4);
			tabInfosHab.addCell (cell5);
			tabInfosHab.addCell (cell6);
			tabInfosHab.setSpacingAfter(40);
			doc.add (tabInfosHab);
			
			// TABLEAU 2 //
			for (Poubelle p : pbs) {
				PdfPTable tb1 = new PdfPTable(4);
				PdfPCell entete1 = new PdfPCell (new Paragraph("Poubelle : "+p.getIdPoubelle()+" Nature des déchets : "+p.getTypeDechet().getLibelle()));
				PdfPCell dateP1 = new PdfPCell (new Paragraph("Date pesée"));
				PdfPCell nbKg1 = new PdfPCell (new Paragraph("Nombre kg"));
				PdfPCell pHt1 = new PdfPCell (new Paragraph("Prix HT au KG"));
				PdfPCell total1 = new PdfPCell (new Paragraph("total HT"));
				entete1.setColspan(4);
				entete1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				dateP1.setBackgroundColor (BaseColor.GRAY);
				nbKg1.setBackgroundColor (BaseColor.GRAY);
				pHt1.setBackgroundColor (BaseColor.GRAY);
				total1.setBackgroundColor (BaseColor.GRAY);
				tb1.addCell(entete1);
				tb1.addCell(dateP1);
				tb1.addCell(nbKg1);
				tb1.addCell(pHt1);
				tb1.addCell(total1);
				ArrayList<Levee> levees = p.getLesLevee(a, m);
				for(Levee l : levees){
					PdfPCell value1 = new PdfPCell (new Paragraph(sdft.format(l.getLaDate())));
					PdfPCell value2 = new PdfPCell (new Paragraph(toString().valueOf(l.getPoids())));
					PdfPCell value3 = new PdfPCell (new Paragraph(toString().valueOf(p.getTypeDechet().getTarif())));
					double total = l.getPoids()*p.getTypeDechet().getTarif();
					PdfPCell value4 = new PdfPCell (new Paragraph(toString().valueOf(Math.round(total * 100.0) / 100.0)));
					tb1.addCell(value1);
					tb1.addCell(value2);
					tb1.addCell(value3);
					tb1.addCell(value4);
					somme = somme + (l.getPoids())*p.getTypeDechet().getTarif();
				}
				tb1.setSpacingAfter(40);
				doc.add(tb1);

			}
			double totalht = Math.round(somme * 100.0) / 100.0  ;
			double tva = (Math.round((somme*0.2) * 100.0) / 100.0);
			double totalpay = totalht+tva;
			PdfPTable tb2 = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell (new Paragraph("Total HT"));
			PdfPCell col2 = new PdfPCell (new Paragraph(toString().valueOf(totalht)));
			PdfPCell col3 = new PdfPCell (new Paragraph("Montant TVA"));
			PdfPCell col4 = new PdfPCell (new Paragraph(toString().valueOf(tva)));
			PdfPCell col5 = new PdfPCell (new Paragraph("Total a payer"));
			PdfPCell col6 = new PdfPCell (new Paragraph(toString().valueOf(totalpay)));
			col1.setColspan(3);
			col1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			tb2.addCell(col1);
			col2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tb2.addCell(col2);
			col3.setColspan(3);
			col3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			tb2.addCell(col3);
			col4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tb2.addCell(col4);
			col5.setColspan(3);
			col5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			tb2.addCell(col5);
			col6.setBackgroundColor (BaseColor.GRAY);
			col6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tb2.addCell(col6);
			doc.add(tb2);
			Facture f = new Facture(m,a,nomFic,h.getIdHabitation());
			AccesData.ajoutFacture(f);
			doc.close();
			h.addFacture(f);
		}
		catch (DocumentException e) {
			e.printStackTrace ();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace ();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
