package it.prova.model;

public class Automobile implements Macchina{
    private int kmPercorsi;
    private int numeroPosti;

    public Automobile(int kmPercorsi, int numeroPosti){
        this.kmPercorsi = kmPercorsi;
        this.numeroPosti = numeroPosti;
    }

    public Automobile(){

    }

    @Override
    public String modoDiSpostarmi() {
        return "Sono un automobile e io mi sposto su quattro ruote";
    }

    @Override
    public String consumoQualeCarburante() {
        return "Sono un automobile e io consumo diesel o benzina";
    }

    public int getKmPercorsi() {
        return kmPercorsi;
    }

    public void setKmPercorsi(int kmPercorsi) {
        this.kmPercorsi = kmPercorsi;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }
}
