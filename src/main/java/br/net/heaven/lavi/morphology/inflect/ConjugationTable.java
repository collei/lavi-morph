package br.net.heaven.lavi.morphology.inflect;

import java.util.ArrayList;
import java.util.List;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.VerbDefinitenessEnum;
import br.net.heaven.lavi.morphology.enums.VerbModesEnum;
import br.net.heaven.lavi.morphology.enums.VerbPersonsEnum;
import br.net.heaven.lavi.morphology.enums.VerbTensesEnum;
import br.net.heaven.lavi.morphology.enums.VerbVoicesEnum;
import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

public class ConjugationTable {
	
	private VerbTensesEnum tense; 
	private VerbVoicesEnum voice; 
	private VerbModesEnum mode; 
	private VerbDefinitenessEnum definiteness;

	private Verb verb;
	private List<ConjugatedItem> units;
	
	public ConjugationTable(Verb verb) {
		if (verb == null) {
			throw new NullPointerException("Verbo não pode ser null");
		}
		//
		this.verb = verb;
		this.units = new ArrayList<ConjugatedItem>();
		this.tense = VerbTensesEnum.IMPERFECT;
		this.voice = VerbVoicesEnum.ACTIVE;
		this.mode = VerbModesEnum.FACTUAL;
		this.definiteness = VerbDefinitenessEnum.INDEFINITE;
	}
	
	/////*/////

	public ConjugationTable setTense(VerbTensesEnum tense) {
		this.tense = tense;
		return this;
	}

	public ConjugationTable setVoice(VerbVoicesEnum voice) {
		this.voice = voice;
		return this;
	}

	public ConjugationTable setMode(VerbModesEnum mode) {
		this.mode = mode;
		return this;
	}

	public ConjugationTable setDefiniteness(VerbDefinitenessEnum definiteness) {
		this.definiteness = definiteness;
		return this;
	}
	
	public ConjugationTable add(VerbPersonsEnum person) {
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
