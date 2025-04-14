package it.prova.model;

public class Moto implements Macchina{

    @Override
    public String modoDiSpostarmi() {
        return "Sono una moto e io mi sposto su 2 ruote";
    }

    @Override
    public String consumoQualeCarburante() {
        return "Sono una moto e io vado a benzina";
    }
}
