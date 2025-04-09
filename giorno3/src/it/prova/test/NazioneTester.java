package it.prova.test;

import it.prova.model.Nazione;

public class NazioneTester {
    public static void main (String[] args) {
        Nazione Italy = new Nazione();
        Italy.setDenominazione("Italia");
        Italy.setAbitanti(60000000);
        Italy.setSuperficieKmQ(302073);

        Nazione France = new Nazione();
        France.setDenominazione("Francia");
        France.setAbitanti(68000000);
        France.setSuperficieKmQ(551695);

        Nazione Germany = new Nazione("Germania", 357592, 83000000);
        Nazione Poland = new Nazione("Polonia", 322575,37000000);
        Nazione Spain = new Nazione("Spagna", 505990, 47400000);
        Nazione Portugal = new Nazione("Portogallo", 92226, 10196709);


        boolean checkPiuEstesa = Italy.piuEstesaDi(France);
        System.out.println("Test metodo piuEstesaDi");
        System.out.println("Start.....");
        System.out.println(France.getDenominazione() + " è piu grande di "+ Italy.getDenominazione() + "? " + checkPiuEstesa);
        System.out.println("End.......");
        System.out.println(".......... \n");

        boolean checkPiuPopolosa = France.piuPopolosaDi(Germany);
        System.out.println("Test metodo piuPopolosaDi");
        System.out.println("Start.....");
        System.out.println(France.getDenominazione() + " ha più abitanti di " + Germany.getDenominazione() + "? " + checkPiuPopolosa);
        System.out.println("End.......");
        System.out.println(".......... \n");

        Nazione[] elencoNazioni = {France, Germany, Poland, Spain, Portugal};

        boolean checkPiuEstesaNelGruppo = Italy.esisteAlmenoUnaPiuEstesa(elencoNazioni);
        System.out.println("Test metodo esisteAlmenoUnaPiuEstesa");
        System.out.println("Start.....");
        System.out.println("Esiste almeno una nazione più estesa di " + Italy.getDenominazione() + "? " + checkPiuEstesaNelGruppo);
        System.out.println("End.......");
        System.out.println(".......... \n");

        int numeroPiuPopolose = Italy.dimmiQuanteSonoPiuPopolose(elencoNazioni);
        System.out.println("Test metodo dimmiQuanteSonoPiuPopolose");
        System.out.println("Start.....");
        System.out.println("Numero di nazioni più popolose di " + Italy.getDenominazione() + ": " + numeroPiuPopolose);
        System.out.println("End.......");
        System.out.println(".......... \n");

        boolean checkPiuPopolosaAssoluta = France.haPiuAbitantiDiTutteLeAltre(elencoNazioni);
        System.out.println("Test metodo haPiuAbitantiDiTutteLeAltre");
        System.out.println("Start.....");
        System.out.println(France.getDenominazione() + " ha più abitanti di tutte le altre? " + checkPiuPopolosaAssoluta);
        System.out.println("End.......");
        System.out.println(".......... \n");

        Nazione Austria = new Nazione("Austria", 83879, 8900000);
        Nazione Albania = new Nazione("Albania", 28748, 2800000);
        Nazione Andorra = new Nazione("Andorra", 468, 77000);
        Nazione[] nazioniA= new Nazione[] {Austria, Albania, Andorra, France};

        boolean checkStessaIniziale = Austria.hannoTutteLaMiaStessaIniziale(nazioniA);
        System.out.println("Test metodo hannoTutteLaMiaStessaIniziale");
        System.out.println("Start.....");
        System.out.println("Tutte le nazioni iniziano con la stessa lettera di " + Austria.getDenominazione() + "? " + checkStessaIniziale);
        System.out.println("End.......");
        System.out.println(".......... \n");

        boolean checkSuperficieSopraMedia = France.eAlDiSopraDellaMediaComeSuperficie(elencoNazioni);
        System.out.println("Test metodo eAlDiSopraDellaMediaComeSuperficie");
        System.out.println("Start.....");
        System.out.println(Italy.getDenominazione() + " ha una superficie sopra la media? " + checkSuperficieSopraMedia);
        System.out.println("End.......");
        System.out.println(".......... \n");

    }
}
