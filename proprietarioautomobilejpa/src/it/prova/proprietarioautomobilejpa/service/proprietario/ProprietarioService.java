package it.prova.proprietarioautomobilejpa.service.proprietario;

import it.prova.proprietarioautomobilejpa.dao.proprietario.ProprietarioDAO;
import it.prova.proprietarioautomobilejpa.model.Proprietario;

import java.util.List;

public interface ProprietarioService {

    public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);

    public Proprietario caricaSingoloProprietario(Long id) throws Exception;

    public List<Proprietario> caricaTuttiProprietari() throws Exception;

    public void aggiornaProprietario(Proprietario proprietarioInstance) throws Exception;

    public void inserisciNuovoProprietario(Proprietario proprietarioInstance) throws Exception;

    public void rimuoviProprietario(Long idProprietarioInstance) throws Exception;
}
