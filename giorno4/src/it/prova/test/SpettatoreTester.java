package it.prova.test;

import it.prova.model.Biglietto;
import it.prova.model.Spettatore;

public class SpettatoreTester {
    public static void main (String[] args) {
        Biglietto general1 = new Biglietto("Re leone", 'z', 33, 16);
        Spettatore spettatoreA1= new Spettatore("Michele","Bianchi", "48881206", general1);

        System.out.println("TEST stampaSpettatoreConBiglietto........Start");
        System.out.println("Nome: " + spettatoreA1.getNome());
        System.out.println("Cognome: " + spettatoreA1.getCognome());

        Biglietto b = spettatoreA1.getBiglietto();
        System.out.println("Spettacolo: " + b.getNomeSpettacolo());
        System.out.println("Fila: " + b.getLetteraFila());
        System.out.println("Posto: " + b.getNumeroPosto());

        System.out.println("TEST stampaSpettatoreConBiglietto........End");
        System.out.println(" .......................................... \n");


    }
}
