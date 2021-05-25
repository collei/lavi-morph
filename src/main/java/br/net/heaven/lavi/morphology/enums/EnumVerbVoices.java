package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

/**
 * <p>Enumerated verb voices.</p>
 * @author almir jr.
 *
 */
public enum EnumVerbVoices implements VerbConjugationFilter {

	ACTIVE(1,"ACTIVE"), MEDIAL(2,"MEDIAL"), PASSIVE(3,"PASSIVE");
	
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
	EnumVerbVoices(int value, String description) {
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
	public static List<EnumVerbVoices> asList() {
		return Arrays.asList(ACTIVE, MEDIAL, PASSIVE);
	}
	
}
