package br.net.heaven.lavi.morphology.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.enums.EnumHarmony;

public class TermTest {
	
	@Test
	public void testaSeSufixoAfixouCorretamente() {
		Term term = new Term("palavra");
		term.appendSuffix("s");
		assertEquals("palavras", term.get());
	}
	
	@Test
	public void testaSeClonaCorretamente() {
		Term term1 = new Term("bola");
		Term term2 = term1.clone();
		assertEquals(term1.get(), term2.get());
	}
	
	@Test
	public void testaSeEndsWithFuncionaCorretamente() {
		Term palavra = new Term("produção");
		assertTrue(palavra.endsWith("ção"));
		assertFalse(palavra.endsWith("mento"));
	}
	
	@Test
	public void testaSeEndsWithMultiploFuncionaCorretamente() {
		Term verboPortugues = new Term("crescer");
		assertTrue(verboPortugues.endsWith("ar","er","ir"));
		assertFalse(verboPortugues.endsWith("ção","mento","aria"));
	}
	
	@Test
	public void testaSeIgual() {
		Term termo1 = new Term("bicicleta");
		Term termo2 = new Term("bicicleta");
		assertTrue(termo2.equals(termo1));
	}
	
	@Test
	public void testaGetter() {
		String palavra = "implementar";
		Term termo = new Term(palavra);
		assertEquals(palavra, termo.get());
	}
	
	@Test
	public void testaSeHarmoniaEstaCorreta() {
		Term termo1 = new Term("bottal");
		Term termo2 = new Term("finnel");
		assertEquals(EnumHarmony.BACK, termo1.getHarmony());
		assertEquals(EnumHarmony.FRONT, termo2.getHarmony());
	}

}
