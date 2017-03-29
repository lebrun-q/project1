package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.TypeDechet;

public class typeDechetTest {
	private TypeDechet unType;
	private double tar = 0.240;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		unType = new TypeDechet("1", "Plastique", tar);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testGetIdTypeDechet() {
		assertEquals("1", unType.getIdTypeDechet());
	}

	@Test
	public void testGetLibelle() {
		assertEquals("Plastique", unType.getLibelle());
	}

	@Test
	public void testSetLibelle() {
		unType.setLibelle("Verre");
		assertEquals("Verre", unType.getLibelle());
	}

	@Test
	public void testGetTarif() {
		assertTrue(tar == unType.getTarif());
	}

	@Test
	public void testSetTarif() {
		unType.setTarif(0.316);
		assertTrue(0.316 == unType.getTarif());
	}

	@Test
	public void testTypeDechet() {
		assertNotNull(unType);
	}

}
