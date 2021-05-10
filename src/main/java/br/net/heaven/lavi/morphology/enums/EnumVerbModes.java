package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

public enum EnumVerbModes implements VerbConjugationFilter {

	FACTUAL(1,"FACTUAL"), DESIDERATIVE(2,"DESIDERATIVE"), IMPERATIVE(3,"IMPERATIVE");
	
	private int value;
	private String description;
	
	EnumVerbModes(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return this.description;
	}	
	
	public static List<EnumVerbModes> asList() {
		return Arrays.asList(FACTUAL, DESIDERATIVE, IMPERATIVE);
	}
	
}
