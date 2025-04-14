package it.prova.model;

public class Aereo implements Macchina{
    private int numeroPasseggeri;
    private int tempoInVolo;
    private int velocitaMassima;

    public Aereo(int numeroPasseggeri, int tempoInVolo){
        this.numeroPasseggeri = numeroPasseggeri;
        this.tempoInVolo = tempoInVolo;
    }

    public Aereo(){

    }

    @Override
    public String modoDiSpostarmi() {
        return "Sono un aereo e io mi sposto volando";
    }

    @Override
    public String consumoQualeCarburante() {
        return "Sono un aereo e consumo solo jetfuel";
    }

    public int getNumeroPasseggeri() {
        return numeroPasseggeri;
    }

    public void setNumeroPasseggeri(int numeroPasseggeri) {
        this.numeroPasseggeri = numeroPasseggeri;
    }

    public int getVelocitaMassima() {
        return velocitaMassima;
    }

    public void setVelocitaMassima(int velocitaMassima) {
        this.velocitaMassima = velocitaMassima;
    }

    public int getTempoInVolo() {
        return tempoInVolo;
    }

    public void setTempoInVolo(int tempoInVolo) {
        this.tempoInVolo = tempoInVolo;
    }
}
