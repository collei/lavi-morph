package br.net.heaven.lavi.morphology.inflect;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.VerbDefinitenessEnum;
import br.net.heaven.lavi.morphology.enums.VerbModesEnum;
import br.net.heaven.lavi.morphology.enums.VerbPersonsEnum;
import br.net.heaven.lavi.morphology.enums.VerbTensesEnum;
import br.net.heaven.lavi.morphology.enums.VerbVoicesEnum;
import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

public class ConjugatedItem {

	private Verb verb;
	private Term conjugated;
	private VerbPersonsEnum person; 
	private VerbTensesEnum tense; 
	private VerbVoicesEnum voice; 
	private VerbModesEnum mode; 
	private VerbDefinitenessEnum definiteness;
	
	public ConjugatedItem(Verb verb, VerbPersonsEnum person, VerbTensesEnum tense, VerbVoicesEnum voice,
			VerbModesEnum mode, VerbDefinitenessEnum definiteness) {
		this.verb = verb;
		this.person = person;
		this.tense = tense;
		this.voice = voice;
		this.mode = mode;
		this.definiteness = definiteness;
		this.conjugated = this.verb.conjugate(this.mode, this.person, this.tense, this.voice, this.definiteness);
	}

	public Verb getVerb() {
		return this.verb;
	}

	public Term getConjugated() {
		return this.conjugated;
	}

	public VerbPersonsEnum getPerson() {
		return person;
	}

	public VerbTensesEnum getTense() {
		return tense;
	}

	public VerbVoicesEnum getVoice() {
		return voice;
	}

	public VerbModesEnum getMode() {
		return mode;
	}

	public VerbDefinitenessEnum getDefiniteness() {
		return definiteness;
	}
	
	public boolean matches(VerbConjugationFilter...filters) {
		boolean matched = true;
		for (VerbConjugationFilter filter : filters) {
			matched = matched && ((this.tense == filter)
					|| (this.voice == filter)
					|| (this.mode == filter)
					|| (this.person == filter)
					|| (this.definiteness == filter)
			);
		}
		return matched;
	}
	
	@Override
	public ConjugatedItem clone() {
		return new ConjugatedItem(verb, person, tense, voice, mode, definiteness);
	}

}
