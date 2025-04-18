package it.prova.test.UtilitiesTesters;

import it.prova.model.Utilities.IterationUtility;

public class IterationUtilityTester {
    public static void main (String[] args) {

        /// //////////////// TESTING INCREMENTAOGNIELEMENTO
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

        /// //////////////// TESTING VERIFICASEMULTIPLITRALORO
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

        /// //////////////// TESTING PRODOTTOVETTORIALE
        int[] numeriPV1 = new int[] {1,3,5,7,9};
        int[] numeriPV2 = new int[] {2,4,6,8,10};
        int[] risultatoPV = IterationUtility.prodottoVettoriale(numeriPV1, numeriPV2);

        System.out.println("prodottoVettoriale start : \n");

        for(int a : risultatoPV) {
            System.out.println(a);
        }

        System.out.println("prodottoVettoriale end : \n");
        System.out.println("------------ \n");

        /// //////////////// TESTING CALCOLASETANTIDISPARIQUANTIPARI
        int[] numeriDispariPariCheck = new int[] {2,3,4,5,3};
        boolean dispariUgualePari = IterationUtility.calcolaSeTantiDispariQuantiPari(numeriDispariPariCheck);
        System.out.println("\n Test calcolaSeTantiDispariQuantiPari start ....");
        System.out.println("I numeri disapri e pari nell'array sono uguali in numero? " + dispariUgualePari);
        System.out.println("Test calcolaSeTantiDispariQuantiPari end ....\n");


        /// //////////////// TESTING verificaSeDifferenzaPosizioniPariConDispariRisultaPositivo
        int[] diffPosPariDispari = new int[] {-2,3,-4,5,-3,3,-9,2,-4};
        boolean diffPosPariDispariCheck = IterationUtility.verificaSeDifferenzaPosizioniPariConDispariRisultaPositivo(diffPosPariDispari);
        System.out.println("\n Test calcolaSeTantiDispariQuantiPari start ....");
        System.out.println("I numeri disapri e pari nell'array sono uguali in numero? " + diffPosPariDispariCheck);
        System.out.println("Test calcolaSeTantiDispariQuantiPari end ....\n");

        // //////////////// TESTING quantiSonoDivisibiliPer
        int[] valoriTest = new int[] {2, 4, 5, 6, 9, 10, 12};
        int divisore = 2;
        int risultato = IterationUtility.quantiSonoDivisibiliPer(valoriTest, divisore);
        System.out.println("\nTest quantiSonoDivisibiliPer start ....");
        System.out.println("Quanti numeri nell'array sono divisibili per " + divisore + "? Risultato: " + risultato);
        System.out.println("Test quantiSonoDivisibiliPer end ....\n");

        // //////////////// TESTING unisciArray
        int[] arrayA = new int[] {1, 2, 3};
        int[] arrayB = new int[] {4, 5, 6};
        int[] arrayUnito = IterationUtility.unisciArray(arrayA, arrayB);

        System.out.println("\nTest unisciArray start ....");
        System.out.print("Array A: ");
        for (int a : arrayA)
            System.out.print(a + " ");

        System.out.print("\nArray B: ");
        for (int b : arrayB)
            System.out.print(b + " ");

        System.out.print("\nArray Unito: ");
        for (int u : arrayUnito)
            System.out.print(u + " ");
        System.out.println("\nTest unisciArray end ....\n");

        // //////////////// TESTING creaStringaAlContrarioConIndice
        String inputTest = "ciao";
        int tipoIndice = 1;
        String risultatoContrario = IterationUtility.creaStringaAlContrarioConIndice(inputTest, tipoIndice);

        System.out.println("\nTest creaStringaAlContrarioConIndice start ....");
        System.out.println("Input: " + inputTest);
        System.out.println("TipoIndice: " + tipoIndice);
        System.out.println("Risultato: " + risultatoContrario);
        System.out.println("Test creaStringaAlContrarioConIndice end ....\n");


    }
}
