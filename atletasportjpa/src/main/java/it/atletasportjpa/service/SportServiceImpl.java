package it.atletasportjpa.service;

import it.atletasportjpa.dao.AtletaDAO;
import it.atletasportjpa.dao.EntityManagerUtil;
import it.atletasportjpa.dao.SportDAO;
import it.atletasportjpa.model.Atleta;
import it.atletasportjpa.model.NomiSport;
import it.atletasportjpa.model.Sport;

import javax.persistence.EntityManager;
import java.util.List;

public class SportServiceImpl implements SportService{
    private SportDAO sportDAO;
    private AtletaDAO atletaDAO;

    @Override
    public List<Sport> caricaTuttiSport() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            sportDAO.setEntityManager(em);
            return sportDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public List<Sport> caricaSportDaDescrizione(String descrizione) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            sportDAO.setEntityManager(em);
            return sportDAO.findByDescrizione(descrizione);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public Sport caricaSportDaId(Long id) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            sportDAO.setEntityManager(em);
            return sportDAO.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void inserisciNuovoSport(String descrizione) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            sportDAO.setEntityManager(em);

            Sport nuovo = new Sport(NomiSport.valueOf(descrizione.toUpperCase()));
            sportDAO.insert(nuovo);

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
    public void aggiornaSport(Long idSport, String descrizione) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            sportDAO.setEntityManager(em);

            Sport esistente = sportDAO.get(idSport);
            if (esistente == null) {
                throw new Exception("Sport non trovato con id: " + idSport);
            }
            esistente = em.merge(esistente);
            esistente.setDescrizione(NomiSport.valueOf(descrizione.toUpperCase()));

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
    public void rimuoviSport(Long idSport) throws Exception {
        if (idSport == null) throw new Exception("Input non valido");
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            sportDAO.setEntityManager(em);
            atletaDAO.setEntityManager(em);

            Sport daRimuovere = sportDAO.get(idSport);
            if (daRimuovere == null) throw new Exception("Sport non trovato con id: " + idSport);

            List<Atleta> atleti = atletaDAO.findAllBySport(daRimuovere);
            for (Atleta a : atleti) {
                Atleta managed = em.merge(a);
                managed.getSportPraticati().remove(daRimuovere);
            }
            sportDAO.delete(daRimuovere);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void setSportDAO(SportDAO sportDAO){
        this.sportDAO = sportDAO;
    }

    @Override
    public void setAtletaDAO(AtletaDAO atletaDAO){
        this.atletaDAO = atletaDAO;
    }

    @Override
    public void aggiungiSportAdAtleta(Atleta atleta) throws Exception {
        if (atleta == null) {
            throw new Exception("Problema valore in input");
        }

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            sportDAO.setEntityManager(em);
            sportDAO.addSportToAthlete(atleta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void rimuoviSportDaAtleta(Atleta atleta) throws Exception {
        if (atleta == null) {
            throw new Exception("Problema valore in input");
        }

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            sportDAO.setEntityManager(em);
            sportDAO.removeSportFromAthlete(atleta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void rimuoviAtletaDopoScollegamentoDaSport(Atleta atleta) throws Exception {
        if (atleta == null) {
            throw new Exception("Problema valore in input");
        }

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            sportDAO.setEntityManager(em);

            Atleta managed = em.merge(atleta);
            sportDAO.removeAthleteAfterRemovalFromSport(managed);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public List<Sport> trovaSportConDateIncoerenti() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            sportDAO.setEntityManager(em);
            return sportDAO.findByIncoherentDates();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }
}
