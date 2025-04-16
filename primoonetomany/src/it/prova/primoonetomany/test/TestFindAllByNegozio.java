package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

import java.util.List;

public class TestFindAllByNegozio {
    public static void main(String[] args) {
        System.out.println("Inizio test ricerca articoli per negozio...");

        Negozio negozioTest = new Negozio();
        negozioTest.setId(1L);

        ArticoloDAO articoloDaoInstance = new ArticoloDAO();

        try {
            List<Articolo> articoli = articoloDaoInstance.findAllByNegozio(negozioTest);

            if (articoli == null || articoli.isEmpty()) {
                System.out.println("Nessun articolo trovato per il negozio con id: " + negozioTest.getId());
            } else {
                System.out.println("Articoli trovati per il negozio con id " + negozioTest.getId() + ":");
                for (Articolo a : articoli) {
                    System.out.println(a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test findAllByNegozio: FAILED con eccezione.");
        }

        System.out.println("################### TEST findAllByNegozio : FINE ###################");
    }
}
