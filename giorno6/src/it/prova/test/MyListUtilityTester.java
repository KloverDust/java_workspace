package it.prova.test;

import it.prova.utilities.MyListUtility;

import java.util.ArrayList;

public class MyListUtilityTester {
    public static void main (String[] args){
        ArrayList <String> listaDiStringhe = new ArrayList<>();
        listaDiStringhe.add("Mario");
        listaDiStringhe.add("Marco");
        listaDiStringhe.add("Massimo");
        listaDiStringhe.add("Michelangelo");

        boolean ultimaLetteraCorrispondente = MyListUtility.checkLastLetter(listaDiStringhe, 'o');
        System.out.println("Test ultimaLetteraCorrispondente start....");
        System.out.println("Il valore di ultimaLetteraCorrispondente è " + ultimaLetteraCorrispondente);
        System.out.println("Test ultimaLetteraCorrispondente end....");

        String parolaPiuLunga = MyListUtility.parolaPiuLunga(listaDiStringhe);
        System.out.println("Test parolaPiuLunga start....");
        System.out.println("Il valore di parolaPiuLunga è " + parolaPiuLunga);
        System.out.println("Test parolapiuLunga end....");

        boolean lunghezzaUgualeCheck = MyListUtility.lunghezzaUguale(listaDiStringhe);
        System.out.println("Test parolaPiuLunga start....");
        System.out.println("Il valore di parolaPiuLunga è " + lunghezzaUgualeCheck);
        System.out.println("Test parolapiuLunga end....");


    }
}
