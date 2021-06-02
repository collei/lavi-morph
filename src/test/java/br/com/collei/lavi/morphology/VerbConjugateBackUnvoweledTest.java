package br.com.collei.lavi.morphology;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.enums.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.enums.EnumVerbModes;
import br.com.collei.lavi.morphology.enums.EnumVerbPersons;
import br.com.collei.lavi.morphology.enums.EnumVerbTenses;
import br.com.collei.lavi.morphology.enums.EnumVerbVoices;
import br.com.collei.lavi.morphology.enums.core.Verb;
import br.com.collei.lavi.morphology.test.helpers.VerbTestItem;
import br.com.collei.lavi.morphology.test.helpers.VerbTestList;
import br.com.collei.lavi.morphology.test.helpers.VerbTestListBuilder;

public class VerbConjugateBackUnvoweledTest {
	
	private static final String verb = "obda";
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na voz ativa")
	public void testaFactualActive() {
		VerbTestList active = VerbTestListBuilder.build(new Verb(verb))
				.setMode(EnumVerbModes.FACTUAL)
				.setVoice(EnumVerbVoices.ACTIVE)
					.setTense(EnumVerbTenses.IMPERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("obu", EnumVerbPersons.I)
							.add("obiš", EnumVerbPersons.YOU)
							.add("obe", EnumVerbPersons.HE_SHE_IT)
							.add("obime", EnumVerbPersons.WE)
							.add("obite", EnumVerbPersons.YOU_PLURAL)
							.add("obech", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("objom", EnumVerbPersons.I)
							.add("objod", EnumVerbPersons.YOU)
							.add("obja", EnumVerbPersons.HE_SHE_IT)
							.add("objonu", EnumVerbPersons.WE)
							.add("objotok", EnumVerbPersons.YOU_PLURAL)
							.add("objuk", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("obtu", EnumVerbPersons.I)
							.add("obtiš", EnumVerbPersons.YOU)
							.add("obte", EnumVerbPersons.HE_SHE_IT)
							.add("obtime", EnumVerbPersons.WE)
							.add("obtite", EnumVerbPersons.YOU_PLURAL)
							.add("obtech", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("obtom", EnumVerbPersons.I)
							.add("obtod", EnumVerbPersons.YOU)
							.add("obtja", EnumVerbPersons.HE_SHE_IT)
							.add("obtonu", EnumVerbPersons.WE)
							.add("obtotok", EnumVerbPersons.YOU_PLURAL)
							.add("obtjuk", EnumVerbPersons.THEY);
		//
		for (VerbTestItem item : active.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na Voz Passiva")
	public void testaFactualPassive() {
		VerbTestList passive = VerbTestListBuilder.build(new Verb(verb))
				.setMode(EnumVerbModes.FACTUAL)
				.setVoice(EnumVerbVoices.PASSIVE)
					.setTense(EnumVerbTenses.IMPERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("oburi", EnumVerbPersons.I)
							.add("obiši", EnumVerbPersons.YOU)
							.add("oberi", EnumVerbPersons.HE_SHE_IT)
							.add("obimeri", EnumVerbPersons.WE)
							.add("obiteri", EnumVerbPersons.YOU_PLURAL)
							.add("obechi", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("objomi", EnumVerbPersons.I)
							.add("objodi", EnumVerbPersons.YOU)
							.add("objari", EnumVerbPersons.HE_SHE_IT)
							.add("objonuri", EnumVerbPersons.WE)
							.add("objotoki", EnumVerbPersons.YOU_PLURAL)
							.add("objuki", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("obturi", EnumVerbPersons.I)
							.add("obtiši", EnumVerbPersons.YOU)
							.add("obteri", EnumVerbPersons.HE_SHE_IT)
							.add("obtimeri", EnumVerbPersons.WE)
							.add("obtiteri", EnumVerbPersons.YOU_PLURAL)
							.add("obtechi", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("obtomi", EnumVerbPersons.I)
							.add("obtodi", EnumVerbPersons.YOU)
							.add("obtjari", EnumVerbPersons.HE_SHE_IT)
							.add("obtonuri", EnumVerbPersons.WE)
							.add("obtotoki", EnumVerbPersons.YOU_PLURAL)
							.add("obtjuki", EnumVerbPersons.THEY);
		//
		for (VerbTestItem item : passive.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na Voz Média")
	public void testaFactualMedial() {
		VerbTestList medial = VerbTestListBuilder.build(new Verb(verb))
				.setMode(EnumVerbModes.FACTUAL)
				.setVoice(EnumVerbVoices.MEDIAL)
					.setTense(EnumVerbTenses.IMPERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("oburor", EnumVerbPersons.I)
							.add("obišor", EnumVerbPersons.YOU)
							.add("oberor", EnumVerbPersons.HE_SHE_IT)
							.add("obimeror", EnumVerbPersons.WE)
							.add("obiteror", EnumVerbPersons.YOU_PLURAL)
							.add("obechor", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("objomor", EnumVerbPersons.I)
							.add("objodor", EnumVerbPersons.YOU)
							.add("objaror", EnumVerbPersons.HE_SHE_IT)
							.add("objonuror", EnumVerbPersons.WE)
							.add("objotokor", EnumVerbPersons.YOU_PLURAL)
							.add("objukor", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("obturor", EnumVerbPersons.I)
							.add("obtišor", EnumVerbPersons.YOU)
							.add("obteror", EnumVerbPersons.HE_SHE_IT)
							.add("obtimeror", EnumVerbPersons.WE)
							.add("obtiteror", EnumVerbPersons.YOU_PLURAL)
							.add("obtechor", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("obtomor", EnumVerbPersons.I)
							.add("obtodor", EnumVerbPersons.YOU)
							.add("obtjaror", EnumVerbPersons.HE_SHE_IT)
							.add("obtonuror", EnumVerbPersons.WE)
							.add("obtotokor", EnumVerbPersons.YOU_PLURAL)
							.add("obtjukor", EnumVerbPersons.THEY);
		//
		for (VerbTestItem item : medial.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	
}
