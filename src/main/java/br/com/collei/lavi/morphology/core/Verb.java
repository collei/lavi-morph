package br.com.collei.lavi.morphology.core;

import br.com.collei.lavi.morphology.EnumHarmony;
import br.com.collei.lavi.morphology.EnumPartsOfSpeech;
import br.com.collei.lavi.morphology.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.EnumVerbModes;
import br.com.collei.lavi.morphology.EnumVerbPersons;
import br.com.collei.lavi.morphology.EnumVerbTenses;
import br.com.collei.lavi.morphology.EnumVerbVoices;
import br.com.collei.lavi.morphology.inflect.Conjugator;

/**
 * <p>Represents a verb, a word that indicates the attributes of an action related to the time and mode of the action, to the agent and, sometimes, the object.</p>
 * @author sjunio
 *
 */
public class Verb {
	
	/**
	 * The Term instance representing internal value of the verb
	 */
	private Term verb;
	
	/**
	 * The Term instance representing the verb stem 
	 */
	private Term stem;
	
	/**
	 * Creates a new instance of the verb.
	 * @param term The term to be created as verb
	 */
	public Verb(Term term) {
		this.verb = new Term(term.get());
		this.stem = new Term(term.get().substring(0, term.get().length()-2));
	}
	
	/**
	 * Creates a new instance of the verb
	 * @param verb The String representation of the verb
	 */
	public Verb(String verb) {
		Term term = new Term(verb);
		this.verb = new Term(term.get());
		this.stem = new Term(term.get().substring(0, term.get().length()-2));
	}

	/**
	 * Returns the internal representation of the verb 
	 * @return the internal representation of the verb
	 */
	public String get() {
		return this.verb.get();
	}
	
	/**
	 * Returns the internal representation of the verb stem
	 * @return the internal representation of the verb stem
	 */
	public String getStem() {
		return this.stem.get();
	}
	
	/**
	 * Returns the harmony type of the verb stem
	 * @return the harmony type of the verb
	 */
	public EnumHarmony getHarmony() {
		return this.stem.getHarmony();
	}
	
	/**
	 * Returns whether the stem ends with vowel or not
	 * @return true if the stem ends with a vowel, false otherwise
	 */
	public boolean isVocalic() {
		return this.stem.isVocalic();
	}
	
	/**
	 * Conjugates the verb within the specified parameters
	 * @param mode The mode of the resulting form
	 * @param person The person of the resulting form
	 * @param tense The tense of the resulting form
	 * @param voice The voice of the resulting form
	 * @param definiteness The definiteness stance of the resulting form
	 * @return The term representing the conjugated form of the verb
	 */
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

	/**
	 * Tests for equality with another verb
	 * @param verb The another verb
	 * @return true if both verbs have the same internal representation, false otherwise
	 */
	public boolean equals(Verb verb) {
		return this.verb.get().equals(verb.get());
	}

}
