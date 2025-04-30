package it.prova.gestioneordiniarticolicategorie.service;

import it.prova.gestioneordiniarticolicategorie.dao.Articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

import javax.persistence.EntityManager;
import java.util.List;

public class ArticoloServiceImpl implements ArticoloService{
    private ArticoloDAO articoloDAO;

    @Override
    public List<Articolo> listAll() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            articoloDAO.setEntityManager(entityManager);
            return articoloDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public Articolo caricaSingoloArticolo(Long id) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            articoloDAO.setEntityManager(em);
            Articolo articolo = articoloDAO.get(id);
            if (articolo != null) {
                // forza il caricamento della collezione lazy
                articolo.getCategorie().size();
            }
            return articolo;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }


    @Override
    public void aggiornaArticolo(Articolo articoloInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            articoloDAO.setEntityManager(entityManager);
            articoloDAO.update(articoloInstance);

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
    public void inserisciNuovoArticolo(Articolo articoloInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            articoloDAO.setEntityManager(entityManager);
            articoloDAO.insert(articoloInstance);

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
    public void rimuoviArticolo(Long idArticolo) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            articoloDAO.setEntityManager(entityManager);
            articoloDAO.delete(articoloDAO.get(idArticolo));
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
            articoloDAO.setEntityManager(em);

            Ordine ordine = em.find(Ordine.class, idOrdine);
            if (ordine == null)
                throw new Exception("Ordine non trovato: " + idOrdine);

            Articolo articolo = em.find(Articolo.class, idArticolo);
            if (articolo == null)
                throw new Exception("Articolo non trovato: " + idArticolo);

            ordine.addArticolo(articolo);
            //articolo.setOrdine(ordine);

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
            articoloDAO.setEntityManager(em);

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
    public void aggiungiArticoloACategoria(Long idCategoria, Long idArticolo) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            articoloDAO.setEntityManager(em);

            Categoria categoria = em.find(Categoria.class, idCategoria);
            if (categoria == null)
                throw new Exception("Ordine non trovato: " + idCategoria);

            Articolo articolo = em.find(Articolo.class, idArticolo);
            if (articolo == null)
                throw new Exception("Articolo non trovato: " + idArticolo);

            categoria.addArticolo(articolo);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void rimuoviArticoloDaCategoria(Long idCategoria, Long idArticolo) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            articoloDAO.setEntityManager(em);

            Categoria categoria = em.find(Categoria.class, idCategoria);
            if (categoria == null)
                throw new Exception("Ordine non trovato: " + idCategoria);

            Articolo articolo = em.find(Articolo.class, idArticolo);
            if (articolo == null)
                throw new Exception("Articolo non trovato: " + idArticolo);

            categoria.removeArticolo(articolo);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public Articolo cercaPerDescrizione(String descrizione) throws Exception {
        return null;
    }

    @Override
    public void setArticoloDAO(ArticoloDAO articoloDAO) {
        this.articoloDAO = articoloDAO;
    }

    @Override
    public void rimuoviArticoloEScollegaCategorie(Long idArticolo) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            articoloDAO.setEntityManager(em);
            articoloDAO.deleteArticoloAndUnlinkCategorie(idArticolo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public Double sommaPrezziArticoliPerCategoria(Long idCategoria) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            articoloDAO.setEntityManager(em);
            return articoloDAO.sumPrezziByCategoriaId(idCategoria);
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public Double sommaPrezziArticoliPerDestinatario(String nomeDestinatario) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            articoloDAO.setEntityManager(em);
            return articoloDAO.sumPrezziByDestinatario(nomeDestinatario);
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public List<Articolo> listArticoliSpeditiOltreScadenza() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            articoloDAO.setEntityManager(em);
            List<Articolo> risultati = articoloDAO.findArticoliSpeditiOltreScadenza();
            // forza il caricamento lazy di eventuali campi che servono
            for (Articolo a : risultati) {
                a.getOrdine().getDataSpedizione();
                a.getOrdine().getDataScadenza();
            }
            return risultati;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }



}
