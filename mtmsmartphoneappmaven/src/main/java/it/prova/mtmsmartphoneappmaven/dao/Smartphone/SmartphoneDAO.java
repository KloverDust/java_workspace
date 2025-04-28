package it.prova.mtmsmartphoneappmaven.dao.Smartphone;

import it.prova.mtmsmartphoneappmaven.dao.IBaseDAO;
import it.prova.mtmsmartphoneappmaven.model.Smartphone;

public interface SmartphoneDAO extends IBaseDAO<Smartphone> {

   public void updateVersioneOS(Long idSmartphone, String nuovaVersioneOS) throws Exception;
   public void updateVersioneOS(Smartphone smartphoneInstance) throws Exception;
}
