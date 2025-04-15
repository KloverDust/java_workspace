package it.prova.motociclettajdbs.test;

import it.prova.motociclettajdbs.dao.MotociclettaDAO;
import it.prova.motociclettajdbs.model.Motocicletta;

import java.util.List;

public class TestFindById {
    public static void main(String[] args) {
        System.out.println("Inizio....");

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();
        Long idRicercato = Long.valueOf(1);

        System.out.println("################ TEST findById ################");
        Motocicletta motociclettaTrovata = motociclettaDaoInstance.findById(idRicercato);

        if (motociclettaTrovata != null) {
            System.out.println("E' stata trovata una motocicletta con l'id: " + idRicercato);
        } else throw new AssertionError("test di findById: FAILED in quanto non c'è nulla da rimuovere");

        System.out.println("################### TEST findById :FINE ###################");

    }
}
