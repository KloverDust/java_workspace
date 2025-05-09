package it.prova.gestioneedifici.service;

import it.prova.gestioneedifici.model.Edificio;

import java.util.List;
import java.util.Map;

public interface EdificioService {
    public List<Edificio> listAllEdifici();

    public Edificio caricaSingoloEdificio(Long id);

    public void aggiorna(Edificio EdificioInstance);

    public void inserisciNuovo(Edificio EdificioInstance);

    public void rimuovi(Long idEdificio);

    public void inserisciEdificioConControlli(Edificio edificioInstance) throws Exception;

    public Map<Edificio, Long> ottieniEdificioECountInquilini() throws Exception;

    public Map<Edificio, Long> ottieniEdificioECountInquilini(Long idEdificio) throws Exception;
}
