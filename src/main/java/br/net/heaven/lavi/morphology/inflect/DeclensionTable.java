package br.net.heaven.lavi.morphology.inflect;

import java.util.ArrayList;
import java.util.List;

import br.net.heaven.lavi.morphology.core.Noun;
import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.enums.NounCasesEnum;
import br.net.heaven.lavi.morphology.enums.NounPersonsEnum;
import br.net.heaven.lavi.morphology.enums.NounPluralitiesEnum;
import br.net.heaven.lavi.morphology.enums.filter.NounDeclensionFilter;

public class DeclensionTable {
	
	private NounPluralitiesEnum plurality;

	private Noun noun;
	private List<DeclensedItem> units;
	
	public DeclensionTable(Noun noun) {
		if (noun == null) {
			throw new NullPointerException("Termo não pode ser null!");
		} else if (noun.get() == null) {
			throw new IllegalArgumentException("Termo não pode conter null!");
		} else if (noun.get().equals("")) {
			throw new IllegalArgumentException("Termo não pode ser uma string vazia!");
		}
		this.noun = noun;
		this.plurality = NounPluralitiesEnum.SINGULAR;
		this.units = new ArrayList<DeclensedItem>();
	}
	
	/////*/////

	public DeclensionTable setPlurality(NounPluralitiesEnum plurality) {
		this.plurality = plurality;
		return this;
	}
	
	public DeclensionTable add(NounCasesEnum nounCase) {
		this.units.add(new DeclensedItem(
				this.noun,
				nounCase,
				this.plurality));
		return this;
	}
	
	public DeclensionTable add(NounPersonsEnum person) {
		this.units.add(new DeclensedItem(
				this.noun,
				person,
				this.plurality));
		return this;
	}
	
	public List<Term> asList() {
		List<Term> list = new ArrayList<Term>();
		for (DeclensedItem item : this.units) {
			list.add(item.getDeclensed().clone());
		}
		return list;
	}
	
	public List<Term> asFiltered(NounDeclensionFilter...filters) {
		List<Term> list = new ArrayList<Term>();
		for (DeclensedItem item : this.units) {
			if (item.matches(filters)) {
				list.add(item.getDeclensed().clone());
			}
		}
		return list;
	}
	
	public List<DeclensedItem> asItemsList() {
		List<DeclensedItem> list = new ArrayList<DeclensedItem>();
		for (DeclensedItem item : this.units) {
			list.add(item.clone());
		}
		return list;
	}
	
	public List<DeclensedItem> asItemsFiltered(NounDeclensionFilter...filters) {
		List<DeclensedItem> list = new ArrayList<DeclensedItem>();
		for (DeclensedItem item : this.units) {
			if (item.matches(filters)) {
				list.add(item.clone());
			}
		}
		return list;
	}

	public List<DeclensedItem> asItemsFiltered(List<NounDeclensionFilter> asFilterList) {
		return this.asItemsFiltered(asFilterList.toArray(new NounDeclensionFilter[asFilterList.size()]));
	}
	
}
