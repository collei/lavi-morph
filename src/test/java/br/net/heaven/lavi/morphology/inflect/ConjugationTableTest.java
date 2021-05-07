package br.net.heaven.lavi.morphology.inflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.VerbDefinitenessEnum;
import br.net.heaven.lavi.morphology.enums.VerbModesEnum;
import br.net.heaven.lavi.morphology.enums.VerbPersonsEnum;
import br.net.heaven.lavi.morphology.enums.VerbTensesEnum;
import br.net.heaven.lavi.morphology.enums.VerbVoicesEnum;
import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

public class ConjugationTableTest {
	
	@Test
	public void testConstructor() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(VerbPersonsEnum.I);
		
		Term term = table.asList().get(0);
		
		assertEquals("eju", term.get());
	}
	
	@Test
	public void testAdd() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(VerbPersonsEnum.YOU_PLURAL);
		
		Term term = table.asList().get(0);
		
		assertEquals("ejte", term.get());
	}
	
	@Test
	public void testAsFiltered() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(VerbPersonsEnum.YOU)
			.add(VerbPersonsEnum.I)
			.setTense(VerbTensesEnum.PERFECT)
			.add(VerbPersonsEnum.YOU)
			.add(VerbPersonsEnum.YOU_PLURAL);
		
		Term term = table.asFiltered(VerbTensesEnum.PERFECT, VerbPersonsEnum.YOU).get(0);
		
		assertEquals("etiš", term.get());
	}
	
	@Test
	public void testAsItemsFiltered() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(VerbPersonsEnum.YOU)
			.add(VerbPersonsEnum.I)
			.setTense(VerbTensesEnum.PERFECT)
			.add(VerbPersonsEnum.YOU)
			.add(VerbPersonsEnum.YOU_PLURAL);
		
		List<VerbConjugationFilter> filters = new ArrayList<VerbConjugationFilter>();
		filters.add(VerbTensesEnum.PERFECT);
		filters.add(VerbPersonsEnum.YOU);
		
		ConjugatedItem item = table.asItemsFiltered(filters).get(0);
		
		assertEquals(VerbTensesEnum.PERFECT, item.getTense());
		assertEquals(VerbPersonsEnum.YOU, item.getPerson());
	}
	
	@Test
	public void testAsItemsFiltered2() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
			.add(VerbPersonsEnum.YOU)
			.add(VerbPersonsEnum.I)
			.setTense(VerbTensesEnum.PERFECT)
			.add(VerbPersonsEnum.YOU)
			.add(VerbPersonsEnum.YOU_PLURAL);
		
		ConjugatedItem item = table.asItemsFiltered(VerbTensesEnum.PERFECT, VerbPersonsEnum.YOU).get(0);
		
		assertEquals(VerbTensesEnum.PERFECT, item.getTense());
		assertEquals(VerbPersonsEnum.YOU, item.getPerson());
	}
	
	@Test
	public void testAsList() {
		ConjugationTable table = new ConjugationTable(new Verb("eda"))
				.add(VerbPersonsEnum.YOU)
				.add(VerbPersonsEnum.I)
				.setTense(VerbTensesEnum.PERFECT)
				.add(VerbPersonsEnum.YOU)
				.add(VerbPersonsEnum.YOU_PLURAL);
		
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
				.add(VerbPersonsEnum.YOU)
				.add(VerbPersonsEnum.I)
				.setTense(VerbTensesEnum.PERFECT)
				.add(VerbPersonsEnum.YOU)
				.add(VerbPersonsEnum.YOU_PLURAL);
		
		List<ConjugatedItem> list = table.asItemsList();
		
		assertEquals(VerbPersonsEnum.YOU, list.get(0).getPerson());
		assertEquals(VerbPersonsEnum.I, list.get(1).getPerson());
		assertEquals(VerbPersonsEnum.YOU, list.get(2).getPerson());
		assertEquals(VerbPersonsEnum.YOU_PLURAL, list.get(3).getPerson());
	}
	
	private ConjugationTable makeTable(String verb) {
		return new ConjugationTable(new Verb(verb))
			.setTense(VerbTensesEnum.PERFECT)
			.setVoice(VerbVoicesEnum.PASSIVE)
			.setMode(VerbModesEnum.DESIDERATIVE)
			.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
			.add(VerbPersonsEnum.YOU_PLURAL);
	}
	
	@Test
	public void testSetDefiniteness() {
		ConjugationTable table = this.makeTable("eda");
		ConjugatedItem item = table.asItemsList().get(0);
		
		assertEquals(VerbDefinitenessEnum.DEFINITE, item.getDefiniteness());
	}
	
	@Test
	public void testSetMode() {
		ConjugationTable table = this.makeTable("eda");
		ConjugatedItem item = table.asItemsList().get(0);
		
		assertEquals(VerbModesEnum.DESIDERATIVE, item.getMode());
	}
	
	@Test
	public void testSetTense() {
		ConjugationTable table = this.makeTable("eda");
		ConjugatedItem item = table.asItemsList().get(0);
		
		assertEquals(VerbTensesEnum.PERFECT, item.getTense());
	}
	
	@Test
	public void testSetVoice() {
		ConjugationTable table = this.makeTable("eda");
		ConjugatedItem item = table.asItemsList().get(0);
		
		assertEquals(VerbVoicesEnum.PASSIVE, item.getVoice());
	}

}
