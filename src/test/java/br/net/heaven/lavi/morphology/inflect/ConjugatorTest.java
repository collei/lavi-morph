package br.net.heaven.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.EnumVerbDefiniteness;
import br.net.heaven.lavi.morphology.enums.EnumVerbPersons;
import br.net.heaven.lavi.morphology.enums.EnumVerbTenses;
import br.net.heaven.lavi.morphology.enums.EnumVerbVoices;

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
