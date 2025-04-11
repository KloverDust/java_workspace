package it.prova.test;

import it.prova.model.Lavoratore;
import it.prova.model.Operaio;
import it.prova.model.Volontario;

public class LavoratoreTester {
    public static void main (String[] args){

        // Testing con istanziazione con le classi specifiche
        Lavoratore AntonioLavoratore = new Lavoratore();
        Operaio BiagioOperario = new Operaio();
        Volontario CarloVolontario = new Volontario();

        System.out.println("\nSTART TEST 1 .....");
        System.out.println(AntonioLavoratore.percepisco());
        System.out.println(BiagioOperario.percepisco());
        System.out.println(CarloVolontario.percepisco());
        System.out.println("END TEST 1 ..... \n");


        // Testing con istanziazione con classe del padre ma senza ovveride dei metodi nel figlio
        System.out.println("\nSTART TEST 2 .....");
        Lavoratore DamianoOperaio = new Operaio();
        Lavoratore EmanueleVolontario = new Volontario();
        System.out.println(DamianoOperaio.percepisco());
        System.out.println(DamianoOperaio.vivo());
        System.out.println(EmanueleVolontario.percepisco());
        System.out.println(EmanueleVolontario.vivo());
        System.out.println("END TEST 2 ..... \n");

        // Testing con istanziazione con classe del padre ma con il override dei metodi nel figlio
        System.out.println("\nSTART TEST 2 .....");
        Lavoratore FabianoOperaio = new Operaio();
        Lavoratore GabrieleVolontario = new Volontario();
        System.out.println(FabianoOperaio.ilMioHobbyE());
        System.out.println(FabianoOperaio.vivo());
        System.out.println(GabrieleVolontario.ilMioHobbyE());
        System.out.println(GabrieleVolontario.vivo());
        System.out.println("END TEST 2 ..... \n");

    }
}
