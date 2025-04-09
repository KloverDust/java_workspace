package it.prova.utility;

public class NumberUtility {

    public static boolean numeriTuttiPari (int [] numeri) {
        for (int i = 0; i<numeri.length; i++) {
            if (numeri[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean esisteUnNegativoPari (int [] numeri) {
        for (int i = 0; i< numeri.length; i++) {
            if( numeri[i] < 0 && numeri[i] % 2 == 0)
                return true;
        }
        return false;
    }

    public static int sommaIndiceDispariAlContrario (int[] numeri) {
        int sommaDispari = 0;
        for (int i = numeri.length -1; i> 0; i--) {
            if( i % 2 == 1) {
                sommaDispari += numeri[i];
            }
        }
        return sommaDispari;
    }

    public static int dimmiQuantiElementiStrettamenteMinoriDi(int[] elementi, int soglia) {
        int counter = 0;
        for (int i = 0; i<elementi.length; i++) {
            if(elementi[i] > soglia)
                counter++;
        }
        return counter;
    }

    public static boolean sonoTuttiDentroUnIntervallo(int[] valori, int min, int max){
        boolean coerente = false;
        for(int i=0; i<valori.length; i++) {
            if (valori[i] > min && valori[i]< max)
                coerente = true;
            else
                coerente = false;
        }
        return coerente;
    }

    public static boolean sommaPosizioniDispariCheckDispari(int [] numeri) {
        int somma = 0;
        for (int i= 1; i < numeri.length; i+=2) {
            somma += numeri[i];
        }

        return (somma%2 !=0);
    }


    public static boolean confrontaArray(int[] numeriA, int[] numeriB) {
        if(numeriA.length != numeriB.length)
            return false;

        for (int i=0; i<numeriA.length ; i++) {
            if (numeriA[i] != numeriB[i])
                return false;
        }
        return true;

    }




}
