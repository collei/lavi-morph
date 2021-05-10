package br.net.heaven.lavi.morphology.inflect;

import java.util.ArrayList;
import java.util.List;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.EnumVerbDefiniteness;
import br.net.heaven.lavi.morphology.enums.EnumVerbModes;
import br.net.heaven.lavi.morphology.enums.EnumVerbPersons;
import br.net.heaven.lavi.morphology.enums.EnumVerbTenses;
import br.net.heaven.lavi.morphology.enums.EnumVerbVoices;
import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

public class ConjugationTable {
	
	private EnumVerbTenses tense; 
	private EnumVerbVoices voice; 
	private EnumVerbModes mode; 
	private EnumVerbDefiniteness definiteness;

	private Verb verb;
	private List<ConjugatedItem> units;
	
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

	public ConjugationTable setTense(EnumVerbTenses tense) {
		this.tense = tense;
		return this;
	}

	public ConjugationTable setVoice(EnumVerbVoices voice) {
		this.voice = voice;
		return this;
	}

	public ConjugationTable setMode(EnumVerbModes mode) {
		this.mode = mode;
		return this;
	}

	public ConjugationTable setDefiniteness(EnumVerbDefiniteness definiteness) {
		this.definiteness = definiteness;
		return this;
	}
	
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
	
	public List<Term> asList() {
		List<Term> list = new ArrayList<Term>();
		for (ConjugatedItem item : this.units) {
			list.add(item.getConjugated().clone());
		}
		return list;
	}
	
	public List<Term> asFiltered(VerbConjugationFilter...filters) {
		List<Term> list = new ArrayList<Term>();
		for (ConjugatedItem item : this.units) {
			if (item.matches(filters)) {
				list.add(item.getConjugated().clone());
			}
		}
		return list;
	}
	
	public List<ConjugatedItem> asItemsList() {
		List<ConjugatedItem> list = new ArrayList<ConjugatedItem>();
		for (ConjugatedItem item : this.units) {
			list.add(item.clone());
		}
		return list;
	}
	
	public List<ConjugatedItem> asItemsFiltered(VerbConjugationFilter...filters) {
		List<ConjugatedItem> list = new ArrayList<ConjugatedItem>();
		for (ConjugatedItem item : this.units) {
			if (item.matches(filters)) {
				list.add(item.clone());
			}
		}
		return list;
	}

	public List<ConjugatedItem> asItemsFiltered(List<VerbConjugationFilter> asFilterList) {
		return this.asItemsFiltered(asFilterList.toArray(new VerbConjugationFilter[asFilterList.size()]));
	}
	
}
