package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.NegozioDAO;
import it.prova.primoonetomany.model.Negozio;

import java.util.List;

public class TestFindAllByIniziali {
    public static void main(String[] args) {
        System.out.println("Inizio test findAllByIniziali...");

        NegozioDAO negozioDaoInstance = new NegozioDAO();
        String iniziali = "B";

        System.out.println("################ TEST findAllByIniziali ################");

        try {
            List<Negozio> risultati = negozioDaoInstance.findAllByIniziali(iniziali);

            if (!risultati.isEmpty()) {
                System.out.println("Negozi trovati: " + risultati.size());
                for (Negozio n : risultati) {
                    System.out.println(n);
                }
            } else {
                System.out.println("Nessun negozio trovato con iniziali: " + iniziali);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test findAllByIniziali: FALLITO con eccezione.");
        }

        System.out.println("################### TEST findAllByIniziali : FINE ###################");
    }
}
