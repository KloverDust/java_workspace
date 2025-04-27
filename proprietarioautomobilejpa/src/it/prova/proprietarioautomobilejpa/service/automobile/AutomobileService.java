package it.prova.proprietarioautomobilejpa.service.automobile;

import it.prova.proprietarioautomobilejpa.dao.automobile.AutomobileDAO;
import it.prova.proprietarioautomobilejpa.model.Automobile;

import java.util.List;

public interface AutomobileService {

    public void setAutomobileDAO(AutomobileDAO automobileDAO);

    public Automobile caricaSingolaAutomobile(Long id) throws Exception;

    public List<Automobile> caricaTutteAutomobili() throws Exception;

    public void aggiornaAutomobile(Automobile automobileInstance) throws Exception;

    public void inserisciNuovaAutomobile(Automobile automobileInstance) throws Exception;

    public void rimuoviAutomobile(Long idAutomobileInstance) throws Exception;

}
