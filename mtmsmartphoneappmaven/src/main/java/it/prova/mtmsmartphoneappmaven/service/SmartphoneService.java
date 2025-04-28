package it.prova.mtmsmartphoneappmaven.service;

import it.prova.mtmsmartphoneappmaven.dao.Smartphone.SmartphoneDAO;
import it.prova.mtmsmartphoneappmaven.model.App;
import it.prova.mtmsmartphoneappmaven.model.Smartphone;

import java.util.List;

public interface SmartphoneService {

    List<Smartphone> listAll() throws Exception;

    Smartphone caricaSingoloElemento(Long id) throws Exception;

    Smartphone caricaSingoloElementoEagerApps(Long id) throws Exception;

    void aggiorna(Smartphone smartphoneInstance) throws Exception;

    void inserisciNuovo(Smartphone smartphoneInstance) throws Exception;

    void rimuovi(Long idSmartphone) throws Exception;

    void rimuoviMaPrimaScollegaApps(Long idSmartphone) throws Exception;

    void aggiungiApp(Smartphone smartphoneInstance, App appInstance) throws Exception;

    void setSmartphoneDAO(SmartphoneDAO smartphoneDAO);

    void aggiornaVersioneOS(Long idSmartphone, String nuovaVersioneOS) throws Exception;

    void aggiornaVersioneOS(Smartphone smartphone) throws Exception;

    void installaAppEsistenteSuSmartphoneEsistente(Long idSmartphone, Long idApp) throws Exception;

    void disinstallaAppDaSmartphone(Long idSmartphone, Long idApp) throws Exception;

}