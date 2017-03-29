package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleTest {
	private TypeDechet td1, td2;
	private Poubelle pb;
	private Date d1 = null;
	private Date d2 = null;
	private Date d3 = null;
	private Levee le1 = null;
	private Levee le2 = null;
	private Levee le3 = null;
	private ArrayList<Levee> listeLevees;
	private SimpleDateFormat dateFormat;

	@Before
	public void setUp() throws Exception {
		// 2 types d�chet pour get et set
		td1 = new TypeDechet("Ver", "verre", 0.10);
		td2 = new TypeDechet("pap", "papier", 0.08);
		// une poubelle
		pb = new Poubelle("pb1", "hab1", td1);
		// 3 lev�es pour la poubelle
		// instanciation dates de lev�e
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d1 = dateFormat.parse("15/05/2015");
			d2 = dateFormat.parse("30/05/2015");
			d3 = dateFormat.parse("15/06/2015");
			le1 = new Levee(d1, 5, pb.getIdPoubelle(), "camion1", "chauffeur1");
			le2 = new Levee(d2, 10, pb.getIdPoubelle(), "camion1", "chauffeur1");
			le3 = new Levee(d3, 12, pb.getIdPoubelle(), "camion1", "chauffeur1");
			// collection de travail pour le setLesLevees
			listeLevees = new ArrayList<Levee>();
			listeLevees.add(le1);
			listeLevees.add(le2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@After
	public void taerDown() throws Exception {
		td1 = null;
		td2 = null;
		pb = null;
		listeLevees = null;
	}

	@Test
	public void testPoubelle() {
		assertNotNull(pb);
	}

	@Test
	public void testGetIdPoubelle() {
		assertEquals(pb.getIdPoubelle(), "pb1");
	}

	@Test
	public void testGetIdHabitation() {
		pb.setIdHabitation("hab2");
		assertEquals(pb.getIdHabitation(), "hab2");
	}

	@Test
	public void testSetIdHabitation() {
		assertEquals(pb.getIdHabitation(), "hab1");
	}

	@Test
	public void testGetTypeDechet() {
		assertEquals(pb.getTypeDechet(), td1);
	}

	@Test
	public void testSetTypeDechet() {
		pb.setTypeDechet(td2);
		assertEquals(pb.getTypeDechet(), td2);
	}

	@Test
	public void testGetLesLevees() {
		assertEquals(pb.getLesLevees().size(), 0);
		pb.addLevee(le1);
		pb.addLevee(le2);
		pb.addLevee(le3);
		assertEquals(pb.getLesLevees().size(), 3);
		assertEquals(pb.getLesLevees().get(0), le1);
		assertEquals(pb.getLesLevees().get(1), le2);
		assertEquals(pb.getLesLevees().get(2), le3);
	}

	@Test
	public void testSetLesLevees() {
		pb.setLesLevees(listeLevees);
		assertEquals(pb.getLesLevees().size(), 2);
		assertEquals(pb.getLesLevees(), listeLevees);
		assertEquals(pb.getLesLevees().get(0), le1);
		assertEquals(pb.getLesLevees().get(1), le2);
	}

	@Test
	public void testAddLevee() {
		pb.addLevee(le1);
		pb.addLevee(le2);
		pb.addLevee(le3);
		assertEquals(3,pb.getLesLevees().size());
		
	}
	@Test
	public void testGetLesLeveesIntInt(){
		pb.addLevee(le1);
		pb.addLevee(le2);
		pb.addLevee(le3);
		assertTrue((pb.getLesLevee(2015,05).size())==2);
	}
	@Test
	public void testGetCout(){
		pb.addLevee(le1);
		pb.addLevee(le2);
		pb.addLevee(le3);
		System.out.println(pb.getCout(2015,05));
		assertTrue(1.5 == pb.getCout(2015,05));
		
	}

}
