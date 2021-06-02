package br.com.collei.lavi.morphology.test.helpers;

import br.com.collei.lavi.morphology.enums.core.Verb;

public class VerbTestListBuilder {
	
	public static VerbTestList build(Verb verb) {
		return new VerbTestList(verb);
	}
	
}
