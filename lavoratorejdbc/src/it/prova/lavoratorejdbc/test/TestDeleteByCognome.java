package it.prova.lavoratorejdbc.test;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;
import it.prova.lavoratorejdbc.model.Lavoratore;

import java.util.List;

public class TestDeleteByCognome {

    public static void main(String[] args) {
        System.out.println("Inizio....");

        LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();
        String cognomeDaEliminare = "rossi";

        System.out.println("################ TEST deleteByCognome ################");

        List<Lavoratore> attualmentePresentiSullaBaseDati = lavoratoreDaoInstance.elencaTuttiQuelliAttualmenteSullaBaseDati();
        if (!attualmentePresentiSullaBaseDati.isEmpty()) {
            int rowsAffected = lavoratoreDaoInstance.deleteByCognome(cognomeDaEliminare);
            System.out.println("Il codice ricevuto è: " + rowsAffected);
            if (rowsAffected == 0 || rowsAffected < 0)
                throw new AssertionError("test di rimozione: FAILED");
            else {
                System.out.println("Il test è stato eseguito con successo eliminando " + rowsAffected + " utenti di cognome " + cognomeDaEliminare);
            }

        } else
            throw new AssertionError("test di rimozione: FAILED in quanto non c'è nulla da rimuovere");

        System.out.println("################### TEST deleteByCognome :FINE #######");

    }
}
