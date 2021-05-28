package br.com.collei.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.EnumVerbPersons;
import br.com.collei.lavi.morphology.EnumVerbTenses;
import br.com.collei.lavi.morphology.EnumVerbVoices;
import br.com.collei.lavi.morphology.core.Verb;
import br.com.collei.lavi.morphology.inflect.Conjugator;

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
