package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.NounDeclensionFilter;

/**
 * <p>Enumerated possessive persons of nominative.</p>
 * @author almir jr.
 *
 */
public enum EnumNounPersons implements NounDeclensionFilter {

	NEUTRAL(0,"NEUTRAL"), I(1,"I"), YOU(2,"YOU"), HE_SHE_IT(3,"HE_SHE_IT"), WE(4,"WE"), YOU_PLURAL(5,"YOU_PLURAL"), THEY(6,"THEY");
	
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
	EnumNounPersons(int value, String description) {
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
	public static List<EnumNounPersons> asList() {
		return Arrays.asList(I, YOU, HE_SHE_IT, WE, YOU_PLURAL, THEY);
	}
	
}
