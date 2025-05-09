package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.DipendenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BatteriaTestSocieta {
    @Autowired 
    private SocietaService societaService;

    @Autowired
    private DipendenteService dipendenteService;


    public void testInserisciNuovaSocieta() throws Exception {
        Societa nuovaSocieta = new Societa("YSL", "Via dei Marmi", LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1));
        societaService.inserisciNuovo(nuovaSocieta);

        if (nuovaSocieta.getId() == null || nuovaSocieta.getId() < 1)
            throw new RuntimeException("testInserisciNuovaSocieta...failed: inserimento fallito");

        System.out.println("testInserisciNuovaSocieta........OK");
    }

    public void testCercaPerExample() throws Exception {
        Societa nuova = new Societa(
                "MANGO",
                "Via dei Test",
                LocalDate.of(2021, 5, 5),
                null
        );
        if (nuova.getId() != null) {
            throw new RuntimeException("testCercaPerExample...failed: transient object con id già valorizzato");
        }
        societaService.inserisciNuovo(nuova);
        if (nuova.getId() == null || nuova.getId() < 1) {
            throw new RuntimeException("testCercaPerExample...failed: inserimento fallito");
        }

        Societa example = new Societa();
        example.setRagioneSociale("MANGO");
        List<Societa> result = societaService.findByExample(example);

        if (result == null) {
            throw new RuntimeException("testCercaPerExample...failed: result è null");
        }
        if (result.isEmpty()) {
            throw new RuntimeException(
                    "testCercaPerExample...failed: nessuna Societa trovata per ragioneSociale 'MANGO'"
            );
        }

        boolean found = false;
        for (Societa s : result) {
            if (nuova.getId().equals(s.getId())
                    && "MANGO".equals(s.getRagioneSociale())) {
                found = true;
            }
            else if (!s.getRagioneSociale().contains("MANGO")) {
                throw new RuntimeException(
                        "testCercaPerExample...failed: elemento inatteso '" + s.getRagioneSociale() + "'"
                );
            }
        }
        if (!found) {
            throw new RuntimeException(
                    "testCercaPerExample...failed: la Societa inserita non è presente nei risultati"
            );
        }

        societaService.rimuovi(nuova.getId());

        System.out.println("testCercaPerExample........OK");
    }

    public void testRimuoviSocieta() throws Exception {
        //Prova eliminazione con societa senza dipendenti
        Societa s1 = new Societa("TEST_NO_DIP", "Via Senza Dipendenti", LocalDate.of(2022, 6, 1), null);
        societaService.inserisciNuovo(s1);
        Long id1 = s1.getId();

        boolean rimosso = societaService.rimuoviSocieta(id1);
        if (rimosso != true) {
            throw new RuntimeException("testRimuoviSocieta...failed: aspettavo delete=1 ma ho ricevuto " + rimosso);
        }

        if (societaService.caricaSingoloSocieta(id1) != null) {
            throw new RuntimeException(
                    "testRimuoviSocieta...failed: la società con id " + id1 + " è ancora presente"
            );
        }
        System.out.println("testRimuoviSocieta (nessun dipendente)........OK");

        //Prova eliminazione di societa con dipendenti
        Societa s2 = new Societa("TEST_CON_DIP", "Via Con Dipendenti", LocalDate.of(2022, 7, 1), null);
        societaService.inserisciNuovo(s2);
        Long id2 = s2.getId();

        Dipendente d = new Dipendente("Mario", "Rossi", LocalDate.of(2023, 1, 15), 30000L);
        d.setSocieta(s2);
        dipendenteService.inserisciNuovo(d);

        try {
            societaService.rimuoviSocieta(id2);
            throw new RuntimeException(
                    "testRimuoviSocieta...failed"
            );
        } catch (IllegalStateException ex) {
            System.out.println(
                    "testRimuoviSocieta (dipendenti presenti)........OK"
            );
        }
    }

    public void testInserimentoDipendenteInSocieta() throws Exception {
        Societa s = new Societa("TEST_INS_DIP8", "Via del Test", LocalDate.of(2020, 1, 1), null);
        societaService.inserisciNuovo(s);
        Long idSoc = s.getId();

        // 1) CASO Happy path
        Dipendente dip = new Dipendente("Luigi", "Verdi", LocalDate.of(2021, 2, 1), 25000L);
        boolean ok = societaService.inserisciDipendenteInSocieta(idSoc, dip);
        if (!ok) {
            throw new RuntimeException(
                    "testInserimentoDipendenteInSocieta...failed: expected true but got " + ok
            );
        }

        if (dip.getId() == null) {
            throw new RuntimeException(
                    "testInserimentoDipendenteInSocieta...failed: dipendente non salvato"
            );
        }
        if (!idSoc.equals(dip.getSocieta().getId())) {
            throw new RuntimeException(
                    "testInserimentoDipendenteInSocieta...failed: societa non associata"
            );
        }
        System.out.println("testInserimentoDipendenteInSocieta........OK");

        // 2) CASO “data antecedente”: deve fallire
        Dipendente dip2 = new Dipendente("Mario", "Blu", LocalDate.of(2019, 12, 31));  // prima del 2020-01-0120000L);
        try {
            societaService.inserisciDipendenteInSocieta(idSoc, dip2);
            throw new RuntimeException(
                    "testInserimentoDipendenteInSocieta...failed: eccezione non sollevata per data antecedente"
            );
        } catch (RuntimeException ex) {
            System.out.println(
                    "testInserimentoDipendenteInSocieta (data antecedente)........OK"
            );
        }

        // 3) CASO “societa inesistente”: deve lanciare EntityNotFoundException
        Dipendente dip3 = new Dipendente("Anna", "Rossi", LocalDate.now(), 18000L);
        try {
            societaService.inserisciDipendenteInSocieta(999999L, dip3);
            throw new RuntimeException(
                    "testInserimentoDipendenteInSocieta...failed: eccezione non sollevata per societa inesistente"
            );
        } catch (EntityNotFoundException ex) {
            System.out.println(
                    "testInserimentoDipendenteInSocieta (societa inesistente)........OK"
            );
        }
    }



}
