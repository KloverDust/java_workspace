package it.atletasportjpa.test;

import java.time.LocalDate;
import java.util.List;

import it.atletasportjpa.dao.EntityManagerUtil;
import it.atletasportjpa.model.Atleta;
import it.atletasportjpa.model.NomiSport;
import it.atletasportjpa.model.Sport;
import it.atletasportjpa.service.AtletaService;
import it.atletasportjpa.service.MyServiceFactory;
import it.atletasportjpa.service.SportService;

public class TestAtletaSport {

    public static void main(String[] args) {
        AtletaService atletaService = MyServiceFactory.getAtletaServiceInstance();
        SportService sportService = MyServiceFactory.getSportServiceInstance();

        try {
            //testCaricaTuttiAtleti(atletaService); //OK
            //testCaricaSingoloAtleta(atletaService); //OK
            //testInserisciNuovoAtleta(atletaService); //OK
            //testAggiornaAtleta(atletaService); //OK
            //testCaricaSingoloAtletaConSport(atletaService); //OK
            //testRimuoviAtleta(atletaService); //OK

            //testCaricaTuttiSport(sportService); //OK
            //testCaricaSportDaId(sportService); //OK
            //testCaricaSportDaDescrizione(sportService); //OK
            //testAggiornaSport(sportService); //OK
            //testRimuoviSport(sportService); //OK

            //testAggiungiSportAdAtleta(sportService, atletaService); //OK
            //testRimuoviSportDaAtleta(sportService, atletaService); //OK
            //testRimuoviAtletaDopoScollegamentoDaSport(sportService, atletaService); //NOT OK
            //testTrovaSportConDateIncoerenti(sportService);
            testSommaMedaglieAtletiSportFiniti(atletaService, sportService);

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            EntityManagerUtil.shutdown();
        }
    }


    private static void testInserisciNuovoAtleta(AtletaService atletaService) throws Exception {
        System.out.println("... testInserisciNuovoAtleta inizio ...");

        Atleta atleta = new Atleta("Eleonora", "Colonnelli", LocalDate.of(1998, 11, 4));
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
        for (Atleta atleta : lista) {
            System.out.println(atleta.toString());
        }
        System.out.println("... testCaricaTuttiAtleti PASS ...");
    }

    private static void testCaricaSingoloAtleta(AtletaService atletaService) throws Exception {
        System.out.println("... testCaricaSingoloAtleta inizio ...");

        Atleta primo = atletaService.caricaTuttiAtleti().get(0);
        Atleta loaded = atletaService.caricaSingoloAtleta(primo.getId());
        if (loaded == null || !loaded.getId().equals(primo.getId())) {
            throw new RuntimeException("testCaricaSingoloAtleta fallito");
        } else {
            System.out.println("Atleta caricato: " + loaded.toString());
        }

        System.out.println("... testCaricaSingoloAtleta PASS ...");
    }

    private static void testAggiornaAtleta(AtletaService atletaService) throws Exception {
        System.out.println("... testAggiornaAtleta inizio ...");

        Atleta atleta = atletaService.caricaTuttiAtleti().get(0);
        String oldNome = atleta.getNome();
        atleta.setNome(oldNome + "_aggiornato");
        atletaService.aggiornaAtleta(atleta);

        Atleta updated = atletaService.caricaSingoloAtleta(atleta.getId());
        if (updated.getNome().equals(oldNome)) {
            throw new RuntimeException("testAggiornaAtleta fallito: nome non cambiato");
        } else {
            System.out.println("Atleta aggiornato: " + updated.toString());
        }

        System.out.println("... testAggiornaAtleta PASS ...");
    }

    private static void testCaricaSingoloAtletaConSport(AtletaService atletaService) throws Exception {
        System.out.println("... testCaricaSingoloAtletaConSport inizio ...");

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

    private static void testInserisciNuovoSport(SportService sportService) throws Exception {
        System.out.println("... testInserisciNuovoSport inizio ...");
        String desc = "CALCIO";
        sportService.inserisciNuovoSport(desc);
        List<Sport> sportList = sportService.caricaSportDaDescrizione(desc);
        if (sportList.isEmpty() || !sportList.get(0).getDescrizione().name().equals(desc)) {
            throw new RuntimeException("testInserisciNuovoSport fallito");
        }
        System.out.println("... testInserisciNuovoSport PASS (" + sportList.get(0) + ")");
    }


    private static void testCaricaTuttiSport(SportService sportService) throws Exception {
        System.out.println("... testCaricaTuttiSport inizio ...");
        List<Sport> lista = sportService.caricaTuttiSport();
        if (lista.isEmpty()) {
            throw new RuntimeException("testCaricaTuttiSport fallito: lista vuota");
        }
        System.out.println("Trovati " + lista.size() + " sport:");
        for (Sport s : lista) {
            System.out.println("  " + s);
        }
        System.out.println("... testCaricaTuttiSport PASS ...");
    }

    private static void testCaricaSportDaId(SportService sportService) throws Exception {
        System.out.println("... testCaricaSportDaId inizio ...");
        Sport primo = sportService.caricaTuttiSport().get(0);
        Sport loaded = sportService.caricaSportDaId(primo.getId());
        if (loaded == null || !loaded.getId().equals(primo.getId())) {
            throw new RuntimeException("testCaricaSportDaId fallito");
        }
        System.out.println("... testCaricaSportDaId PASS (" + loaded + ") ...");
    }

    private static void testCaricaSportDaDescrizione(SportService sportService) throws Exception {
        System.out.println("... testCaricaSportDaDescrizione inizio ...");
        String desc = sportService.caricaTuttiSport().get(0).getDescrizione().name();
        List<Sport> sportList = sportService.caricaSportDaDescrizione(desc);
        if (sportList.isEmpty() || !sportList.get(0).getDescrizione().name().equals(desc)) {
            throw new RuntimeException("testCaricaSportDaDescrizione fallito");
        }
        System.out.println("... testCaricaSportDaDescrizione PASS (" + sportList.get(0) + ") ...");
    }


    private static void testAggiornaSport(SportService sportService) throws Exception {
        System.out.println("... testAggiornaSport inizio ...");
        sportService.inserisciNuovoSport("CORSA");

        List<Sport> sportList = sportService.caricaSportDaDescrizione("CORSA");
        if (sportList.isEmpty()) {
            throw new RuntimeException("Nessuno sport trovato con descrizione CORSA");
        }
        Sport s = sportList.get(0);
        Long id = s.getId();

        sportService.aggiornaSport(id, "TENNIS");
        Sport updated = sportService.caricaSportDaId(id);

        if (!"TENNIS".equals(updated.getDescrizione().name())) {
            throw new RuntimeException("testAggiornaSport fallito");
        }
        System.out.println("... testAggiornaSport PASS (" + updated + ") ...");
    }


    private static void testRimuoviSport(SportService sportService) throws Exception {
        System.out.println("... testRimuoviSport inizio ...");
        sportService.inserisciNuovoSport("BASKET");
        List<Sport> sportList = sportService.caricaSportDaDescrizione("BASKET");
        if (sportList.isEmpty()) {
            throw new RuntimeException("Nessuno sport trovato con descrizione BASKET");
        }
        Sport s = sportList.get(0);
        Long id = s.getId();

        sportService.rimuoviSport(id);
        Sport shouldBeNull = sportService.caricaSportDaId(id);
        if (shouldBeNull != null) {
            throw new RuntimeException("testRimuoviSport fallito: sport ancora presente");
        }
        System.out.println("... testRimuoviSport PASS ...");
    }

    private static void testAggiungiSportAdAtleta(SportService sportService, AtletaService atletaService) throws Exception {
        System.out.println("... testAggiungiSportAdAtleta inizio ...");

        Atleta atleta = new Atleta("Luca", "Neri", LocalDate.of(1992, 2, 2));
        atletaService.inserisciNuovoAtleta(atleta);
        Long atletaId = atleta.getId();

        String descr = "TENNIS";
        List<Sport> lista = sportService.caricaSportDaDescrizione(descr);
        Sport s;
        if (lista.isEmpty()) {
            sportService.inserisciNuovoSport(descr);
            lista = sportService.caricaSportDaDescrizione(descr);
        }
        if (lista.isEmpty()) {
            throw new RuntimeException("testAggiungiSportAdAtleta fallito: nessuno sport creato");
        }
        s = lista.get(0);

        atleta.getSportPraticati().add(s);
        sportService.aggiungiSportAdAtleta(atleta);

        Atleta reload = atletaService.caricaSingoloAtletaConSport(atletaId);
        boolean found = reload.getSportPraticati().stream()
                .anyMatch(x -> x.getId().equals(s.getId()));
        if (!found) {
            throw new RuntimeException("testAggiungiSportAdAtleta fallito: associazione non presente");
        }

        System.out.println("... testAggiungiSportAdAtleta PASS (trovato sport " + s + " per atleta " + reload + ") ...");
    }

    private static void testRimuoviSportDaAtleta(SportService sportService, AtletaService atletaService) throws Exception {
        System.out.println("... testRimuoviSportDaAtleta inizio ...");

        Atleta atleta = atletaService.caricaTuttiAtleti().get(0);
        Atleta withSport = atletaService.caricaSingoloAtletaConSport(atleta.getId());
        if (withSport.getSportPraticati().isEmpty()) {
            throw new RuntimeException("testRimuoviSportDaAtleta fallito: atleta senza sport");
        }

        sportService.rimuoviSportDaAtleta(withSport);

        Atleta reload = atletaService.caricaSingoloAtletaConSport(withSport.getId());
        if (!reload.getSportPraticati().isEmpty()) {
            throw new RuntimeException("testRimuoviSportDaAtleta fallito: sport ancora presenti");
        }

        System.out.println("... testRimuoviSportDaAtleta PASS ...");
    }

    private static void testRimuoviAtletaDopoScollegamentoDaSport(SportService sportService, AtletaService atletaService) throws Exception {
        System.out.println("... testRimuoviAtletaDopoScollegamentoDaSport inizio ...");

        Atleta atleta = new Atleta("Anna", "Verdi", LocalDate.of(1995, 5, 5));
        atletaService.inserisciNuovoAtleta(atleta);
        Long atletaId = atleta.getId();

        List<Sport> lista = sportService.caricaSportDaDescrizione("PALLAVOLO");
        Sport s;
        if (lista.isEmpty()) {
            sportService.inserisciNuovoSport("PALLAVOLO");
            lista = sportService.caricaSportDaDescrizione("PALLAVOLO");
        }
        if (lista.isEmpty()) {
            throw new RuntimeException("testRimuoviAtletaDopoScollegamentoDaSport fallito: nessuno sport creato");
        }
        s = lista.get(0);

        atleta.getSportPraticati().add(s);
        sportService.aggiungiSportAdAtleta(atleta);

        sportService.rimuoviAtletaDopoScollegamentoDaSport(atleta);

        Atleta shouldBeNull = atletaService.caricaSingoloAtleta(atletaId);
        if (shouldBeNull != null) {
            throw new RuntimeException("testRimuoviAtletaDopoScollegamentoDaSport fallito: atleta ancora presente");
        }

        System.out.println("... testRimuoviAtletaDopoScollegamentoDaSport PASS ...");
    }

    private static void testTrovaSportConDateIncoerenti(SportService sportService) throws Exception {
        System.out.println("... testTrovaSportConDateIncoerenti inizio ...");


        Sport corretto = new Sport(NomiSport.CALCIO, LocalDate.of(2020,1,1), LocalDate.of(2020,12,31));
        Sport incoerente = new Sport(NomiSport.CORSA, LocalDate.of(2021,6,1), LocalDate.of(2021,5,1));

        sportService.inserisciNuovoSport(corretto.getDescrizione().name());
        sportService.inserisciNuovoSport(incoerente.getDescrizione().name());

        List<Sport> tutti = sportService.caricaTuttiSport();
        for (Sport s : tutti) {
            if (s.getId().equals(corretto.getId())) {
                sportService.aggiornaSport(s.getId(), corretto.getDescrizione().name());
            }
            if (s.getId().equals(incoerente.getId())) {
            }
        }

        List<Sport> errore = sportService.trovaSportConDateIncoerenti();
        if (errore.isEmpty()) {
            throw new RuntimeException("testTrovaSportConDateIncoerenti fallito: lista vuota");
        }
        boolean found = errore.stream()
                .anyMatch(s -> s.getDescrizione() == NomiSport.CORSA);
        if (!found) {
            throw new RuntimeException("testTrovaSportConDateIncoerenti fallito: CORSA non in lista");
        }

        System.out.println("... testTrovaSportConDateIncoerenti PASS: " + errore);
    }

    private static void testSommaMedaglieAtletiSportFiniti(AtletaService atletaService,
                                                           SportService sportService) throws Exception {
        System.out.println("... testSommaMedaglieAtletiSportFiniti inizio ...");

        String desc = "NUOTO";
        sportService.inserisciNuovoSport(desc);
        Sport s = sportService.caricaSportDaDescrizione(desc).get(0);

        Atleta a1 = new Atleta("Marco", "Rossi", LocalDate.of(1990, 1,1));
        a1.setNumeroMedaglieVinte(3);
        a1.getSportPraticati().add(s);
        atletaService.inserisciNuovoAtleta(a1);

        Atleta a2 = new Atleta("Francesca", "Bianchi", LocalDate.of(1992, 2,2));
        a2.setNumeroMedaglieVinte(5);
        a2.getSportPraticati().add(s);
        atletaService.inserisciNuovoAtleta(a2);

        Long somma = atletaService.calcolaSommaMedaglieAtletiSportFiniti();
        if (somma == null || somma != 8L) {
            throw new RuntimeException("testSommaMedaglieAtletiSportFiniti fallito: atteso 8, ottenuto " + somma);
        }

        System.out.println("... testSommaMedaglieAtletiSportFiniti PASS: totale=" + somma + " ...");
    }

}
