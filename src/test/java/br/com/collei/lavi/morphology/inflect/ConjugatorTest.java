package br.com.collei.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.Verb;
import br.com.collei.lavi.morphology.enums.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.enums.EnumVerbPersons;
import br.com.collei.lavi.morphology.enums.EnumVerbTenses;
import br.com.collei.lavi.morphology.enums.EnumVerbVoices;

public class ConjugatorTest {

	@Test
	public void testDoFactual() {
		String forma = Conjugator.doFactual(new Verb("obda"), EnumVerbPersons.YOU_PLURAL, EnumVerbTenses.IMPERFECT,
				EnumVerbVoices.ACTIVE, EnumVerbDefiniteness.DEFINITE);
		assertTrue("objotok".equals(forma));
	}

	@Test
	public void testDoDesiderative() {
		String forma = Conjugator.doDesiderative(new Verb("obda"), EnumVerbPersons.YOU_PLURAL, EnumVerbTenses.IMPERFECT,
				EnumVerbVoices.ACTIVE, EnumVerbDefiniteness.DEFINITE);
		assertTrue("na objotok".equals(forma));
	}

	@Test
	public void testDoImperative() {
		String forma = Conjugator.doImperative(new Verb("obda"), EnumVerbPersons.YOU_PLURAL,
				EnumVerbDefiniteness.DEFINITE);
		assertTrue("obichtok".equals(forma));
	}

}
