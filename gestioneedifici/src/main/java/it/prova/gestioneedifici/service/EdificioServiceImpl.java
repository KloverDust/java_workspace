package it.prova.gestioneedifici.service;

import it.prova.gestioneedifici.exception.EdificioCostruitoInPassatoException;
import it.prova.gestioneedifici.exception.NumeroPianiInferioreA4Exception;
import it.prova.gestioneedifici.model.Edificio;
import it.prova.gestioneedifici.repository.EdificioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EdificioServiceImpl implements EdificioService {

    @Autowired
    EdificioRepository edificioRepository;


    @Override
    public List<Edificio> listAllEdifici() {
        return (List<Edificio>) edificioRepository.findAll();
    }

    @Override
    public Edificio caricaSingoloEdificio(Long id) {
        return edificioRepository.findById(id).orElse(null);
    }

    @Override
    public void aggiorna(Edificio EdificioInstance) {
        edificioRepository.save(EdificioInstance);
    }

    @Override
    public void inserisciNuovo(Edificio EdificioInstance) {
        edificioRepository.save(EdificioInstance);
    }

    @Override
    public void rimuovi(Long idEdificio) {
        edificioRepository.deleteById(idEdificio);
    }

    @Override
    public void inserisciEdificioConControlli(Edificio edificioInstance) throws Exception{
        if (edificioInstance == null) {
            throw new RuntimeException("Edificio passato NULL");
        }

        if(edificioInstance.getDataCostruzione().isBefore(LocalDate.now())) {
            throw new EdificioCostruitoInPassatoException("L'edificio è stato gia costruito e non può essere considerato");
        }

        if(edificioInstance.getNumeroPiani() < 4) {
            throw new NumeroPianiInferioreA4Exception("Il numero di piani dell'edificio è inferiore a 4");
        }

        edificioRepository.save(edificioInstance);
    }

    @Override
    public Map<Edificio, Long> ottieniEdificioECountInquilini() throws Exception {
        return edificioRepository.ottieniEdificioECountInquilini();
    }

    @Override
    public Map<Edificio, Long> ottieniEdificioECountInquilini(Long idEdificio) throws Exception {
        return edificioRepository.ottieniCountPerEdificio(idEdificio);
    }
}
