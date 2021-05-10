package br.net.heaven.lavi.morphology.inflect;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.EnumVerbDefiniteness;
import br.net.heaven.lavi.morphology.enums.EnumVerbModes;
import br.net.heaven.lavi.morphology.enums.EnumVerbPersons;
import br.net.heaven.lavi.morphology.enums.EnumVerbTenses;
import br.net.heaven.lavi.morphology.enums.EnumVerbVoices;
import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

public class ConjugatedItem {

	private Verb verb;
	private Term conjugated;
	private EnumVerbPersons person; 
	private EnumVerbTenses tense; 
	private EnumVerbVoices voice; 
	private EnumVerbModes mode; 
	private EnumVerbDefiniteness definiteness;
	
	public ConjugatedItem(Verb verb, EnumVerbPersons person, EnumVerbTenses tense, EnumVerbVoices voice,
			EnumVerbModes mode, EnumVerbDefiniteness definiteness) {
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

	public EnumVerbPersons getPerson() {
		return person;
	}

	public EnumVerbTenses getTense() {
		return tense;
	}

	public EnumVerbVoices getVoice() {
		return voice;
	}

	public EnumVerbModes getMode() {
		return mode;
	}

	public EnumVerbDefiniteness getDefiniteness() {
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
