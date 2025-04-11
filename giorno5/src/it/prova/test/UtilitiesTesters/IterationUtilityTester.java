package it.prova.test.UtilitiesTesters;

import it.prova.model.Utilities.IterationUtility;

public class IterationUtilityTester {
    public static void main (String[] args) {
        int[] arrayNumeri = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arrayModificato = IterationUtility.incrementaOgniElemento(arrayNumeri, 4);

        System.out.println("Array originale prima : \n");
        for (int numero : arrayNumeri) {
            System.out.println(numero);
        }
        System.out.println("------------ \n");

        System.out.println("Array modificato: \n");
        for (int numero : arrayModificato) {
            System.out.println(numero);
        }
        System.out.println("------------ \n");

        System.out.println("Array originale dopo : \n");
        for (int numero : arrayNumeri) {
            System.out.println(numero);
        }
        System.out.println("------------ \n");

        int[] numeriProva1 = new int[] {1,3,5,7,9};
        int[] numeriProva2 = new int[] {2,4,6,8,10};
        int[] numeriProva3 = new int[] {1,8,12,13,21};
        int[] numeriCheck = new int[] {2,4,2,4,2};

        boolean testNumeriProva1 = IterationUtility.verificaSeMultipliTraLoro(numeriCheck, numeriProva1);
        boolean testNumeriProva2 = IterationUtility.verificaSeMultipliTraLoro(numeriCheck, numeriProva2);
        boolean testNumeriProva3 = IterationUtility.verificaSeMultipliTraLoro(numeriCheck, numeriProva3);

        System.out.println("numeriProva1 check : \n");
        System.out.println(testNumeriProva1);
        System.out.println("------------ \n");

        System.out.println("numeriProva2 check : \n");
        System.out.println(testNumeriProva2);
        System.out.println("------------ \n");

        System.out.println("numeriProva3 check : \n");
        System.out.println(testNumeriProva3);
        System.out.println("------------ \n");

        int[] numeriPV1 = new int[] {1,3,5,7,9};
        int[] numeriPV2 = new int[] {2,4,6,8,10};
        int[] risultatoPV = IterationUtility.prodottoVettoriale(numeriPV1, numeriPV2);

        System.out.println("prodottoVettoriale start : \n");

        for(int a : risultatoPV) {
            System.out.println(a);
        }

        System.out.println("prodottoVettoriale end : \n");
        System.out.println("------------ \n");
    }
}
