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

public class VerbConjugateFrontVoweledTest {
	
	private static final String verb = "eda";
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na voz ativa")
	public void testaFactualActive() {
		VerbTestList active = VerbTestListBuilder.build(new Verb(verb))
				.setMode(VerbModesEnum.FACTUAL)
				.setVoice(VerbVoicesEnum.ACTIVE)
					.setTense(VerbTensesEnum.IMPERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("eju", VerbPersonsEnum.I)
							.add("ejš", VerbPersonsEnum.YOU)
							.add("ej", VerbPersonsEnum.HE_SHE_IT)
							.add("ejme", VerbPersonsEnum.WE)
							.add("ejte", VerbPersonsEnum.YOU_PLURAL)
							.add("ejech", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("ejem", VerbPersonsEnum.I)
							.add("ejed", VerbPersonsEnum.YOU)
							.add("eje", VerbPersonsEnum.HE_SHE_IT)
							.add("ejenu", VerbPersonsEnum.WE)
							.add("ejitek", VerbPersonsEnum.YOU_PLURAL)
							.add("ejuk", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("etu", VerbPersonsEnum.I)
							.add("etiš", VerbPersonsEnum.YOU)
							.add("ete", VerbPersonsEnum.HE_SHE_IT)
							.add("etime", VerbPersonsEnum.WE)
							.add("etite", VerbPersonsEnum.YOU_PLURAL)
							.add("etech", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("etem", VerbPersonsEnum.I)
							.add("eted", VerbPersonsEnum.YOU)
							.add("etje", VerbPersonsEnum.HE_SHE_IT)
							.add("etenu", VerbPersonsEnum.WE)
							.add("etitek", VerbPersonsEnum.YOU_PLURAL)
							.add("etjuk", VerbPersonsEnum.THEY);
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
							.add("ejuri", VerbPersonsEnum.I)
							.add("ejši", VerbPersonsEnum.YOU)
							.add("eji", VerbPersonsEnum.HE_SHE_IT)
							.add("ejmeri", VerbPersonsEnum.WE)
							.add("ejteri", VerbPersonsEnum.YOU_PLURAL)
							.add("ejechi", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("ejemi", VerbPersonsEnum.I)
							.add("ejedi", VerbPersonsEnum.YOU)
							.add("ejeri", VerbPersonsEnum.HE_SHE_IT)
							.add("ejenuri", VerbPersonsEnum.WE)
							.add("ejiteki", VerbPersonsEnum.YOU_PLURAL)
							.add("ejuki", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("eturi", VerbPersonsEnum.I)
							.add("etiši", VerbPersonsEnum.YOU)
							.add("eteri", VerbPersonsEnum.HE_SHE_IT)
							.add("etimeri", VerbPersonsEnum.WE)
							.add("etiteri", VerbPersonsEnum.YOU_PLURAL)
							.add("etechi", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("etemi", VerbPersonsEnum.I)
							.add("etedi", VerbPersonsEnum.YOU)
							.add("etjeri", VerbPersonsEnum.HE_SHE_IT)
							.add("etenuri", VerbPersonsEnum.WE)
							.add("etiteki", VerbPersonsEnum.YOU_PLURAL)
							.add("etjuki", VerbPersonsEnum.THEY);
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
							.add("ejurer", VerbPersonsEnum.I)
							.add("ejšer", VerbPersonsEnum.YOU)
							.add("ejer", VerbPersonsEnum.HE_SHE_IT)
							.add("ejmerer", VerbPersonsEnum.WE)
							.add("ejterer", VerbPersonsEnum.YOU_PLURAL)
							.add("ejecher", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("ejemer", VerbPersonsEnum.I)
							.add("ejeder", VerbPersonsEnum.YOU)
							.add("ejerer", VerbPersonsEnum.HE_SHE_IT)
							.add("ejenurer", VerbPersonsEnum.WE)
							.add("ejiteker", VerbPersonsEnum.YOU_PLURAL)
							.add("ejuker", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("eturer", VerbPersonsEnum.I)
							.add("etišer", VerbPersonsEnum.YOU)
							.add("eterer", VerbPersonsEnum.HE_SHE_IT)
							.add("etimerer", VerbPersonsEnum.WE)
							.add("etiterer", VerbPersonsEnum.YOU_PLURAL)
							.add("etecher", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("etemer", VerbPersonsEnum.I)
							.add("eteder", VerbPersonsEnum.YOU)
							.add("etjerer", VerbPersonsEnum.HE_SHE_IT)
							.add("etenurer", VerbPersonsEnum.WE)
							.add("etiteker", VerbPersonsEnum.YOU_PLURAL)
							.add("etjuker", VerbPersonsEnum.THEY);
		//
		for (VerbTestItem item : medial.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	
}
