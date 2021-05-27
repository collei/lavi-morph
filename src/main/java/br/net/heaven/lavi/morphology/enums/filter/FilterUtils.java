package br.net.heaven.lavi.morphology.enums.filter;

import java.util.ArrayList;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.EnumVerbDefiniteness;
import br.net.heaven.lavi.morphology.enums.EnumVerbModes;
import br.net.heaven.lavi.morphology.enums.EnumVerbPersons;
import br.net.heaven.lavi.morphology.enums.EnumVerbTenses;
import br.net.heaven.lavi.morphology.enums.EnumVerbVoices;

/**
 * <p>Utility class for applying filters upon verb conjugation work.</p>
 * @author almir jr.
 *
 */
public class FilterUtils {
	
	/**
	 * <p>Internal list of every possible verb conjugation filter to be checked against strings through fromString() method.</p>
	 */
	private static List<VerbConjugationFilter> savedFilters = null;
	
	/**
	 * <p>Initialize the internal set of verb conjugation filters.</p>
	 */
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
	
	/**
	 * <p>Checks strings against a given GenericFilter.</p>
	 * @param target The given filter of type GenericFilter
	 * @param filters A list of String representations to be checked against the given filter
	 * @return true if one of the strings matches the given filter, false otherwise
	 */
	public static boolean matches(GenericFilter target, String...filters) {
		for (String filt : filters) {
			if (target.name().equals(filt)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p>Checks strings against a given VerbConjugationFilter.</p>
	 * @param target The given filter of type VerbConjugationFilter
	 * @param filters A list of String representations to be checked against the given filter
	 * @return true if one of the strings matches the given filter, false otherwise
	 */
	public static boolean matches(VerbConjugationFilter target, String...filters) {
		for (String filt : filters) {
			if (target.name().equals(filt)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p>Converts a String representation into a VerbConjugationFilter value, if possible.</p>
	 * @param string The representation to be converted
	 * @return The VerbConjugationFilter value corresponding to the given string representation
	 */
	public static VerbConjugationFilter fromString(String string) {
		initFilters();
		for (VerbConjugationFilter filter : savedFilters) {
			if (filter.name().equals(string)) {
				return filter;
			}
		}
		return null;
	}
	
	/**
	 * <p>Converts a list of String representations into a list of VerbConjugationFilter values.
	 * For each String of the list, returns a VerbConjugationFilter value if possible.</p>
	 * @param stringFilters A list of string representations to be converted
	 * @return A list of VerbConjugationFilter values converted from the string representations
	 */
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
