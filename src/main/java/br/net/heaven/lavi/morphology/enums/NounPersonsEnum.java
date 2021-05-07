package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.filter.NounDeclensionFilter;

public enum NounPersonsEnum implements NounDeclensionFilter {

	NEUTRAL(0,"NEUTRAL"), I(1,"I"), YOU(2,"YOU"), HE_SHE_IT(3,"HE_SHE_IT"), WE(4,"WE"), YOU_PLURAL(5,"YOU_PLURAL"), THEY(6,"THEY");
	
	private int value;
	private String description;
	
	NounPersonsEnum(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return this.description;
	}
	
	public static List<NounPersonsEnum> asList() {
		return Arrays.asList(I, YOU, HE_SHE_IT, WE, YOU_PLURAL, THEY);
	}
	
}
