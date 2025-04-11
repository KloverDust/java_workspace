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
}
