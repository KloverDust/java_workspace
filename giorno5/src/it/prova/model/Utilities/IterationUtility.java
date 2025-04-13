package it.prova.model.Utilities;

public class IterationUtility {

    public static int[] incrementaOgniElemento(int[] valori, int incremento) {
        int dimensioneArrayOriginale = valori.length;
        int[] arrayModificato= new int[dimensioneArrayOriginale];

        int j=0;
        for(int valore : valori) {
            if( (valore + incremento) %incremento == 0) {
                arrayModificato[j] = valore + incremento;
                //j++;
            } else {
                arrayModificato[j] = 0;
                //j++;
            }
            j++;
        }
        return arrayModificato;
    }

    public static boolean verificaSeMultipliTraLoro(int[] numeriControllo, int[] numeriDaControllare) {
        for (int i = 0; i< numeriControllo.length; i++) {
            if (numeriDaControllare[i] % numeriControllo[i] == 0)
                return true;
        }
        return false;
    }

    public static int[] prodottoVettoriale (int[] input1, int[] input2) {
        int[] prodottoVettorialeResult = new int[input1.length];

        for(int i =0; i< input1.length; i++) {
            prodottoVettorialeResult[i] = input1[i] * input2[i];
        }
        return prodottoVettorialeResult;
    }

    public static boolean calcolaSeTantiDispariQuantiPari(int[] input) {
        int pariCounter = 0;
        int dispariCounter = 0;
        for (int numero : input) {
            if (numero % 2 == 0)
                pariCounter++;
            else
                dispariCounter++;
        }
        return (pariCounter == dispariCounter);
    }

    public static boolean verificaSeDifferenzaPosizioniPariConDispariRisultaPositivo(int [] input) {
        int sommaPari = 0;
        int sommaDispari = 0;
        for (int i= 0; i< input.length; i++) {
            if (i%2 ==0) {
                sommaPari += input[i];
            } else sommaDispari += input[i];
        }
        return (sommaPari + sommaDispari > 0);
    }

    public static int quantiSonoDivisibiliPer(int[] valori, int divisore) {
        int divisibili = 0;
        for(int i = 0; i<valori.length; i++) {
            if (valori[i] % divisore == 0) {
                divisibili++;
            }
        }
        return divisibili;
    }

    public static int[] unisciArray (int[] arrayA, int[] arrayB) {
        int lunghezzaArrayA = arrayA.length;
        int lunghezzaArrayB = arrayB.length;
        int[] arrayUnito = new int[lunghezzaArrayA + lunghezzaArrayB];

        for(int i= 0; i<lunghezzaArrayA+lunghezzaArrayB; i++) {
            if(i < lunghezzaArrayA ){
                arrayUnito[i] = arrayA[i];
            }
            else {
                arrayUnito[i] = arrayB[i-lunghezzaArrayA];
            }

        }
        return  arrayUnito;

    }

    public static String creaStringaAlContrarioConIndice(String input, int tipoIndice) {
        int lunghezzaInput = input.length();
        String result = "";

        for(int i=input.length() -1; i>=0; i--){
            if(tipoIndice % 2 == 0 && i%2 == 0){
                result += input.charAt(i);
            } else if (tipoIndice % 2 == 1 && i%2 == 1){
                result += input.charAt(i);
            }
        }
        return result;
    }
}
