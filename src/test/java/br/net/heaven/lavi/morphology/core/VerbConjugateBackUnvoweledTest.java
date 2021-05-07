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

public class VerbConjugateBackUnvoweledTest {
	
	private static final String verb = "obda";
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na voz ativa")
	public void testaFactualActive() {
		VerbTestList active = VerbTestListBuilder.build(new Verb(verb))
				.setMode(VerbModesEnum.FACTUAL)
				.setVoice(VerbVoicesEnum.ACTIVE)
					.setTense(VerbTensesEnum.IMPERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("obu", VerbPersonsEnum.I)
							.add("obiš", VerbPersonsEnum.YOU)
							.add("obe", VerbPersonsEnum.HE_SHE_IT)
							.add("obime", VerbPersonsEnum.WE)
							.add("obite", VerbPersonsEnum.YOU_PLURAL)
							.add("obech", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("objom", VerbPersonsEnum.I)
							.add("objod", VerbPersonsEnum.YOU)
							.add("obja", VerbPersonsEnum.HE_SHE_IT)
							.add("objonu", VerbPersonsEnum.WE)
							.add("objotok", VerbPersonsEnum.YOU_PLURAL)
							.add("objuk", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("obtu", VerbPersonsEnum.I)
							.add("obtiš", VerbPersonsEnum.YOU)
							.add("obte", VerbPersonsEnum.HE_SHE_IT)
							.add("obtime", VerbPersonsEnum.WE)
							.add("obtite", VerbPersonsEnum.YOU_PLURAL)
							.add("obtech", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("obtom", VerbPersonsEnum.I)
							.add("obtod", VerbPersonsEnum.YOU)
							.add("obtja", VerbPersonsEnum.HE_SHE_IT)
							.add("obtonu", VerbPersonsEnum.WE)
							.add("obtotok", VerbPersonsEnum.YOU_PLURAL)
							.add("obtjuk", VerbPersonsEnum.THEY);
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
							.add("oburi", VerbPersonsEnum.I)
							.add("obiši", VerbPersonsEnum.YOU)
							.add("oberi", VerbPersonsEnum.HE_SHE_IT)
							.add("obimeri", VerbPersonsEnum.WE)
							.add("obiteri", VerbPersonsEnum.YOU_PLURAL)
							.add("obechi", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("objomi", VerbPersonsEnum.I)
							.add("objodi", VerbPersonsEnum.YOU)
							.add("objari", VerbPersonsEnum.HE_SHE_IT)
							.add("objonuri", VerbPersonsEnum.WE)
							.add("objotoki", VerbPersonsEnum.YOU_PLURAL)
							.add("objuki", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("obturi", VerbPersonsEnum.I)
							.add("obtiši", VerbPersonsEnum.YOU)
							.add("obteri", VerbPersonsEnum.HE_SHE_IT)
							.add("obtimeri", VerbPersonsEnum.WE)
							.add("obtiteri", VerbPersonsEnum.YOU_PLURAL)
							.add("obtechi", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("obtomi", VerbPersonsEnum.I)
							.add("obtodi", VerbPersonsEnum.YOU)
							.add("obtjari", VerbPersonsEnum.HE_SHE_IT)
							.add("obtonuri", VerbPersonsEnum.WE)
							.add("obtotoki", VerbPersonsEnum.YOU_PLURAL)
							.add("obtjuki", VerbPersonsEnum.THEY);
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
							.add("oburor", VerbPersonsEnum.I)
							.add("obišor", VerbPersonsEnum.YOU)
							.add("oberor", VerbPersonsEnum.HE_SHE_IT)
							.add("obimeror", VerbPersonsEnum.WE)
							.add("obiteror", VerbPersonsEnum.YOU_PLURAL)
							.add("obechor", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("objomor", VerbPersonsEnum.I)
							.add("objodor", VerbPersonsEnum.YOU)
							.add("objaror", VerbPersonsEnum.HE_SHE_IT)
							.add("objonuror", VerbPersonsEnum.WE)
							.add("objotokor", VerbPersonsEnum.YOU_PLURAL)
							.add("objukor", VerbPersonsEnum.THEY)
					.setTense(VerbTensesEnum.PERFECT)
						.setDefiniteness(VerbDefinitenessEnum.INDEFINITE)
							.add("obturor", VerbPersonsEnum.I)
							.add("obtišor", VerbPersonsEnum.YOU)
							.add("obteror", VerbPersonsEnum.HE_SHE_IT)
							.add("obtimeror", VerbPersonsEnum.WE)
							.add("obtiteror", VerbPersonsEnum.YOU_PLURAL)
							.add("obtechor", VerbPersonsEnum.THEY)
						.setDefiniteness(VerbDefinitenessEnum.DEFINITE)
							.add("obtomor", VerbPersonsEnum.I)
							.add("obtodor", VerbPersonsEnum.YOU)
							.add("obtjaror", VerbPersonsEnum.HE_SHE_IT)
							.add("obtonuror", VerbPersonsEnum.WE)
							.add("obtotokor", VerbPersonsEnum.YOU_PLURAL)
							.add("obtjukor", VerbPersonsEnum.THEY);
		//
		for (VerbTestItem item : medial.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	
}
