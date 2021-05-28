package br.com.collei.lavi.morphology.inflect;

import br.com.collei.lavi.morphology.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.EnumVerbModes;
import br.com.collei.lavi.morphology.EnumVerbPersons;
import br.com.collei.lavi.morphology.EnumVerbTenses;
import br.com.collei.lavi.morphology.EnumVerbVoices;
import br.com.collei.lavi.morphology.core.Term;
import br.com.collei.lavi.morphology.core.Verb;
import br.com.collei.lavi.morphology.filter.VerbConjugationFilter;

/**
 * <p>A conjugated item in a ConjugationTable instance.</p>
 * @author almir jr.
 *
 */
public class ConjugatedItem {

	/**
	 * <p>The original verb, infinitive form.</p>
	 */
	private Verb verb;
	
	/**
	 * <p>The conjugated form of the verb.</p>
	 */
	private Term conjugated;
	
	/**
	 * <p>The verb person in which the verb is conjugated.</p>
	 */
	private EnumVerbPersons person; 
	
	/**
	 * <p>The verb tense in which the verb is conjugated.</p>
	 */
	private EnumVerbTenses tense; 
	
	/**
	 * <p>The verb voice in which the verb is conjugated.</p>
	 */
	private EnumVerbVoices voice; 
	
	/**
	 * <p>The verb mode in which the verb is conjugated.</p>
	 */
	private EnumVerbModes mode; 
	
	/**
	 * <p>The verb definiteness in which the verb is conjugated.</p>
	 */
	private EnumVerbDefiniteness definiteness;
	
	/**
	 * <p>Creates a new instance of the conjugated form of the given verb.</p>
	 * @param verb The given verb
	 * @param person The given person
	 * @param tense The given tense
	 * @param voice The given voice
	 * @param mode The given mode
	 * @param definiteness The given definiteness
	 */
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

	/**
	 * <p>Gets the original verb.</p>
	 * @return the original verb
	 * @see Verb
	 */
	public Verb getVerb() {
		return this.verb;
	}

	/**
	 * <p>Gets the conjugated form.</p>
	 * @return the conjugated form
	 * @see Term
	 */
	public Term getConjugated() {
		return this.conjugated;
	}

	/**
	 * <p>Gets the conjugated person.</p>
	 * @return the conjugated person
	 */
	public EnumVerbPersons getPerson() {
		return person;
	}

	/**
	 * <p>Gets the conjugated tense.</p>
	 * @return the conjugated tense
	 */
	public EnumVerbTenses getTense() {
		return tense;
	}

	/**
	 * <p>Gets the conjugated voice.</p>
	 * @return the conjugated voice
	 */
	public EnumVerbVoices getVoice() {
		return voice;
	}

	/**
	 * <p>Gets the conjugated mode.</p>
	 * @return the conjugated mode
	 */
	public EnumVerbModes getMode() {
		return mode;
	}

	/**
	 * <p>Gets the conjugated definiteness.</p>
	 * @return the conjugated definiteness
	 */
	public EnumVerbDefiniteness getDefiniteness() {
		return definiteness;
	}
	
	/**
	 * <p>Returns whether the conjugated form match every of the given conjugation filters.</p>
	 * <p>Example: conjugatedItem.matches(EnumVerbTenses.IMPERFECT, EnumVerbPersons.I) returns true if (and only if) conjugatedItem is both IMPERFECT and 1st person.</p>
	 * @param filters List of any VerbConjugationFilter enumerated values
	 * @return true if the conjugated form matches ALL the given filters, false otherwise
	 */
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
	
	/**
	 * <p>Generates a copy of the current instance.</p>
	 */
	@Override
	public ConjugatedItem clone() {
		return new ConjugatedItem(verb, person, tense, voice, mode, definiteness);
	}

}
