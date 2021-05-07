
package br.net.heaven.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.core.Noun;
import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.enums.NounCasesEnum;
import br.net.heaven.lavi.morphology.enums.NounPersonsEnum;
import br.net.heaven.lavi.morphology.enums.NounPluralitiesEnum;
import br.net.heaven.lavi.morphology.enums.filter.NounDeclensionFilter;

public class DeclensionTableTest {
	
	@Test
	public void testConstructor() {
		Noun noun = new Noun("apa");
		try {
			DeclensionTable table = new DeclensionTable(noun);
			
			assertNotNull(table);
		} catch (Exception e) {
			fail("Some internal error in this constructor.");
		}
	}
	
	@Test
	public void testAddByCase() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
			.add(NounCasesEnum.ACCUSATIVE);
			
		Term term = table.asList().get(0);
			
		assertEquals("apat", term.get());
	}
	
	@Test
	public void testAddByPerson() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
			.add(NounPersonsEnum.I);
			
		Term term = table.asList().get(0);
			
		assertEquals("apam", term.get());
	}
	
	@Test
	public void testAsFiltered() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
			.add(NounPersonsEnum.YOU)
			.add(NounPersonsEnum.I)
			.setPlurality(NounPluralitiesEnum.PLURAL)
			.add(NounPersonsEnum.YOU)
			.add(NounPersonsEnum.YOU_PLURAL);
		
		Term term = table.asFiltered(NounPluralitiesEnum.PLURAL, NounPersonsEnum.YOU).get(0);
		
		assertEquals("apaid", term.get());
	}
	
	@Test
	public void testAsItemsFilteredWithList() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.add(NounPersonsEnum.YOU)
				.add(NounPersonsEnum.I)
				.setPlurality(NounPluralitiesEnum.PLURAL)
				.add(NounPersonsEnum.YOU)
				.add(NounPersonsEnum.YOU_PLURAL);
		
		List<NounDeclensionFilter> filters = new ArrayList<NounDeclensionFilter>();
		filters.add(NounPluralitiesEnum.PLURAL);
		filters.add(NounPersonsEnum.YOU);
		
		DeclensedItem item = table.asItemsFiltered(filters).get(0);
		
		assertEquals(NounPluralitiesEnum.PLURAL, item.getPlurality());
		assertEquals(NounPersonsEnum.YOU, item.getPerson());
	}
	
	@Test
	public void testAsItemsFilteredWithDots() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.add(NounPersonsEnum.YOU)
				.add(NounPersonsEnum.I)
				.setPlurality(NounPluralitiesEnum.PLURAL)
				.add(NounPersonsEnum.YOU)
				.add(NounPersonsEnum.YOU_PLURAL);
		
		DeclensedItem item = table.asItemsFiltered(NounPluralitiesEnum.PLURAL, NounPersonsEnum.YOU).get(0);
		
		assertEquals(NounPluralitiesEnum.PLURAL, item.getPlurality());
		assertEquals(NounPersonsEnum.YOU, item.getPerson());
	}
	
	/////////////////// modify these below //////////////////////
	
	@Test
	public void testAsList() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.add(NounPersonsEnum.YOU)
				.add(NounPersonsEnum.I)
				.setPlurality(NounPluralitiesEnum.PLURAL)
				.add(NounPersonsEnum.YOU)
				.add(NounPersonsEnum.YOU_PLURAL);
		
		List<Term> list = table.asList();
		
		List<Term> shouldbe = new ArrayList<Term>();
		shouldbe.add(new Term("apad"));
		shouldbe.add(new Term("apam"));
		shouldbe.add(new Term("apaid"));
		shouldbe.add(new Term("apaitok"));
		
		assertTrue(list.get(0).equals(shouldbe.get(0)));
		assertTrue(list.get(1).equals(shouldbe.get(1)));
		assertTrue(list.get(2).equals(shouldbe.get(2)));
		assertTrue(list.get(3).equals(shouldbe.get(3)));
	}
	
	@Test
	public void testAsItemsList() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.add(NounPersonsEnum.YOU)
				.add(NounPersonsEnum.I)
				.setPlurality(NounPluralitiesEnum.PLURAL)
				.add(NounPersonsEnum.YOU)
				.add(NounPersonsEnum.YOU_PLURAL);
		
		List<DeclensedItem> list = table.asItemsList();
		
		assertEquals(NounPersonsEnum.YOU, list.get(0).getPerson());
		assertEquals(NounPersonsEnum.I, list.get(1).getPerson());
		assertEquals(NounPersonsEnum.YOU, list.get(2).getPerson());
		assertEquals(NounPersonsEnum.YOU_PLURAL, list.get(3).getPerson());
	}
	
	@Test
	public void testSetPlurality() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.setPlurality(NounPluralitiesEnum.DUAL)
				.add(NounPersonsEnum.YOU_PLURAL);
		DeclensedItem item = table.asItemsList().get(0);
		
		assertEquals(NounPluralitiesEnum.DUAL, item.getPlurality());
	}
	
	@Test
	public void testIfDefaultCaseIsNominative() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.setPlurality(NounPluralitiesEnum.DUAL)
				.add(NounPersonsEnum.YOU_PLURAL);
		DeclensedItem item = table.asItemsList().get(0);
		
		assertEquals(NounCasesEnum.NOMINATIVE, item.getCase());
	}


}

