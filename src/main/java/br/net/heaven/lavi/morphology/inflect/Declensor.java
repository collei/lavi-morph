package br.net.heaven.lavi.morphology.inflect;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.enums.EnumHarmony;
import br.net.heaven.lavi.morphology.enums.EnumNounCases;
import br.net.heaven.lavi.morphology.enums.EnumNounPluralities;
import br.net.heaven.lavi.morphology.enums.EnumNounPersons;

public class Declensor {

	public static String makeDeclension(Term term, EnumNounPersons person, EnumNounCases nounCase, EnumNounPluralities plurality) {
		String possessive = makePossessive(term, person, plurality);
		Term possesiveTerm = new Term(possessive);
		Term possessiveDeclensed = new Term(makeDeclension(possesiveTerm, nounCase, EnumNounPluralities.SINGULAR));
		return possessiveDeclensed.get();
	}
	
	public static String makeDeclension(Term term, EnumNounCases nounCase, EnumNounPluralities plurality) {
		String affix = "";
		//
		if (plurality == EnumNounPluralities.SINGULAR) {
			if (term.getHarmony() == EnumHarmony.BACK) {
				if (term.isVocalic()) {
					affix = chooseCase(nounCase, "", "t", "n", "nak", "kar", "ni", "ve", "no", "le", "to");
				} else if (term.endsWith("r","s","š","n","t")) {
					affix = chooseCase(nounCase, "", "t", "en", "nak", "kar", "ni", "ve", "no", "le", "to");
				} else {
					affix = chooseCase(nounCase, "", "ot", "en", "nak", "kar", "ni", "ve", "no", "le", "to");
				}
			} else {
				if (term.isVocalic()) {
					affix = chooseCase(nounCase, "", "t", "n", "nek", "ker", "ni", "ve", "no", "le", "to");
				} else if (term.endsWith("r","s","š","n","t")) {
					affix = chooseCase(nounCase, "", "t", "en", "nek", "ker", "ni", "ve", "no", "le", "to");
				} else {
					affix = chooseCase(nounCase, "", "et", "en", "nek", "ker", "ni", "ve", "no", "le", "to");
				}
			}
		} else if (plurality == EnumNounPluralities.DUAL) {
			if (term.getHarmony() == EnumHarmony.BACK) {
				affix = chooseCase(nounCase, "lar", "lart", "laren", "larnak", "larkar", "larni", "larve", "larno", "larle", "larto");
			} else {
				affix = chooseCase(nounCase, "ler", "lert", "leren", "lernek", "lerker", "lerni", "lerve", "lerno", "lerle", "lerto");
			}
		} else if (plurality == EnumNounPluralities.PLURAL) {
			if (term.getHarmony() == EnumHarmony.BACK) {
				if (term.isVocalic()) {
					affix = chooseCase(nounCase, "k", "tok", "nim", "nakim", "karim", "kni", "kve", "kno", "kle", "kto");
				} else {
					affix = chooseCase(nounCase, "ok", "otok", "enim", "nakim", "karim", "okni", "okve", "okno", "okle", "okto");
				}
			} else {
				if (term.isVocalic()) {
					affix = chooseCase(nounCase, "k", "tek", "nim", "nekim", "kerim", "kni", "kve", "kno", "kle", "kto");
				} else {
					affix = chooseCase(nounCase, "ek", "etek", "enim", "nekim", "kerim", "ekni", "ekve", "ekno", "ekle", "ekto");
				}
			}
		}
		//
		return term.get() + affix;
	}
	
	public static String makePossessive(Term term, EnumNounPersons person, EnumNounPluralities plurality) {
		String affix = "";
		//
		if (plurality == EnumNounPluralities.SINGULAR) {
			if (term.getHarmony() == EnumHarmony.BACK) {
				if (term.isVocalic()) {
					affix = choosePerson(person, "m", "d", "j", "nu", "tok", "juk");
				} else {
					affix = choosePerson(person, "om", "od", "ja", "onu", "otok", "juk");
				}
			} else {
				if (term.isVocalic()) {
					affix = choosePerson(person, "m", "d", "j", "nu", "tek", "juk");
				} else {
					affix = choosePerson(person, "em", "ed", "je", "enu", "itek", "juk");
				}
			}
		} else if (plurality == EnumNounPluralities.DUAL) {
			if (term.getHarmony() == EnumHarmony.BACK) {
				affix = choosePerson(person, "laram", "larad", "larja", "laranu", "lartok", "larjuk");
			} else {
				affix = choosePerson(person, "lerem", "lered", "lerje", "lerenu", "lertek", "lerjuk");
			}
		} else if (plurality == EnumNounPluralities.PLURAL) {
			if (term.getHarmony() == EnumHarmony.BACK) {
				if (term.isVocalic()) {
					affix = choosePerson(person, "im", "id", "ij", "inu", "itok", "ijuk");
				} else {
					affix = choosePerson(person, "oim", "oid", "oija", "oinu", "oitok", "oijuk");
				}
			} else {
				if (term.isVocalic()) {
					affix = choosePerson(person, "im", "id", "ij", "inu", "itek", "ijuk");
				} else {
					affix = choosePerson(person, "eim", "eid", "eije", "einu", "eitek", "eijuk");
				}
			}
		}
		//
		return term.get() + affix;
	}

	/*** for internal use only ***/
	
	private static String choosePerson(EnumNounPersons person, String i, String you, String heSheIt, String we, String youPlural, String they) {
		switch (person) {
		case I:
			return i;
		case YOU:
			return you;
		case HE_SHE_IT:
			return heSheIt;
		case WE:
			return we;
		case YOU_PLURAL:
			return youPlural;
		case THEY:
			return they;
		default:
			return null;
		}
	}
	
	private static String chooseCase(EnumNounCases nounCase, String nominative, String accusative, String genitive, String dative, String ablative, String locative, String instrumental, String partitive, String abessive, String comitative) {
		switch (nounCase) {
			case ACCUSATIVE:
				return accusative;
			case GENITIVE:
				return genitive;
			case DATIVE:
				return dative;
			case ABLATIVE:
				return ablative;
			case LOCATIVE:
				return locative;
			case INSTRUMENTAL:
				return instrumental;
			case PARTITIVE:
				return partitive;
			case ABESSIVE:
				return abessive;
			case COMITATIVE:
				return comitative;
			default:
				return nominative;
		}
	}

}
