package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;

import java.util.List;

public interface ProgettoService {
    public List<Progetto> listAllProgetti();

    public Progetto caricaSingoloProgetto(Long id);

    public void aggiorna(Progetto progettoInstance);

    public void inserisciNuovo(Progetto progettoInstance);

    public void rimuovi(Long idProgetto);

    public List<Progetto> cercaProgettoConNome(String nome);

    public List<Progetto> cercaProgettoConCliente(String cliente);

    public List<Progetto> cercaProgettoConDurata(int durata);

    public boolean rimuoviSocietaScollegataDaDipendente(Long idSocieta);

    public void collegaProgettoADipendenti(Long progettoId, List <Dipendente> dipendenti) throws Exception;

    public List<String> listaClientiDeiProgettiDataSocieta(Societa societaInput) throws Exception;

    public List<String> listaNomiSocietaConProgettiDiDurataSuperioreA12Mesi() throws Exception;

    public List<Progetto> listaProgettiConDipendentiRALSuperioriAl29999() throws Exception;

    public List<Progetto> trovaProgettiAnomali() throws Exception;
}
