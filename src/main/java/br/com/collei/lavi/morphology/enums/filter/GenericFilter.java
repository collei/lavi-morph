package br.com.collei.lavi.morphology.enums.filter;

/**
 * <p>A generic filter, extended by NounDeclensionFilter and VerbConjugatedFilter.</p>
 * @author almir jr.
 * @see NounDeclensionFilter
 * @see VerbConjugationFilter
 *
 */
public interface GenericFilter {
	
	/**
	 * <p>Returns the name of the filter item.</p>
	 * @return the name of the filter item.
	 */
	public String name();

}
