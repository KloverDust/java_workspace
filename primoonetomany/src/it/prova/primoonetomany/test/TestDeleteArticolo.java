package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;

public class TestDeleteArticolo {
    public static void main(String[] args) {
        System.out.println("Inizio test eliminazione articolo...");

        ArticoloDAO articoloDaoInstance = new ArticoloDAO();
        Long idDaEliminare = 8L;

        System.out.println("################ TEST delete ################");

        try {
            int righeEliminate = articoloDaoInstance.delete(idDaEliminare);

            if (righeEliminate > 0) {
                System.out.println("Eliminazione riuscita: " + righeEliminate + " riga eliminata.");
            } else {
                throw new AssertionError("Test delete: FAILED - nessuna riga modificata.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test delete: FAILED con eccezione.");
        }

        System.out.println("################### TEST delete : FINE ###################");
    }
}
