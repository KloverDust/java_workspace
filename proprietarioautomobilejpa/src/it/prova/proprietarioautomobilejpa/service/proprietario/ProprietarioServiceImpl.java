package it.prova.proprietarioautomobilejpa.service.proprietario;

import it.prova.proprietarioautomobilejpa.dao.EntityManagerUtil;
import it.prova.proprietarioautomobilejpa.dao.proprietario.ProprietarioDAO;
import it.prova.proprietarioautomobilejpa.model.Proprietario;

import javax.persistence.EntityManager;
import java.util.List;

public class ProprietarioServiceImpl implements ProprietarioService{
    private ProprietarioDAO proprietarioDAO;

    @Override
    public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
        this.proprietarioDAO = proprietarioDAO;
    }

    @Override
    public Proprietario caricaSingoloProprietario(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            proprietarioDAO.setEntityManager(entityManager);
            return proprietarioDAO.get(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public List<Proprietario> caricaTuttiProprietari() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            proprietarioDAO.setEntityManager(entityManager);
            return proprietarioDAO.list();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void aggiornaProprietario(Proprietario proprietarioInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            proprietarioDAO.setEntityManager(entityManager);
            proprietarioDAO.update(proprietarioInstance);
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
    public void inserisciNuovoProprietario(Proprietario proprietarioInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            proprietarioDAO.setEntityManager(entityManager);
            proprietarioDAO.insert(proprietarioInstance);
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
    public void rimuoviProprietario(Long idProprietarioInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        if (idProprietarioInstance == null) {
            throw new Exception("Problema valore in input");
        }

        try {
            entityManager.getTransaction().begin();
            proprietarioDAO.setEntityManager(entityManager);
            Proprietario proprietarioInstance = proprietarioDAO.get(idProprietarioInstance);
            proprietarioDAO.delete(proprietarioInstance);
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
