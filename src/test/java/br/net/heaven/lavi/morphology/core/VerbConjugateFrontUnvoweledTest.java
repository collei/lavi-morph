package br.net.heaven.lavi.morphology.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.net.heaven.lavi.morphology.enums.VerbDefinitenessEnum;
import br.net.heaven.lavi.morphology.enums.VerbModesEnum;
import br.net.heaven.lavi.morphology.enums.VerbPersonsEnum;
import br.net.heaven.lavi.morphology.enums.VerbTensesEnum;
import br.net.heaven.lavi.morphology.enums.VerbVoicesEnum;
import br.net.heaven.lavi.morphology.test.helpers.VerbTestItem;
import br.net.heaven.lavi.morphology.test.helpers.VerbTestList;
import br.net.heaven.lavi.morphology.test.helpers.VerbTestListBuilder;

public class VerbConjugateFrontUnvoweledTest {
	
	private static final String verb = "čepda";
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na voz ativa")
	public void testaFactualActive() {
		VerbTestList active = VerbTestListBuilder.build(new Verb(verb))
				.setMode(VerbModesEnum.FACTUAL)
				.setVoice(VerbVoicesEnum.ACTIVE)
					.setTense(VerbTensesEnum.IMPERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("čepu", VerbPersonsEnum.I)
							.add("čepiš", VerbPersonsEnum.YOU)
							.add("čepe", VerbPersonsEnum.HE_SHE_IT)
							.add("čepime", VerbPersonsEnum.WE)
							.add("čepite", VerbPersonsEnum.YOU_PLURAL)
							.add("čepech", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("čepjem", VerbPersonsEnum.I)
							.add("čepjed", VerbPersonsEnum.YOU)
							.add("čepje", VerbPersonsEnum.HE_SHE_IT)
							.add("čepjenu", VerbPersonsEnum.WE)
							.add("čepjitek", VerbPersonsEnum.YOU_PLURAL)
							.add("čepjuk", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("čeptu", VerbPersonsEnum.I)
							.add("čeptiš", VerbPersonsEnum.YOU)
							.add("čepte", VerbPersonsEnum.HE_SHE_IT)
							.add("čeptime", VerbPersonsEnum.WE)
							.add("čeptite", VerbPersonsEnum.YOU_PLURAL)
							.add("čeptech", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("čeptem", VerbPersonsEnum.I)
							.add("čepted", VerbPersonsEnum.YOU)
							.add("čeptje", VerbPersonsEnum.HE_SHE_IT)
							.add("čeptenu", VerbPersonsEnum.WE)
							.add("čeptitek", VerbPersonsEnum.YOU_PLURAL)
							.add("čeptjuk", VerbPersonsEnum.THEY);
		//
		for (VerbTestItem item : active.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na Voz Passiva")
	public void testaFactualPassive() {
		VerbTestList passive = VerbTestListBuilder.build(new Verb(verb))
				.setMode(VerbModesEnum.FACTUAL)
				.setVoice(VerbVoicesEnum.PASSIVE)
					.setTense(VerbTensesEnum.IMPERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("čepuri", VerbPersonsEnum.I)
							.add("čepiši", VerbPersonsEnum.YOU)
							.add("čeperi", VerbPersonsEnum.HE_SHE_IT)
							.add("čepimeri", VerbPersonsEnum.WE)
							.add("čepiteri", VerbPersonsEnum.YOU_PLURAL)
							.add("čepechi", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("čepjemi", VerbPersonsEnum.I)
							.add("čepjedi", VerbPersonsEnum.YOU)
							.add("čepjeri", VerbPersonsEnum.HE_SHE_IT)
							.add("čepjenuri", VerbPersonsEnum.WE)
							.add("čepjiteki", VerbPersonsEnum.YOU_PLURAL)
							.add("čepjuki", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("čepturi", VerbPersonsEnum.I)
							.add("čeptiši", VerbPersonsEnum.YOU)
							.add("čepteri", VerbPersonsEnum.HE_SHE_IT)
							.add("čeptimeri", VerbPersonsEnum.WE)
							.add("čeptiteri", VerbPersonsEnum.YOU_PLURAL)
							.add("čeptechi", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("čeptemi", VerbPersonsEnum.I)
							.add("čeptedi", VerbPersonsEnum.YOU)
							.add("čeptjeri", VerbPersonsEnum.HE_SHE_IT)
							.add("čeptenuri", VerbPersonsEnum.WE)
							.add("čeptiteki", VerbPersonsEnum.YOU_PLURAL)
							.add("čeptjuki", VerbPersonsEnum.THEY);
		//
		for (VerbTestItem item : passive.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na Voz Média")
	public void testaFactualMedial() {
		VerbTestList medial = VerbTestListBuilder.build(new Verb(verb))
				.setMode(VerbModesEnum.FACTUAL)
				.setVoice(VerbVoicesEnum.MEDIAL)
					.setTense(VerbTensesEnum.IMPERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("čepurer", VerbPersonsEnum.I)
							.add("čepišer", VerbPersonsEnum.YOU)
							.add("čeperer", VerbPersonsEnum.HE_SHE_IT)
							.add("čepimerer", VerbPersonsEnum.WE)
							.add("čepiterer", VerbPersonsEnum.YOU_PLURAL)
							.add("čepecher", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("čepjemer", VerbPersonsEnum.I)
							.add("čepjeder", VerbPersonsEnum.YOU)
							.add("čepjerer", VerbPersonsEnum.HE_SHE_IT)
							.add("čepjenurer", VerbPersonsEnum.WE)
							.add("čepjiteker", VerbPersonsEnum.YOU_PLURAL)
							.add("čepjuker", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("čepturer", VerbPersonsEnum.I)
							.add("čeptišer", VerbPersonsEnum.YOU)
							.add("čepterer", VerbPersonsEnum.HE_SHE_IT)
							.add("čeptimerer", VerbPersonsEnum.WE)
							.add("čeptiterer", VerbPersonsEnum.YOU_PLURAL)
							.add("čeptecher", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("čeptemer", VerbPersonsEnum.I)
							.add("čepteder", VerbPersonsEnum.YOU)
							.add("čeptjerer", VerbPersonsEnum.HE_SHE_IT)
							.add("čeptenurer", VerbPersonsEnum.WE)
							.add("čeptiteker", VerbPersonsEnum.YOU_PLURAL)
							.add("čeptjuker", VerbPersonsEnum.THEY);
		//
		for (VerbTestItem item : medial.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	
}
