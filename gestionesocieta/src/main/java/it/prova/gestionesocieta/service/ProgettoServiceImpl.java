package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.exception.ExceptionSocietaMortaPrimaDellaFineProgetto;
import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.DipendenteRepository;
import it.prova.gestionesocieta.repository.ProgettoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ProgettoServiceImpl implements ProgettoService {
    @Autowired
    private ProgettoRepository progettoRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Override
    public List<Progetto> listAllProgetti() {
        return (List<Progetto>) progettoRepository.findAll();
    }

    @Override
    public Progetto caricaSingoloProgetto(Long id) {
        return progettoRepository.findById(id).orElse(null);
    }

    @Override
    public void aggiorna(Progetto progettoInstance) {
        progettoRepository.save(progettoInstance);
    }

    @Override
    public void inserisciNuovo(Progetto progettoInstance) {
        progettoRepository.save(progettoInstance);
    }

    @Override
    public void rimuovi(Long idProgetto) {
        progettoRepository.deleteById(idProgetto);
    }

    @Override
    public List<Progetto> cercaProgettoConNome(String nome) {
        return List.of();
    }

    @Override
    public List<Progetto> cercaProgettoConCliente(String cliente) {
        return List.of();
    }

    @Override
    public List<Progetto> cercaProgettoConDurata(int durata) {
        return List.of();
    }

    @Override
    public boolean rimuoviSocietaScollegataDaDipendente(Long idSocieta) {
        return false;
    }

    @Override
    public void collegaProgettoADipendenti(Long progettoId, List<Dipendente> dipendenti) throws Exception {
        Progetto progetto = progettoRepository.findById(progettoId).orElseThrow(() -> new RuntimeException("Progetto non trovato"));

        List<Dipendente> dipendentiDb = (List<Dipendente>) dipendenteRepository.findAllById(dipendenti.stream().map(d -> d.getId()).toList());

        if(dipendentiDb.size() != dipendenti.size()) {
            throw new Exception("Alcuni dipendenti non trovati");
        }

        LocalDate dataFinePrevista = LocalDate.now().plusMonths(progetto.getDurataInMesi());
        for (Dipendente d : dipendentiDb) {
            Societa societaDipendente = d.getSocieta();
            if (societaDipendente.getDataChiusura() != null && societaDipendente.getDataChiusura().isBefore(dataFinePrevista)) {
                throw new ExceptionSocietaMortaPrimaDellaFineProgetto(
                        "La società del dipendente " + d.getNome() + " " + d.getCognome() +
                                " chiuderà (" + societaDipendente.getDataChiusura() +
                                ") prima della fine prevista del progetto (" + dataFinePrevista + ")");
            }
        }

        progetto.getDipendenti().addAll(dipendentiDb); // Metodo fondamentale per il salvataggio: aggiorno il lato owner
        dipendentiDb.forEach(d -> d.getProgetti().add(progetto)); //teniamo in sync il lato “non-owner” della relazione: la lista progetti dentro ciascun Dipendente.

        progettoRepository.save(progetto); // Posso anche ometterlo in quanto progeto è dirty dopo progetto.getDipendenti().addAll(dipendentiDb)
        dipendenteRepository.saveAll(dipendentiDb); // Anche qui la chiamata non è necessaria, basta progetto.getDipendenti().addAll(dipendentiDb);
    }

    @Override
    public List<String> listaClientiDeiProgettiDataSocieta(Societa societaInput) throws Exception {
        return progettoRepository.findClientiBySocieta(societaInput);
    }

    @Override
    public List<String> listaNomiSocietaConProgettiDiDurataSuperioreA12Mesi() throws Exception {
        return progettoRepository.findCompaniesWithProjectsOlderThan12Months();
    }

    @Override
    public List<Progetto> listaProgettiConDipendentiRALSuperioriAl29999() throws Exception {
        return progettoRepository.findProjectsWithEmployersWithRALGreaterThan29999();
    }

    @Override
    public List<Progetto> trovaProgettiAnomali() throws Exception {
        return progettoRepository.findAnomalousProjectsWithClosedCompanyEmployees();
    }
}
