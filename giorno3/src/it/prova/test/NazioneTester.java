package it.prova.test;

import it.prova.model.Nazione;

public class NazioneTester {
    public static void main (String[] args) {
        Nazione Italy = new Nazione();
        Italy.setDenominazione("Italia");
        Italy.setAbitanti(60000000);
        Italy.setSuperficieKmQ(302073);

        System.out.println(Italy);
    }
}
