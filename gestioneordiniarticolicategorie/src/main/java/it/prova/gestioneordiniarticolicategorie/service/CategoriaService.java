package it.prova.gestioneordiniarticolicategorie.service;

import it.prova.gestioneordiniarticolicategorie.dao.Categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> listAll() throws Exception;

    Categoria caricaSingolaCategoria(Long id) throws Exception;

    void inserisciNuovaCategoria(Categoria categoriaInstance) throws Exception;

    void aggiornaCategoria(Categoria categoriaInstance) throws Exception;

    void rimuoviCategoria(Long idCategoria) throws Exception;

    void aggiungiArticoloACategoria(Long idCategoria, Long idArticolo) throws Exception;
    void rimuoviArticoloDaCategoria(Long idCategoria, Long idArticolo) throws Exception;

    List<Categoria> cercaPerDescrizione(String descrizione) throws Exception;

    void setCategoriaDAO(CategoriaDAO categoriaDAO);

    void rimuoviCategoriaEScollegaArticoli(Long idCategoria) throws Exception;

}
