package it.prova.gestioneordiniarticolicategorie.service;

import it.prova.gestioneordiniarticolicategorie.dao.Articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

import java.util.List;

public interface ArticoloService {

    public List<Articolo> listAll() throws Exception;

    public Articolo caricaSingoloArticolo(Long id) throws Exception;

    public void aggiornaArticolo(Articolo articoloInstance) throws Exception;

    public void inserisciNuovoArticolo(Articolo articoloInstance) throws Exception;

    public void rimuoviArticolo(Long idArticolo) throws Exception;

    public void aggiungiArticoloAOrdine(Long idOrdine, Long idArticolo) throws Exception;
    public void rimuoviArticoloDaOrdine(Long idOrdine, Long idArticolo) throws Exception;

    public void aggiungiArticoloACategoria(Long idCategoria, Long idArticolo) throws Exception;
    public void rimuoviArticoloDaCategoria(Long idCategoria, Long idArticolo) throws Exception;

    public Articolo cercaPerDescrizione(String descrizione) throws Exception;

    public void setArticoloDAO(ArticoloDAO articoloDAO);

    public void rimuoviArticoloEScollegaCategorie(Long idArticolo) throws Exception;

    public Double sommaPrezziArticoliPerCategoria(Long idCategoria) throws Exception;

    public Double sommaPrezziArticoliPerDestinatario(String nomeDestinatario) throws Exception;

    public List<Articolo> listArticoliSpeditiOltreScadenza() throws Exception;

}
