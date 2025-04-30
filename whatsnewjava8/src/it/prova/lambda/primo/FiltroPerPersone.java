package it.prova.lambda.primo;

import java.util.ArrayList;
import java.util.List;

import it.prova.lambda.Persona;

public class FiltroPerPersone {
	
	public static List<Persona> uomini(List<Persona> input){
		List<Persona> result = new ArrayList<>();
		for (Persona personaItem : input) {
			if(personaItem.getSesso() != null && personaItem.getSesso().equals("M")){
				result.add(personaItem);
			}
		}
		return result;
	}
	
	public static List<Persona> donne(List<Persona> input){
		List<Persona> result = new ArrayList<>();
		for (Persona personaItem : input) {
			if(personaItem.getSesso() != null && personaItem.getSesso().equals("F")){
				result.add(personaItem);
			}
		}
		return result;
	}
	
	public static List<Persona> maggiorenni(List<Persona> input){
		List<Persona> result = new ArrayList<>();
		for (Persona personaItem : input) {
			if(personaItem.getEta() >= 18){
				result.add(personaItem);
			}
		}
		return result;
	}
	
	public static List<Persona> nomeCheIniziaPer(String iniziale,List<Persona> input){
		List<Persona> result = new ArrayList<>();
		for (Persona personaItem : input) {
			if(personaItem.getNome() != null && personaItem.getNome().startsWith(iniziale)){
				result.add(personaItem);
			}
		}
		return result;
	}

}
