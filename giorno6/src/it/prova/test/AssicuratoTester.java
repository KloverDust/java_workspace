package it.prova.test;

import it.prova.model.Assicurato;

import java.util.ArrayList;

public class AssicuratoTester {
    public static void main(String[] args) {
        ArrayList<Assicurato> assicuratiUnipol = new ArrayList<>();
        Assicurato primoAssicurato = new Assicurato("Mario", "Rossi", "MRSS293AJFFJA2992", 250);
        Assicurato secondoAssicurato = new Assicurato("Luca", "Bianchi", "LCBNCH85M01H501Y", 300);
        Assicurato terzoAssicurato = new Assicurato("Giulia", "verdi", "GLVRDI92C50F205Z", 180);
        Assicurato quartoAssicurato = new Assicurato("Francesca", "veri", "FRNRS77A41E888Q", 400);
        Assicurato quintoAssicurato = new Assicurato("Alessandro", "Russo", "ALRSSN60T22Z404G", 220);

        assicuratiUnipol.add(primoAssicurato);
        assicuratiUnipol.add(secondoAssicurato);
        assicuratiUnipol.add(terzoAssicurato);
        assicuratiUnipol.add(quartoAssicurato);

        boolean assicuratoInLista = quintoAssicurato.presenteInElenco(assicuratiUnipol);
        System.out.println("L'assicurato è presente in lista? " + assicuratoInLista);

        int cognomiStessaIniziale = Assicurato.quantiConInizialeNelCognome(assicuratiUnipol, 'v');
        System.out.println("Gli assicurati in lista con i cognomi con le stesse iniziali sono? " + cognomiStessaIniziale);

        ArrayList<String> cognomi = Assicurato.estraiSoloICognomi(assicuratiUnipol);
        System.out.println("I cognomi degli assicurati sono: " + cognomi.toString());

        ArrayList<Assicurato> assicuratiConRataMaggiore = Assicurato.estraiQuelliConRataMaggioreDi(assicuratiUnipol, 300);
        System.out.println("Gli assicurati con rata maggiore di: " + "300" + " sono: ");
        for (Assicurato assic : assicuratiConRataMaggiore) {
            System.out.println(assic.getNome() + " " + assic.getCognome());
        }

    }
}
