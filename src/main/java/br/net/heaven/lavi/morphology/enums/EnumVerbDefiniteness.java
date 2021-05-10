package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

public enum EnumVerbDefiniteness implements VerbConjugationFilter {

	INDEFINITE(1,"INDEFINITE"), DEFINITE(2,"DEFINITE");
	
	private int value;
	private String description;
	
	EnumVerbDefiniteness(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return this.description;
	}
	
	public static List<EnumVerbDefiniteness> asList() {
		return Arrays.asList(INDEFINITE, DEFINITE);
	}
	
}
