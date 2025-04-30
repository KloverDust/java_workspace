package it.prova.lambda.secondo;

import java.util.List;

import it.prova.lambda.Persona;

public class SecondoTest {

	public static void main(String[] args) {

		System.out.println("UOMINI....");
		ICriterio<Persona> criterioPerSoliUomini = new ICriterio<Persona>() {
			@Override
			public boolean test(Persona t) {
				return t.getSesso() != null && t.getSesso().equals("M");
			}
		};
		List<Persona> uomini = FiltroPerPersone_2.personeFiltratePer(Persona.list(),criterioPerSoliUomini );
		stampa(uomini);
		
		
		

		System.out.println("DONNE....");
		List<Persona> donne = FiltroPerPersone_2.personeFiltratePer(Persona.list(), new ICriterio<Persona>() {
			@Override
			public boolean test(Persona t) {
				return t.getSesso() != null && t.getSesso().equals("F");
			}
		});
		stampa(donne);

		System.out.println("MAGGIORENNI....");
		List<Persona> maggiorenni = FiltroPerPersone_2.personeFiltratePer(Persona.list(), new ICriterio<Persona>() {
			@Override
			public boolean test(Persona t) {
				return t.getEta() >= 18;
			}
		});
		stampa(maggiorenni);

		System.out.println("NOME CHE INIZIA PER A....");
		List<Persona> listaConIniziale = FiltroPerPersone_2.personeFiltratePer(Persona.list(),
				new ICriterio<Persona>() {
					@Override
					public boolean test(Persona t) {
						//decido QUI!!! l'iniziale con cui ricercare!!! Il metodo resta uno e ad alto livello
						return t.getNome() != null && t.getNome().startsWith("A");
					}
				});
		stampa(listaConIniziale);

		// ###############################################################################################################
		// CIOE' DO' IN INGRESSO L'IMPLEMENTAZIONE DESIDERATA COME SE FOSSE A
		// RUNTIME. IL CRITERIO LO DECIDO ALL'OCCORRENZA
		// ###############################################################################################################
	}

	private static void stampa(List<Persona> input) {
		for (Persona personaItem : input) {
			System.out.println(personaItem);
		}
	}

}
