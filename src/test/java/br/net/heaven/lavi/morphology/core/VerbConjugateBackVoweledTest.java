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

public class VerbConjugateBackVoweledTest {
	
	private static final String verb = "soda";
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na voz ativa")
	public void testaFactualActive() {
		VerbTestList active = VerbTestListBuilder.build(new Verb(verb))
				.setMode(VerbModesEnum.FACTUAL)
				.setVoice(VerbVoicesEnum.ACTIVE)
					.setTense(VerbTensesEnum.IMPERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("soju", VerbPersonsEnum.I)
							.add("sojš", VerbPersonsEnum.YOU)
							.add("soj", VerbPersonsEnum.HE_SHE_IT)
							.add("sojme", VerbPersonsEnum.WE)
							.add("sojte", VerbPersonsEnum.YOU_PLURAL)
							.add("sojech", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("sojom", VerbPersonsEnum.I)
							.add("sojod", VerbPersonsEnum.YOU)
							.add("soja", VerbPersonsEnum.HE_SHE_IT)
							.add("sojonu", VerbPersonsEnum.WE)
							.add("sojotok", VerbPersonsEnum.YOU_PLURAL)
							.add("sojuk", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("sotu", VerbPersonsEnum.I)
							.add("sotiš", VerbPersonsEnum.YOU)
							.add("sote", VerbPersonsEnum.HE_SHE_IT)
							.add("sotime", VerbPersonsEnum.WE)
							.add("sotite", VerbPersonsEnum.YOU_PLURAL)
							.add("sotech", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("sotom", VerbPersonsEnum.I)
							.add("sotod", VerbPersonsEnum.YOU)
							.add("sotja", VerbPersonsEnum.HE_SHE_IT)
							.add("sotonu", VerbPersonsEnum.WE)
							.add("sototok", VerbPersonsEnum.YOU_PLURAL)
							.add("sotjuk", VerbPersonsEnum.THEY);
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
							.add("sojuri", VerbPersonsEnum.I)
							.add("sojši", VerbPersonsEnum.YOU)
							.add("soji", VerbPersonsEnum.HE_SHE_IT)
							.add("sojmeri", VerbPersonsEnum.WE)
							.add("sojteri", VerbPersonsEnum.YOU_PLURAL)
							.add("sojechi", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("sojomi", VerbPersonsEnum.I)
							.add("sojodi", VerbPersonsEnum.YOU)
							.add("sojari", VerbPersonsEnum.HE_SHE_IT)
							.add("sojonuri", VerbPersonsEnum.WE)
							.add("sojotoki", VerbPersonsEnum.YOU_PLURAL)
							.add("sojuki", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("soturi", VerbPersonsEnum.I)
							.add("sotiši", VerbPersonsEnum.YOU)
							.add("soteri", VerbPersonsEnum.HE_SHE_IT)
							.add("sotimeri", VerbPersonsEnum.WE)
							.add("sotiteri", VerbPersonsEnum.YOU_PLURAL)
							.add("sotechi", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("sotomi", VerbPersonsEnum.I)
							.add("sotodi", VerbPersonsEnum.YOU)
							.add("sotjari", VerbPersonsEnum.HE_SHE_IT)
							.add("sotonuri", VerbPersonsEnum.WE)
							.add("sototoki", VerbPersonsEnum.YOU_PLURAL)
							.add("sotjuki", VerbPersonsEnum.THEY);
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
							.add("sojuror", VerbPersonsEnum.I)
							.add("sojšor", VerbPersonsEnum.YOU)
							.add("sojor", VerbPersonsEnum.HE_SHE_IT)
							.add("sojmeror", VerbPersonsEnum.WE)
							.add("sojteror", VerbPersonsEnum.YOU_PLURAL)
							.add("sojechor", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("sojomor", VerbPersonsEnum.I)
							.add("sojodor", VerbPersonsEnum.YOU)
							.add("sojaror", VerbPersonsEnum.HE_SHE_IT)
							.add("sojonuror", VerbPersonsEnum.WE)
							.add("sojotokor", VerbPersonsEnum.YOU_PLURAL)
							.add("sojukor", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("soturor", VerbPersonsEnum.I)
							.add("sotišor", VerbPersonsEnum.YOU)
							.add("soteror", VerbPersonsEnum.HE_SHE_IT)
							.add("sotimeror", VerbPersonsEnum.WE)
							.add("sotiteror", VerbPersonsEnum.YOU_PLURAL)
							.add("sotechor", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("sotomor", VerbPersonsEnum.I)
							.add("sotodor", VerbPersonsEnum.YOU)
							.add("sotjaror", VerbPersonsEnum.HE_SHE_IT)
							.add("sotonuror", VerbPersonsEnum.WE)
							.add("sototokor", VerbPersonsEnum.YOU_PLURAL)
							.add("sotjukor", VerbPersonsEnum.THEY);
		//
		for (VerbTestItem item : medial.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	
}
