package br.com.collei.lavi.morphology.inflect;

import br.com.collei.lavi.morphology.Noun;
import br.com.collei.lavi.morphology.Term;
import br.com.collei.lavi.morphology.enums.EnumNounCases;
import br.com.collei.lavi.morphology.enums.EnumNounPersons;
import br.com.collei.lavi.morphology.enums.EnumNounPluralities;
import br.com.collei.lavi.morphology.filter.NounDeclensionFilter;

/**
 * <p>Holds the declensed item attributes.</p>
 * @author almir jr.
 *
 */
public class DeclensedItem {

	/**
	 * <p>the noun in original form.</p>
	 */
	private Noun noun;
	
	/**
	 * <p>the declensed form of the noun.</p>
	 */
	private Noun declensed;
	
	/**
	 * <p>the declensed person of the noun.</p>
	 */
	private EnumNounPersons person;
	
	/**
	 * <p>the declensed plurality of the noun.</p>
	 */
	private EnumNounPluralities plurality; 
	
	/**
	 * <p>the declensed case of the noun.</p>
	 */
	private EnumNounCases nounCase; 
	
	/**
	 * <p>Creates an instance of a declensed item, given the parameters below.</p>
	 * @param noun The noun to be declensed
	 * @param nounCase The case in which it will be declensed
	 * @param plurality The plurality in which it will be declensed
	 */
	public DeclensedItem(Noun noun, EnumNounCases nounCase, EnumNounPluralities plurality) {
		this.noun = noun;
		this.person = EnumNounPersons.NEUTRAL;
		this.plurality = plurality;
		this.nounCase = nounCase;
		this.declensed = this.noun.makeDeclension(nounCase, plurality);
	}

	/**
	 * <p>Creates a possessive form of the nominative, given the parameters below.</p>
	 * @param noun The noun to be declensed
	 * @param person The person in which it will be declensed
	 * @param plurality The plurality in which it will be declensed
	 */
	public DeclensedItem(Noun noun, EnumNounPersons person, EnumNounPluralities plurality) {
		this.noun = noun;
		this.person = person;
		this.plurality = plurality;
		this.nounCase = EnumNounCases.NOMINATIVE;
		this.declensed = this.noun.makePossessive(person, plurality);
	}

	/**
	 * <p>Returns the original noun.</p>
	 * @return the original noun
	 */
	public Term getNoun() {
		return this.noun;
	}

	/**
	 * <p>Returns the declensed version of the noun.</p>
	 * @return the declensed version of the noun
	 */
	public Term getDeclensed() {
		return this.declensed;
	}

	/**
	 * <p>Returns the declensed person attribute.</p>
	 * @return the declensed person attribute
	 */
	public EnumNounPersons getPerson() {
		return person;
	}

	/**
	 * <p>Returns the declensed case attribute.</p>
	 * @return the declensed case attribute
	 */
	public EnumNounCases getCase() {
		return nounCase;
	}

	/**
	 * <p>Returns the declensed plurality attribute.</p>
	 * @return the declensed plurality attribute
	 */
	public EnumNounPluralities getPlurality() {
		return plurality;
	}
	
	/**
	 * <p>Returns whether the DeclensedItem instance matches all the filters.</p>
	 * @param filters The given filters
	 * @return true if it matches all filters, false otherwise
	 */
	public boolean matches(NounDeclensionFilter...filters) {
		boolean matched = true;
		for (NounDeclensionFilter filter : filters) {
			matched = matched && ((this.nounCase == filter) || (this.person == filter) || (this.plurality == filter));
		}
		return matched;
	}
	
	/**
	 * <p>Returns a copy of this instance.</p>
	 */
	@Override
	public DeclensedItem clone() {
		if (person == EnumNounPersons.NEUTRAL) {
			return new DeclensedItem(noun, nounCase, plurality);
		} else {
			return new DeclensedItem(noun, person, plurality);
		}
	}

}
