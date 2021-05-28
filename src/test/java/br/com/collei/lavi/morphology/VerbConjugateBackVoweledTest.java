package br.com.collei.lavi.morphology;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.EnumVerbModes;
import br.com.collei.lavi.morphology.EnumVerbPersons;
import br.com.collei.lavi.morphology.EnumVerbTenses;
import br.com.collei.lavi.morphology.EnumVerbVoices;
import br.com.collei.lavi.morphology.core.Verb;
import br.com.collei.lavi.morphology.test.helpers.VerbTestItem;
import br.com.collei.lavi.morphology.test.helpers.VerbTestList;
import br.com.collei.lavi.morphology.test.helpers.VerbTestListBuilder;

public class VerbConjugateBackVoweledTest {
	
	private static final String verb = "soda";
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na voz ativa")
	public void testaFactualActive() {
		VerbTestList active = VerbTestListBuilder.build(new Verb(verb))
				.setMode(EnumVerbModes.FACTUAL)
				.setVoice(EnumVerbVoices.ACTIVE)
					.setTense(EnumVerbTenses.IMPERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("soju", EnumVerbPersons.I)
							.add("sojš", EnumVerbPersons.YOU)
							.add("soj", EnumVerbPersons.HE_SHE_IT)
							.add("sojme", EnumVerbPersons.WE)
							.add("sojte", EnumVerbPersons.YOU_PLURAL)
							.add("sojech", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("sojom", EnumVerbPersons.I)
							.add("sojod", EnumVerbPersons.YOU)
							.add("soja", EnumVerbPersons.HE_SHE_IT)
							.add("sojonu", EnumVerbPersons.WE)
							.add("sojotok", EnumVerbPersons.YOU_PLURAL)
							.add("sojuk", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("sotu", EnumVerbPersons.I)
							.add("sotiš", EnumVerbPersons.YOU)
							.add("sote", EnumVerbPersons.HE_SHE_IT)
							.add("sotime", EnumVerbPersons.WE)
							.add("sotite", EnumVerbPersons.YOU_PLURAL)
							.add("sotech", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("sotom", EnumVerbPersons.I)
							.add("sotod", EnumVerbPersons.YOU)
							.add("sotja", EnumVerbPersons.HE_SHE_IT)
							.add("sotonu", EnumVerbPersons.WE)
							.add("sototok", EnumVerbPersons.YOU_PLURAL)
							.add("sotjuk", EnumVerbPersons.THEY);
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
							.add("sojuri", EnumVerbPersons.I)
							.add("sojši", EnumVerbPersons.YOU)
							.add("soji", EnumVerbPersons.HE_SHE_IT)
							.add("sojmeri", EnumVerbPersons.WE)
							.add("sojteri", EnumVerbPersons.YOU_PLURAL)
							.add("sojechi", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("sojomi", EnumVerbPersons.I)
							.add("sojodi", EnumVerbPersons.YOU)
							.add("sojari", EnumVerbPersons.HE_SHE_IT)
							.add("sojonuri", EnumVerbPersons.WE)
							.add("sojotoki", EnumVerbPersons.YOU_PLURAL)
							.add("sojuki", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("soturi", EnumVerbPersons.I)
							.add("sotiši", EnumVerbPersons.YOU)
							.add("soteri", EnumVerbPersons.HE_SHE_IT)
							.add("sotimeri", EnumVerbPersons.WE)
							.add("sotiteri", EnumVerbPersons.YOU_PLURAL)
							.add("sotechi", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("sotomi", EnumVerbPersons.I)
							.add("sotodi", EnumVerbPersons.YOU)
							.add("sotjari", EnumVerbPersons.HE_SHE_IT)
							.add("sotonuri", EnumVerbPersons.WE)
							.add("sototoki", EnumVerbPersons.YOU_PLURAL)
							.add("sotjuki", EnumVerbPersons.THEY);
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
							.add("sojuror", EnumVerbPersons.I)
							.add("sojšor", EnumVerbPersons.YOU)
							.add("sojor", EnumVerbPersons.HE_SHE_IT)
							.add("sojmeror", EnumVerbPersons.WE)
							.add("sojteror", EnumVerbPersons.YOU_PLURAL)
							.add("sojechor", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("sojomor", EnumVerbPersons.I)
							.add("sojodor", EnumVerbPersons.YOU)
							.add("sojaror", EnumVerbPersons.HE_SHE_IT)
							.add("sojonuror", EnumVerbPersons.WE)
							.add("sojotokor", EnumVerbPersons.YOU_PLURAL)
							.add("sojukor", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("soturor", EnumVerbPersons.I)
							.add("sotišor", EnumVerbPersons.YOU)
							.add("soteror", EnumVerbPersons.HE_SHE_IT)
							.add("sotimeror", EnumVerbPersons.WE)
							.add("sotiteror", EnumVerbPersons.YOU_PLURAL)
							.add("sotechor", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("sotomor", EnumVerbPersons.I)
							.add("sotodor", EnumVerbPersons.YOU)
							.add("sotjaror", EnumVerbPersons.HE_SHE_IT)
							.add("sotonuror", EnumVerbPersons.WE)
							.add("sototokor", EnumVerbPersons.YOU_PLURAL)
							.add("sotjukor", EnumVerbPersons.THEY);
		//
		for (VerbTestItem item : medial.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	
}
