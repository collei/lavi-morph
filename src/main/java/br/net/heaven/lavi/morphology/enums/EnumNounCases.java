package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.NounDeclensionFilter;

/**
 * <p>Enumerated harmony types.</p>
 * @author almir jr.
 *
 */
public enum EnumNounCases implements NounDeclensionFilter {

	NOMINATIVE(1,"NOMINATIVE"),
	ACCUSATIVE(2,"ACCUSATIVE"),
	GENITIVE(3,"GENITIVE"),
	DATIVE(4,"DATIVE"),
	ABLATIVE(5,"ABLATIVE"),
	LOCATIVE(6,"LOCATIVE"),
	INSTRUMENTAL(7,"INSTRUMENTAL"),
	PARTITIVE(8,"PARTITIVE"),
	ABESSIVE(9,"ABESSIVE"),
	COMITATIVE(10,"COMITATIVE");
	
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
	EnumNounCases(int value, String description) {
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
	public static List<EnumNounCases> asList() {
		return Arrays.asList(NOMINATIVE, ACCUSATIVE, GENITIVE, DATIVE, ABLATIVE, LOCATIVE, INSTRUMENTAL, PARTITIVE, ABESSIVE, COMITATIVE);
	}

}
