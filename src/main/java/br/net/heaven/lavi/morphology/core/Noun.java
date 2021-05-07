package br.net.heaven.lavi.morphology.core;

import br.net.heaven.lavi.morphology.enums.NounCasesEnum;
import br.net.heaven.lavi.morphology.enums.NounPluralitiesEnum;
import br.net.heaven.lavi.morphology.enums.NounPersonsEnum;
import br.net.heaven.lavi.morphology.inflect.Declensor;

public class Noun extends Term {
	
	public Noun(String noun) {
		super(noun);
	}
	
	public Noun makeDeclension(NounCasesEnum nounCase) {
		return makeDeclension(nounCase, NounPluralitiesEnum.SINGULAR);
	}
	
	public Noun makeDeclension(NounCasesEnum nounCase, NounPluralitiesEnum plurality) {
		String declensed = Declensor.makeDeclension(this, nounCase, plurality);
		return new Noun(declensed);
	}

	public Noun makePossessive(NounPersonsEnum person) {
		return makePossessive(person, NounPluralitiesEnum.SINGULAR);
	}

	public Noun makePossessive(NounPersonsEnum person, NounPluralitiesEnum plurality) {
		String declensed = Declensor.makePossessive(this, person, plurality);
		return new Noun(declensed);
	}

}
