package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;

public class TestFindByIdArticolo {
    public static void main(String[] args) {
        System.out.println("Inizio test findByIdEager...");

        ArticoloDAO articoloDaoInstance = new ArticoloDAO();
        // Inserisci qui l'ID di un articolo esistente nel database
        Long idArticoloTest = 1L;

        try {
            Articolo articolo = articoloDaoInstance.findByIdEager(idArticoloTest);
            if (articolo == null) {
                System.out.println("Nessun articolo trovato per l'id: " + idArticoloTest);
            } else {
                System.out.println("Articolo trovato: ");
                System.out.println("ID: " + articolo.getId());
                System.out.println("Nome: " + articolo.getNome());
                System.out.println("Matricola: " + articolo.getMatricola());
                if (articolo.getNegozio() != null) {
                    System.out.println("Negozio: " + articolo.getNegozio());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test findByIdEager: FAILED con eccezione.");
        }

        System.out.println("################### TEST findByIdEager : FINE ###################");
    }
}
