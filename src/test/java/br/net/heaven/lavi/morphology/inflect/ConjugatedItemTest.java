package br.net.heaven.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.VerbDefinitenessEnum;
import br.net.heaven.lavi.morphology.enums.VerbModesEnum;
import br.net.heaven.lavi.morphology.enums.VerbPersonsEnum;
import br.net.heaven.lavi.morphology.enums.VerbTensesEnum;
import br.net.heaven.lavi.morphology.enums.VerbVoicesEnum;

public class ConjugatedItemTest {

	@Test
	public void testConstructor() {
		Verb verb = new Verb("eda");
		try {
			ConjugatedItem item = new ConjugatedItem(verb, VerbPersonsEnum.WE,
					VerbTensesEnum.PERFECT,
					VerbVoicesEnum.PASSIVE,
					VerbModesEnum.DESIDERATIVE,
					VerbDefinitenessEnum.DEFINITE);
			assertNotNull(item);
		} catch (Exception e) {
			fail("Algum erro ao instanciar ConjugatedItem");
		}
	}

	private ConjugatedItem makeConjugatedItemOf(String verb) {
		return new ConjugatedItem(new Verb(verb), VerbPersonsEnum.WE,
				VerbTensesEnum.PERFECT,
				VerbVoicesEnum.PASSIVE,
				VerbModesEnum.DESIDERATIVE,
				VerbDefinitenessEnum.DEFINITE);
	}
	
	@Test
	public void testGetConjugated() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals("na etenuri", item.getConjugated().get());
	}
	
	@Test
	public void testGetDefiniteness() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(VerbDefinitenessEnum.DEFINITE, item.getDefiniteness());
	}
	
	@Test
	public void testGetMode() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(VerbModesEnum.DESIDERATIVE, item.getMode());
	}
	
	@Test
	public void testGetPerson() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(VerbPersonsEnum.WE, item.getPerson());
	}
	
	@Test
	public void testGetTense() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(VerbTensesEnum.PERFECT, item.getTense());
	}
	
	@Test
	public void testGetVoice() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(VerbVoicesEnum.PASSIVE, item.getVoice());
	}
	
	@Test
	public void testGetVerb() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals("eda", item.getVerb().get());
	}
	
	@Test
	public void testMatches() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertTrue(item.matches(VerbVoicesEnum.PASSIVE, VerbModesEnum.DESIDERATIVE));
		assertFalse(item.matches(VerbVoicesEnum.PASSIVE, VerbModesEnum.FACTUAL));
	}

}
