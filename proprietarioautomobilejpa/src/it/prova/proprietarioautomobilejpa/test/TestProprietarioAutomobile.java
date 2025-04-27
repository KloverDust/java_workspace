package it.prova.proprietarioautomobilejpa.test;

import it.prova.proprietarioautomobilejpa.dao.EntityManagerUtil;
import it.prova.proprietarioautomobilejpa.model.Automobile;
import it.prova.proprietarioautomobilejpa.model.Proprietario;
import it.prova.proprietarioautomobilejpa.service.MyServiceFactory;
import it.prova.proprietarioautomobilejpa.service.automobile.AutomobileService;
import it.prova.proprietarioautomobilejpa.service.automobile.AutomobileServiceImpl;
import it.prova.proprietarioautomobilejpa.service.proprietario.ProprietarioService;
import it.prova.proprietarioautomobilejpa.service.proprietario.ProprietarioServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class TestProprietarioAutomobile {

    public static void main(String[] args) {
        ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
        AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();

        try {
            //testCaricaSingoloProprietario(proprietarioService);
            //testCaricaTuttiProprietari(proprietarioService);
            //testAggiornaProprietario(proprietarioService);
            //testInsertProprietario(proprietarioService);
            //testEliminaProprietario(proprietarioService);

            //testCaricaSingolaAutomobile(automobileService);
            //testCaricaTutteAutomobili(automobileService);
            //testAggiornaAutomobile(automobileService);
            //testInserisciNuovaAutomobile(automobileService);
            //testRimuoviAutomobile(automobileService);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {

            EntityManagerUtil.shutdown();
        }
    }

    private static void testInserisciNuovaAutomobile(AutomobileService automobileService) throws Exception {
        Automobile nuovaAuto = new Automobile("Fiat", "Panda", "sjdasakf", 2020);
        automobileService.inserisciNuovaAutomobile(nuovaAuto);
        System.out.println("Inserita: " + nuovaAuto);

    }

    private static void testRimuoviAutomobile(AutomobileService automobileService) throws Exception {
        Automobile auto = new Automobile("Ford", "Focus", "jsfjsj", 2021);
        automobileService.inserisciNuovaAutomobile(auto);
        Long id = auto.getId();

        automobileService.rimuoviAutomobile(id);

        Automobile recuperata = automobileService.caricaSingolaAutomobile(id);
        if (recuperata == null) {
            System.out.println("Test rimozione OK");
        } else {
            throw new Exception("Test rimozione fallito");
        }
    }

    private static void testAggiornaAutomobile(AutomobileService automobileService) throws Exception {
        Automobile auto = new Automobile( "Toyota", "Corolla", "jsdfjs",2022);
        automobileService.inserisciNuovaAutomobile(auto);

        auto.setAnnoImmatricolazione(2023);
        automobileService.aggiornaAutomobile(auto);

        Automobile aggiornata = automobileService.caricaSingolaAutomobile(auto.getId());
        if (aggiornata.getAnnoImmatricolazione() == 2023) {
            System.out.println("Test aggiornamento OK");
        } else {
            throw new Exception("Test aggiornamento fallito");
        }
    }

    private static void testCaricaTutteAutomobili(AutomobileService automobileService) throws Exception {
        System.out.println("Tutte le automobili presenti:");
        List<Automobile> lista = automobileService.caricaTutteAutomobili();
        for (Automobile a : lista) {
            System.out.println(a);
        }

        if (lista != null && !lista.isEmpty()) {
            System.out.println("Test caricamento OK");
        } else {
            throw new Exception("Test caricamento fallito");
        }
    }

    private static void testCaricaSingolaAutomobile(AutomobileService automobileService) throws Exception{
        System.out.println("\n.......testCaricaSingolaAutomobile inizio.............");
        Long idDaCercare = 1L;
        Automobile automobileInstance = null;
        try {
            automobileInstance = automobileService.caricaSingolaAutomobile(idDaCercare);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        if (automobileInstance == null) {
            System.out.println("testCaricaSingolaAutomobile: AUTOMOBILE NON TROVATO");
            throw new Exception("testCaricaSingolaAutomobile: AUTOMOBILE NON TROVATO");
        } else {
            System.out.println("testCaricaSingolaAutomobile: AUTOMOBILE TROVATO");
            System.out.println(automobileInstance);
        }

        System.out.println(".......testCaricaSingolaAutomobile fine: PASSED.............\n");
    }

    private static void testCaricaSingoloProprietario(ProprietarioService proprietarioService) throws Exception{
        System.out.println("\n.......testCaricaSingoloProprietario inizio.............");
        Long idDaCercare = 1L;
        Proprietario proprietarioInstance = null;
        try {
            proprietarioInstance = proprietarioService.caricaSingoloProprietario(idDaCercare);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        if (proprietarioInstance == null) {
            System.out.println("testCaricaSingoloProprietario: PROPRIETARIO NON TROVATO");
            throw new Exception("testCaricaSingoloProprietario: PROPRIETARIO NON TROVATO");
        } else {
            System.out.println("testCaricaSingoloProprietario: PROPRIETARIO TROVATO");
            System.out.println(proprietarioInstance);
        }

        System.out.println(".......testCaricaSingoloProprietario fine: PASSED.............\n");
    }

    private static void testCaricaTuttiProprietari(ProprietarioService proprietarioService) throws Exception {
        System.out.println("\n.......testCaricaTuttiProprietari inizio.............");
        List<Proprietario> listaProprietari = null;
        try {
            listaProprietari = proprietarioService.caricaTuttiProprietari();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        if (listaProprietari == null || listaProprietari.size() == 0) {
            System.out.println("testCaricaTuttiProprietari: NESSUN PROPRIETARIO TROVATO");
            throw new Exception("testCaricaTuttiProprietari: NESSUN PROPRIETARIO TROVATO");
        } else {
            System.out.println("testCaricaTuttiProprietari: PROPRIETARI TROVATI");
            for (Proprietario proprietarioItem : listaProprietari) {
                System.out.println(proprietarioItem);
            }
        }
        System.out.println(".......testCaricaTuttiProprietari fine.............\n");

    }

    private static void testAggiornaProprietario(ProprietarioService proprietarioService) throws Exception{
        System.out.println("\n.......testAggiornaProprietario inizio.............");
        Proprietario proprietarioInstance = null;
        try {
            proprietarioInstance = proprietarioService.caricaSingoloProprietario(1L);
            proprietarioInstance.setNome("Mario");
            proprietarioInstance.setCognome("Cosacchi");
            proprietarioService.aggiornaProprietario(proprietarioInstance);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        if (proprietarioInstance == null) {
            System.out.println("testAggiornaProprietario: PROPRIETARIO NON TROVATO");
            throw new Exception("testAggiornaProprietario: PROPRIETARIO NON TROVATO");
        } else {
            System.out.println("testAggiornaProprietario: PROPRIETARIO AGGIORNATO");
            System.out.println(proprietarioInstance);
        }

        System.out.println(".......testAggiornaProprietario fine: PASSED.............\n");
    }

    private static void testInsertProprietario(ProprietarioService proprietarioService) throws Exception{
        System.out.println("\n.......testInsertProprietario inizio.............");
        Proprietario proprietarioInstance = new Proprietario("Mario", "Rossi", "1234567890", LocalDate.of(1980,1,1));
        try {
            proprietarioService.inserisciNuovoProprietario(proprietarioInstance);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        System.out.println(".......testInsertProprietario fine: PASSED.............\n");
    }

    private static void testEliminaProprietario(ProprietarioService proprietarioService) throws Exception {
        System.out.println("\n.......testEliminaProprietario inizio.............");
        Proprietario proprietarioInstance = null;
        try {
            //proprietarioInstance = proprietarioService.caricaSingoloProprietario(4L);
            proprietarioService.rimuoviProprietario(4L);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }



}
