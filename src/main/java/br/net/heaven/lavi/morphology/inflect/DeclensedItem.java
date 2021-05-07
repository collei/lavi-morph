package br.net.heaven.lavi.morphology.inflect;

import br.net.heaven.lavi.morphology.core.Noun;
import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.enums.NounCasesEnum;
import br.net.heaven.lavi.morphology.enums.NounPersonsEnum;
import br.net.heaven.lavi.morphology.enums.NounPluralitiesEnum;
import br.net.heaven.lavi.morphology.enums.filter.NounDeclensionFilter;

public class DeclensedItem {

	private Noun noun;
	private Noun declensed;
	private NounPersonsEnum person; 
	private NounPluralitiesEnum plurality; 
	private NounCasesEnum nounCase; 
	
	public DeclensedItem(Noun noun, NounCasesEnum nounCase, NounPluralitiesEnum plurality) {
		this.noun = noun;
		this.person = NounPersonsEnum.NEUTRAL;
		this.plurality = plurality;
		this.nounCase = nounCase;
		this.declensed = this.noun.makeDeclension(nounCase, plurality);
	}

	public DeclensedItem(Noun noun, NounPersonsEnum person, NounPluralitiesEnum plurality) {
		this.noun = noun;
		this.person = person;
		this.plurality = plurality;
		this.nounCase = NounCasesEnum.NOMINATIVE;
		this.declensed = this.noun.makePossessive(person, plurality);
	}

	public Term getNoun() {
		return this.noun;
	}

	public Term getDeclensed() {
		return this.declensed;
	}

	public NounPersonsEnum getPerson() {
		return person;
	}

	public NounCasesEnum getCase() {
		return nounCase;
	}

	public NounPluralitiesEnum getPlurality() {
		return plurality;
	}
	
	public boolean matches(NounDeclensionFilter...filters) {
		boolean matched = true;
		for (NounDeclensionFilter filter : filters) {
			matched = matched && ((this.nounCase == filter) || (this.person == filter) || (this.plurality == filter));
		}
		return matched;
	}
	
	@Override
	public DeclensedItem clone() {
		if (person == NounPersonsEnum.NEUTRAL) {
			return new DeclensedItem(noun, nounCase, plurality);
		} else {
			return new DeclensedItem(noun, person, plurality);
		}
	}

}
