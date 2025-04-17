package it.prova.dao.televisore;

import it.prova.dao.IBaseDAO;
import it.prova.model.Televisore;

import java.time.LocalDate;
import java.util.List;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
    public Televisore findTelevisorePiuGrande() throws Exception;
    public List<Televisore> findProdottiInIntervallo(LocalDate inizio, LocalDate fine) throws Exception;
    public List<Televisore> showDistintaMarcheUltimi6Mesi(LocalDate giorno) throws Exception;
}
