package it.prova.mtmsmartphoneappmaven.service;

import it.prova.mtmsmartphoneappmaven.dao.EntityManagerUtil;
import it.prova.mtmsmartphoneappmaven.dao.Smartphone.SmartphoneDAO;
import it.prova.mtmsmartphoneappmaven.model.App;
import it.prova.mtmsmartphoneappmaven.model.Smartphone;

import javax.persistence.EntityManager;
import java.util.List;

public class SmartphoneServiceImpl implements SmartphoneService{
    private SmartphoneDAO smartphoneDAO;

    @Override
    public List<Smartphone> listAll() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            smartphoneDAO.setEntityManager(em);
            return smartphoneDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public Smartphone caricaSingoloElemento(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            smartphoneDAO.setEntityManager(entityManager);
            return smartphoneDAO.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public Smartphone caricaSingoloElementoEagerApps(Long id) throws Exception {
        return null;
    }

    @Override
    public void aggiorna(Smartphone smartphoneInstance) throws Exception {

    }

    @Override
    public void inserisciNuovo(Smartphone smartphoneInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            smartphoneDAO.setEntityManager(entityManager);
            smartphoneDAO.insert(smartphoneInstance);
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
    public void aggiornaVersioneOS(Long idSmartphone, String nuovaVersioneOS) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            smartphoneDAO.setEntityManager(em);
            smartphoneDAO.updateVersioneOS(idSmartphone, nuovaVersioneOS);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void aggiornaVersioneOS(Smartphone smartphoneInstance) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            smartphoneDAO.setEntityManager(em);
            smartphoneDAO.updateVersioneOS(smartphoneInstance);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }


    @Override
    public void rimuovi(Long idSmartphone) throws Exception {

    }

    @Override
    public void rimuoviMaPrimaScollegaApps(Long idSmartphone) throws Exception {

    }

    @Override
    public void aggiungiApp(Smartphone smartphoneInstance, App appInstance) throws Exception {

    }

    @Override
    public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO) {
        this.smartphoneDAO = smartphoneDAO;
    }
}
