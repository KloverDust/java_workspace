package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatteriaTestDipendente {

    @Autowired
    private SocietaService societaService;

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private ProgettoService progettoService;

    public void testCollegaProgettoADipendenti() throws Exception {
        List<Dipendente> dipendenti = new ArrayList<>();

        // Dipendente 1
        Societa soc1 = new Societa("Ferrarelle", "Via delle acque 14", LocalDate.of(2021,1,1), LocalDate.of(2027,10,10));
        societaService.inserisciNuovo(soc1);
        if (soc1.getId() == null || soc1.getId() < 1) {
            throw new Exception("Società non inserita");
        }
        Dipendente dip1 = new Dipendente("Mario", "Rossi", LocalDate.of(2020, 5, 10), 28000L);
        dip1.setSocieta(soc1);
        dipendenteService.inserisciNuovo(dip1);
        if (dip1.getId() == null || dip1.getId() < 1) {
            throw new Exception("Dipendente 1 non inserito");
        }
        dipendenti.add(dip1);

        // Dipendente 2
        Societa soc2 = new Societa("TechSpa", "Via del Tech 2", LocalDate.of(2019,3,3), LocalDate.of(2030,12,31));
        societaService.inserisciNuovo(soc2);
        if (soc2.getId() == null || soc2.getId() < 1) {
            throw new Exception("Società 2 non inserita");
        }
        Dipendente dip2 = new Dipendente("Luigi", "Verdi", LocalDate.of(2019, 8, 20), 30000L);
        dip2.setSocieta(soc2);
        dipendenteService.inserisciNuovo(dip2);
        if (dip2.getId() == null || dip2.getId() < 1) {
            throw new Exception("Dipendente 2 non inserito");
        }
        dipendenti.add(dip2);

        // Dipendente 3
        Societa soc3 = new Societa("InnovateX", "Piazza Nuova 5", LocalDate.of(2022,2,2), LocalDate.of(2029,11,11));
        societaService.inserisciNuovo(soc3);
        if (soc3.getId() == null || soc3.getId() < 1) {
            throw new Exception("Società 3 non inserita");
        }
        Dipendente dip3 = new Dipendente("Anna", "Bianchi", LocalDate.of(2021, 1, 15), 32000L);
        dip3.setSocieta(soc3);
        dipendenteService.inserisciNuovo(dip3);
        if (dip3.getId() == null || dip3.getId() < 1) {
            throw new Exception("Dipendente 3 non inserito");
        }
        dipendenti.add(dip3);

        // preparo il progetto
        Progetto progetto = new Progetto("ProgettoX", "ClienteX", 12);
        progettoService.inserisciNuovo(progetto);
        if (progetto.getId() == null || progetto.getId() < 1) {
            throw new Exception("Progetto non inserito");
        }

        progettoService.collegaProgettoADipendenti(progetto.getId(), dipendenti);
    }

    public void testTrovaDipendentePiuVecchioConSocietaEProgettiVecchi() throws Exception { // Rimosso throws Exception se il service lancia RuntimeException
        System.out.println("\n******* Inizio Test testTrovaDipendentePiuVecchioConSocietaEProgettiVecchi *******");

        // Società pre-1990
        Societa socVecchia = new Societa("Antica SRL", "Via Storica 1", LocalDate.of(1985, 5, 5), null);
        societaService.inserisciNuovo(socVecchia);
        if (socVecchia.getId() == null) throw new RuntimeException("Setup fallito: Societa Vecchia");

        // Progetto lungo >= 6 mesi
        Progetto projLungo = new Progetto("ProgettoImportante", "Cliente Top", 12); // >= 6
        progettoService.inserisciNuovo(projLungo);
        if (projLungo.getId() == null) throw new RuntimeException("Setup fallito: Progetto Lungo");

        // Progetto corto < 6 mesi
        Progetto projCorto = new Progetto("ProgettoRapido", "Cliente Occasionale", 3); // < 6
        progettoService.inserisciNuovo(projCorto);
        if (projCorto.getId() == null) throw new RuntimeException("Setup fallito: Progetto Corto");

        // 1. Il candidato atteso: Assunto prima, soc vecchia, progetto lungo
        Dipendente dipAtteso = new Dipendente("Anna", "Anziana", LocalDate.of(2010, 3, 15), 40000L);
        dipAtteso.setSocieta(socVecchia);
        dipendenteService.inserisciNuovo(dipAtteso);
        if (dipAtteso.getId() == null) throw new RuntimeException("Setup fallito: Dipendente Atteso");

        // 2. Candidato valido ma assunto dopo: soc vecchia, progetto lungo
        Dipendente dipValidoMaGiovane = new Dipendente("Bruno", "Breve", LocalDate.of(2015, 8, 10), 38000L);
        dipValidoMaGiovane.setSocieta(socVecchia);
        dipendenteService.inserisciNuovo(dipValidoMaGiovane);
        if (dipValidoMaGiovane.getId() == null) throw new RuntimeException("Setup fallito: Dipendente Valido Ma Giovane");

        // 3. Candidato scartato per progetto corto: assunto prima, soc vecchia, progetto corto
        Dipendente dipScartatoProj = new Dipendente("Diana", "Datata", LocalDate.of(2008, 11, 5), 42000L);
        dipScartatoProj.setSocieta(socVecchia);
        dipendenteService.inserisciNuovo(dipScartatoProj);
        if (dipScartatoProj.getId() == null) throw new RuntimeException("Setup fallito: Dipendente Scartato Proj");

        progettoService.collegaProgettoADipendenti(projLungo.getId(), List.of(dipAtteso, dipValidoMaGiovane));
        progettoService.collegaProgettoADipendenti(projCorto.getId(), List.of(dipScartatoProj));


        Dipendente dipendenteTrovato = null;
        try {
            dipendenteTrovato = dipendenteService.trovaDipendentePiuVecchioPerProgettoESocietaVecchi();
            System.out.println("Dipendente trovato: " + dipendenteTrovato);
        } catch (RuntimeException e) { // Cattura l'eccezione specifica lanciata da orElseThrow
            e.printStackTrace();
            throw new RuntimeException("TEST FALLITO: Eccezione inattesa lanciata! " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("TEST FALLITO: Eccezione generica inattesa lanciata! " + e.getMessage());
        }

        // Verifica non null
        if (dipendenteTrovato == null) {
            throw new RuntimeException("TEST FALLITO: Il dipendente trovato è null!");
        }

        Long expectedId = dipAtteso.getId();
        Long actualId = dipendenteTrovato.getId();
        if (!actualId.equals(expectedId)) {
            throw new RuntimeException("TEST FALLITO: Trovato dipendente errato. Atteso ID: " + expectedId
                    + " (Assunto: " + dipAtteso.getDataAssunzione()
                    + "), Trovato ID: " + actualId
                    + " (Assunto: " + dipendenteTrovato.getDataAssunzione() + ")");
        }

        System.out.println("Verifica (breve) dipendente più vecchio SUPERATA. Trovato: " + dipendenteTrovato.getNome() + " " + dipendenteTrovato.getCognome() + ", Assunto il: " + dipendenteTrovato.getDataAssunzione());
        System.out.println("\n******* Fine Test testTrovaDipendentePiuVecchioConSocietaEProgettiVecchi *******");
    }

}
