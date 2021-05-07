package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

public enum HarmonyEnum {

	BACK(1,"BACK"), FRONT(2,"FRONT");
	
	private int value;
	private String description;
	
	HarmonyEnum(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return this.description;
	}
	
	public static List<HarmonyEnum> asList() {
		return Arrays.asList(BACK, FRONT);
	}
	
}
