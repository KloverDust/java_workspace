package it.atletasportmanytomany.service;

import it.atletasportmanytomany.dao.AtletaDAO;
import it.atletasportmanytomany.dao.SportDAO;
import it.atletasportmanytomany.model.Sport;

import java.util.List;

public class SportServiceImpl implements SportService{
    private SportDAO sportDAO;
    private AtletaDAO atletaDAO;

    @Override
    public List<Sport> caricaTuttiSport() throws Exception {
        return List.of();
    }

    @Override
    public void caricaSportDaDescrizione(String descrizione) throws Exception {

    }

    @Override
    public void caricaSportDaId(Long id) throws Exception {

    }

    @Override
    public void inserisciNuovoSport(String descrizione) throws Exception {

    }

    @Override
    public void aggiornaSport(Long idSport, String descrizione) throws Exception {

    }

    @Override
    public void rimuoviSport(Long idSport) throws Exception {

    }

    @Override
    public void setSportDAO(SportDAO sportDAO) throws Exception {

    }

    @Override
    public void setAtletaDAO(AtletaDAO atletaDAO) throws Exception {

    }
}
