package br.com.collei.lavi.morphology.test.helpers;

import br.com.collei.lavi.morphology.Term;
import br.com.collei.lavi.morphology.Verb;
import br.com.collei.lavi.morphology.enums.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.enums.EnumVerbModes;
import br.com.collei.lavi.morphology.enums.EnumVerbPersons;
import br.com.collei.lavi.morphology.enums.EnumVerbTenses;
import br.com.collei.lavi.morphology.enums.EnumVerbVoices;

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
