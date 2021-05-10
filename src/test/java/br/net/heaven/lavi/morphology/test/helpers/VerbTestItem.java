package br.net.heaven.lavi.morphology.test.helpers;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.EnumVerbDefiniteness;
import br.net.heaven.lavi.morphology.enums.EnumVerbModes;
import br.net.heaven.lavi.morphology.enums.EnumVerbPersons;
import br.net.heaven.lavi.morphology.enums.EnumVerbTenses;
import br.net.heaven.lavi.morphology.enums.EnumVerbVoices;

public class VerbTestItem {
	
	private Verb verb;
	private Term conjugated;
	private EnumVerbPersons person; 
	private EnumVerbTenses tense; 
	private EnumVerbVoices voice; 
	private EnumVerbModes mode; 
	private EnumVerbDefiniteness definiteness;
	
	public VerbTestItem(Verb verb, Term conjugated, EnumVerbPersons person, EnumVerbTenses tense, EnumVerbVoices voice,
			EnumVerbModes mode, EnumVerbDefiniteness definiteness) {
		this.verb = verb;
		this.conjugated = conjugated;
		this.person = person;
		this.tense = tense;
		this.voice = voice;
		this.mode = mode;
		this.definiteness = definiteness;
	}

	public Verb getVerb() {
		return this.verb;
	}

	public Term getConjugated() {
		return this.conjugated;
	}

	public Term conjugate() {
		return this.verb.conjugate(this.mode, this.person, this.tense, this.voice, this.definiteness);
	}

}
