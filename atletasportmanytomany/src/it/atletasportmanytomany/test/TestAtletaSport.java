package it.atletasportmanytomany.test;

import java.time.LocalDate;
import java.util.List;

import it.atletasportmanytomany.dao.EntityManagerUtil;
import it.atletasportmanytomany.model.Atleta;
import it.atletasportmanytomany.service.AtletaService;
import it.atletasportmanytomany.service.MyServiceFactory;
import it.atletasportmanytomany.service.SportService;

public class TestAtletaSport {

    public static void main(String[] args) {
        AtletaService atletaService = MyServiceFactory.getAtletaServiceInstance();
        SportService sportService = MyServiceFactory.getSportServiceInstance();

        try {
            testInserisciNuovoAtleta(atletaService);
            testCaricaTuttiAtleti(atletaService);
            testCaricaSingoloAtleta(atletaService);
            testAggiornaAtleta(atletaService);
            testCaricaSingoloAtletaConSport(atletaService);
            testRimuoviAtleta(atletaService);

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            EntityManagerUtil.shutdown();
        }
    }

    private static void testInserisciNuovoAtleta(AtletaService atletaService) throws Exception {
        System.out.println("... testInserisciNuovoAtleta inizio ...");

        Atleta atleta = new Atleta("Mario", "Rossi", LocalDate.of(1990, 5, 15));
        atletaService.inserisciNuovoAtleta(atleta);
        if (atleta.getId() == null) {
            throw new RuntimeException("testInserisciNuovoAtleta fallito: id non valorizzato");
        }

        System.out.println("... testInserisciNuovoAtleta PASS ...");
    }

    private static void testCaricaTuttiAtleti(AtletaService atletaService) throws Exception {
        System.out.println("... testCaricaTuttiAtleti inizio ...");

        List<Atleta> lista = atletaService.caricaTuttiAtleti();
        if (lista.isEmpty()) {
            throw new RuntimeException("testCaricaTuttiAtleti fallito: lista vuota");
        }
        System.out.println("Trovati " + lista.size() + " atleti");
        System.out.println("... testCaricaTuttiAtleti PASS ...");
    }

    private static void testCaricaSingoloAtleta(AtletaService atletaService) throws Exception {
        System.out.println("... testCaricaSingoloAtleta inizio ...");

        Atleta primo = atletaService.caricaTuttiAtleti().get(0);
        Atleta loaded = atletaService.caricaSingoloAtleta(primo.getId());
        if (loaded == null || !loaded.getId().equals(primo.getId())) {
            throw new RuntimeException("testCaricaSingoloAtleta fallito");
        }

        System.out.println("... testCaricaSingoloAtleta PASS ...");
    }

    private static void testAggiornaAtleta(AtletaService atletaService) throws Exception {
        System.out.println("... testAggiornaAtleta inizio ...");

        Atleta atleta = atletaService.caricaTuttiAtleti().get(0);
        String oldNome = atleta.getNome();
        atleta.setNome(oldNome + "_UPDATED");
        atletaService.aggiornaAtleta(atleta);

        Atleta updated = atletaService.caricaSingoloAtleta(atleta.getId());
        if (updated.getNome().equals(oldNome)) {
            throw new RuntimeException("testAggiornaAtleta fallito: nome non cambiato");
        }

        System.out.println("... testAggiornaAtleta PASS ...");
    }

    private static void testCaricaSingoloAtletaConSport(AtletaService atletaService) throws Exception {
        System.out.println("... testCaricaSingoloAtletaConSport inizio ...");

        // prendo un atleta esistente
        Atleta atleta = atletaService.caricaTuttiAtleti().get(0);
        Atleta loaded = atletaService.caricaSingoloAtletaConSport(atleta.getId());

        if (loaded == null) {
            throw new RuntimeException("testCaricaSingoloAtletaConSport fallito: atleta nullo");
        }
        if (loaded.getSportPraticati() == null) {
            throw new RuntimeException("testCaricaSingoloAtletaConSport fallito: sportPraticati è null");
        }

        System.out.println("Atleta con id " + loaded.getId() + " usa "
                + loaded.getSportPraticati().size() + " sport (lazy-loaded).");
        System.out.println("... testCaricaSingoloAtletaConSport PASS ...");
    }

    private static void testRimuoviAtleta(AtletaService atletaService) throws Exception {
        System.out.println("... testRimuoviAtleta inizio ...");

        Atleta atleta = new Atleta("Da", "Rimuovere", LocalDate.now());
        atletaService.inserisciNuovoAtleta(atleta);
        Long id = atleta.getId();

        atletaService.rimuoviAtleta(id);

        Atleta shouldBeNull = atletaService.caricaSingoloAtleta(id);
        if (shouldBeNull != null) {
            throw new RuntimeException("testRimuoviAtleta fallito: atleta ancora presente");
        }

        System.out.println("... testRimuoviAtleta PASS ...");
    }
}
