package it.prova.gestioneordiniarticolicategorie.dao.Categoria;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
    void deleteCategoriaAndUnlinkArticoli(Long idCategoria) throws Exception;

}
