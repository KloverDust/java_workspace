package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;

import java.util.List;

public class TestFindAllByIndirizzoNegozio {
    public static void main(String[] args) {
        System.out.println("Inizio test ricerca articoli per indirizzo negozio...");

        String indirizzoInput = "Via Roma";

        ArticoloDAO articoloDaoInstance = new ArticoloDAO();

        try {
            List<Articolo> articoli = articoloDaoInstance.findAllByIndirizzoNegozio(indirizzoInput);

            if (articoli == null || articoli.isEmpty()) {
                System.out.println("Nessun articolo trovato per indirizzo negozio: " + indirizzoInput);
            } else {
                System.out.println("Articoli trovati per indirizzo negozio " + indirizzoInput + ":");
                for (Articolo a : articoli) {
                    System.out.println(a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test findAllByIndirizzoNegozio: FAILED con eccezione.");
        }

        System.out.println("################### TEST findAllByIndirizzoNegozio : FINE ###################");
    }
}
