package it.prova.mtmsmartphoneappmaven.service;

import it.prova.mtmsmartphoneappmaven.dao.App.AppDAO;
import it.prova.mtmsmartphoneappmaven.dao.EntityManagerUtil;
import it.prova.mtmsmartphoneappmaven.model.App;
import it.prova.mtmsmartphoneappmaven.model.Smartphone;

import javax.persistence.EntityManager;
import java.util.List;

public class AppServiceImpl implements AppService{
    private AppDAO appDAO;

    @Override
    public void setAppDAO(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @Override
    public List<App> listAll() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            appDAO.setEntityManager(em);
            return appDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public App caricaSingoloElemento(Long id) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            appDAO.setEntityManager(em);
            return appDAO.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public App caricaSingoloElementoEagerSmartphones(Long id) throws Exception {
        return null;
    }

    @Override
    public void aggiorna(App appInstance) throws Exception {

    }

    @Override
    public void inserisciNuovo(App appInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            appDAO.setEntityManager(entityManager);
            appDAO.insert(appInstance);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void rimuovi(Long idApp) throws Exception {

    }

    @Override
    public void rimuoviMaPrimaScollegaSmartphones(Long idApp) throws Exception {

    }

    @Override
    public void aggiungiSmartphone(App appInstance, Smartphone smartphoneInstance) throws Exception {

    }

    @Override
    public void aggiornaVersioneEData(App appInstance) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            appDAO.setEntityManager(em);
            appDAO.updateVersioneEData(appInstance);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }


}
