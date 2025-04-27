package it.prova.proprietarioautomobilejpa.service;

import it.prova.proprietarioautomobilejpa.dao.MyDaoFactory;
import it.prova.proprietarioautomobilejpa.service.automobile.AutomobileService;
import it.prova.proprietarioautomobilejpa.service.automobile.AutomobileServiceImpl;
import it.prova.proprietarioautomobilejpa.service.proprietario.ProprietarioService;
import it.prova.proprietarioautomobilejpa.service.proprietario.ProprietarioServiceImpl;

public class MyServiceFactory {

	// rendiamo le istanze restituite SINGLETON
	private static AutomobileService AutomobileServiceInstance = null;
	private static ProprietarioService ProprietarioServiceInstance = null;

	public static AutomobileService getAutomobileServiceInstance() {
		if (AutomobileServiceInstance == null) {
			AutomobileServiceInstance = new AutomobileServiceImpl();
			AutomobileServiceInstance.setAutomobileDAO(MyDaoFactory.getAutomobileDAOInstance());
		}
		return AutomobileServiceInstance;
	}

	public static ProprietarioService getProprietarioServiceInstance() {
		if (ProprietarioServiceInstance == null) {
			ProprietarioServiceInstance = new ProprietarioServiceImpl();
			ProprietarioServiceInstance.setProprietarioDAO(MyDaoFactory.getProprietarioDAOInstance());
		}
		return ProprietarioServiceInstance;
	}

}
