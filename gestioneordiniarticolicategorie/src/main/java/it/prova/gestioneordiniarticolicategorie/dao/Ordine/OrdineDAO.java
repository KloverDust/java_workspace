package it.prova.gestioneordiniarticolicategorie.dao.Ordine;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

import java.util.List;

public interface OrdineDAO extends IBaseDAO<Ordine> {
    Long countArticoliByOrdineId(Long idOrdine) throws Exception;
    Ordine findLatestByCategoriaId(Long idCategoria) throws Exception;
    List<String> findDistinctIndirizziBySerialeLike(String seriale) throws Exception;

}
