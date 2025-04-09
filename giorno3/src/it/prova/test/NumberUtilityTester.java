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
        System.out.println("...................................... \n");


        //TEST riduciArray
        System.out.println("TEST riduciArray........Start");
        int[] arrayDaRidurre = {2, 4, 8 ,1 ,9};
        int[] arrayRidotto = NumberUtility.riduciArray(arrayDaRidurre, 2);
        System.out.print("L'array ridotto è: ");
        for (int num : arrayRidotto) {
            System.out.print(num + " ");
        }

        System.out.print("\nL'array non ridotto è: ");
        for (int num : arrayDaRidurre) {
            System.out.print(num + " ");
        }
        System.out.println();




        System.out.println("TEST riduciArray..........End");
        System.out.println("......................................");
    }

}
