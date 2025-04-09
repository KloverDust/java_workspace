package it.prova.utility;

public class NumberUtility {

    public static boolean checkArrayDecrescente(int [] arrayNumeri) {
        for (int i=0; i< arrayNumeri.length -1; i++) {
            if (arrayNumeri[i] < arrayNumeri[i+1]) // Qui bisogna mettere <=
                return false;
        }
        return true;
    }

    public static int[] creaProgressioneNumerica(int quanti, int moltiplicando) {
        int [] arrayRichiesto = new int[quanti];
        arrayRichiesto[0]= moltiplicando;

        for (int i=0; i<quanti-1 ; i++) {
            arrayRichiesto[i+1] = arrayRichiesto[i] * moltiplicando;

        }
        return arrayRichiesto;
    }

    public static int[] riduciArray (int[] input, int riduzione) {
        int[] arrayCopia = new int[input.length];

        for (int i= 0; i< input.length; i++) {
            arrayCopia[i] = input[i] - riduzione;
        }
        return arrayCopia;
    }
}
