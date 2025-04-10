package it.prova.model;

public class Spettatore {
    private String nome;
    private String cognome;
    private String numeroCartaDiCredito;
    private Biglietto biglietto = new Biglietto();

    public Spettatore(String nome, String cognome, String numeroCartaDiCredito, Biglietto biglietto){
        this.nome = nome;
        this.cognome = cognome;
        this.numeroCartaDiCredito = numeroCartaDiCredito;
        this.biglietto= biglietto;
    }

    public Spettatore(String nome, String cognome, String numeroCartaDiCredito){
        this.nome = nome;
        this.cognome = cognome;
        this.numeroCartaDiCredito = numeroCartaDiCredito;
    }

    public Spettatore(){

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

    public String getNumeroCartaDiCredito() {
        return numeroCartaDiCredito;
    }

    public void setNumeroCartaDiCredito(String numeroCartaDiCredito) {
        this.numeroCartaDiCredito = numeroCartaDiCredito;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }
}
