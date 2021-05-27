package br.net.heaven.lavi.morphology.core;

import br.net.heaven.lavi.morphology.enums.EnumNounCases;
import br.net.heaven.lavi.morphology.enums.EnumNounPersons;
import br.net.heaven.lavi.morphology.enums.EnumNounPluralities;
import br.net.heaven.lavi.morphology.enums.EnumPartsOfSpeech;
import br.net.heaven.lavi.morphology.inflect.Declensor;

/**
 * <p>Noun is a word that names a being in the world.</p>
 * 
 * @author almir jr.
 *
 */
public class Noun extends Term {
	
	/**
	 * <p>Creates a noun instance.</p>
	 * @param noun the noun to be created
	 */
	public Noun(String noun) {
		super(noun, EnumPartsOfSpeech.NOUN);
	}
	
	/**
	 * <p>Performs declension of the noun to the singular.</p>
	 * @param nounCase the case to which the noun will be declensed
	 * @return a declensed version of the noun
	 */
	public Noun makeDeclension(EnumNounCases nounCase) {
		return makeDeclension(nounCase, EnumNounPluralities.SINGULAR);
	}
	
	/**
	 * <p>Performs declension of the noun.</p>
	 * @param nounCase the case to which the noun will be ddeclensed
	 * @param plurality the plurality (SINGULAR, DUAL, PLURAL) of the resulting Noun
	 * @return a declensed version of the noun
	 */
	public Noun makeDeclension(EnumNounCases nounCase, EnumNounPluralities plurality) {
		String declensed = Declensor.makeDeclension(this, nounCase, plurality);
		return new Noun(declensed);
	}

	/**
	 * <p>Performs possessive declension of the current noun.</p>
	 * @param person to wich the noun will be declensed
	 * @return a possessive-declensed version of the noun
	 */
	public Noun makePossessive(EnumNounPersons person) {
		return makePossessive(person, EnumNounPluralities.SINGULAR);
	}

	/**
	 * <p>Performs possessive declension of the current noun.</p>
	 * @param person to wich the noun will be declensed
	 * @param plurality the plurality (SINGULAR, DUAL, PLURAL) of the resulting Noun
	 * @return a possessive-declensed version of the noun
	 */
	public Noun makePossessive(EnumNounPersons person, EnumNounPluralities plurality) {
		String declensed = Declensor.makePossessive(this, person, plurality);
		return new Noun(declensed);
	}

}
