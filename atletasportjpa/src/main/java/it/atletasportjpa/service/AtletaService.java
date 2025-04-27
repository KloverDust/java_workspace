package it.atletasportjpa.service;

import it.atletasportjpa.dao.AtletaDAO;
import it.atletasportjpa.dao.SportDAO;
import it.atletasportjpa.model.Atleta;

import java.util.List;

public interface AtletaService {
    public List<Atleta> caricaTuttiAtleti() throws Exception;

    public Atleta caricaSingoloAtleta(Long id) throws Exception;

    public Atleta caricaSingoloAtletaConSport(Long id) throws Exception;

    public void inserisciNuovoAtleta(Atleta atletaInstance) throws Exception;

    public void aggiornaAtleta(Atleta atletaInstance) throws Exception;

    public void rimuoviAtleta(Long idAtleta) throws Exception;

    public void setAtletaDAO(AtletaDAO atletaDAO);

    public void setSportDAO(SportDAO sportDAO);

    public Long calcolaSommaMedaglieAtletiSportFiniti() throws Exception;
}
