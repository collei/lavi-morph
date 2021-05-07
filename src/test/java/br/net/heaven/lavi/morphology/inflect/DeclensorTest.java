package br.net.heaven.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.enums.NounCasesEnum;
import br.net.heaven.lavi.morphology.enums.NounPersonsEnum;
import br.net.heaven.lavi.morphology.enums.NounPluralitiesEnum;

public class DeclensorTest {
	
	@Test
	public void testMakeDeclension() {
		String termo = Declensor.makeDeclension(new Term("betu"), NounCasesEnum.ACCUSATIVE, NounPluralitiesEnum.PLURAL);
		//
		System.out.println("printado: " + termo);
		//assertTrue("betukot".equals(termo));
		assertTrue("betutok".equals(termo));
	}

	@Test
	public void testMakeDeclension2() {
		String termo = Declensor.makeDeclension(new Term("betu"), NounPersonsEnum.WE, NounCasesEnum.ACCUSATIVE, NounPluralitiesEnum.PLURAL);
		//
		assertTrue("betuinut".equals(termo));
	}

	@Test
	public void testMakePossessive() {
		String termo = Declensor.makePossessive(new Term("betu"), NounPersonsEnum.WE, NounPluralitiesEnum.PLURAL);
		//
		assertTrue("betuinu".equals(termo));
	}

}
