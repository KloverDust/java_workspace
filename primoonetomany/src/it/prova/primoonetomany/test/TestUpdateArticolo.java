package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

public class TestUpdateArticolo {
    public static void main(String[] args) {
        System.out.println("Inizio test aggiornamento articolo...");

        ArticoloDAO articoloDaoInstance = new ArticoloDAO();

        Long idArticoloDaAggiornare = 1L;

        try {

            Articolo articoloEsistente = articoloDaoInstance.findById(idArticoloDaAggiornare);
            if (articoloEsistente == null) {
                throw new RuntimeException("Articolo non trovato per l'id: " + idArticoloDaAggiornare);
            }

            articoloEsistente.setNome("Nome Aggiornato");
            articoloEsistente.setMatricola("MatricolaAggiornata");

            Negozio negozio = new Negozio();
            negozio.setId(1L);
            articoloEsistente.setNegozio(negozio);

            int righeModificate = articoloDaoInstance.update(articoloEsistente);

            if (righeModificate > 0) {
                System.out.println("Aggiornamento riuscito: " + righeModificate + " riga modificata.");
            } else {
                throw new AssertionError("Test update: FAILED - nessuna riga modificata (ID non trovato?).");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test update: FAILED con eccezione.");
        }

        System.out.println("################### TEST update : FINE ###################");
    }
}
