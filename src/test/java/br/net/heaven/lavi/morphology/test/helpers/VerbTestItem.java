package br.net.heaven.lavi.morphology.test.helpers;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.VerbDefinitenessEnum;
import br.net.heaven.lavi.morphology.enums.VerbModesEnum;
import br.net.heaven.lavi.morphology.enums.VerbPersonsEnum;
import br.net.heaven.lavi.morphology.enums.VerbTensesEnum;
import br.net.heaven.lavi.morphology.enums.VerbVoicesEnum;

public class VerbTestItem {
	
	private Verb verb;
	private Term conjugated;
	private VerbPersonsEnum person; 
	private VerbTensesEnum tense; 
	private VerbVoicesEnum voice; 
	private VerbModesEnum mode; 
	private VerbDefinitenessEnum definiteness;
	
	public VerbTestItem(Verb verb, Term conjugated, VerbPersonsEnum person, VerbTensesEnum tense, VerbVoicesEnum voice,
			VerbModesEnum mode, VerbDefinitenessEnum definiteness) {
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
