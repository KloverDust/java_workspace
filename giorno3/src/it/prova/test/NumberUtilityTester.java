package it.prova.test;

import it.prova.utility.NumberUtility;

public class NumberUtilityTester {

    public static void main (String [] args) {
        //TEST checkArrayDecrescente
        System.out.println("TEST checkArrayDecrescente........Start");
        int [] numeriDaTestare1 = {8, 5, 3};

        boolean checkConfrontaArray = NumberUtility.checkArrayDecrescente(numeriDaTestare1);
        System.out.println("L'array è decrescente? " + checkConfrontaArray);
        System.out.println("TEST checkConfrontaArray..........End");
        System.out.println("......................................");

        //TEST creaProgressioneNumerica
        System.out.println("TEST creaProgressioneNumerica........Start");
        int quanti = 4;
        int moltiplicando = 2;
        int [] numeriRestituiti = NumberUtility.creaProgressioneNumerica(quanti, moltiplicando);

        System.out.println("L'array costruito per la progressione è ? " );
        for (int i =0; i<numeriRestituiti.length;  i++) {
            System.out.println(numeriRestituiti[i]);
        }
        System.out.println("TEST creaProgressioneNumerica..........End");
        System.out.println("......................................");

    }

}
