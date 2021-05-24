package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

/**
 * <p>Enumerated harmony types.</p>
 * @author almir jr.
 *
 */
public enum EnumVerbModes implements VerbConjugationFilter {

	FACTUAL(1,"FACTUAL"), DESIDERATIVE(2,"DESIDERATIVE"), IMPERATIVE(3,"IMPERATIVE");
	
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
	EnumVerbModes(int value, String description) {
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
	 * @return
	 */
	public static List<EnumVerbModes> asList() {
		return Arrays.asList(FACTUAL, DESIDERATIVE, IMPERATIVE);
	}
	
}
