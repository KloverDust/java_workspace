package it.atletasportjpa.service;

import it.atletasportjpa.dao.AtletaDAO;
import it.atletasportjpa.dao.EntityManagerUtil;
import it.atletasportjpa.dao.SportDAO;
import it.atletasportjpa.model.Atleta;

import javax.persistence.EntityManager;
import java.util.List;

public class AtletaServiceImpl implements AtletaService{
    private AtletaDAO atletaDAO;
    private SportDAO sportDAO;

    @Override
    public List<Atleta> caricaTuttiAtleti() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            atletaDAO.setEntityManager(em);
            return atletaDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public Atleta caricaSingoloAtleta(Long id) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            atletaDAO.setEntityManager(em);
            return atletaDAO.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public Atleta caricaSingoloAtletaConSport(Long id) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            atletaDAO.setEntityManager(em);
            Atleta atleta = atletaDAO.get(id);
            if (atleta != null) {
                // forzo il caricamento lazy della collezione
                atleta.getSportPraticati().size();
            }
            return atleta;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void inserisciNuovoAtleta(Atleta atletaInstance) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            atletaDAO.setEntityManager(em);
            atletaDAO.insert(atletaInstance);
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
    public void aggiornaAtleta(Atleta atletaInstance) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            atletaDAO.setEntityManager(em);
            atletaDAO.update(atletaInstance);
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
    public void rimuoviAtleta(Long idAtleta) throws Exception {
        if (idAtleta == null) {
            throw new Exception("Problema valore in input");
        }

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            atletaDAO.setEntityManager(em);

            Atleta atletaToRemove = atletaDAO.get(idAtleta);
            if (atletaToRemove == null) {
                throw new Exception("Atleta non trovato con id: " + idAtleta);
            }

            atletaToRemove = em.merge(atletaToRemove);
            atletaDAO.delete(atletaToRemove);

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
    public void setAtletaDAO(AtletaDAO atletaDAO) {
        this.atletaDAO = atletaDAO;
    }

    @Override
    public void setSportDAO(SportDAO sportDAO) {
        this.sportDAO = sportDAO;
    }

    @Override
    public Long calcolaSommaMedaglieAtletiSportFiniti() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            atletaDAO.setEntityManager(em);
            return atletaDAO.sumMedaglieAtletiSportFiniti();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }
}
