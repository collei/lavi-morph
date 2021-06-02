package br.com.collei.lavi.morphology.test.helpers;

import java.util.ArrayList;
import java.util.List;

import br.com.collei.lavi.morphology.enums.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.enums.EnumVerbModes;
import br.com.collei.lavi.morphology.enums.EnumVerbPersons;
import br.com.collei.lavi.morphology.enums.EnumVerbTenses;
import br.com.collei.lavi.morphology.enums.EnumVerbVoices;
import br.com.collei.lavi.morphology.enums.core.Term;
import br.com.collei.lavi.morphology.enums.core.Verb;

public class VerbTestList {
	
	private EnumVerbTenses tense; 
	private EnumVerbVoices voice; 
	private EnumVerbModes mode; 
	private EnumVerbDefiniteness definiteness;

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

	public VerbTestList setTense(EnumVerbTenses tense) {
		this.tense = tense;
		return this;
	}

	public VerbTestList setVoice(EnumVerbVoices voice) {
		this.voice = voice;
		return this;
	}

	public VerbTestList setMode(EnumVerbModes mode) {
		this.mode = mode;
		return this;
	}

	public VerbTestList setDefiniteness(EnumVerbDefiniteness definiteness) {
		this.definiteness = definiteness;
		return this;
	}
	
	public VerbTestList add(String conjugatedForm, EnumVerbPersons person) {
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
