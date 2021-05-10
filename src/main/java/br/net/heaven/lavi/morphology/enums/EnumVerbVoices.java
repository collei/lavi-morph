package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.VerbConjugationFilter;

public enum EnumVerbVoices implements VerbConjugationFilter {

	ACTIVE(1,"ACTIVE"), MEDIAL(2,"MEDIAL"), PASSIVE(3,"PASSIVE");
	
	private int value;
	private String description;
	
	EnumVerbVoices(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return this.description;
	}
	
	public static List<EnumVerbVoices> asList() {
		return Arrays.asList(ACTIVE, MEDIAL, PASSIVE);
	}
	
}
