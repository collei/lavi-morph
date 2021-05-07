package br.net.heaven.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.VerbDefinitenessEnum;
import br.net.heaven.lavi.morphology.enums.VerbPersonsEnum;
import br.net.heaven.lavi.morphology.enums.VerbTensesEnum;
import br.net.heaven.lavi.morphology.enums.VerbVoicesEnum;

public class ConjugatorTest {

	@Test
	public void testDoFactual() {
		String forma = Conjugator.doFactual(new Verb("obda"), VerbPersonsEnum.YOU_PLURAL, VerbTensesEnum.IMPERFECT,
				VerbVoicesEnum.ACTIVE, VerbDefinitenessEnum.DEFINITE);
		assertTrue("objotok".equals(forma));
	}

	@Test
	public void testDoDesiderative() {
		String forma = Conjugator.doDesiderative(new Verb("obda"), VerbPersonsEnum.YOU_PLURAL, VerbTensesEnum.IMPERFECT,
				VerbVoicesEnum.ACTIVE, VerbDefinitenessEnum.DEFINITE);
		assertTrue("na objotok".equals(forma));
	}

	@Test
	public void testDoImperative() {
		String forma = Conjugator.doImperative(new Verb("obda"), VerbPersonsEnum.YOU_PLURAL,
				VerbDefinitenessEnum.DEFINITE);
		assertTrue("obichtok".equals(forma));
	}

}
