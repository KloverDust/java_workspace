package it.prova.lambda.secondo;

import java.util.ArrayList;
import java.util.List;

import it.prova.lambda.Persona;

/*
 * Cosa non va nel codice 'primo'? A voler essere puntigliosi...
 * Ogni metodo ripete un meccanismo di loop.
 * Va scritto un metodo per ogni criterio di ricerca che si vuole implementare
 * Se i criteri di ricerca cambiano, sarebbe necessaria una serie di modifiche un pò in tutto il codice
 * Proviamo ad accorpare un po' con le classi anonime
 */
public class FiltroPerPersone_2 {
	
	public static List<Persona> personeFiltratePer(List<Persona> input, ICriterio<Persona> criterioInInput){
		List<Persona> result = new ArrayList<>();
		
		for (Persona personaItem : input) {
			if(criterioInInput.test(personaItem))
				result.add(personaItem);
		}
		
		return result;
	}

}
