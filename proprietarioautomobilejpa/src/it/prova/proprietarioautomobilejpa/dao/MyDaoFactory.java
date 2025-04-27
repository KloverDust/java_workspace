package it.prova.proprietarioautomobilejpa.dao;

import it.prova.proprietarioautomobilejpa.dao.automobile.AutomobileDAO;
import it.prova.proprietarioautomobilejpa.dao.automobile.AutomobileDAOImpl;
import it.prova.proprietarioautomobilejpa.dao.proprietario.ProprietarioDAO;
import it.prova.proprietarioautomobilejpa.dao.proprietario.ProprietarioDAOImpl;
import it.prova.proprietarioautomobilejpa.model.Proprietario;

public class MyDaoFactory {

	// rendiamo questo factory SINGLETON
	private static AutomobileDAO automobileDAOInstance = null;
	private static ProprietarioDAO proprietarioDAOInstance = null;

	public static AutomobileDAO getAutomobileDAOInstance() {
		if (automobileDAOInstance == null)
			automobileDAOInstance = new AutomobileDAOImpl();
		return automobileDAOInstance;
	}

	public static ProprietarioDAO getProprietarioDAOInstance(){
		if(proprietarioDAOInstance == null)
			proprietarioDAOInstance = new ProprietarioDAOImpl();
		return proprietarioDAOInstance;
	}

}
