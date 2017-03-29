package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Camion;

public class camionTest {
	private Camion unCamion;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		unCamion = new Camion("XX-111-ZZ",sdf.parse("03/06/2016"));
	}

	@After
	public void tearDown() throws Exception {
		unCamion = null;
	}

	@Test
	public void testCamion() {
		assertNotNull(unCamion);
	}

	@Test
	public void testGetImmatriculation() {
		assertEquals("XX-111-ZZ", unCamion.getImmatriculation());
	}

	@Test
	public void testSetImmatriculation() {
		unCamion.setImmatriculation("ZZ-111-XX");
		assertEquals("ZZ-111-XX", unCamion.getImmatriculation());
	}

	@Test
	public void testGetDateMiseEnCirculation() {
		assertEquals("03/06/2016", sdf.format(unCamion.getDateMiseEnCirculation()));
	}

	@Test
	public void testSetDateMiseEnCirculation() throws ParseException {
		unCamion.setDateMiseEnCirculation(sdf.parse( "08/04/2007"));
		assertEquals("08/04/2007", sdf.format(unCamion.getDateMiseEnCirculation()));
	}

	@Test
	public void testToString() {
		assertEquals("Camion [immatriculation=" + unCamion.getImmatriculation() + ", dateMiseEnCirculation=" + unCamion.getDateMiseEnCirculation() + "]",unCamion.toString() );
	}

}
