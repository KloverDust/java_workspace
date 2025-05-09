package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;

import java.time.LocalDate;
import java.util.List;

public interface DipendenteService {
    public List<Dipendente> listAllDipendenti();

    public Dipendente caricaSingoloDipendente(Long id);

    public void aggiorna(Dipendente dipendenteInstance);

    public void inserisciNuovo(Dipendente dipendenteInstance);

    public void rimuovi(Long idDipendente);

    public List<Dipendente> findByNome(String nameInput);

    public List<Dipendente> cercaDipendentiConDataAssunzione(LocalDate data);

    public List<Dipendente> cercaDipendentiPerReddito(String redditoAnnuoLordo);

    public List<Dipendente> cercaPerProgetto(Progetto progettoInput);

    public void collegaDipendenteAProgetti(Long idDipendente, List<Progetto> progetti) throws Exception;

    public Dipendente trovaDipendentePiuVecchioPerProgettoESocietaVecchi() throws Exception;
}
