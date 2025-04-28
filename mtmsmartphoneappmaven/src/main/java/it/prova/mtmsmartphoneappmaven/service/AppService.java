package it.prova.mtmsmartphoneappmaven.service;


import java.util.List;

import it.prova.mtmsmartphoneappmaven.dao.App.AppDAO;
import it.prova.mtmsmartphoneappmaven.model.App;
import it.prova.mtmsmartphoneappmaven.model.Smartphone;

public interface AppService {

    List<App> listAll() throws Exception;

    App caricaSingoloElemento(Long id) throws Exception;

    App caricaSingoloElementoEagerSmartphones(Long id) throws Exception;

    void aggiorna(App appInstance) throws Exception;

    void inserisciNuovo(App appInstance) throws Exception;

    void rimuovi(Long idApp) throws Exception;

    void rimuoviMaPrimaScollegaSmartphones(Long idApp) throws Exception;

    void aggiungiSmartphone(App appInstance, Smartphone smartphoneInstance) throws Exception;

    void setAppDAO(AppDAO appDAO);

    void aggiornaVersioneEData(App appInstance) throws Exception;
}
