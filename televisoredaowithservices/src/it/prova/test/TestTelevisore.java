package it.prova.test;

import it.prova.model.Televisore;
import it.prova.service.MyServiceFactory;
import it.prova.service.televisore.TelevisoreService;

import java.time.LocalDate;
import java.util.List;

public class TestTelevisore {

    public static void main(String[] args) {
        TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceImpl();

        try {
            /// INIZIO TEST INSERT ///
            //System.out.println("\nPrima del test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.");
            //testInserimentoNuovoTelevisore(televisoreService);
            //System.out.println("Dopo il test, in tabella ci sono " + televisoreService.listAll().size() + " elementi. \n");
            /// FINE TEST INSERT ///

            /// INIZIO TEST GET ///
            //System.out.println("\nPrima del test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.");
            //testGetTelevisorePerId(televisoreService);
            //System.out.println("Dopo il test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.\n");
            /// FINE TEST GET ///

            /// INIZIO TEST UPDATE ///
            //System.out.println("\nPrima del test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.");
            //testUpdateTelevisore(televisoreService);
            //System.out.println("Dopo il test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.\n");
            /// FINE TEST UPDATE ///

            /// INIZIO TEST DELETE ///
            //System.out.println("\nPrima del test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.");
            //testDeleteTelevisore(televisoreService);
            //System.out.println("Dopo il test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.\n");
            /// FINE TEST DELETE ///

            /// INIZIO TELEVISOREPIUGRANDE ///
            //System.out.println("\nPrima del test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.");
            //testTelevisorePiuGrande(televisoreService);
            //System.out.println("Dopo il test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.\n");
            /// FINE TEST TELEVISOREPIUGRANDE ///

            /// INIZIO testTrovaProdottiInIntervallo ///
            //System.out.println("\nPrima del test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.");
            //testTrovaProdottiInIntervallo(televisoreService);
            //System.out.println("Dopo il test, in tabella ci sono " + televisoreService.listAll().size() + " elementi.\n");
            /// FINE TEST testTrovaProdottiInIntervallo ///

            /// INIZIO testListaDistintaMarcheUltimi6Mesi ///
            testListaDistintaMarcheUltimi6Mesi(televisoreService);
            /// FINE testListaDistintaMarcheUltimi6Mesi ///


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void testListaDistintaMarcheUltimi6Mesi(TelevisoreService televisoreService) throws Exception {
        System.out.println("<------testListaDistintaMarcheUltimi6Mesi INIZIO ------->");

        LocalDate dataRiferimento = LocalDate.now();
        List<Televisore> televisori = televisoreService.listaDistintaMarcheUltimi6Mesi(dataRiferimento);

        if (televisori == null || televisori.isEmpty()) {
            System.out.println("Nessun televisore trovato negli ultimi 6 mesi rispetto a " + dataRiferimento);
        } else {
            System.out.println("Televisori prodotti negli ultimi 6 mesi:");
            for (Televisore tv : televisori) {
                System.out.println(tv);
            }
        }

        System.out.println("<------testListaDistintaMarcheUltimi6Mesi PASSED-END ------->");
    }


    private static void testTrovaProdottiInIntervallo(TelevisoreService televisoreService) throws Exception {
        System.out.println("<------testTrovaProdottiInIntervallo INIZIO ------->");

        LocalDate inizio = LocalDate.parse("1960-01-01");
        LocalDate fine = LocalDate.parse("2024-12-12");

        List<Televisore> televisoriNellIntervallo = televisoreService.trovaProdottiInIntervallo(inizio, fine);

        if (televisoriNellIntervallo == null || televisoriNellIntervallo.isEmpty()) {
            System.out.println("Nessun televisore trovato nell'intervallo tra " + inizio + " e " + fine);
        } else {
            System.out.println("Televisori trovati nell'intervallo:");
            for (Televisore tv : televisoriNellIntervallo) {
                System.out.println(tv);
            }
        }

        System.out.println("<------testTrovaProdottiInIntervallo PASSED-END ------->");
    }


    private static void testDeleteTelevisore(TelevisoreService televisoreService) throws Exception {
        System.out.println("<------testDeleteTelevisore INIZIO ------->");

        Long idDaRimuovere = 15L;

        int deleteResult = televisoreService.rimuovi(idDaRimuovere);
        if (deleteResult != 1)
            throw new RuntimeException("<-------testDeleteTelevisore FAILED: delete fallita ------>");

        Televisore verificaCancellazione = televisoreService.findById(idDaRimuovere);
        if (verificaCancellazione != null)
            throw new RuntimeException("<-------testDeleteTelevisore FAILED: il televisore risulta ancora presente ------>");

        System.out.println("E' stato correttamente eliminato il televisore con ID " + idDaRimuovere);
        System.out.println("<------testDeleteTelevisore PASSED-END ------->");
    }


    private static void testGetTelevisorePerId(TelevisoreService televisoreService) throws Exception{
        System.out.println("<------testGetTelevisorePerId INIZIO ------->");

        Long idDaRicercare = 1L;
        Televisore televisoreTrovato = televisoreService.findById(idDaRicercare);
        if (televisoreTrovato == null)
            throw new RuntimeException("<-------testGetTelevisorePerId FAILED: nessun televisore trovato ------>");
        else {
            System.out.println("E' stato correttamente trovato un televisore " + televisoreTrovato.toString());
        }

        System.out.println("<------testGetTelevisorePerId PASSED-END ------->");
    }

    private static void testUpdateTelevisore(TelevisoreService televisoreService) throws Exception {
        System.out.println("<------testUpdateTelevisore INIZIO ------->");
        Long idTelevisoreDaModificare = 1L;
        Televisore televisoreDaModificare = televisoreService.findById(idTelevisoreDaModificare);
        televisoreDaModificare.setPollici(100);

        if (televisoreService.aggiorna(televisoreDaModificare) != 1)
            throw new RuntimeException("<-------testUpdateTelevisore FAILED ------>");
        else {
            System.out.println("E' stato correttamente modificato il televisore " + televisoreDaModificare.toString());
        }

        System.out.println("<------testUpdateTelevisore PASSED-END ------->");
    }

    private static void testInserimentoNuovoTelevisore(TelevisoreService televisoreService) throws Exception{
        System.out.println("<------testInserimentoNuovoTelevisore INIZIO ------->");
        Televisore nuovoTelevisore = new Televisore("LG", "LGHDR55", 55);

        if (televisoreService.inserisciNuovo(nuovoTelevisore) != 1)
            throw new RuntimeException("<-------testInserimentoNuovoUser FAILED ------>");
        else {
            System.out.println("E' stato correttamente inserito il televisore " + nuovoTelevisore.toString());
        }

        System.out.println("<------testInserimentoNuovoUser PASSED-END ------->");
    }

    private static void testTelevisorePiuGrande(TelevisoreService televisoreService) throws Exception {
        System.out.println("<------testTelevisorePiuGrande INIZIO ------->");

        Televisore televisorePiuGrande = televisoreService.trovaIlPiuGrande();

        if (televisorePiuGrande != null) {
            System.out.println("Il televisore con il maggior numero di pollici è: " + televisorePiuGrande.toString());
        } else {
            throw new RuntimeException("<-------testTelevisorePiuGrande FAILED: nessun televisore trovato ------>");
        }

        System.out.println("<------testTelevisorePiuGrande PASSED-END ------->");
    }




}


