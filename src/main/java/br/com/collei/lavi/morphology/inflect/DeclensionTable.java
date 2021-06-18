package br.com.collei.lavi.morphology.inflect;

import java.util.ArrayList;
import java.util.List;

import br.com.collei.lavi.morphology.Noun;
import br.com.collei.lavi.morphology.Term;
import br.com.collei.lavi.morphology.enums.EnumNounCases;
import br.com.collei.lavi.morphology.enums.EnumNounPersons;
import br.com.collei.lavi.morphology.enums.EnumNounPluralities;
import br.com.collei.lavi.morphology.filter.NounDeclensionFilter;

/**
 * <p>Holds the declension items and makes the composition work easy.</p>
 * @author almir jr.
 *
 */
public class DeclensionTable {
	
	/**
	 * <p>The current plurality.</p>
	 */
	private EnumNounPluralities plurality;

	/**
	 * <p>The noun being declensed.</p>
	 */
	private Noun noun;
	
	/**
	 * <p>The list of DeclensedItem instances.</p>
	 */
	private List<DeclensedItem> units;
	
	/**
	 * <p>Creates an instance of the table.</p>
	 * @param noun The noun to be declensed
	 * @throws NullPointerException if the argument is null
	 * @throws IllegalArgumentException if the Noun instance contains a null String or an empty String
	 */
	public DeclensionTable(Noun noun) {
		if (noun == null) {
			throw new NullPointerException("Termo não pode ser null!");
		} else if (noun.get() == null) {
			throw new IllegalArgumentException("Termo não pode conter null!");
		} else if (noun.get().equals("")) {
			throw new IllegalArgumentException("Termo não pode ser uma string vazia!");
		}
		this.noun = noun;
		this.plurality = EnumNounPluralities.SINGULAR;
		this.units = new ArrayList<DeclensedItem>();
	}
	
	/////*/////

	/**
	 * <p>Defines the current plurality.</p>
	 * @param plurality The plurality to be set
	 * @return the table itself
	 */
	public DeclensionTable setPlurality(EnumNounPluralities plurality) {
		this.plurality = plurality;
		return this;
	}
	
	/**
	 * <p>Adds a new item to the table with the current plurality.</p>
	 * @param nounCase The case to be added
	 * @return the table itself
	 */
	public DeclensionTable add(EnumNounCases nounCase) {
		this.units.add(new DeclensedItem(
				this.noun,
				nounCase,
				this.plurality));
		return this;
	}
	
	/**
	 * <p>Adds a new item to the table with gthe current plurality.</p>
	 * @param person The person of the Nominative form to be added
	 * @return the table itself
	 */
	public DeclensionTable add(EnumNounPersons person) {
		this.units.add(new DeclensedItem(
				this.noun,
				person,
				this.plurality));
		return this;
	}
	
	/**
	 * <p>Returns a list of declensed items as a List of Term instances.</p>
	 * @return a list of Term instances
	 */
	public List<Term> asList() {
		List<Term> list = new ArrayList<Term>();
		for (DeclensedItem item : this.units) {
			list.add(item.getDeclensed().clone());
		}
		return list;
	}
	
	/**
	 * <p>Returns a list of declensed items as a List of Term instances that match all the given filters.</p>
	 * @param filters One or more filters
	 * @return a list of Term instances that match all the given filters
	 */
	public List<Term> asFiltered(NounDeclensionFilter...filters) {
		List<Term> list = new ArrayList<Term>();
		for (DeclensedItem item : this.units) {
			if (item.matches(filters)) {
				list.add(item.getDeclensed().clone());
			}
		}
		return list;
	}
	
	/**
	 * <p>Returns a list of DeclensedItem instances.</p>
	 * @return a list of DeclensedItem instances
	 */
	public List<DeclensedItem> asItemsList() {
		List<DeclensedItem> list = new ArrayList<DeclensedItem>();
		for (DeclensedItem item : this.units) {
			list.add(item.clone());
		}
		return list;
	}
	
	/**
	 * <p>Returns a list of DeclensedItem instances that match all the given filters.</p>
	 * @param filters One or more filters
	 * @return a list of DeclensedItem instances that match all the given filters
	 */
	public List<DeclensedItem> asItemsFiltered(NounDeclensionFilter...filters) {
		List<DeclensedItem> list = new ArrayList<DeclensedItem>();
		for (DeclensedItem item : this.units) {
			if (item.matches(filters)) {
				list.add(item.clone());
			}
		}
		return list;
	}

	/**
	 * <p>Returns a list of DeclensedItem instances that match all the values present in the filterList.</p>
	 * @param filterList A list of filters
	 * @return a list of DeclensedItem instances that match all the values present in the filterList
	 */
	public List<DeclensedItem> asItemsFiltered(List<NounDeclensionFilter> filterList) {
		return this.asItemsFiltered(filterList.toArray(new NounDeclensionFilter[filterList.size()]));
	}
	
}
