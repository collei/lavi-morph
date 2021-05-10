package br.net.heaven.lavi.morphology.core;

import br.net.heaven.lavi.morphology.enums.EnumHarmony;
import br.net.heaven.lavi.morphology.enums.EnumPartsOfSpeech;
import br.net.heaven.lavi.morphology.enums.EnumVerbDefiniteness;
import br.net.heaven.lavi.morphology.enums.EnumVerbModes;
import br.net.heaven.lavi.morphology.enums.EnumVerbPersons;
import br.net.heaven.lavi.morphology.enums.EnumVerbTenses;
import br.net.heaven.lavi.morphology.enums.EnumVerbVoices;
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
	
	public EnumHarmony getHarmony() {
		return this.stem.getHarmony();
	}
	
	public boolean isVocalic() {
		return this.stem.isVocalic();
	}
	
	public Term conjugate(EnumVerbModes mode, EnumVerbPersons person, EnumVerbTenses tense, EnumVerbVoices voice, EnumVerbDefiniteness definiteness) {
		String conjugated;
		//
		if (mode == EnumVerbModes.DESIDERATIVE) {
			conjugated = Conjugator.doDesiderative(this, person, tense, voice, definiteness);
		} else if (mode == EnumVerbModes.IMPERATIVE) {
			conjugated = Conjugator.doImperative(this, person, definiteness);
		} else {
			conjugated = Conjugator.doFactual(this, person, tense, voice, definiteness);
		}
		//
		return new Term(conjugated, EnumPartsOfSpeech.VERB);
	}

	public boolean equals(Verb verb) {
		return this.verb.get().equals(verb.get());
	}

}
