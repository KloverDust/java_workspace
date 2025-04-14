package it.prova.utilities;

import java.util.ArrayList;

public class MyListUtility {
    private ArrayList <String> stringhe;

    public static String parolaPiuLunga(ArrayList <String> paroleInput) {
        String parolaLong = paroleInput.get(0);

        for (String s : paroleInput) {
            if (parolaLong.length() < s.length()) {
                parolaLong = s;
            }
        }
        return parolaLong;
    }

    public static boolean checkLastLetter(ArrayList <String> words, char letter) {
        for (String word : words) {
            if (word.charAt(word.length() - 1) != letter) {
                return false;
            }
        }
        return true;
    }

    public static boolean lunghezzaUguale(ArrayList <String> parole) {
        int lunghezzaParola = parole.get(0).length();
        for (int i = 0; i < parole.size(); i++ ) {
            if (parole.get(i).length() != lunghezzaParola) {
                return false;
            }
        }
        return true;
    }
}
