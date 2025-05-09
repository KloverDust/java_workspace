package it.prova.gestioneedifici.service;

import it.prova.gestioneedifici.exception.NumeroMassimoPerPianoException;
import it.prova.gestioneedifici.model.Edificio;
import it.prova.gestioneedifici.model.Inquilino;
import it.prova.gestioneedifici.model.Inquilino;
import it.prova.gestioneedifici.repository.InquilinoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class InquilinoServiceImpl implements InquilinoService {
    
    @Autowired
    InquilinoRepository inquilinoRepository;

    @Autowired
    EdificioService edificioService;

    @Override
    public List<Inquilino> listAllInquilini() {
        return (List<Inquilino>) inquilinoRepository.findAll();
    }

    @Override
    public Inquilino caricaSingoloInquilino(Long id) {
        return inquilinoRepository.findById(id).orElse(null);
    }

    @Override
    public void aggiorna(Inquilino InquilinoInstance) {
        inquilinoRepository.save(InquilinoInstance);
    }

    @Override
    public void inserisciNuovo(Inquilino InquilinoInstance) {
        inquilinoRepository.save(InquilinoInstance);
    }

    @Override
    public void rimuovi(Long idInquilino) {
        inquilinoRepository.deleteById(idInquilino);
    }

    @Override
    public void inserisciCoinquilinoConControlliDatoEdificio(Inquilino inquilinoInstance, Long idEdificio) throws Exception {
        if (inquilinoInstance == null) {
            throw new RuntimeException("Inquilino passato NULL");
        }

        Edificio edificio = edificioService.caricaSingoloEdificio(idEdificio);
        if (edificio == null) {
            throw new RuntimeException("Edificio passato NULL");
        }

        if (LocalDate.now().minusYears(18).isBefore(inquilinoInstance.getDataNascita()) && inquilinoInstance.getAffittoDovuto() != 0) {
            throw new Exception("L'inquilino deve essere maggiorenne");
        }

        Map<Edificio, Long> mappa = edificioService.ottieniEdificioECountInquilini(idEdificio);
        int quantiInquilini = mappa.get(mappa.keySet().iterator().next()).intValue();
        Edificio edifico = mappa.keySet().iterator().next();

        if(quantiInquilini > edifico.getNumeroPiani() * 16){
            throw new NumeroMassimoPerPianoException("L'edificio ha raggiunto il numero massimo di inquilini per piano");
        }

    }
}
