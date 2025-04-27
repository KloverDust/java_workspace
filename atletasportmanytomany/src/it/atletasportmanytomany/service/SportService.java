package it.atletasportmanytomany.service;

import it.atletasportmanytomany.dao.AtletaDAO;
import it.atletasportmanytomany.dao.SportDAO;
import it.atletasportmanytomany.model.Sport;

import java.util.List;

public interface SportService {
    public List<Sport> caricaTuttiSport() throws Exception;

    public void caricaSportDaDescrizione(String descrizione) throws Exception;

    public void caricaSportDaId(Long id) throws Exception;

    public void inserisciNuovoSport(String descrizione) throws Exception;

    public void aggiornaSport(Long idSport, String descrizione) throws Exception;

    public void rimuoviSport(Long idSport) throws Exception;

    public void setSportDAO(SportDAO sportDAO) throws Exception;

    public void setAtletaDAO(AtletaDAO atletaDAO) throws Exception;
}
