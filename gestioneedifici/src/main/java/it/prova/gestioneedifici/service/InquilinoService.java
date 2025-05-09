package it.prova.gestioneedifici.service;

import it.prova.gestioneedifici.model.Inquilino;

import java.util.List;

public interface InquilinoService {
    public List<Inquilino> listAllInquilini();

    public Inquilino caricaSingoloInquilino(Long id);

    public void aggiorna(Inquilino InquilinoInstance);

    public void inserisciNuovo(Inquilino InquilinoInstance);

    public void rimuovi(Long idInquilino);

    public void inserisciCoinquilinoConControlliDatoEdificio(Inquilino inquilinoInstance,Long idEdificio) throws Exception;
}
