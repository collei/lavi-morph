package br.net.heaven.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.core.Noun;
import br.net.heaven.lavi.morphology.enums.NounCasesEnum;
import br.net.heaven.lavi.morphology.enums.NounPersonsEnum;
import br.net.heaven.lavi.morphology.enums.NounPluralitiesEnum;

public class DeclensedItemTest {
	
	@Test
	public void testConstructor1() {
		Noun noun = new Noun("apa");
		//
		try {
			DeclensedItem item = new DeclensedItem(noun, NounCasesEnum.ACCUSATIVE, NounPluralitiesEnum.PLURAL);
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
			DeclensedItem item = new DeclensedItem(noun, NounPersonsEnum.THEY, NounPluralitiesEnum.PLURAL);
			assertNotNull(item);
		} catch (Exception e) {
			fail("Algum erro ao instanciar ConjugatedItem");
		}
	}
	
	@Test
	public void testClone() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, NounPersonsEnum.THEY, NounPluralitiesEnum.PLURAL);
		assertEquals(item.getPerson(), item.clone().getPerson());
		assertEquals(item.getPlurality(), item.clone().getPlurality());
		assertTrue(item.getNoun().get().equals(item.clone().getNoun().get()));
	}

	@Test
	public void testGetCase() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, NounCasesEnum.ACCUSATIVE, NounPluralitiesEnum.PLURAL);
		//
		assertEquals(NounCasesEnum.ACCUSATIVE, item.getCase());
	}
	
	@Test
	public void testGetPerson() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, NounPersonsEnum.HE_SHE_IT, NounPluralitiesEnum.PLURAL);
		//
		assertEquals(NounPersonsEnum.HE_SHE_IT, item.getPerson());
	}
	
	@Test
	public void testGetPlurality() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, NounCasesEnum.ACCUSATIVE, NounPluralitiesEnum.DUAL);
		//
		assertEquals(NounPluralitiesEnum.DUAL, item.getPlurality());
	}
	
	@Test
	public void testGetNoun() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, NounCasesEnum.ACCUSATIVE, NounPluralitiesEnum.PLURAL);
		//
		assertTrue("apa".equals(item.getNoun().get()));
	}
	
	@Test
	public void testGetDeclensed() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, NounCasesEnum.ACCUSATIVE, NounPluralitiesEnum.PLURAL);
		//
		assertTrue("apatok".equals(item.getDeclensed().get()));
	}
	
	@Test
	public void testMatches() {
		Noun noun = new Noun("apa");
		DeclensedItem item = new DeclensedItem(noun, NounCasesEnum.ACCUSATIVE, NounPluralitiesEnum.PLURAL);
		assertTrue(item.matches(NounCasesEnum.ACCUSATIVE, NounPluralitiesEnum.PLURAL));
		assertFalse(item.matches(NounCasesEnum.DATIVE, NounPluralitiesEnum.PLURAL));
	}
	
}
