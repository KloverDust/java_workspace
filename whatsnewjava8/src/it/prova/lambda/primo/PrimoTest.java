package it.prova.lambda.primo;

import java.util.List;

import it.prova.lambda.Persona;

public class PrimoTest {

	public static void main(String[] args) {
		
		System.out.println("UOMINI....");
		stampa(FiltroPerPersone.uomini(Persona.list()));
		
		System.out.println("DONNE....");
		stampa(FiltroPerPersone.donne(Persona.list()));
		
		System.out.println("MAGGIORENNI....");
		stampa(FiltroPerPersone.maggiorenni(Persona.list()));
		
		System.out.println("NOME CHE INIZIA PER A....");
		stampa(FiltroPerPersone.nomeCheIniziaPer("A",Persona.list()));
	}
	
	private static void stampa(List<Persona> input){
		for (Persona personaItem : input) {
			System.out.println(personaItem);
		}
	}

}
