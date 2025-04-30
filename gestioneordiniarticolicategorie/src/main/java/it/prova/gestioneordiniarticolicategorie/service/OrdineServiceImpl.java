package it.prova.gestioneordiniarticolicategorie.service;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.Ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdineServiceImpl implements OrdineService{
    private OrdineDAO ordineDAO;

    @Override
    public List<Ordine> listAll() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            ordineDAO.setEntityManager(em);
            return ordineDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public Ordine caricaSingoloOrdine(Long id) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            ordineDAO.setEntityManager(em);
            return ordineDAO.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void inserisciNuovoOrdine(Ordine ordineInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            ordineDAO.setEntityManager(entityManager);
            ordineDAO.insert(ordineInstance);
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
    public void aggiornaOrdine(Ordine ordineInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            ordineDAO.setEntityManager(entityManager);
            ordineDAO.update(ordineInstance);

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
    public void rimuoviOrdine(Long idOrdine) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            ordineDAO.setEntityManager(entityManager);
            Long n = ordineDAO.countArticoliByOrdineId(idOrdine);
            if (n > 0) {
                throw new RuntimeException(
                        "Impossibile eliminare l'ordine (id=" + idOrdine + "): ci sono ancora " + n + " articoli"
                );
            }
            ordineDAO.delete(ordineDAO.get(idOrdine));

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
    public void aggiungiArticoloAOrdine(Long idOrdine, Long idArticolo) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            ordineDAO.setEntityManager(em);

            Ordine ordine = em.find(Ordine.class, idOrdine);
            if (ordine == null)
                throw new Exception("Ordine non trovato: " + idOrdine);

            Articolo articolo = em.find(Articolo.class, idArticolo);
            if (articolo == null)
                throw new Exception("Articolo non trovato: " + idArticolo);

            ordine.addArticolo(articolo);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void rimuoviArticoloDaOrdine(Long idOrdine, Long idArticolo) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            ordineDAO.setEntityManager(em);

            Ordine ordine = em.find(Ordine.class, idOrdine);
            if (ordine == null)
                throw new Exception("Ordine non trovato: " + idOrdine);

            Articolo articolo = em.find(Articolo.class, idArticolo);
            if (articolo == null)
                throw new Exception("Articolo non trovato: " + idArticolo);

            ordine.removeArticolo(articolo);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void setOrdineDAO(OrdineDAO ordineDAO) {
        this.ordineDAO = ordineDAO;
    }

    @Override
    public Ordine caricaOrdinePiuRecentePerCategoria(Long idCategoria) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            ordineDAO.setEntityManager(em);
            return ordineDAO.findLatestByCategoriaId(idCategoria);
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public List<String> listaIndirizziPerSerialeArticolo(String seriale) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            ordineDAO.setEntityManager(em);
            return ordineDAO.findDistinctIndirizziBySerialeLike(seriale);
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

}
