package br.net.heaven.lavi.morphology.test.helpers;

import java.util.ArrayList;
import java.util.List;

import br.net.heaven.lavi.morphology.core.Term;
import br.net.heaven.lavi.morphology.core.Verb;
import br.net.heaven.lavi.morphology.enums.VerbDefinitenessEnum;
import br.net.heaven.lavi.morphology.enums.VerbModesEnum;
import br.net.heaven.lavi.morphology.enums.VerbPersonsEnum;
import br.net.heaven.lavi.morphology.enums.VerbTensesEnum;
import br.net.heaven.lavi.morphology.enums.VerbVoicesEnum;

public class VerbTestList {
	
	private VerbTensesEnum tense; 
	private VerbVoicesEnum voice; 
	private VerbModesEnum mode; 
	private VerbDefinitenessEnum definiteness;

	private Verb verb;
	private List<VerbTestItem> units;
	
	public VerbTestList(Verb verb) {
		if (verb == null) {
			throw new NullPointerException("Verbo não pode ser null");
		}
		
		this.verb = verb;
		this.units = new ArrayList<VerbTestItem>();
	}
	
	/////*/////

	public VerbTestList setTense(VerbTensesEnum tense) {
		this.tense = tense;
		return this;
	}

	public VerbTestList setVoice(VerbVoicesEnum voice) {
		this.voice = voice;
		return this;
	}

	public VerbTestList setMode(VerbModesEnum mode) {
		this.mode = mode;
		return this;
	}

	public VerbTestList setDefiniteness(VerbDefinitenessEnum definiteness) {
		this.definiteness = definiteness;
		return this;
	}
	
	public VerbTestList add(String conjugatedForm, VerbPersonsEnum person) {
		this.units.add(new VerbTestItem(
				this.verb,
				new Term(conjugatedForm),
				person,
				this.tense,
				this.voice,
				this.mode,
				this.definiteness));
		return this;
	}
	
	public List<VerbTestItem> asList() {
		return this.units;
	}
	
	public VerbTestItem itemByIndex(int index) {
		return this.units.get(index);
	}
	
}
