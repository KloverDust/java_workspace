package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;

import java.util.List;

public class TestFindAllByMatricola {
    public static void main(String[] args) {
        System.out.println("Inizio test ricerca articoli per matricola...");

        String matricolaInput = "MSC001";

        ArticoloDAO articoloDaoInstance = new ArticoloDAO();

        try {
            List<Articolo> articoli = articoloDaoInstance.findAllByMatricola(matricolaInput);

            if (articoli == null) {
                System.out.println("Nessun articolo trovato con matricola: " + matricolaInput);
            } else {
                System.out.println("Articoli trovati con matricola " + matricolaInput + ":");
                for (Articolo articolo : articoli) {
                    System.out.println(articolo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test findAllByMatricola: FAILED con eccezione.");
        }

        System.out.println("################### TEST findAllByMatricola : FINE ###################");
    }
}
