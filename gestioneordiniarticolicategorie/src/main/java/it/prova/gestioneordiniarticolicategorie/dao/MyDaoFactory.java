package it.prova.gestioneordiniarticolicategorie.dao;

import it.prova.gestioneordiniarticolicategorie.dao.Articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.Articolo.ArticoloDAOImpl;
import it.prova.gestioneordiniarticolicategorie.dao.Categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.dao.Categoria.CategoriaDAOImpl;
import it.prova.gestioneordiniarticolicategorie.dao.Ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.dao.Ordine.OrdineDAOImpl;


public class MyDaoFactory {

	private static ArticoloDAO articoloDaoInstance = null;
	private static OrdineDAO ordineDaoInstance = null;
	private static CategoriaDAO categoriaDaoInstance = null;

	public static ArticoloDAO getArticoloDAOInstance() {
		if (articoloDaoInstance == null)
			articoloDaoInstance = new ArticoloDAOImpl();

		return articoloDaoInstance;
	}
	public static OrdineDAO getOrdineDAOInstance() {
		if (ordineDaoInstance == null)
			ordineDaoInstance = new OrdineDAOImpl();

		return ordineDaoInstance;
	}
	public static CategoriaDAO getCategoriaDAOInstance() {
		if (categoriaDaoInstance == null)
			categoriaDaoInstance = new CategoriaDAOImpl();

		return categoriaDaoInstance;
	}

}
