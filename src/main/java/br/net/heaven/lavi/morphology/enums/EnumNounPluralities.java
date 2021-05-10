package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.NounDeclensionFilter;

public enum EnumNounPluralities implements NounDeclensionFilter {

	SINGULAR(1,"SINGULAR"), DUAL(2,"DUAL"), PLURAL(3,"PLURAL");

	private int value;	
	private String description;
	
	EnumNounPluralities(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return this.description;
	}	
	
	public static List<EnumNounPluralities> asList() {
		return Arrays.asList(SINGULAR, DUAL, PLURAL);
	}
	
}
