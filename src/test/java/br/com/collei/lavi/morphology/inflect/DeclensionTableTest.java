
package br.com.collei.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.Noun;
import br.com.collei.lavi.morphology.Term;
import br.com.collei.lavi.morphology.enums.EnumNounCases;
import br.com.collei.lavi.morphology.enums.EnumNounPersons;
import br.com.collei.lavi.morphology.enums.EnumNounPluralities;
import br.com.collei.lavi.morphology.filter.NounDeclensionFilter;

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
			.add(EnumNounCases.ACCUSATIVE);
			
		Term term = table.asList().get(0);
			
		assertEquals("apat", term.get());
	}
	
	@Test
	public void testAddByPerson() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
			.add(EnumNounPersons.I);
			
		Term term = table.asList().get(0);
			
		assertEquals("apam", term.get());
	}
	
	@Test
	public void testAsFiltered() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
			.add(EnumNounPersons.YOU)
			.add(EnumNounPersons.I)
			.setPlurality(EnumNounPluralities.PLURAL)
			.add(EnumNounPersons.YOU)
			.add(EnumNounPersons.YOU_PLURAL);
		
		Term term = table.asFiltered(EnumNounPluralities.PLURAL, EnumNounPersons.YOU).get(0);
		
		assertEquals("apaid", term.get());
	}
	
	@Test
	public void testAsItemsFilteredWithList() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.add(EnumNounPersons.YOU)
				.add(EnumNounPersons.I)
				.setPlurality(EnumNounPluralities.PLURAL)
				.add(EnumNounPersons.YOU)
				.add(EnumNounPersons.YOU_PLURAL);
		
		List<NounDeclensionFilter> filters = new ArrayList<NounDeclensionFilter>();
		filters.add(EnumNounPluralities.PLURAL);
		filters.add(EnumNounPersons.YOU);
		
		DeclensedItem item = table.asItemsFiltered(filters).get(0);
		
		assertEquals(EnumNounPluralities.PLURAL, item.getPlurality());
		assertEquals(EnumNounPersons.YOU, item.getPerson());
	}
	
	@Test
	public void testAsItemsFilteredWithDots() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.add(EnumNounPersons.YOU)
				.add(EnumNounPersons.I)
				.setPlurality(EnumNounPluralities.PLURAL)
				.add(EnumNounPersons.YOU)
				.add(EnumNounPersons.YOU_PLURAL);
		
		DeclensedItem item = table.asItemsFiltered(EnumNounPluralities.PLURAL, EnumNounPersons.YOU).get(0);
		
		assertEquals(EnumNounPluralities.PLURAL, item.getPlurality());
		assertEquals(EnumNounPersons.YOU, item.getPerson());
	}
	
	/////////////////// modify these below //////////////////////
	
	@Test
	public void testAsList() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.add(EnumNounPersons.YOU)
				.add(EnumNounPersons.I)
				.setPlurality(EnumNounPluralities.PLURAL)
				.add(EnumNounPersons.YOU)
				.add(EnumNounPersons.YOU_PLURAL);
		
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
				.add(EnumNounPersons.YOU)
				.add(EnumNounPersons.I)
				.setPlurality(EnumNounPluralities.PLURAL)
				.add(EnumNounPersons.YOU)
				.add(EnumNounPersons.YOU_PLURAL);
		
		List<DeclensedItem> list = table.asItemsList();
		
		assertEquals(EnumNounPersons.YOU, list.get(0).getPerson());
		assertEquals(EnumNounPersons.I, list.get(1).getPerson());
		assertEquals(EnumNounPersons.YOU, list.get(2).getPerson());
		assertEquals(EnumNounPersons.YOU_PLURAL, list.get(3).getPerson());
	}
	
	@Test
	public void testSetPlurality() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.setPlurality(EnumNounPluralities.DUAL)
				.add(EnumNounPersons.YOU_PLURAL);
		DeclensedItem item = table.asItemsList().get(0);
		
		assertEquals(EnumNounPluralities.DUAL, item.getPlurality());
	}
	
	@Test
	public void testIfDefaultCaseIsNominative() {
		DeclensionTable table = new DeclensionTable(new Noun("apa"))
				.setPlurality(EnumNounPluralities.DUAL)
				.add(EnumNounPersons.YOU_PLURAL);
		DeclensedItem item = table.asItemsList().get(0);
		
		assertEquals(EnumNounCases.NOMINATIVE, item.getCase());
	}


}

