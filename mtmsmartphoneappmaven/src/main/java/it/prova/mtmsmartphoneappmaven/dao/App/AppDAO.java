package it.prova.mtmsmartphoneappmaven.dao.App;

import it.prova.mtmsmartphoneappmaven.dao.IBaseDAO;
import it.prova.mtmsmartphoneappmaven.model.App;

public interface AppDAO extends IBaseDAO<App> {
    public  void updateVersioneEData(App appInstance) throws Exception;
}
