package it.prova.gestioneordiniarticolicategorie.dao.Articolo;

import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;

public class ArticoloDAOImpl implements ArticoloDAO{
    private EntityManager entityManager;

    @Override
    public List<Articolo> list() throws Exception {
        return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
    }

    @Override
    public Articolo get(Long id) throws Exception {
        return entityManager.find(Articolo.class, id);
    }

    @Override
    public void update(Articolo input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        input = entityManager.merge(input);
    }

    @Override
    public void insert(Articolo input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Articolo input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(input));
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void deleteArticoloAndUnlinkCategorie(Long idArticolo) throws Exception {
        Articolo a = entityManager.find(Articolo.class, idArticolo);
        if (a == null) {
            throw new Exception("Articolo non trovato: " + idArticolo);
        }

        for (Categoria c : new HashSet<>(a.getCategorie())) {
            a.getCategorie().remove(c);
            c.getArticoli().remove(a);
        }
        entityManager.remove(a);
    }

    @Override
    public Double sumPrezziByCategoriaId(Long idCategoria) throws Exception {
        Double result = entityManager.createQuery("SELECT SUM(a.prezzoSingolo) " + "FROM Categoria c JOIN c.articoli a " + "WHERE c.id = :idCategoria", Double.class)
                .setParameter("idCategoria", idCategoria)
                .getSingleResult();
        return result != null ? result : 0.0;
    }

    @Override
    public Double sumPrezziByDestinatario(String nomeDestinatario) throws Exception {
        Double result = entityManager.createQuery("SELECT SUM(a.prezzoSingolo) " + "FROM Articolo a " + "WHERE a.ordine.nomeDestinatario = :nome", Double.class)
                .setParameter("nome", nomeDestinatario)
                .getSingleResult();
        return result != null ? result : 0.0;
    }

    @Override
    public List<Articolo> findArticoliSpeditiOltreScadenza() throws Exception {
        return entityManager.createQuery(
                        "SELECT a FROM Articolo a " + " WHERE a.ordine.dataSpedizione > a.ordine.dataScadenza", Articolo.class)
                .getResultList();
    }




}
