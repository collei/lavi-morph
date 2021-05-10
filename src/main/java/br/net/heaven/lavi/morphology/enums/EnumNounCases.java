package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.NounDeclensionFilter;

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
	
	private int value;
	private String description;
	
	EnumNounCases(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		return this.description;
	}	
	
	public static List<EnumNounCases> asList() {
		return Arrays.asList(NOMINATIVE, ACCUSATIVE, GENITIVE, DATIVE, ABLATIVE, LOCATIVE, INSTRUMENTAL, PARTITIVE, ABESSIVE, COMITATIVE);
	}

}
