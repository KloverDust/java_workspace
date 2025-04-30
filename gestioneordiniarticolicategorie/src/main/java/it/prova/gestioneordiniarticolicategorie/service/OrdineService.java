package it.prova.gestioneordiniarticolicategorie.service;

import it.prova.gestioneordiniarticolicategorie.dao.Ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;
import java.util.List;

public interface OrdineService {

    List<Ordine> listAll() throws Exception;

    Ordine caricaSingoloOrdine(Long id) throws Exception;

    void inserisciNuovoOrdine(Ordine ordineInstance) throws Exception;

    void aggiornaOrdine(Ordine ordineInstance) throws Exception;

    void rimuoviOrdine(Long idOrdine) throws Exception;

    void aggiungiArticoloAOrdine(Long idOrdine, Long idArticolo) throws Exception;
    void rimuoviArticoloDaOrdine(Long idOrdine, Long idArticolo) throws Exception;

    void setOrdineDAO(OrdineDAO ordineDAO);

    Ordine caricaOrdinePiuRecentePerCategoria(Long idCategoria) throws Exception;

    List<String> listaIndirizziPerSerialeArticolo(String seriale) throws Exception;


    //List<Long> estraiArticoliAssociatiAdOrdine(Long idOrdine) throws Exception;

    //List<Ordine> findOrdiniInRitardo() throws Exception;
}
