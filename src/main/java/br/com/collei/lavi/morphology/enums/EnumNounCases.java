package br.com.collei.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.com.collei.lavi.morphology.enums.filter.NounDeclensionFilter;

/**
 * <p>Enumerated noun cases.</p>
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
	@Override
	public String toString() {
		return this.description;
	}	
	
	/**
	 * <p>Generates the list of the enumerated types.</p>
	 * @return the list of all possible values
	 */
	public static List<EnumNounCases> asList() {
		return Arrays.asList(NOMINATIVE, ACCUSATIVE, GENITIVE, DATIVE, ABLATIVE, LOCATIVE, INSTRUMENTAL, PARTITIVE, ABESSIVE, COMITATIVE);
	}

}
