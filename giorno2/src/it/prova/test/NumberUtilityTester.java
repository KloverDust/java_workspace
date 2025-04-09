package it.prova.test;

import it.prova.utility.NumberUtility;

public class NumberUtilityTester {
    public static void main (String[] args) {

        //TEST numeriTuttiPari
        System.out.println("TEST numeriTuttiPari........Start");
        int [] numeriDaTestare1 = {2, 4, 6, 8, 10, 12, 8};
        boolean isNumeriPari = NumberUtility.numeriTuttiPari(numeriDaTestare1);
        System.out.println("I numeri sono tutti pari? " + isNumeriPari);
        System.out.println("TEST numeriTuttiPari..........End");
        System.out.println(".................................");

        //TEST esisteUnNegativoPari
        System.out.println("TEST esisteUnNegativoPari........Start");
        int [] numeriDaTestare2 = {-2, 1, 7, 8, 11, 12, 5};
        boolean negativoPariPresente = NumberUtility.esisteUnNegativoPari(numeriDaTestare2);
        System.out.println("Esiste un numero negativo pari? " + negativoPariPresente);
        System.out.println("TEST esisteUnNegativoPari..........End");
        System.out.println("......................................");

        //TEST sommaIndiceDispariAlContrario
        System.out.println("TEST sommaIndiceDispariAlContrario........Start");
        int [] numeriDaTestare3 = {-2, 1, 7, 8, 11, 12, 5};
        int sommaNumeriConIndiceDispari = NumberUtility.sommaIndiceDispariAlContrario(numeriDaTestare3);
        System.out.println("Somma dei numeri con indice dispari " + sommaNumeriConIndiceDispari);
        System.out.println("TEST sommaIndiceDispariAlContrario..........End");
        System.out.println("......................................");

        //TEST sommaPosizioniDispariCheckDispari
        System.out.println("TEST ........Start");
        int [] numeriDaTestare4 = {1,3,1,5};
        boolean checkDispari = NumberUtility.sommaPosizioniDispariCheckDispari(numeriDaTestare4);
        System.out.println("Somma dei numeri con indice dispari è dispari? " + checkDispari);
        System.out.println("TEST sommaPosizioniDispariCheckDispari..........End");
        System.out.println("......................................");

        //TEST confrontaArray
        System.out.println("TEST ........Start");
        int [] numeriDaTestareA = {1,3,1,5,8};
        int [] numeriDaTestareB = {1,3,1,5,8,9};

        boolean checkConfrontaArray = NumberUtility.confrontaArray(numeriDaTestareA, numeriDaTestareB);
        System.out.println("Gli array hanno gli stessi numeri nelle stesse posizioni? " + checkConfrontaArray);
        System.out.println("TEST confrontaArray..........End");
        System.out.println("......................................");
    }
}
