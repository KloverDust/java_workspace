package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.NegozioDAO;
import it.prova.primoonetomany.model.Negozio;

public class TestDeleteNegozio {

    public static void main(String[] args) {
        System.out.println("Inizio test eliminazione negozio...");

        NegozioDAO negozioDaoInstance = new NegozioDAO();
        Long idDaEliminare = 2L;

        System.out.println("################ TEST update ################");

        try {

            int righeEliminate = negozioDaoInstance.delete(idDaEliminare);

            if (righeEliminate > 0) {
                System.out.println("Eliminazione riuscito: " + righeEliminate + " riga eliminata.");
            } else {
                throw new AssertionError("Test delete: FAILED - nessuna riga modificata (ID non trovato?).");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test delete: FAILED con eccezione.");
        }

        System.out.println("################### TEST delete : FINE ###################");
    }
}
