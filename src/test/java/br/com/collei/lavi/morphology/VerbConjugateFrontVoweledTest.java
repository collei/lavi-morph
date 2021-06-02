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

public class VerbConjugateFrontVoweledTest {
	
	private static final String verb = "eda";
	
	@Test
	@DisplayName("Verbo " + verb + ": Tabela conjugação na voz ativa")
	public void testaFactualActive() {
		VerbTestList active = VerbTestListBuilder.build(new Verb(verb))
				.setMode(EnumVerbModes.FACTUAL)
				.setVoice(EnumVerbVoices.ACTIVE)
					.setTense(EnumVerbTenses.IMPERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("eju", EnumVerbPersons.I)
							.add("ejš", EnumVerbPersons.YOU)
							.add("ej", EnumVerbPersons.HE_SHE_IT)
							.add("ejme", EnumVerbPersons.WE)
							.add("ejte", EnumVerbPersons.YOU_PLURAL)
							.add("ejech", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("ejem", EnumVerbPersons.I)
							.add("ejed", EnumVerbPersons.YOU)
							.add("eje", EnumVerbPersons.HE_SHE_IT)
							.add("ejenu", EnumVerbPersons.WE)
							.add("ejitek", EnumVerbPersons.YOU_PLURAL)
							.add("ejuk", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("etu", EnumVerbPersons.I)
							.add("etiš", EnumVerbPersons.YOU)
							.add("ete", EnumVerbPersons.HE_SHE_IT)
							.add("etime", EnumVerbPersons.WE)
							.add("etite", EnumVerbPersons.YOU_PLURAL)
							.add("etech", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("etem", EnumVerbPersons.I)
							.add("eted", EnumVerbPersons.YOU)
							.add("etje", EnumVerbPersons.HE_SHE_IT)
							.add("etenu", EnumVerbPersons.WE)
							.add("etitek", EnumVerbPersons.YOU_PLURAL)
							.add("etjuk", EnumVerbPersons.THEY);
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
							.add("ejuri", EnumVerbPersons.I)
							.add("ejši", EnumVerbPersons.YOU)
							.add("eji", EnumVerbPersons.HE_SHE_IT)
							.add("ejmeri", EnumVerbPersons.WE)
							.add("ejteri", EnumVerbPersons.YOU_PLURAL)
							.add("ejechi", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("ejemi", EnumVerbPersons.I)
							.add("ejedi", EnumVerbPersons.YOU)
							.add("ejeri", EnumVerbPersons.HE_SHE_IT)
							.add("ejenuri", EnumVerbPersons.WE)
							.add("ejiteki", EnumVerbPersons.YOU_PLURAL)
							.add("ejuki", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("eturi", EnumVerbPersons.I)
							.add("etiši", EnumVerbPersons.YOU)
							.add("eteri", EnumVerbPersons.HE_SHE_IT)
							.add("etimeri", EnumVerbPersons.WE)
							.add("etiteri", EnumVerbPersons.YOU_PLURAL)
							.add("etechi", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("etemi", EnumVerbPersons.I)
							.add("etedi", EnumVerbPersons.YOU)
							.add("etjeri", EnumVerbPersons.HE_SHE_IT)
							.add("etenuri", EnumVerbPersons.WE)
							.add("etiteki", EnumVerbPersons.YOU_PLURAL)
							.add("etjuki", EnumVerbPersons.THEY);
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
							.add("ejurer", EnumVerbPersons.I)
							.add("ejšer", EnumVerbPersons.YOU)
							.add("ejer", EnumVerbPersons.HE_SHE_IT)
							.add("ejmerer", EnumVerbPersons.WE)
							.add("ejterer", EnumVerbPersons.YOU_PLURAL)
							.add("ejecher", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("ejemer", EnumVerbPersons.I)
							.add("ejeder", EnumVerbPersons.YOU)
							.add("ejerer", EnumVerbPersons.HE_SHE_IT)
							.add("ejenurer", EnumVerbPersons.WE)
							.add("ejiteker", EnumVerbPersons.YOU_PLURAL)
							.add("ejuker", EnumVerbPersons.THEY)
					.setTense(EnumVerbTenses.PERFECT)
						.setDefiniteness(EnumVerbDefiniteness.INDEFINITE)
							.add("eturer", EnumVerbPersons.I)
							.add("etišer", EnumVerbPersons.YOU)
							.add("eterer", EnumVerbPersons.HE_SHE_IT)
							.add("etimerer", EnumVerbPersons.WE)
							.add("etiterer", EnumVerbPersons.YOU_PLURAL)
							.add("etecher", EnumVerbPersons.THEY)
						.setDefiniteness(EnumVerbDefiniteness.DEFINITE)
							.add("etemer", EnumVerbPersons.I)
							.add("eteder", EnumVerbPersons.YOU)
							.add("etjerer", EnumVerbPersons.HE_SHE_IT)
							.add("etenurer", EnumVerbPersons.WE)
							.add("etiteker", EnumVerbPersons.YOU_PLURAL)
							.add("etjuker", EnumVerbPersons.THEY);
		//
		for (VerbTestItem item : medial.asList()) {
			assertEquals(item.getConjugated().get(), item.conjugate().get());
		}
	}
	
	
}
