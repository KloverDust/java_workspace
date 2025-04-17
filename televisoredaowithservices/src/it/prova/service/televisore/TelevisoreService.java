package it.prova.service.televisore;

import it.prova.dao.televisore.TelevisoreDAO;
import it.prova.model.Televisore;

import java.time.LocalDate;
import java.util.List;

public interface TelevisoreService {
    // questo mi serve per injection
    public void setTelevisoreDao(TelevisoreDAO userDao);

    public List<Televisore> listAll() throws Exception;

    public Televisore findById(Long idInput) throws Exception;

    public int aggiorna(Televisore input) throws Exception;

    public int inserisciNuovo(Televisore input) throws Exception;

    public int rimuovi(Long idDaRimuovere) throws Exception;

    public List<Televisore> findByExample(Televisore input) throws Exception;

    public Televisore trovaIlPiuGrande() throws Exception;

    public List<Televisore> trovaProdottiInIntervallo(LocalDate inizio, LocalDate fine) throws Exception;

    public List<Televisore> listaDistintaMarcheUltimi6Mesi(LocalDate giorno) throws Exception;
}
