package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

public enum EnumVerbTenses implements VerbConjugationFilter {

	IMPERFECT(1,"IMPERFECT"), PERFECT(2,"PERFECT");
	
	private int value;
	private String description;
	
	EnumVerbTenses(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return this.description;
	}
	
	public static List<EnumVerbTenses> asList() {
		return Arrays.asList(IMPERFECT, PERFECT);
	}
	
}
