package it.prova.test;

import it.prova.model.Lavoratore;
import it.prova.model.Operaio;
import it.prova.model.Volontario;

public class LavoratoreTester {
    public static void main (String[] args){

        // Testing con istanziazione con le classi specifiche
        Lavoratore antonioLavoratore = new Lavoratore();
        Operaio biagioOperario = new Operaio("Biagio", "Antonacci", 1200);
        Volontario carloVolontario = new Volontario("Carlo", "Rossi", "HelpingPaws");

        System.out.println("\nSTART TEST 1 .....");
        System.out.println(antonioLavoratore.percepisco());
        System.out.println(biagioOperario.percepisco());
        System.out.println("Sono " + carloVolontario.getNome() + " " + carloVolontario.getCognome() + " e percepisco "  + carloVolontario.percepisco());
        System.out.println("END TEST 1 ..... \n");


        // Testing con istanziazione con classe del padre ma senza override dei metodi nel figlio
        System.out.println("\nSTART TEST 2 .....");
        Lavoratore damianoOperaio = new Operaio("Damiano", "Michelangeli", 1330);
        Lavoratore emanueleVolontario = new Volontario("Emanuele", "Grimaldi", "4Tigers");
        System.out.println(damianoOperaio.percepisco());
        System.out.println(emanueleVolontario.percepisco());
        System.out.println("END TEST 2 ..... \n");

        // Testing con istanziazione con classe del padre ma con il override dei metodi nel figlio
        System.out.println("\nSTART TEST 3 .....");
        Lavoratore fabianoOperaio = new Operaio();
        Lavoratore gabrieleVolontario = new Volontario("Gabriele", "Marconi", "LifeForAll");
        System.out.println(fabianoOperaio.ilMioHobbyE());
        System.out.println(gabrieleVolontario.ilMioHobbyE());
        System.out.println("END TEST 3 ..... \n");

    }
}
