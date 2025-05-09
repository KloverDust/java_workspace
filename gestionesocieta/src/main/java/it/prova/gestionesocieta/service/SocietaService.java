package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;

import java.time.LocalDate;
import java.util.List;

public interface SocietaService {
    public List<Societa> listAllSocieta();

    public Societa caricaSingoloSocieta(Long id);

    public void aggiorna(Societa societaInstance);

    public void inserisciNuovo(Societa societaInstance) throws Exception;

    public void rimuovi(Long idSocieta);

    public List<Societa> findByExample(Societa example);

    public List<Societa> cercaSocietaConDataFondazione(LocalDate data);

    public List<Societa> cercaSocietaConDataChiusura(LocalDate data);

    public List<Societa> cercaSocietaConRagioneSociale(String ragioneSociale);

    public List<Societa> cercaSocietaConIndirizzo(String indirizzo);

    public boolean rimuoviSocieta(Long idSocieta) throws Exception;

    public boolean inserisciDipendenteInSocieta(Long idSocieta, Dipendente dipendenteInstance) throws Exception;
}
