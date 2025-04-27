package it.atletasportjpa.service;

import it.atletasportjpa.dao.MyDAOFactory;

public class MyServiceFactory {
    private static AtletaService ATLETA_SERVICE_INSTANCE = null;
    private static SportService SPORT_SERVICE_INSTANCE = null;

    public static AtletaService getAtletaServiceInstance() {
        if (ATLETA_SERVICE_INSTANCE == null)
            ATLETA_SERVICE_INSTANCE = new AtletaServiceImpl();

        ATLETA_SERVICE_INSTANCE.setAtletaDAO(MyDAOFactory.getAtletaDAOInstance());
        ATLETA_SERVICE_INSTANCE.setSportDAO(MyDAOFactory.getSportDAOInstance());
        return ATLETA_SERVICE_INSTANCE;
    }

    public static SportService getSportServiceInstance() {
        if (SPORT_SERVICE_INSTANCE == null)
            SPORT_SERVICE_INSTANCE = new SportServiceImpl();

        SPORT_SERVICE_INSTANCE.setSportDAO(MyDAOFactory.getSportDAOInstance());
        SPORT_SERVICE_INSTANCE.setAtletaDAO(MyDAOFactory.getAtletaDAOInstance());
        return SPORT_SERVICE_INSTANCE;
    }
}
