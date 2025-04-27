package it.prova.proprietarioautomobilejpa.service.automobile;

import it.prova.proprietarioautomobilejpa.dao.EntityManagerUtil;
import it.prova.proprietarioautomobilejpa.dao.automobile.AutomobileDAO;
import it.prova.proprietarioautomobilejpa.model.Automobile;
import it.prova.proprietarioautomobilejpa.model.Proprietario;

import javax.persistence.EntityManager;
import java.util.List;

public class AutomobileServiceImpl implements AutomobileService{
    private AutomobileDAO automobileDAO;

    @Override
    public void setAutomobileDAO(AutomobileDAO automobileDAO) {
        this.automobileDAO = automobileDAO;
    }

    @Override
    public Automobile caricaSingolaAutomobile(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            automobileDAO.setEntityManager(entityManager);
            return automobileDAO.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public List<Automobile> caricaTutteAutomobili() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            automobileDAO.setEntityManager(entityManager);
            return automobileDAO.list();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void aggiornaAutomobile(Automobile automobileInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            automobileDAO.setEntityManager(entityManager);
            automobileDAO.update(automobileInstance);
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
    public void inserisciNuovaAutomobile(Automobile automobileInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            automobileDAO.setEntityManager(entityManager);
            automobileDAO.insert(automobileInstance);
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
    public void rimuoviAutomobile(Long idAutomobileInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        if (idAutomobileInstance == null) {
            throw new Exception("Problema valore in input");
        }

        try {
            entityManager.getTransaction().begin();
            automobileDAO.setEntityManager(entityManager);
            Automobile automobileInstance = automobileDAO.get(idAutomobileInstance);
            automobileDAO.delete(automobileInstance);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }
}
