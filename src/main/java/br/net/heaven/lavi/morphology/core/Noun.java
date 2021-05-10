package br.net.heaven.lavi.morphology.core;

import br.net.heaven.lavi.morphology.enums.EnumNounCases;
import br.net.heaven.lavi.morphology.enums.EnumNounPersons;
import br.net.heaven.lavi.morphology.enums.EnumNounPluralities;
import br.net.heaven.lavi.morphology.enums.EnumPartsOfSpeech;
import br.net.heaven.lavi.morphology.inflect.Declensor;

public class Noun extends Term {
	
	public Noun(String noun) {
		super(noun, EnumPartsOfSpeech.NOUN);
	}
	
	public Noun makeDeclension(EnumNounCases nounCase) {
		return makeDeclension(nounCase, EnumNounPluralities.SINGULAR);
	}
	
	public Noun makeDeclension(EnumNounCases nounCase, EnumNounPluralities plurality) {
		String declensed = Declensor.makeDeclension(this, nounCase, plurality);
		return new Noun(declensed);
	}

	public Noun makePossessive(EnumNounPersons person) {
		return makePossessive(person, EnumNounPluralities.SINGULAR);
	}

	public Noun makePossessive(EnumNounPersons person, EnumNounPluralities plurality) {
		String declensed = Declensor.makePossessive(this, person, plurality);
		return new Noun(declensed);
	}

}
