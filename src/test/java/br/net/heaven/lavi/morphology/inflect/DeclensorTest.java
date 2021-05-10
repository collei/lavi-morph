package br.net.heaven.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.enums.EnumNounCases;
import br.net.heaven.lavi.morphology.enums.EnumNounPersons;
import br.net.heaven.lavi.morphology.enums.EnumNounPluralities;

public class DeclensorTest {
	
	@Test
	public void testMakeDeclension() {
		String termo = Declensor.makeDeclension(new Term("betu"), EnumNounCases.ACCUSATIVE, EnumNounPluralities.PLURAL);
		//
		System.out.println("printado: " + termo);
		//assertTrue("betukot".equals(termo));
		assertTrue("betutok".equals(termo));
	}

	@Test
	public void testMakeDeclension2() {
		String termo = Declensor.makeDeclension(new Term("betu"), EnumNounPersons.WE, EnumNounCases.ACCUSATIVE, EnumNounPluralities.PLURAL);
		//
		assertTrue("betuinut".equals(termo));
	}

	@Test
	public void testMakePossessive() {
		String termo = Declensor.makePossessive(new Term("betu"), EnumNounPersons.WE, EnumNounPluralities.PLURAL);
		//
		assertTrue("betuinu".equals(termo));
	}

}
