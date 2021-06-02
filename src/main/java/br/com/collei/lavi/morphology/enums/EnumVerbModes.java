package br.com.collei.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.com.collei.lavi.morphology.enums.filter.VerbConjugationFilter;

/**
 * <p>Enumerated verb modes.</p>
 * @author almir jr.
 *
 */
public enum EnumVerbModes implements VerbConjugationFilter {

	FACTUAL(1,"FACTUAL"), DESIDERATIVE(2,"DESIDERATIVE"), IMPERATIVE(3,"IMPERATIVE");
	
	/**
	 * <p>Fix 'bad class file' issues</p>
	 */
	private static final long serialVersionUID = 98274998904169L;
	
	/**
	 * <p>numeric value of the type.</p>
	 */
	private final int value;
	
	/**
	 * <p>textual description of the type.</p>
	 */
	private final String description;
	
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
	@Override
	public String toString() {
		return this.description;
	}	
	
	/**
	 * <p>Generates the list of the enumerated types.</p>
	 * @return the list of all possible values
	 */
	public static List<EnumVerbModes> asList() {
		return Arrays.asList(FACTUAL, DESIDERATIVE, IMPERATIVE);
	}
	
}
