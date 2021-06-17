package br.com.collei.lavi.morphology.enums.inflect;

import br.com.collei.lavi.morphology.enums.EnumHarmony;
import br.com.collei.lavi.morphology.enums.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.enums.EnumVerbPersons;
import br.com.collei.lavi.morphology.enums.EnumVerbTenses;
import br.com.collei.lavi.morphology.enums.EnumVerbVoices;
import br.com.collei.lavi.morphology.enums.core.Term;
import br.com.collei.lavi.morphology.enums.core.Verb;

/**
 * <p>This class applies the rules for verb conjugation for every tense, voice, mode etc..</p>
 * @author almir jr.
 *
 */
public class Conjugator {
	
	/**
	 * <p>Conjugates a verb into Factual pattern, given the parameters below.</p>
	 * @param verb The verb to be conjugated
	 * @param person The verb person
	 * @param tense The verb tense
	 * @param voice The verb voice
	 * @param definiteness The verb definiteness
	 * @return The conjugated verb as a String
	 */
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
	
	/**
	 * <p>Conjugates a verb into a Desiderative pattern, given the parameters below.</p>
	 * @param verb The verb to be conjugated
	 * @param person The verb person
	 * @param tense The verb tense
	 * @param voice The verb voice
	 * @param definiteness The verb definiteness
	 * @return The conjugated verb as a String
	 */
	public static String doDesiderative(Verb verb, EnumVerbPersons person, EnumVerbTenses tense, EnumVerbVoices voice, EnumVerbDefiniteness definiteness) {
		String partial = Conjugator.doFactual(verb, person, tense, voice, definiteness);
		return "na " + partial;
	}
	
	/**
	 * <p>Conjugates a verb into Imperative pattern, given the parameters below.</p>
	 * @param verb The verb to be conjugated
	 * @param person The verb person
	 * @param definiteness The verb definiteness
	 * @return The conjugated verb as a String
	 */
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
	
	/**
	 * <p>Returns one of the given suffixes based upon the given person.</p>
	 * @param person The given person
	 * @param i The suffix for 1st singular person
	 * @param you The suffix for 2nd singular person
	 * @param heSheIt The suffix for 3rd singular person
	 * @param we The suffix for 1st plural person
	 * @param youPlural The suffix for 2nd plural person 
	 * @param they The suffix for 3rd plural person
	 * @return one of the suffixes given above, or an empty string ("") otherwise
	 */
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
	
	/**
	 * <p>Returns one of the given suffixes based upon the given person.</p>
	 * @param person The given person
	 * @param you The suffix for 2nd singular person
	 * @param we The suffix for 1st plural person
	 * @param youPlural The suffix for 2nd plural person 
	 * @return one of the suffixes given above, or an empty string ("") otherwise
	 */
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
	
	/**
	 * <p>Attaches the appropriate suffix for the given voice. It takes vocalicy and vowel harmony in account.</p>
	 * @param conjugatedVerb A conjugated form of the verb as a Term instance
	 * @param voice The given voice
	 * @return A modified version of the conjugated term for the given voice
	 */
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