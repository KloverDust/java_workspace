package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.repository.DipendenteRepository;
import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;
import it.prova.gestionesocieta.exception.ExceptionRagioneSocialeGiaEsistente;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.SocietaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SocietaServiceImpl implements SocietaService{
    @Autowired
    private SocietaRepository societaRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Societa> listAllSocieta() {
        return (List<Societa>) societaRepository.findAll();
    }

    @Override
    public Societa caricaSingoloSocieta(Long id) {
        return societaRepository.findById(id).orElse(null);
    }

    @Override
    public void aggiorna(Societa societaInstance) {
        societaRepository.save(societaInstance);
    }

    @Override
    public void inserisciNuovo(Societa societaInstance) throws Exception{
        if (!societaRepository.findByRagioneSociale(societaInstance.getRagioneSociale()).isEmpty()) {
            throw new ExceptionRagioneSocialeGiaEsistente("Ragione sociale " + societaInstance.getRagioneSociale() + " già presente");
        }
        societaRepository.save(societaInstance);
    }

    @Override
    public void rimuovi(Long idSocieta) {
        societaRepository.deleteById(idSocieta);
    }

    @Override
    public List<Societa> findByExample(Societa example) {

        Map<String, Object> paramaterMap = new HashMap<String, Object>();
        List<String> whereClauses = new ArrayList<String>();

        StringBuilder queryBuilder = new StringBuilder("select a from Societa a where a.id = a.id ");

        if (StringUtils.isNotEmpty(example.getRagioneSociale())) {
            whereClauses.add(" a.ragioneSociale  like :ragioneSociale ");
            paramaterMap.put("ragioneSociale", "%" + example.getRagioneSociale() + "%");
        }

        if (StringUtils.isNotEmpty(example.getIndirizzo())) {
            whereClauses.add(" a.indirizzo like :indirizzo ");
            paramaterMap.put("indirizzo", "%" + example.getIndirizzo() + "%");
        }

        if (example.getDataFondazione() != null) {
            whereClauses.add(" a.dataFondazione = :dataFondazione ");
            paramaterMap.put("dataFondazione", example.getDataFondazione());
        }

        if (example.getDataChiusura() != null) {
            whereClauses.add(" a.dataChiusura = :dataChiusura ");
            paramaterMap.put("dataChiusura", example.getDataChiusura());
        }

        queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
        queryBuilder.append(StringUtils.join(whereClauses, " and "));
        TypedQuery<Societa> typedQuery = entityManager.createQuery(queryBuilder.toString(), Societa.class);

        for (String key : paramaterMap.keySet()) {
            typedQuery.setParameter(key, paramaterMap.get(key));
        }

        return typedQuery.getResultList();
    }

    @Override
    public List<Societa> cercaSocietaConDataFondazione(LocalDate data) {
        return List.of();
    }

    @Override
    public List<Societa> cercaSocietaConDataChiusura(LocalDate data) {
        return List.of();
    }

    @Override
    public List<Societa> cercaSocietaConRagioneSociale(String ragioneSociale) {
        return List.of();
    }

    @Override
    public List<Societa> cercaSocietaConIndirizzo(String indirizzo) {
        return List.of();
    }

    @Override
    public boolean rimuoviSocieta(Long idSocieta) throws Exception{
        Societa societa = societaRepository.findById(idSocieta).orElse(null);

        if (societa == null) {
            throw new RuntimeException("Società con id " + idSocieta + " non trovata");
        }

        if (!societa.getDipendenti().isEmpty()) {
            throw new RuntimeException("Impossibile eliminare la società " + idSocieta + ": esistono dipendenti associati");
        }

        societaRepository.deleteById(idSocieta);
        return true;
    }

    @Override
    public boolean inserisciDipendenteInSocieta(Long idSocieta, Dipendente dipendenteInstance) throws Exception {
        Societa societa = societaRepository.findById(idSocieta).orElse(null);

        if (societa == null) {
            throw new EntityNotFoundException("Società con id " + idSocieta + " non trovata");
        }

        if (societa.getDataFondazione().isAfter(dipendenteInstance.getDataAssunzione())) {
            throw new RuntimeException("Impossibile assumere " + dipendenteInstance.getNome() + " " + dipendenteInstance.getCognome() + ": data assunzione precedente alla fondazione");
        }

        dipendenteInstance.setSocieta(societa);
        dipendenteRepository.save(dipendenteInstance);

        societa.getDipendenti().add(dipendenteInstance);
        return true;
    }


}
