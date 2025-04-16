package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.NegozioDAO;
import it.prova.primoonetomany.model.Negozio;

public class TestUpdateNegozio {
    public static void main(String[] args) {
        System.out.println("Inizio test aggiornamento negozio...");

        NegozioDAO negozioDaoInstance = new NegozioDAO();
        Long idDaAggiornare = 1L; // Assicurati che esista nel DB

        System.out.println("################ TEST update ################");

        try {
            Negozio negozio = new Negozio();
            negozio.setId(idDaAggiornare);
            negozio.setNome("Bottega Veneta");
            negozio.setIndirizzo("Via Roma 99");
            negozio.setDataApertura(java.time.LocalDate.of(1945, 1, 15));

            int righeAggiornate = negozioDaoInstance.update(negozio);

            if (righeAggiornate > 0) {
                System.out.println("Aggiornamento riuscito: " + righeAggiornate + " riga/e modificata/e.");
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
