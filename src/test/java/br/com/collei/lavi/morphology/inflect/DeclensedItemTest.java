package br.com.collei.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.Noun;
import br.com.collei.lavi.morphology.enums.EnumNounCases;
import br.com.collei.lavi.morphology.enums.EnumNounPersons;
import br.com.collei.lavi.morphology.enums.EnumNounPluralities;

public class DeclensedItemTest {
	
	@Test
	public void testConstructor1() {
		Noun noun = new Noun("apa");
		//
		try {
			DeclensedItem item = new DeclensedItem(noun, EnumNounCases.ACCUSATIVE, EnumNounPluralities.PLURAL);
			assertNotNull(item);
		} catch (Exception e) {
			fail("Algum erro ao instanciar ConjugatedItem");
		}
	}

	@Test
	public void testConstructor2() {
		Noun noun = new Noun("apa");
		//
		try {
			DeclensedItem item = new DeclensedItem(noun, EnumNounPersons.THEY, EnumNounPluralities.PLURAL);
			assertNotNull(item);
		} catch (Exception e) {
			fail("Algum erro ao instanciar ConjugatedItem");
		}
	}
	
	@Test
	public void testClone() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, EnumNounPersons.THEY, EnumNounPluralities.PLURAL);
		assertEquals(item.getPerson(), item.clone().getPerson());
		assertEquals(item.getPlurality(), item.clone().getPlurality());
		assertTrue(item.getNoun().get().equals(item.clone().getNoun().get()));
	}

	@Test
	public void testGetCase() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, EnumNounCases.ACCUSATIVE, EnumNounPluralities.PLURAL);
		//
		assertEquals(EnumNounCases.ACCUSATIVE, item.getCase());
	}
	
	@Test
	public void testGetPerson() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, EnumNounPersons.HE_SHE_IT, EnumNounPluralities.PLURAL);
		//
		assertEquals(EnumNounPersons.HE_SHE_IT, item.getPerson());
	}
	
	@Test
	public void testGetPlurality() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, EnumNounCases.ACCUSATIVE, EnumNounPluralities.DUAL);
		//
		assertEquals(EnumNounPluralities.DUAL, item.getPlurality());
	}
	
	@Test
	public void testGetNoun() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, EnumNounCases.ACCUSATIVE, EnumNounPluralities.PLURAL);
		//
		assertTrue("apa".equals(item.getNoun().get()));
	}
	
	@Test
	public void testGetDeclensed() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, EnumNounCases.ACCUSATIVE, EnumNounPluralities.PLURAL);
		//
		assertTrue("apatok".equals(item.getDeclensed().get()));
	}
	
	@Test
	public void testMatches() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, EnumNounCases.ACCUSATIVE, EnumNounPluralities.PLURAL);
		assertTrue(item.matches(EnumNounCases.ACCUSATIVE, EnumNounPluralities.PLURAL));
		assertFalse(item.matches(EnumNounCases.DATIVE, EnumNounPluralities.PLURAL));
	}
	
}
