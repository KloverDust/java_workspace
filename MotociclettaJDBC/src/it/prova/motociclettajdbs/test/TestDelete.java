package it.prova.motociclettajdbs.test;

import it.prova.motociclettajdbs.dao.MotociclettaDAO;

public class TestDelete {
    public static void main(String[] args) {
        System.out.println("Inizio test delete...");

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();
        Long idDaCancellare = 1L; // Assicurati che questo ID esista nel DB

        System.out.println("################ TEST delete ################");

        try {
            int righeEliminate = motociclettaDaoInstance.delete(idDaCancellare);

            if (righeEliminate > 0) {
                System.out.println(" Eliminazione riuscita: " + righeEliminate + " riga/e eliminata/e.");
            } else {
                throw new AssertionError(" Test delete: FAILED - nessuna riga eliminata- ID non trovato?.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError(" Test delete: FAILED con eccezione.");
        }

        System.out.println("################### TEST delete : FINE ###################");
    }
}
