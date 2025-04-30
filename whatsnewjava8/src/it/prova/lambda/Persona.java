package it.prova.lambda;

import java.util.Arrays;
import java.util.List;

public class Persona {

	private String nome;
	private String cognome;
	private String sesso; // M o F
	private int eta;

	public Persona() {
	}

	public Persona(String nome, String cognome, String sesso, int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", eta=" + eta + "]";
	}

	public static List<Persona> list() {
		List<Persona> listaPersoneMock = Arrays.asList(new Persona("Mario", "Bianchi", "M", 45),
				new Persona("Giuseppe", "Rossi", "M", 85), new Persona("Pippo", "Pipponio", "M", 18),
				new Persona("Pluto", "Plutone", "M", 32), new Persona("Antonietta", "Bismark", "F", 31),
				new Persona("Maria", "Flacca", "F", 17), new Persona("Asturio", "Mangiafuoco", "M", 15));
		return listaPersoneMock;
	}

}
