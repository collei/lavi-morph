package br.net.heaven.lavi.morphology.inflect;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.EnumHarmony;
import br.net.heaven.lavi.morphology.enums.EnumVerbDefiniteness;
import br.net.heaven.lavi.morphology.enums.EnumVerbPersons;
import br.net.heaven.lavi.morphology.enums.EnumVerbTenses;
import br.net.heaven.lavi.morphology.enums.EnumVerbVoices;

public class Conjugator {
	
	public static String doFactual(Verb verb, EnumVerbPersons person, EnumVerbTenses tense, EnumVerbVoices voice, EnumVerbDefiniteness definiteness) {
		String suffix = "";
		Term conjugated = new Term(verb.getStem());
		EnumHarmony harmony = verb.getHarmony();
		boolean vocalic = verb.isVocalic();
		//
		if (tense == EnumVerbTenses.PERFECT) {
			if (definiteness == EnumVerbDefiniteness.DEFINITE) {
				if (harmony == EnumHarmony.BACK) {
					suffix = Conjugator.choosePerson(person, "tom", "tod", "tja", "tonu", "totok", "tjuk");
				} else {
					suffix = Conjugator.choosePerson(person, "tem", "ted", "tje", "tenu", "titek", "tjuk");
				}
			} else {
				suffix = Conjugator.choosePerson(person, "tu", "tiš", "te", "time", "tite", "tech");
			}
		} else {
			if (definiteness == EnumVerbDefiniteness.DEFINITE) {
				if (harmony == EnumHarmony.BACK) {
					suffix = Conjugator.choosePerson(person, "jom", "jod", "ja", "jonu", "jotok", "juk");
				} else {
					suffix = Conjugator.choosePerson(person, "jem", "jed", "je", "jenu", "jitek", "juk");
				}
			} else {
				if (vocalic) {
					suffix = Conjugator.choosePerson(person, "ju", "jš", "j", "jme", "jte", "jech");
				} else {
					suffix = Conjugator.choosePerson(person, "u", "iš", "e", "ime", "ite", "ech");
				}
			}
		}
		//
		conjugated.appendSuffix(suffix);
		conjugated.appendSuffix(Conjugator.generateVoiceAffix(conjugated, voice));
		//
		return conjugated.get();
	}
	
	public static String doDesiderative(Verb verb, EnumVerbPersons person, EnumVerbTenses tense, EnumVerbVoices voice, EnumVerbDefiniteness definiteness) {
		String partial = Conjugator.doFactual(verb, person, tense, voice, definiteness);
		return "na " + partial;
	}
	
	public static String doImperative(Verb verb, EnumVerbPersons person, EnumVerbDefiniteness definiteness) {
		String suffix = "";
		Term conjugated = new Term(verb.getStem());
		EnumHarmony harmony = verb.getHarmony();
		boolean vocalic = verb.isVocalic();
		//
		if (definiteness == EnumVerbDefiniteness.DEFINITE) {
			if (harmony == EnumHarmony.BACK) {
				if (vocalic) {
					suffix = Conjugator.choosePerson(person, "chod", "chonu", "chtok");
				} else {
					suffix = Conjugator.choosePerson(person, "chod", "ichonu", "ichtok");
				}
			} else {
				if (vocalic) {
					suffix = Conjugator.choosePerson(person, "ched", "chenu", "chtek");
				} else {
					suffix = Conjugator.choosePerson(person, "ched", "ichenu", "ichtek");
				}
			}
		} else { // (definiteness == VerbDefinitenessEnum.INDEFINITE)
			if (vocalic) {
				suffix = Conjugator.choosePerson(person, "ch", "moch", "toch");
			} else {
				suffix = Conjugator.choosePerson(person, "och", "omoch", "otoch");
			}
		}
		//
		conjugated.appendSuffix(suffix);
		//conjugated.appendSuffix(Conjugator.generateVoiceAffix(conjugated, voice));
		//
		return conjugated.get();
	}
	
	/// for internal use
	
	private static String choosePerson(EnumVerbPersons person, String i, String you, String heSheIt, String we, String youPlural, String they) {
		switch (person) {
			case I:
				return i;
			case HE_SHE_IT:
				return heSheIt;
			case THEY:
				return they;
			default:
				return choosePerson(person, you, we, youPlural);
		}
	}
	
	private static String choosePerson(EnumVerbPersons person, String you, String we, String youPlural) {
		switch (person) {
			case YOU:
				return you;
			case WE:
				return we;
			case YOU_PLURAL:
				return youPlural;
			default:
				return "";
		}
	}
	
	private static String generateVoiceAffix(Term conjugatedVerb, EnumVerbVoices voice) {
		boolean vocalic = conjugatedVerb.isVocalic();
		EnumHarmony harmony = conjugatedVerb.getHarmony();
		//
		if (voice == EnumVerbVoices.PASSIVE) {
			if (vocalic) {
				return "ri";
			} else {
				return "i";
			}
		} else if (voice == EnumVerbVoices.MEDIAL) {
			if (harmony == EnumHarmony.BACK) {
				if (vocalic) {
					return "ror";
				} else {
					return "or";
				}
			} else {
				if (vocalic) {
					return "rer";
				} else {
					return "er";
				}
			}
		}
		return "";
	}

}