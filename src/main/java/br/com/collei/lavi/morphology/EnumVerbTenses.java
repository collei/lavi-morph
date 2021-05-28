package br.com.collei.lavi.morphology;

import java.util.Arrays;
import java.util.List;

import br.com.collei.lavi.morphology.filter.VerbConjugationFilter;

/**
 * <p>Enumerated verb tenses.</p>
 * @author almir jr.
 *
 */
public enum EnumVerbTenses implements VerbConjugationFilter {

	IMPERFECT(1,"IMPERFECT"), PERFECT(2,"PERFECT");
	
	/**
	 * <p>numeric value of the type.</p>
	 */
	private int value;
	
	/**
	 * <p>textual description of the type.</p>
	 */
	private String description;
	
	/**
	 * <p>Creates a new type of this enumeration.</p>
	 * @param value the numeric value of the type
	 * @param description the textual description of the value
	 */
	EnumVerbTenses(int value, String description) {
		this.value = value;
		this.description = description;
	}

	/**
	 * <p>returns the numeric value of the type.</p>
	 * @return the numeric value of the type
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * <p>gets the textual description of the type.</p>
	 */
	public String toString() {
		return this.description;
	}
	
	/**
	 * <p>Generates the list of the enumerated types.</p>
	 * @return the list of all possible values
	 */
	public static List<EnumVerbTenses> asList() {
		return Arrays.asList(IMPERFECT, PERFECT);
	}
	
}
