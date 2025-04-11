package it.prova.test.UtilitiesTesters;

import it.prova.model.Utilities.IterationUtility;

public class IterationUtilityTester {
    public static void main (String[] args) {
        int[] arrayNumeri = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arrayModificato = IterationUtility.incrementaOgniElemento(arrayNumeri, 4);

        for (int numero : arrayModificato) {
            System.out.println(numero);
        }
    }
}
