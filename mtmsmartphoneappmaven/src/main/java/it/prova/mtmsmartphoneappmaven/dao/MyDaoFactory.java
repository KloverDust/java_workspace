package it.prova.mtmsmartphoneappmaven.dao;

import it.prova.mtmsmartphoneappmaven.dao.App.AppDAO;
import it.prova.mtmsmartphoneappmaven.dao.App.AppDAOImpl;
import it.prova.mtmsmartphoneappmaven.dao.Smartphone.SmartphoneDAO;
import it.prova.mtmsmartphoneappmaven.dao.Smartphone.SmartphoneDAOImpl;

public class MyDaoFactory {

	private static AppDAO appDaoInstance = null;
	private static SmartphoneDAO smartphoneDaoInstance = null;

	public static AppDAO getAppDAOInstance() {
		if (appDaoInstance == null)
			appDaoInstance = new AppDAOImpl();

		return appDaoInstance;
	}

	public static SmartphoneDAO getSmartphoneDAOInstance() {
		if (smartphoneDaoInstance == null)
			smartphoneDaoInstance = new SmartphoneDAOImpl();

		return smartphoneDaoInstance;
	}

}
