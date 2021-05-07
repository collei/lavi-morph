package br.net.heaven.lavi.morphology.test.helpers;

import br.net.heaven.lavi.morphology.core.Verb;

public class VerbTestListBuilder {
	
	public static VerbTestList build(Verb verb) {
		return new VerbTestList(verb);
	}
	
}
