package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.NegozioDAO;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

public class TestPopulateArticoli {
    public static void main(String[] args) {
        System.out.println("Inizio test populateArticoli...");

        Negozio negozioTest = new Negozio();
        negozioTest.setId(1L);

        NegozioDAO negozioDaoInstance = new NegozioDAO();

        try {
            negozioDaoInstance.populateArticoli(negozioTest);

            if (negozioTest.getArticoli() == null || negozioTest.getArticoli().isEmpty()) {
                System.out.println("Nessun articolo trovato per il negozio con id: " + negozioTest.getId());
            } else {
                System.out.println("Articoli popolati per il negozio con id " + negozioTest.getId() + ":");
                for (Articolo a : negozioTest.getArticoli()) {
                    System.out.println(a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test populateArticoli: FAILED con eccezione.");
        }

        System.out.println("################### TEST populateArticoli : FINE ###################");
    }
}
