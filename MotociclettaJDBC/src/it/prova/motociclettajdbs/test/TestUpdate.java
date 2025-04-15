package it.prova.motociclettajdbs.test;

import it.prova.motociclettajdbs.dao.MotociclettaDAO;
import it.prova.motociclettajdbs.model.Motocicletta;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUpdate {
    public static void main(String[] args) {
        System.out.println("Inizio test update...");

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();
        Long idDaAggiornare = 2L; // Assicurati che questo ID esista nel DB

        System.out.println("################ TEST update ################");

        try {
            // Creo una moto con ID esistente e modifico i suoi dati
            Motocicletta motoDaAggiornare = new Motocicletta();
            motoDaAggiornare.setId(idDaAggiornare);
            motoDaAggiornare.setMarca("KTM");
            motoDaAggiornare.setModello("Duke 790");
            motoDaAggiornare.setCilindrata(799);

            Date nuovaData = new SimpleDateFormat("dd-MM-yyyy").parse("11-04-2019");
            motoDaAggiornare.setDataImmatricolazione(nuovaData);

            int righeAggiornate = motociclettaDaoInstance.update(motoDaAggiornare);

            if (righeAggiornate > 0) {
                System.out.println("Aggiornamento riuscito: " + righeAggiornate + " riga/e modificata/e.");
            } else {
                throw new AssertionError("Test update: FAILED - nessuna riga modificata - ID non trovato.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test update: FAILED con eccezione.");
        }

        System.out.println("################### TEST update : FINE ###################");
    }
}
