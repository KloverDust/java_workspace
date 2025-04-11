package it.prova.model.Utilities;

public class IterationUtility {

    public static int[] incrementaOgniElemento(int[] valori, int incremento) {
        int dimensioneArrayOriginale = valori.length;
        int[] arrayModificato= new int[dimensioneArrayOriginale];

        int j=0;
        for(int valore : valori) {
            if( (valore + incremento) %incremento == 0) {
                arrayModificato[j] = valore + incremento;
                j++;
            } else {
                arrayModificato[j] = 0;
                j++;
            }
        }
        return arrayModificato;
    }
}
