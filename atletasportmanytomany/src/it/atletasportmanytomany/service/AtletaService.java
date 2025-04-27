package it.atletasportmanytomany.service;

import it.atletasportmanytomany.dao.AtletaDAO;
import it.atletasportmanytomany.dao.SportDAO;
import it.atletasportmanytomany.model.Atleta;

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
}
