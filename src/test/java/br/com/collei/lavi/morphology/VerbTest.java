package br.com.collei.lavi.morphology;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.enums.EnumHarmony;

public class VerbTest {
	
	@Test
	public void testaSeCriouCorretamenteAPartirDeString() {
		Verb verbo = new Verb("bogudoda");
		assertEquals("bogudoda", verbo.get());
	}
	
	@Test
	public void testaSeCriouCorretamenteAPartirDeTermo() {
		Term termo = new Term("bogudoda");
		Verb verbo = new Verb(termo);
		assertEquals(termo.get(), verbo.get());
	}
	
	@Test
	public void testaGetter() {
		String string = "berauda";
		Verb verbo = new Verb(string);
		assertEquals(string, verbo.get());
	}
	
	@Test
	public void testaSeHarmoniaEstaCorreta() {
		Verb verbo1 = new Verb("ayumida");
		Verb verbo2 = new Verb("benetida");
		assertEquals(EnumHarmony.BACK, verbo1.getHarmony());
		assertEquals(EnumHarmony.FRONT, verbo2.getHarmony());
	}

	@Test
	public void testaGetterDeStem() {
		String string = "berauda";
		String raiz = "berau";
		Verb verbo = new Verb(string);
		assertEquals(raiz, verbo.getStem());
	}
	
	@Test
	public void testaSeDetectaVocalicidadeCorretamente() {
		Verb vogal = new Verb("berauda");
		Verb consoante = new Verb("obda");
		assertTrue(vogal.isVocalic());
		assertFalse(consoante.isVocalic());
	}

	
}
