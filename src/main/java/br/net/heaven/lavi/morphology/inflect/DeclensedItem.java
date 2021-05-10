package br.net.heaven.lavi.morphology.inflect;

import br.net.heaven.lavi.morphology.core.Noun;
import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.enums.EnumNounCases;
import br.net.heaven.lavi.morphology.enums.EnumNounPersons;
import br.net.heaven.lavi.morphology.enums.EnumNounPluralities;
import br.net.heaven.lavi.morphology.enums.filter.NounDeclensionFilter;

public class DeclensedItem {

	private Noun noun;
	private Noun declensed;
	private EnumNounPersons person; 
	private EnumNounPluralities plurality; 
	private EnumNounCases nounCase; 
	
	public DeclensedItem(Noun noun, EnumNounCases nounCase, EnumNounPluralities plurality) {
		this.noun = noun;
		this.person = EnumNounPersons.NEUTRAL;
		this.plurality = plurality;
		this.nounCase = nounCase;
		this.declensed = this.noun.makeDeclension(nounCase, plurality);
	}

	public DeclensedItem(Noun noun, EnumNounPersons person, EnumNounPluralities plurality) {
		this.noun = noun;
		this.person = person;
		this.plurality = plurality;
		this.nounCase = EnumNounCases.NOMINATIVE;
		this.declensed = this.noun.makePossessive(person, plurality);
	}

	public Term getNoun() {
		return this.noun;
	}

	public Term getDeclensed() {
		return this.declensed;
	}

	public EnumNounPersons getPerson() {
		return person;
	}

	public EnumNounCases getCase() {
		return nounCase;
	}

	public EnumNounPluralities getPlurality() {
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
		if (person == EnumNounPersons.NEUTRAL) {
			return new DeclensedItem(noun, nounCase, plurality);
		} else {
			return new DeclensedItem(noun, person, plurality);
		}
	}

}
