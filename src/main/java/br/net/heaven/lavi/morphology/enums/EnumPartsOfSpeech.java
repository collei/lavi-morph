package br.net.heaven.lavi.morphology.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumPartsOfSpeech {

	UNDEFINED(0,"UNDEFINED","undefined"),
	NOUN(1,"NOUN","n."),
	ADJECTIVE(2,"ADJECTIVE","adj."),
	ADVERB(3,"ADVERB","adv."),
	VERB(4,"VERB","v."),
	PREPOSITION(5,"PREPOSITION","prep."),
	POSTPOSITION(6,"POSTPOSITION","postp."),
	CIRCUMPOSITION(7,"CIRCUMPOSITION","circump."),
	PRONOUN(8,"PRONOUN","pron."),
	NUMBER(9,"NUMBER","num."),
	DISCOURSE_MARKER(10,"DISCOURSE_MARKER","disc. m."),
	PARTICLE(11,"PARTICLE","part."),
	CONJUNCTION(12,"CONJUNCTION","conj."),
	INTERJECTION(13,"INTERJECTION","interj."),
	ASPECT_MARKER(14,"ASPECT_MARKER","asp. m."),
	EVIDENCE_MARKER(15,"EVIDENCE_MARKER","evid. m."),
	EMPHASIZER(16,"EMPHASIZER","emph."),
	SEPARATOR(17,"SEPARATOR","sep."),
	MODE_MARKER(18,"MODE_MARKER","m. m."),
	TENSE_MARKER(19,"TENSE_MARKER","t. m."),
	COVERB(20,"COVERB","cov."),
	COPULA(21,"COPULA","cop."),
	PREFIX(22,"PREFIX","pref."),
	SUFFIX(23,"SUFFIX","suff."),
	PHRASE(24,"PHRASE","phrase");
	
	private int value;
	private String description;
	private String abbreviation;
	
	EnumPartsOfSpeech(int value, String description, String abbreviation) {
		this.value = value;
		this.description = description;
		this.abbreviation = abbreviation;
	}

	public int getValue() {
		return this.value;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}
	
	public String toString() {
		return this.description;
	}
	
	public static List<EnumPartsOfSpeech> asList() {
		return Arrays.asList(NOUN,ADJECTIVE,ADVERB,VERB,PREPOSITION,POSTPOSITION,CIRCUMPOSITION,PRONOUN,NUMBER,DISCOURSE_MARKER,PARTICLE,CONJUNCTION,INTERJECTION,ASPECT_MARKER,EVIDENCE_MARKER,EMPHASIZER,SEPARATOR,MODE_MARKER,TENSE_MARKER,COVERB,COPULA,PREFIX,SUFFIX,PHRASE);
	}
	
}
