package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.exception.ExceptionSocietaMortaPrimaDellaFineProgetto;
import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.repository.DipendenteRepository;
import it.prova.gestionesocieta.repository.ProgettoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional // Non mi fa aggiungere readOnly
public class DipendenteServiceImpl implements DipendenteService {
    
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ProgettoService progettoService;

    @Autowired
    private ProgettoRepository progettoRepository;
    
    @Override
    public List<Dipendente> listAllDipendenti() {
        return (List<Dipendente>) dipendenteRepository.findAll();
    }

    @Override
    public Dipendente caricaSingoloDipendente(Long id) {
        return dipendenteRepository.findById(id).orElse(null);

    }

    @Override
    public void aggiorna(Dipendente dipendenteInstance) {
        dipendenteRepository.save(dipendenteInstance);
    }

    @Override
    public void inserisciNuovo(Dipendente dipendenteInstance) {
        dipendenteRepository.save(dipendenteInstance);
    }

    @Override
    public void rimuovi(Long idDipendente) {
        dipendenteRepository.deleteById(idDipendente);
    }

    @Override
    public List<Dipendente> findByNome(String nameInput) {
        return List.of();
    }

    @Override
    public List<Dipendente> cercaDipendentiConDataAssunzione(LocalDate data) {
        return List.of();
    }

    @Override
    public List<Dipendente> cercaDipendentiPerReddito(String redditoAnnuoLordo) {
        return List.of();
    }

    @Override
    public List<Dipendente> cercaPerProgetto(Progetto progettoInput) {
        return List.of();
    }

    @Override
    public void collegaDipendenteAProgetti(Long idDipendente, List<Progetto> progetti) throws Exception {
        Dipendente dipendente = dipendenteRepository.findById(idDipendente).orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

        List<Progetto> progettiDb = (List<Progetto>) progettoRepository.findAllById(progetti.stream().map(p -> p.getId()).toList());
        if (progettiDb.size() != progetti.size()) {
            throw new ExceptionSocietaMortaPrimaDellaFineProgetto("Alcuni progetti non trovati");
        }

        for (Progetto progetto : progettiDb) {
            LocalDate dataFinePrevista = LocalDate.now().plusMonths(progetto.getDurataInMesi());

            if (dipendente.getSocieta().getDataChiusura() != null && dipendente.getSocieta().getDataChiusura().isBefore(dataFinePrevista)) {
                throw new ExceptionSocietaMortaPrimaDellaFineProgetto("La società del dipendente chiuderà prima della fine prevista del progetto");
            }

            progetto.addDipendente(dipendente);
        }

        dipendenteRepository.save(dipendente); // NOn serve dato che progetto è l'owner della relazione many to many con dipendente
    }

    @Override
    public Dipendente trovaDipendentePiuVecchioPerProgettoESocietaVecchi() throws Exception {
        Optional<Dipendente> dipendenteOpt = dipendenteRepository.findOldestEmployerWithProjectsOlderThan6MonthsAndCompanies(LocalDate.of(1990, 1, 1)).stream().findFirst() ;
        return dipendenteOpt.orElseThrow(() -> new EntityNotFoundException("Nessun dipendente trovato con i criteri specificati."));
    }
}
