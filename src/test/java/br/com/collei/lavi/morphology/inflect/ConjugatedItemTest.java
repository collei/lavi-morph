package br.com.collei.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.Verb;
import br.com.collei.lavi.morphology.enums.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.enums.EnumVerbModes;
import br.com.collei.lavi.morphology.enums.EnumVerbPersons;
import br.com.collei.lavi.morphology.enums.EnumVerbTenses;
import br.com.collei.lavi.morphology.enums.EnumVerbVoices;

public class ConjugatedItemTest {

	@Test
	public void testConstructor() {
		Verb verb = new Verb("eda");
		try {
			ConjugatedItem item = new ConjugatedItem(verb, EnumVerbPersons.WE,
					EnumVerbTenses.PERFECT,
					EnumVerbVoices.PASSIVE,
					EnumVerbModes.DESIDERATIVE,
					EnumVerbDefiniteness.DEFINITE);
			assertNotNull(item);
		} catch (Exception e) {
			fail("Algum erro ao instanciar ConjugatedItem");
		}
	}

	private ConjugatedItem makeConjugatedItemOf(String verb) {
		return new ConjugatedItem(new Verb(verb), EnumVerbPersons.WE,
				EnumVerbTenses.PERFECT,
				EnumVerbVoices.PASSIVE,
				EnumVerbModes.DESIDERATIVE,
				EnumVerbDefiniteness.DEFINITE);
	}
	
	@Test
	public void testGetConjugated() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals("na etenuri", item.getConjugated().get());
	}
	
	@Test
	public void testGetDefiniteness() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(EnumVerbDefiniteness.DEFINITE, item.getDefiniteness());
	}
	
	@Test
	public void testGetMode() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(EnumVerbModes.DESIDERATIVE, item.getMode());
	}
	
	@Test
	public void testGetPerson() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(EnumVerbPersons.WE, item.getPerson());
	}
	
	@Test
	public void testGetTense() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(EnumVerbTenses.PERFECT, item.getTense());
	}
	
	@Test
	public void testGetVoice() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals(EnumVerbVoices.PASSIVE, item.getVoice());
	}
	
	@Test
	public void testGetVerb() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertEquals("eda", item.getVerb().get());
	}
	
	@Test
	public void testMatches() {
		ConjugatedItem item = this.makeConjugatedItemOf("eda");
		assertTrue(item.matches(EnumVerbVoices.PASSIVE, EnumVerbModes.DESIDERATIVE));
		assertFalse(item.matches(EnumVerbVoices.PASSIVE, EnumVerbModes.FACTUAL));
	}

}
