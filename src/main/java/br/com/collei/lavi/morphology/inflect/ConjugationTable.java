package br.com.collei.lavi.morphology.enums.inflect;

import java.util.ArrayList;
import java.util.List;

import br.com.collei.lavi.morphology.enums.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.enums.EnumVerbModes;
import br.com.collei.lavi.morphology.enums.EnumVerbPersons;
import br.com.collei.lavi.morphology.enums.EnumVerbTenses;
import br.com.collei.lavi.morphology.enums.EnumVerbVoices;
import br.com.collei.lavi.morphology.enums.core.Term;
import br.com.collei.lavi.morphology.enums.core.Verb;
import br.com.collei.lavi.morphology.enums.filter.VerbConjugationFilter;

/**
 * <p>Holds the conjugation table and makes its composition work easy
 * @author almir jr.
 *
 */
public class ConjugationTable {
	
	/**
	 * <p>Holds the current tense being applied.</p>
	 */
	private EnumVerbTenses tense; 
	
	/**
	 * <p>Holds the current voice being applied.</p>
	 */
	private EnumVerbVoices voice; 
	
	/**
	 * <p>Holds the current mode being applied.</p>
	 */
	private EnumVerbModes mode; 
	
	/**
	 * <p>Holds the current definiteness being applied.</p>
	 */
	private EnumVerbDefiniteness definiteness;

	/**
	 * <p>The verb to be conjugated.</p>
	 */
	private Verb verb;
	
	/**
	 * <p>The list of conjugated items is kept here.</p>
	 */
	private List<ConjugatedItem> units;
	
	/**
	 * <p>Creates a new instance of the table.
	 * @param verb The verb to be conjugated
	 */
	public ConjugationTable(Verb verb) {
		if (verb == null) {
			throw new NullPointerException("Verbo não pode ser null");
		}
		//
		this.verb = verb;
		this.units = new ArrayList<ConjugatedItem>();
		this.tense = EnumVerbTenses.IMPERFECT;
		this.voice = EnumVerbVoices.ACTIVE;
		this.mode = EnumVerbModes.FACTUAL;
		this.definiteness = EnumVerbDefiniteness.INDEFINITE;
	}
	
	/////*/////

	/**
	 * <p>Defines the tense to be applied.</p>
	 * @param tense A verbal tense
	 * @return the table itself
	 */
	public ConjugationTable setTense(EnumVerbTenses tense) {
		this.tense = tense;
		return this;
	}

	/**
	 * <p>Defines the voice to be applied.</p>
	 * @param voice A verbal voice
	 * @return the table itself
	 */
	public ConjugationTable setVoice(EnumVerbVoices voice) {
		this.voice = voice;
		return this;
	}

	/**
	 * <p>Defines the mode to be applied.</p>
	 * @param mode A verbal mode
	 * @return the table itself
	 */
	public ConjugationTable setMode(EnumVerbModes mode) {
		this.mode = mode;
		return this;
	}

	/**
	 * <p>Defines the definiteness to be applied.</p>
	 * @param definiteness A verbal definiteness
	 * @return the table itself
	 */
	public ConjugationTable setDefiniteness(EnumVerbDefiniteness definiteness) {
		this.definiteness = definiteness;
		return this;
	}
	
	/**
	 * <p>Adds a conjugation item to the table, with the current settings on tense, mode, voice etc..</p>
	 * @param person The person to be added
	 * @return the table itself
	 */
	public ConjugationTable add(EnumVerbPersons person) {
		this.units.add(new ConjugatedItem(
				this.verb,
				person,
				this.tense,
				this.voice,
				this.mode,
				this.definiteness));
		return this;
	}
	
	/**
	 * <p>Returns the table contents as a list of terms.</p>
	 * @return the list of terms
	 */
	public List<Term> asList() {
		List<Term> list = new ArrayList<Term>();
		for (ConjugatedItem item : this.units) {
			list.add(item.getConjugated().clone());
		}
		return list;
	}
	
	/**
	 * <p>Returns the table contents as a list of terms, but only those matching the filters provided.</p>
	 * @param filters A set of filters to be applied
	 * @return the list of terms that past the filters
	 */
	public List<Term> asFiltered(VerbConjugationFilter...filters) {
		List<Term> list = new ArrayList<Term>();
		for (ConjugatedItem item : this.units) {
			if (item.matches(filters)) {
				list.add(item.getConjugated().clone());
			}
		}
		return list;
	}
	
	/**
	 * <p>Returns the table contents as a list of ConjugatedItem instances.</p>
	 * @return the list of ConjugatedItem instances
	 */
	public List<ConjugatedItem> asItemsList() {
		List<ConjugatedItem> list = new ArrayList<ConjugatedItem>();
		for (ConjugatedItem item : this.units) {
			list.add(item.clone());
		}
		return list;
	}
	
	/**
	 * <p>Returns the table contents as a list of ConjugatedItem instances, but only those matching the filters provided.</p>
	 * @param filters One or more filters to be applied, comma-separated
	 * @return the list of ConjugatedItem instances that past the filters
	 */
	public List<ConjugatedItem> asItemsFiltered(VerbConjugationFilter...filters) {
		List<ConjugatedItem> list = new ArrayList<ConjugatedItem>();
		for (ConjugatedItem item : this.units) {
			if (item.matches(filters)) {
				list.add(item.clone());
			}
		}
		return list;
	}

	/**
	 * <p>Returns the table contents as a list of ConjugatedItem instances, but only those matching the filters provided.</p>
	 * @param filterList A list of filters to be applied
	 * @return the list of ConjugatedItem instances that past the filters
	 */
	public List<ConjugatedItem> asItemsFiltered(List<VerbConjugationFilter> filterList) {
		return this.asItemsFiltered(filterList.toArray(new VerbConjugationFilter[filterList.size()]));
	}
	
}
