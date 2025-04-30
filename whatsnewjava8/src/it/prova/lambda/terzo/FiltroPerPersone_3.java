package it.prova.lambda.terzo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import it.prova.lambda.Persona;

/*
 * Sintassi delle LAMBDA EXPRESSION: 
 * espressione che prende in input due interi e restituisce la somma
	(int x, int y) -> x + y
	
	espressione che prende in input una stringa e restituisce la sua lunghezza
	s -> s.length() 
	
	 
 * ICriterio passata al metodo delle classi anonime l'abbiamo scritta noi!
 * Java SE 8 fornisce il package java.util.function che contiene un certo numero di interfacce funzionali standard (es. Predicate<T>, Consumer<T>, Supplier<T>. 
 * Nel nostro caso possiamo sicuramente dire che l’interfaccia Predicate soddisfa le nostre esigenze.
 */
public class FiltroPerPersone_3 {
	public static List<Persona> personeFiltratePer(List<Persona> input, Predicate<Persona> criterioInInput){
		List<Persona> result = new ArrayList<>();
		
		for (Persona personaItem : input) {
			if(criterioInInput.test(personaItem))
				result.add(personaItem);
		}
		
		return result;
	}
}
