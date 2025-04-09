package it.prova.utility;

public class ArrayUtility {

    public static int calcolaParoleDispari(String[] parole) {
        int dispariCounter = 0;

        for (int i = 0; i < parole.length; i++) {
            if (parole[i].length() % 2 == 1)
                dispariCounter++;
        }
        return dispariCounter;
    }

    public static boolean sommaNulla(int[] inputNumeri) {
        int somma = 0;

        for (int i = 0; i < inputNumeri.length; i++) {
            somma += inputNumeri[i];
        }

        return somma == 0;
    }

    public static boolean cercaSeParolaPresente(String[] paroleInput, String parolaCercata) {
        for (int i =0; i< paroleInput.length; i++) {
            if(paroleInput[i].equals(parolaCercata))
                return true;
        }
        return false;
    }

    public static String parolaPiuLunga(String[] paroleInput) {
        String parolaLong = paroleInput[0];

        for (String s : paroleInput) {
            if (parolaLong.length() < s.length()) {
                parolaLong = s;
            }
        }
        return parolaLong;
    }

    public static String invertiStringa(String parolaDaInvertire) {
        String parolaInvertita = "";
        for (int i=parolaDaInvertire.length()-1; i>=0; i--) {
            parolaInvertita += parolaDaInvertire.charAt(i); // Mi viene segnalato come
        }
        return parolaInvertita;
    }

    public static boolean lunghezzaUguale(String [] parole) {
        int lunghezzaParola = parole[0].length();
        for (int i = 0; i < parole.length; i++ ) {
            if (lunghezzaParola != parole[i].length()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkLastLetter(String [] words, char letter) {
        for (int i = 0; i< words.length; i++) {
            if (words[i].charAt(words[i].length()-1) != letter) {
                return false;
            }
        }
        return true;
    }

    public static int sommaLunghezzeParole(String[] parole) {
        int sommaLunghezze = 0;
        for (int i = 0; i < parole.length; i++) {
            sommaLunghezze += parole[i].length();
        }
        return sommaLunghezze;
    }


}
