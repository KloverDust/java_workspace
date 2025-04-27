package it.atletasportjpa.service;

import it.atletasportjpa.dao.AtletaDAO;
import it.atletasportjpa.dao.SportDAO;
import it.atletasportjpa.model.Atleta;
import it.atletasportjpa.model.Sport;

import java.util.List;

public interface SportService {
    public List<Sport> caricaTuttiSport() throws Exception;

    public List<Sport> caricaSportDaDescrizione(String descrizione) throws Exception;

    public Sport caricaSportDaId(Long id) throws Exception;

    public void inserisciNuovoSport(String descrizione) throws Exception;

    public void aggiornaSport(Long idSport, String descrizione) throws Exception;

    public void rimuoviSport(Long idSport) throws Exception;

    public void setSportDAO(SportDAO sportDAO);

    public void setAtletaDAO(AtletaDAO atletaDAO);

    public void aggiungiSportAdAtleta(Atleta atleta) throws Exception;

    public void rimuoviSportDaAtleta(Atleta atleta) throws Exception;

    public void rimuoviAtletaDopoScollegamentoDaSport(Atleta atleta) throws Exception;

    public List<Sport> trovaSportConDateIncoerenti() throws Exception;
}
