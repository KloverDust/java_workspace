package it.prova.motociclettajdbs.test;

import it.prova.motociclettajdbs.dao.MotociclettaDAO;
import it.prova.motociclettajdbs.model.Motocicletta;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestInsert {
    public static void main(String[] args) {
        System.out.println("Inizio test inserimento...");
        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();
        System.out.println("################ TEST insert ################");

        try {
            Motocicletta nuovaMoto = new Motocicletta();
            nuovaMoto.setMarca("Suzuki");
            nuovaMoto.setModello("GSX-R750");
            nuovaMoto.setCilindrata(750);

            Date dataImmatricolazione = new SimpleDateFormat("dd-MM-yyyy").parse("10-01-2010");
            nuovaMoto.setDataImmatricolazione(dataImmatricolazione);

            int righeInserite = motociclettaDaoInstance.insert(nuovaMoto);

            if (righeInserite > 0) {
                System.out.println("Inserimento riuscito: " + righeInserite + " riga/e inserita/e.");
            } else {
                throw new AssertionError("Test insert: FAILED - nessuna riga inserita.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test insert: FAILED con eccezione.");
        }

        System.out.println("################### TEST insert : FINE ###################");
    }
}
