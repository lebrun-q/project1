package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Chauffeur;

public class chauffeurTest {
	private Chauffeur unChauffeur;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		unChauffeur = new Chauffeur ("1","Georges","Charles",sdf.parse("17/11/2016"));
	}

	@After
	public void tearDown() throws Exception {
		unChauffeur = null;
	}

	@Test
	public void testChauffeur() {
		assertNotNull("L'instance est créée", unChauffeur);
	}

	@Test
	public void testGetIdChauffeur() {
		assertEquals("Est ce que l'identifiant est correct", "1",unChauffeur.getIdChauffeur());

	}

	@Test
	public void testGetNomChauffeur() {
		assertEquals("Le nom est correct ? ", "Georges",unChauffeur.getNomChauffeur());
	}

	@Test
	public void testSetNomChauffeur() {
		unChauffeur.setNomChauffeur("Jean");
		assertEquals("Le nom est correct ? ","Jean",unChauffeur.getNomChauffeur());
	}

	@Test
	public void testGetPrenomChauffeur() {
		assertEquals("Le prenom est correct ? ","Charles",unChauffeur.getPrenomChauffeur());
	}

	@Test
	public void testSetPrenomChauffeur() {
		unChauffeur.setPrenomChauffeur("Robert");
		assertEquals("Le prenom est correct ? ","Robert", unChauffeur.getPrenomChauffeur());
	}

	@Test
	public void testGetDateEmbauche() {
		assertEquals("17/11/2016", sdf.format(unChauffeur.getDateEmbauche()));
	}

	@Test
	public void testSetDateEmbauche() throws ParseException {
		unChauffeur.setDateEmbauche(sdf.parse("05/06/2003"));
		assertEquals("05/06/2003", sdf.format(unChauffeur.getDateEmbauche()));
	}
}
