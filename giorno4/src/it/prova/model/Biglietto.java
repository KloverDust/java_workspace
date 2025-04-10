package it.prova.model;

public class Biglietto {
    private String nomeSpettacolo;
    private char letteraFila;
    private int numeroPosto;
    private float prezzo;

    public Biglietto(String nomeSpettacolo, char letteraFila, int numeroPosto, float prezzo){
        this.nomeSpettacolo = nomeSpettacolo;
        this.letteraFila = letteraFila;
        this.numeroPosto = numeroPosto;
        this.prezzo = prezzo;
    }

    public Biglietto() {

    }

    public String getNomeSpettacolo() {
        return nomeSpettacolo;
    }

    public void setNomeSpettacolo(String nomeSpettacolo) {
        this.nomeSpettacolo = nomeSpettacolo;
    }

    public char getLetteraFila() {
        return letteraFila;
    }

    public void setLetteraFila(char letteraFila) {
        this.letteraFila = letteraFila;
    }

    public int getNumeroPosto() {
        return numeroPosto;
    }

    public void setNumeroPosto(int numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}
