package br.net.heaven.lavi.morphology.enums.filter;

import java.util.ArrayList;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.EnumVerbDefiniteness;
import br.net.heaven.lavi.morphology.enums.EnumVerbModes;
import br.net.heaven.lavi.morphology.enums.EnumVerbPersons;
import br.net.heaven.lavi.morphology.enums.EnumVerbTenses;
import br.net.heaven.lavi.morphology.enums.EnumVerbVoices;

public class FilterUtils {
	
	private static List<VerbConjugationFilter> savedFilters = null;
	
	private static void initFilters() {
		if (savedFilters == null) {
			savedFilters = new ArrayList<VerbConjugationFilter>();
			for (VerbConjugationFilter filter : EnumVerbPersons.asList()) {
				savedFilters.add(filter);
			}
			for (VerbConjugationFilter filter : EnumVerbTenses.asList()) {
				savedFilters.add(filter);
			}
			for (VerbConjugationFilter filter : EnumVerbModes.asList()) {
				savedFilters.add(filter);
			}
			for (VerbConjugationFilter filter : EnumVerbVoices.asList()) {
				savedFilters.add(filter);
			}
			for (VerbConjugationFilter filter : EnumVerbDefiniteness.asList()) {
				savedFilters.add(filter);
			}
		}
	}
	
	public static boolean matches(GenericFilter target, String...filters) {
		for (String filt : filters) {
			if (target.name().equals(filt)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean matches(VerbConjugationFilter target, String...filters) {
		for (String filt : filters) {
			if (target.name().equals(filt)) {
				return true;
			}
		}
		return false;
	}
	
	public static VerbConjugationFilter fromString(String string) {
		initFilters();
		for (VerbConjugationFilter filter : savedFilters) {
			if (filter.name().equals(string)) {
				return filter;
			}
		}
		return null;
	}
	
	public static List<VerbConjugationFilter> asFilterList(List<String> stringFilters) {
		List<VerbConjugationFilter> filterList = new ArrayList<VerbConjugationFilter>();
		for (String stringFilter : stringFilters) {
			VerbConjugationFilter filter = fromString(stringFilter);
			if (filter != null && filter.name().equals(stringFilter)) {
				filterList.add(filter);
			}
		}
		return filterList;
	}

}
