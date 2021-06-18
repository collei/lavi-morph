package br.com.collei.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.Term;
import br.com.collei.lavi.morphology.Verb;
import br.com.collei.lavi.morphology.enums.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.enums.EnumVerbModes;
import br.com.collei.lavi.morphology.enums.EnumVerbPersons;
import br.com.collei.lavi.morphology.enums.EnumVerbTenses;
import br.com.collei.lavi.morphology.enums.EnumVerbVoices;
import br.com.collei.lavi.morphology.filter.VerbConjugationFilter;

public class ConjugationTableTest {
	
	@Test
	public void testConstructor() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(EnumVerbPersons.I);
		
		Term term = table.asList().get(0);
		
		assertEquals("eju", term.get());
	}
	
	@Test
	public void testAdd() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(EnumVerbPersons.YOU_PLURAL);
		
		Term term = table.asList().get(0);
		
		assertEquals("ejte", term.get());
	}
	
	@Test
	public void testAsFiltered() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(EnumVerbPersons.YOU)
			.add(EnumVerbPersons.I)
			.setTense(EnumVerbTenses.PERFECT)
			.add(EnumVerbPersons.YOU)
			.add(EnumVerbPersons.YOU_PLURAL);
		
		Term term = table.asFiltered(EnumVerbTenses.PERFECT, EnumVerbPersons.YOU).get(0);
		
		assertEquals("etiš", term.get());
	}
	
	@Test
	public void testAsItemsFiltered() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(EnumVerbPersons.YOU)
			.add(EnumVerbPersons.I)
			.setTense(EnumVerbTenses.PERFECT)
			.add(EnumVerbPersons.YOU)
			.add(EnumVerbPersons.YOU_PLURAL);
		
		List<VerbConjugationFilter> filters = new ArrayList<VerbConjugationFilter>();
		filters.add(EnumVerbTenses.PERFECT);
		filters.add(EnumVerbPersons.YOU);
		
		ConjugatedItem item = table.asItemsFiltered(filters).get(0);
		
		assertEquals(EnumVerbTenses.PERFECT, item.getTense());
		assertEquals(EnumVerbPersons.YOU, item.getPerson());
	}
	
	@Test
	public void testAsItemsFiltered2() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(EnumVerbPersons.YOU)
			.add(EnumVerbPersons.I)
			.setTense(EnumVerbTenses.PERFECT)
			.add(EnumVerbPersons.YOU)
			.add(EnumVerbPersons.YOU_PLURAL);
		
		ConjugatedItem item = table.asItemsFiltered(EnumVerbTenses.PERFECT, EnumVerbPersons.YOU).get(0);
		
		assertEquals(EnumVerbTenses.PERFECT, item.getTense());
		assertEquals(EnumVerbPersons.YOU, item.getPerson());
	}
	
	@Test
	public void testAsList() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
				.add(EnumVerbPersons.YOU)
				.add(EnumVerbPersons.I)
				.setTense(EnumVerbTenses.PERFECT)
				.add(EnumVerbPersons.YOU)
				.add(EnumVerbPersons.YOU_PLURAL);
		
		List<Term> list = table.asList();
		
		List<Term> shouldbe = new ArrayList<Term>();
		shouldbe.add(new Term("ejš"));
		shouldbe.add(new Term("eju"));
		shouldbe.add(new Term("etiš"));
		shouldbe.add(new Term("etite"));
		
		assertTrue(list.get(0).equals(shouldbe.get(0)));
		assertTrue(list.get(1).equals(shouldbe.get(1)));
		assertTrue(list.get(2).equals(shouldbe.get(2)));
		assertTrue(list.get(3).equals(shouldbe.get(3)));
	}
	
	@Test
	public void testAsItemsList() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
				.add(EnumVerbPersons.YOU)
				.add(EnumVerbPersons.I)
				.setTense(EnumVerbTenses.PERFECT)
				.add(EnumVerbPersons.YOU)
				.add(EnumVerbPersons.YOU_PLURAL);
		
		List<ConjugatedItem> list = table.asItemsList();
		
		assertEquals(EnumVerbPersons.YOU, list.get(0).getPerson());
		assertEquals(EnumVerbPersons.I, list.get(1).getPerson());
		assertEquals(EnumVerbPersons.YOU, list.get(2).getPerson());
		assertEquals(EnumVerbPersons.YOU_PLURAL, list.get(3).getPerson());
	}
	
	private ConjugationTable makeTable(String verb) {
		return new ConjugationTable(new Verb(verb))
			.setTense(EnumVerbTenses.PERFECT)
			.setVoice(EnumVerbVoices.PASSIVE)
			.setMode(EnumVerbModes.DESIDERATIVE)
			.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
			.add(EnumVerbPersons.YOU_PLURAL);
	}
	
	@Test
	public void testSetDefiniteness() {
		ConjugationTable table = this.makeTable("eda");
		ConjugatedItem item = table.asItemsList().get(0);
		
		assertEquals(EnumVerbDefiniteness.DEFINITE, item.getDefiniteness());
	}
	
	@Test
	public void testSetMode() {
		ConjugationTable table = this.makeTable("eda");
		ConjugatedItem item = table.asItemsList().get(0);
		
		assertEquals(EnumVerbModes.DESIDERATIVE, item.getMode());
	}
	
	@Test
	public void testSetTense() {
		ConjugationTable table = this.makeTable("eda");
		ConjugatedItem item = table.asItemsList().get(0);
		
		assertEquals(EnumVerbTenses.PERFECT, item.getTense());
	}
	
	@Test
	public void testSetVoice() {
		ConjugationTable table = this.makeTable("eda");
		ConjugatedItem item = table.asItemsList().get(0);
		
		assertEquals(EnumVerbVoices.PASSIVE, item.getVoice());
	}

}
