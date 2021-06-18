package br.com.collei.lavi.morphology;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.collei.lavi.morphology.enums.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.enums.EnumVerbModes;
import br.com.collei.lavi.morphology.enums.EnumVerbPersons;
import br.com.collei.lavi.morphology.enums.EnumVerbTenses;
import br.com.collei.lavi.morphology.enums.EnumVerbVoices;
import br.com.collei.lavi.morphology.test.helpers.VerbTestItem;
import br.com.collei.lavi.morphology.test.helpers.VerbTestList;
import br.com.collei.lavi.morphology.test.helpers.VerbTestListBuilder;

public class VerbConjugateFrontUnvoweledTest {
	
	private static final String verb = "čepda";
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na voz ativa")
	public void testaFactualActive() {
		VerbTestList active = VerbTestListBuilder.build(new Verb(verb))
				.setMode(EnumVerbModes.FACTUAL)
				.setVoice(EnumVerbVoices.ACTIVE)
					.setTense(EnumVerbTenses.IMPERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("čepu", EnumVerbPersons.I)
							.add("čepiš", EnumVerbPersons.YOU)
							.add("čepe", EnumVerbPersons.HE_SHE_IT)
							.add("čepime", EnumVerbPersons.WE)
							.add("čepite", EnumVerbPersons.YOU_PLURAL)
							.add("čepech", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("čepjem", EnumVerbPersons.I)
							.add("čepjed", EnumVerbPersons.YOU)
							.add("čepje", EnumVerbPersons.HE_SHE_IT)
							.add("čepjenu", EnumVerbPersons.WE)
							.add("čepjitek", EnumVerbPersons.YOU_PLURAL)
							.add("čepjuk", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("čeptu", EnumVerbPersons.I)
							.add("čeptiš", EnumVerbPersons.YOU)
							.add("čepte", EnumVerbPersons.HE_SHE_IT)
							.add("čeptime", EnumVerbPersons.WE)
							.add("čeptite", EnumVerbPersons.YOU_PLURAL)
							.add("čeptech", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("čeptem", EnumVerbPersons.I)
							.add("čepted", EnumVerbPersons.YOU)
							.add("čeptje", EnumVerbPersons.HE_SHE_IT)
							.add("čeptenu", EnumVerbPersons.WE)
							.add("čeptitek", EnumVerbPersons.YOU_PLURAL)
							.add("čeptjuk", EnumVerbPersons.THEY);
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
							.add("čepuri", EnumVerbPersons.I)
							.add("čepiši", EnumVerbPersons.YOU)
							.add("čeperi", EnumVerbPersons.HE_SHE_IT)
							.add("čepimeri", EnumVerbPersons.WE)
							.add("čepiteri", EnumVerbPersons.YOU_PLURAL)
							.add("čepechi", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("čepjemi", EnumVerbPersons.I)
							.add("čepjedi", EnumVerbPersons.YOU)
							.add("čepjeri", EnumVerbPersons.HE_SHE_IT)
							.add("čepjenuri", EnumVerbPersons.WE)
							.add("čepjiteki", EnumVerbPersons.YOU_PLURAL)
							.add("čepjuki", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("čepturi", EnumVerbPersons.I)
							.add("čeptiši", EnumVerbPersons.YOU)
							.add("čepteri", EnumVerbPersons.HE_SHE_IT)
							.add("čeptimeri", EnumVerbPersons.WE)
							.add("čeptiteri", EnumVerbPersons.YOU_PLURAL)
							.add("čeptechi", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("čeptemi", EnumVerbPersons.I)
							.add("čeptedi", EnumVerbPersons.YOU)
							.add("čeptjeri", EnumVerbPersons.HE_SHE_IT)
							.add("čeptenuri", EnumVerbPersons.WE)
							.add("čeptiteki", EnumVerbPersons.YOU_PLURAL)
							.add("čeptjuki", EnumVerbPersons.THEY);
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
							.add("čepurer", EnumVerbPersons.I)
							.add("čepišer", EnumVerbPersons.YOU)
							.add("čeperer", EnumVerbPersons.HE_SHE_IT)
							.add("čepimerer", EnumVerbPersons.WE)
							.add("čepiterer", EnumVerbPersons.YOU_PLURAL)
							.add("čepecher", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("čepjemer", EnumVerbPersons.I)
							.add("čepjeder", EnumVerbPersons.YOU)
							.add("čepjerer", EnumVerbPersons.HE_SHE_IT)
							.add("čepjenurer", EnumVerbPersons.WE)
							.add("čepjiteker", EnumVerbPersons.YOU_PLURAL)
							.add("čepjuker", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("čepturer", EnumVerbPersons.I)
							.add("čeptišer", EnumVerbPersons.YOU)
							.add("čepterer", EnumVerbPersons.HE_SHE_IT)
							.add("čeptimerer", EnumVerbPersons.WE)
							.add("čeptiterer", EnumVerbPersons.YOU_PLURAL)
							.add("čeptecher", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("čeptemer", EnumVerbPersons.I)
							.add("čepteder", EnumVerbPersons.YOU)
							.add("čeptjerer", EnumVerbPersons.HE_SHE_IT)
							.add("čeptenurer", EnumVerbPersons.WE)
							.add("čeptiteker", EnumVerbPersons.YOU_PLURAL)
							.add("čeptjuker", EnumVerbPersons.THEY);
		//
		for (VerbTestItem item : medial.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	
}
