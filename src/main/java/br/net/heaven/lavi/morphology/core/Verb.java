package br.net.heaven.lavi.morphology.core;

import br.net.heaven.lavi.morphology.enums.HarmonyEnum;
import br.net.heaven.lavi.morphology.enums.VerbDefinitenessEnum;
import br.net.heaven.lavi.morphology.enums.VerbModesEnum;
import br.net.heaven.lavi.morphology.enums.VerbPersonsEnum;
import br.net.heaven.lavi.morphology.enums.VerbTensesEnum;
import br.net.heaven.lavi.morphology.enums.VerbVoicesEnum;
import br.net.heaven.lavi.morphology.inflect.Conjugator;

public class Verb {
	
	private Term verb;
	private Term stem;
	
	public Verb(Term term) {
		this.verb = new Term(term.get());
		this.stem = new Term(term.get().substring(0, term.get().length()-2));
	}
	
	public Verb(String verb) {
		Term term = new Term(verb);
		this.verb = new Term(term.get());
		this.stem = new Term(term.get().substring(0, term.get().length()-2));
	}

	public String get() {
		return this.verb.get();
	}
	
	public String getStem() {
		return this.stem.get();
	}
	
	public HarmonyEnum getHarmony() {
		return this.stem.getHarmony();
	}
	
	public boolean isVocalic() {
		return this.stem.isVocalic();
	}
	
	public Term conjugate(VerbModesEnum mode, VerbPersonsEnum person, VerbTensesEnum tense, VerbVoicesEnum voice, VerbDefinitenessEnum definiteness) {
		String conjugated;
		//
		if (mode == VerbModesEnum.DESIDERATIVE) {
			conjugated = Conjugator.doDesiderative(this, person, tense, voice, definiteness);
		} else if (mode == VerbModesEnum.IMPERATIVE) {
			conjugated = Conjugator.doImperative(this, person, definiteness);
		} else {
			conjugated = Conjugator.doFactual(this, person, tense, voice, definiteness);
		}
		//
		return new Term(conjugated);
	}

	public boolean equals(Verb verb) {
		return this.verb.get().equals(verb.get());
	}

}
