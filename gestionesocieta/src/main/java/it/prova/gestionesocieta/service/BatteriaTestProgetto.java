package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteriaTestProgetto {
    @Autowired
    private SocietaService societaService;

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private ProgettoService progettoService;

    public void testInserisciNuovoProgetto() {
        Progetto progetto1 = new Progetto("GIS1", "FibraNet", 24);
        progettoService.inserisciNuovo(progetto1);

        if (progetto1.getId() == null || progetto1.getId() < 1) {
            throw new RuntimeException("Progetto non inserito");
        }

    }

    public void testCollegaDipendenteAPiuProgetti() throws Exception {
        List<Progetto> progetti = new ArrayList<>();

        Progetto progetto1 = new Progetto("GIS5", "FibraNet2", 24);
        progettoService.inserisciNuovo(progetto1);
        if (progetto1.getId() == null || progetto1.getId() < 1) {
            throw new Exception("Progetto non inserito");
        }

        Progetto progetto2 = new Progetto("GIS6", "FibraNet3", 24);
        progettoService.inserisciNuovo(progetto2);
        if (progetto2.getId() == null || progetto2.getId() < 1) {
            throw new Exception("Progetto non inserito");
        }

        Progetto progetto3 = new Progetto("GIS7", "FibraNet4", 24);
        progettoService.inserisciNuovo(progetto3);
        if (progetto3.getId() == null || progetto3.getId() < 1) {
            throw new Exception("Progetto non inserito");
        }

        progetti.add(progetto1);
        progetti.add(progetto2);
        progetti.add(progetto3);

        Societa societa1 = new Societa("AcquaPanna", "Via delle acque 14", LocalDate.of(2021,1,1), LocalDate.of(2027,10,10));
        societaService.inserisciNuovo(societa1);
        if (societa1.getId() == null || societa1.getId() < 1) {
            throw new Exception("Societa non inserita");
        }
        Dipendente dipendente1 = new Dipendente("William", "Layther", LocalDate.of(1998,12,12), 30000L);
        dipendente1.setSocieta(societa1);
        dipendenteService.inserisciNuovo(dipendente1);
        if (dipendente1.getId() == null || dipendente1.getId() < 1) {
            throw new Exception("Dipendente non inserito");
        }

        dipendenteService.collegaDipendenteAProgetti(dipendente1.getId(), progetti);

    }

    public void testListaClientiProgettoPerSocieta() throws Exception { // Rinominato per chiarezza
        System.out.println("\n******* Inizio Test testListaClientiProgettoPerSocieta *******");

        // Societa A
        Societa societaA = new Societa("ClientiTest SPA", "Via Test A 1", LocalDate.now().minusYears(5), null);
        societaService.inserisciNuovo(societaA);
        if (societaA.getId() == null) throw new Exception("Setup fallito: Inserimento Societa A");

        // Societa B
        Societa societaB = new Societa("AltraClienti SRL", "Via Test B 2", LocalDate.now().minusYears(2), null);
        societaService.inserisciNuovo(societaB);
        if (societaB.getId() == null) throw new Exception("Setup fallito: Inserimento Societa B");

        // Dipendenti
        Dipendente dipA1 = new Dipendente("Gioacchino", "Cammelli", LocalDate.now().minusYears(3), 31000L);
        dipA1.setSocieta(societaA);
        dipendenteService.inserisciNuovo(dipA1);
        if (dipA1.getId() == null) throw new Exception("Setup fallito: Inserimento Dipendente A1");

        Dipendente dipA2 = new Dipendente("Anna", "Scogli", LocalDate.now().minusYears(1), 33000L);
        dipA2.setSocieta(societaA);
        dipendenteService.inserisciNuovo(dipA2);
        if (dipA2.getId() == null) throw new Exception("Setup fallito: Inserimento Dipendente A2");

        Dipendente dipB1 = new Dipendente("Luca", "Genovesi", LocalDate.now().minusYears(1), 29000L);
        dipB1.setSocieta(societaB);
        dipendenteService.inserisciNuovo(dipB1);
        if (dipB1.getId() == null) throw new Exception("Setup fallito: Inserimento Dipendente B1");
        System.out.println("Creati Dipendenti per Societa A e B.");

        // Progetti
        Progetto projClienteX_A = new Progetto("P_XA", "ClienteX", 12); // Lavorato da dipA1 (Societa A)
        progettoService.inserisciNuovo(projClienteX_A);
        if (projClienteX_A.getId() == null) throw new Exception("Setup fallito: Inserimento Progetto XA");

        Progetto projClienteY_A = new Progetto("P_YA", "ClienteY", 6);  // Lavorato da dipA2 (Societa A)
        progettoService.inserisciNuovo(projClienteY_A);
        if (projClienteY_A.getId() == null) throw new Exception("Setup fallito: Inserimento Progetto YA");

        Progetto projClienteZ_AB = new Progetto("P_ZAB", "ClienteZ", 24); // Lavorato da dipA1 (A) e dipB1 (B)
        progettoService.inserisciNuovo(projClienteZ_AB);
        if (projClienteZ_AB.getId() == null) throw new Exception("Setup fallito: Inserimento Progetto ZAB");

        Progetto projClienteW_B = new Progetto("P_WB", "ClienteW", 10); // Lavorato da dipB1 (Societa B)
        progettoService.inserisciNuovo(projClienteW_B);
        if (projClienteW_B.getId() == null) throw new Exception("Setup fallito: Inserimento Progetto WB");

        Progetto projClienteX_A2 = new Progetto("P_XA2", "ClienteX", 8); // Lavorato da dipA2 (Societa A) - Cliente duplicato!
        progettoService.inserisciNuovo(projClienteX_A2);
        if (projClienteX_A2.getId() == null) throw new Exception("Setup fallito: Inserimento Progetto XA2");
        System.out.println("Creati Progetti con vari clienti.");


        // --- 2. Collegamenti Dipendenti <-> Progetti ---
        // Usiamo il metodo che modifica l'owner (Progetto) per semplicità qui,
        // assumendo che sia transazionale o che il salvataggio avvenga correttamente.
        // Se hai dubbi, usa dipendenteService.collegaDipendenteAProgetti
        System.out.println("Collegamento dipendenti ai progetti...");
        progettoService.collegaProgettoADipendenti(projClienteX_A.getId(), List.of(dipA1));
        progettoService.collegaProgettoADipendenti(projClienteY_A.getId(), List.of(dipA2));
        progettoService.collegaProgettoADipendenti(projClienteZ_AB.getId(), List.of(dipA1, dipB1)); // A & B
        progettoService.collegaProgettoADipendenti(projClienteW_B.getId(), List.of(dipB1));          // Solo B
        progettoService.collegaProgettoADipendenti(projClienteX_A2.getId(), List.of(dipA2));        // Solo A (ClienteX)
        System.out.println("Collegamenti completati.");


        // --- 3. Esecuzione della Logica da Testare ---
        System.out.println("\nRichiesta clienti per Societa A (ID: " + societaA.getId() + ")");
        List<String> clientiTrovatiPerA = progettoService.listaClientiDeiProgettiDataSocieta(societaA);

        // Verifica non null
        if (clientiTrovatiPerA == null) {
            throw new RuntimeException("TEST FALLITO: La lista clienti per Societa A è null!");
        }

        // Verifica dimensione attesa
        // Ci aspettiamo: ClienteX (da P_XA e P_XA2, ma contato una sola volta),
        //               ClienteY (da P_YA),
        //               ClienteZ (da P_ZAB, perché dipA1 ci lavora)
        // NON ci aspettiamo ClienteW (solo Societa B)
        int expectedSizeA = 3;
        if (clientiTrovatiPerA.size() != expectedSizeA) {
            throw new RuntimeException("TEST FALLITO: Dimensione lista errata per Societa A. Atteso: " + expectedSizeA + ", Trovato: " + clientiTrovatiPerA.size());
        }

        // Verifica contenuto (l'ordine non è garantito)
        if (!clientiTrovatiPerA.contains("ClienteX")) {
            throw new RuntimeException("TEST FALLITO: Manca 'ClienteX' nella lista per Societa A.");
        }
        if (!clientiTrovatiPerA.contains("ClienteY")) {
            throw new RuntimeException("TEST FALLITO: Manca 'ClienteY' nella lista per Societa A.");
        }
        if (!clientiTrovatiPerA.contains("ClienteZ")) {
            throw new RuntimeException("TEST FALLITO: Manca 'ClienteZ' nella lista per Societa A.");
        }
        // Verifica assenza di elementi non attesi
        if (clientiTrovatiPerA.contains("ClienteW")) {
            throw new RuntimeException("TEST FALLITO: Presente 'ClienteW' (non atteso) nella lista per Societa A.");
        }

        System.out.println("Verifica per Societa A SUPERATA.");

        System.out.println("\n******* Fine Test testListaClientiProgettoPerSocieta *******");
    }

    public void testListaNomiSocietaConProgettiDiDurataSuperioreA12Mesi() throws Exception {
        System.out.println("\n******* Inizio Test testListaNomiSocietaConProgettiDiDurataSuperioreA12Mesi *******");

        // Societa A: Avrà dipendenti su progetti lunghi
        Societa societaA_Lunga = new Societa("Lunga SRL", "Via Lunga 1", LocalDate.now().minusYears(5), null);
        societaService.inserisciNuovo(societaA_Lunga);
        if (societaA_Lunga.getId() == null) throw new Exception("Setup fallito: Societa A");

        // Societa B: Avrà dipendenti solo su progetti corti
        Societa societaB_Corta = new Societa("Corta SPA", "Via Corta 2", LocalDate.now().minusYears(2), null);
        societaService.inserisciNuovo(societaB_Corta);
        if (societaB_Corta.getId() == null) throw new Exception("Setup fallito: Societa B");

        Dipendente dipA1 = new Dipendente("LungoNome1", "LungoCognome1", LocalDate.now().minusYears(2), 35000L);
        dipA1.setSocieta(societaA_Lunga);
        dipendenteService.inserisciNuovo(dipA1);
        if (dipA1.getId() == null) throw new Exception("Setup fallito: Dipendente A1");

        Dipendente dipA2 = new Dipendente("LungoNome2", "LungoCognome2", LocalDate.now().minusYears(1), 36000L);
        dipA2.setSocieta(societaA_Lunga);
        dipendenteService.inserisciNuovo(dipA2);
        if (dipA2.getId() == null) throw new Exception("Setup fallito: Dipendente A2");

        Dipendente dipB1 = new Dipendente("CortoNome1", "CortoCognome1", LocalDate.now().minusMonths(6), 30000L);
        dipB1.setSocieta(societaB_Corta);
        dipendenteService.inserisciNuovo(dipB1);
        if (dipB1.getId() == null) throw new Exception("Setup fallito: Dipendente B1");
        System.out.println("Creati Dipendenti.");

        Progetto projLungo = new Progetto("ProgettoAlfa", "Cliente Alfa", 24);
        progettoService.inserisciNuovo(projLungo);
        if (projLungo.getId() == null) throw new Exception("Setup fallito: Progetto Lungo");

        Progetto projCorto = new Progetto("ProgettoBeta", "Cliente Beta", 6);
        progettoService.inserisciNuovo(projCorto);
        if (projCorto.getId() == null) throw new Exception("Setup fallito: Progetto Corto");
        System.out.println("Creati Progetti.");

        // I dipendenti di A lavorano sul progetto lungo
        progettoService.collegaProgettoADipendenti(projLungo.getId(), List.of(dipA1, dipA2));
        // Il dipendente di B lavora sul progetto corto
        progettoService.collegaProgettoADipendenti(projCorto.getId(), List.of(dipB1));
        System.out.println("Collegamenti completati.");

        List<String> nomiSocietaTrovate = progettoService.listaNomiSocietaConProgettiDiDurataSuperioreA12Mesi();
        //System.out.println("Nomi società trovate: " + nomiSocietaTrovate);

        if (nomiSocietaTrovate == null) {
            throw new RuntimeException("TEST FALLITO: La lista nomi società è null!");
        }

        // Verifica dimensione attesa (solo Societa A deve essere presente)
        int expectedSize = 1;
        if (nomiSocietaTrovate.size() != expectedSize) {
            throw new RuntimeException("TEST FALLITO: Dimensione lista errata. Atteso: " + expectedSize + ", Trovato: " + nomiSocietaTrovate.size());
        }

        // Verifica contenuto (deve contenere il nome di Societa A)
        if (!nomiSocietaTrovate.contains(societaA_Lunga.getRagioneSociale())) {
            throw new RuntimeException("TEST FALLITO: Manca '" + societaA_Lunga.getRagioneSociale() + "' nella lista.");
        }

        // Verifica assenza (NON deve contenere il nome di Societa B)
        if (nomiSocietaTrovate.contains(societaB_Corta.getRagioneSociale())) {
            throw new RuntimeException("TEST FALLITO: Presente '" + societaB_Corta.getRagioneSociale() + "' (non atteso) nella lista.");
        }

        System.out.println("Verifica (breve) nomi società con progetti lunghi SUPERATA.");
        System.out.println("\n******* Fine Test testListaNomiSocietaConProgettiDiDurataSuperioreA12Mesi *******");
    }

    public void testListaProgettiConDipendentiConRALSopra29999() throws Exception {
        System.out.println("\n******* Inizio Test testListaProgettiConDipendentiConRALSopra29999 *******");

        Societa societaRal = new Societa("RAL Test Inc.", "Via Stipendio 10", LocalDate.now().minusYears(1), null);
        societaService.inserisciNuovo(societaRal);
        if (societaRal.getId() == null) throw new Exception("Setup fallito: Societa RAL");

        Dipendente dipAlto = new Dipendente("Ricco", "Rossi", LocalDate.now().minusMonths(10), 35000L); // >= 30k
        dipAlto.setSocieta(societaRal);
        dipendenteService.inserisciNuovo(dipAlto);
        if (dipAlto.getId() == null) throw new Exception("Setup fallito: Dipendente Alto");

        Dipendente dipBasso = new Dipendente("Povero", "Bianchi", LocalDate.now().minusMonths(5), 25000L); // < 30k
        dipBasso.setSocieta(societaRal);
        dipendenteService.inserisciNuovo(dipBasso);
        if (dipBasso.getId() == null) throw new Exception("Setup fallito: Dipendente Basso");

        Dipendente dipEsatto = new Dipendente("Giusto", "Verdi", LocalDate.now().minusMonths(8), 30000L); // == 30k
        dipEsatto.setSocieta(societaRal);
        dipendenteService.inserisciNuovo(dipEsatto);
        if (dipEsatto.getId() == null) throw new Exception("Setup fallito: Dipendente Esatto");

        // Progetti: uno con dip >= 30k, uno solo con dip < 30k, uno misto
        Progetto projSoloAlto = new Progetto("ProgettoRicco", "Cliente VIP", 12);
        progettoService.inserisciNuovo(projSoloAlto);
        if (projSoloAlto.getId() == null) throw new Exception("Setup fallito: Progetto Solo Alto");

        Progetto projSoloBasso = new Progetto("ProgettoPovero", "Cliente Standard", 6);
        progettoService.inserisciNuovo(projSoloBasso);
        if (projSoloBasso.getId() == null) throw new Exception("Setup fallito: Progetto Solo Basso");

        Progetto projMisto = new Progetto("ProgettoMisto", "Cliente Qualunque", 18);
        progettoService.inserisciNuovo(projMisto);
        if (projMisto.getId() == null) throw new Exception("Setup fallito: Progetto Misto");


        progettoService.collegaProgettoADipendenti(projSoloAlto.getId(), List.of(dipAlto));
        progettoService.collegaProgettoADipendenti(projSoloBasso.getId(), List.of(dipBasso));
        progettoService.collegaProgettoADipendenti(projMisto.getId(), List.of(dipEsatto, dipBasso));

        List<Progetto> progettiTrovati = progettoService.listaProgettiConDipendentiRALSuperioriAl29999();

        System.out.println("Progetti trovati (" + progettiTrovati.size() + "): " + progettiTrovati);

        // Verifica non null
        if (progettiTrovati == null) {
            throw new RuntimeException("TEST FALLITO: La lista progetti è null!");
        }

        // Verifica dimensione attesa (projSoloAlto e projMisto devono esserci)
        int expectedSize = 2;
        if (progettiTrovati.size() != expectedSize) {
            throw new RuntimeException("TEST FALLITO: Dimensione lista errata. Atteso: " + expectedSize + ", Trovato: " + progettiTrovati.size());
        }

        // Verifica contenuto (presenza degli ID attesi)
        List<Long> idsTrovati = progettiTrovati.stream().map(Progetto::getId).collect(Collectors.toList());
        Long idSoloAlto = projSoloAlto.getId();
        Long idMisto = projMisto.getId();

        if (!idsTrovati.contains(idSoloAlto)) {
            throw new RuntimeException("TEST FALLITO: Manca il progetto 'SoloAlto' (ID: " + idSoloAlto + ") nella lista.");
        }
        if (!idsTrovati.contains(idMisto)) {
            throw new RuntimeException("TEST FALLITO: Manca il progetto 'Misto' (ID: " + idMisto + ") nella lista.");
        }

        System.out.println("Verifica (breve) progetti con dipendenti RAL >= 30000 SUPERATA.");
        System.out.println("\n******* Fine Test testListaProgettiConDipendentiConRALSopra29999 *******");
    }

    public void testTrovaProgettiAnomali() throws Exception{
        System.out.println("\n******* Inizio Test testFindAnomalousProjects *******");

        // Società Chiusa
        Societa socChiusa = new Societa("Defunta Happy SPA", "Via Passata Felice 3", LocalDate.now().minusYears(8), LocalDate.now().minusMonths(6));
        societaService.inserisciNuovo(socChiusa);
        if (socChiusa.getId() == null) throw new RuntimeException("Setup fallito: Societa Chiusa");

        // Dipendente della Società Chiusa
        Dipendente dipSocChiusa = new Dipendente("Cesare", "Contento", LocalDate.now().minusYears(5), 38000L);
        dipSocChiusa.setSocieta(socChiusa);
        dipendenteService.inserisciNuovo(dipSocChiusa);
        if (dipSocChiusa.getId() == null) throw new RuntimeException("Setup fallito: Dipendente Societa Chiusa");

        // Progetto Target (che diventerà anomalo)
        Progetto projTarget = new Progetto("ProgettoHappyAnomalo", "Cliente Fortunato", 15);
        progettoService.inserisciNuovo(projTarget);
        if (projTarget.getId() == null) throw new RuntimeException("Setup fallito: Progetto Target");

        progettoService.collegaProgettoADipendenti(projTarget.getId(), List.of(dipSocChiusa));

        List<Progetto> progettiAnomaliTrovati = progettoService.trovaProgettiAnomali();

        if (progettiAnomaliTrovati == null) {
            throw new RuntimeException("TEST FALLITO: La lista progetti anomali è null!");
        }

        int expectedSize = 1;
        if (progettiAnomaliTrovati.size() != expectedSize) {
            throw new RuntimeException("TEST FALLITO: Dimensione lista errata. Atteso: " + expectedSize + ", Trovato: " + progettiAnomaliTrovati.size());
        }

        Long idTrovato = progettiAnomaliTrovati.get(0).getId();
        Long idAtteso = projTarget.getId();

        if (!idTrovato.equals(idAtteso)) {
            throw new RuntimeException("TEST FALLITO: Trovato progetto errato. Atteso ID: " + idAtteso + ", Trovato ID: " + idTrovato);
        }

        System.out.println("\n******* Fine Test testFindAnomalousProjects_HappyPath *******");
    }

}
