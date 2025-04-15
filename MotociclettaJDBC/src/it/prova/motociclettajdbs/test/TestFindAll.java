package it.prova.motociclettajdbs.test;

import it.prova.motociclettajdbs.dao.MotociclettaDAO;
import it.prova.motociclettajdbs.model.Motocicletta;

import java.util.List;

public class TestFindAll {
    public static void main(String[] args) {
        System.out.println("Inizio....");

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        System.out.println("################ TEST findAll ################");

        List<Motocicletta> listaMotociclette = motociclettaDaoInstance.findAll();

        if (listaMotociclette != null && !listaMotociclette.isEmpty()) {
            System.out.println("Sono state trovate " + listaMotociclette.size() + " motociclette:");
            for (Motocicletta moto : listaMotociclette) {
                System.out.println(moto.getMarca() + " " + moto.getModello()+ " " + moto.getCilindrata());
            }
        } else {
            throw new AssertionError("test di findAll: FAILED - nessuna motocicletta trovata");
        }

        System.out.println("################### TEST findAll : FINE ###################");
    }
}
