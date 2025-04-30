package it.prova.gestioneordiniarticolicategorie.dao.Articolo;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;

import java.util.List;

public interface ArticoloDAO extends IBaseDAO<Articolo> {
    void deleteArticoloAndUnlinkCategorie(Long idArticolo) throws Exception;
    Double sumPrezziByCategoriaId(Long idCategoria) throws Exception;
    Double sumPrezziByDestinatario(String nomeDestinatario) throws Exception;
    List<Articolo> findArticoliSpeditiOltreScadenza() throws Exception;


}
