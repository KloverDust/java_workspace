package it.prova.gestioneordiniarticolicategorie.service;

import it.prova.gestioneordiniarticolicategorie.dao.Categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaServiceImpl implements CategoriaService{
    private CategoriaDAO categoriaDAO;

    @Override
    public List<Categoria> listAll() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            categoriaDAO.setEntityManager(em);
            return categoriaDAO.list();
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public Categoria caricaSingolaCategoria(Long id) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            categoriaDAO.setEntityManager(em);
            Categoria categoria = categoriaDAO.get(id);
            if (categoria == null) {
                return null;
            }
            // forzo il caricamento dei lazy
            categoria.getArticoli().size();
            return categoria;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }


    @Override
    public void inserisciNuovaCategoria(Categoria categoriaInstance) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            categoriaDAO.setEntityManager(em);
            categoriaDAO.insert(categoriaInstance);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void aggiornaCategoria(Categoria categoriaInstance) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            categoriaDAO.setEntityManager(em);
            categoriaDAO.update(categoriaInstance);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

    @Override
    public void rimuoviCategoria(Long idCategoria) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            categoriaDAO.setEntityManager(em);
            Categoria managed = categoriaDAO.get(idCategoria);
            categoriaDAO.delete(managed);
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
            categoriaDAO.setEntityManager(em);

            Categoria categoria = em.find(Categoria.class, idCategoria);
            if (categoria == null)
                throw new Exception("Categoria non trovata: " + idCategoria);

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
            categoriaDAO.setEntityManager(em);

            Categoria categoria = em.find(Categoria.class, idCategoria);
            if (categoria == null)
                throw new Exception("Categoria non trovata: " + idCategoria);

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
    public List<Categoria> cercaPerDescrizione(String descrizione) throws Exception {
        return List.of();
    }

    @Override
    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public void rimuoviCategoriaEScollegaArticoli(Long idCategoria) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            categoriaDAO.setEntityManager(em);
            categoriaDAO.deleteCategoriaAndUnlinkArticoli(idCategoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(em);
        }
    }

}
