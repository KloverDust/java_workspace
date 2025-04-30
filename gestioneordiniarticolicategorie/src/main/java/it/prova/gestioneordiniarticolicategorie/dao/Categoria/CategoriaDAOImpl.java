package it.prova.gestioneordiniarticolicategorie.dao.Categoria;

import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO{
    private EntityManager entityManager;

    @Override
    public List<Categoria> list() throws Exception {
        return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
    }

    @Override
    public Categoria get(Long id) throws Exception {
        return entityManager.find(Categoria.class, id);
    }

    @Override
    public void update(Categoria input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        input = entityManager.merge(input);
    }

    @Override
    public void insert(Categoria input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Categoria input) throws Exception {
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
    public void deleteCategoriaAndUnlinkArticoli(Long idCategoria) throws Exception {
        Categoria c = entityManager.find(Categoria.class, idCategoria);
        if (c == null) {
            throw new Exception("Categoria non trovata: " + idCategoria);
        }
        for (Articolo a : new HashSet<>(c.getArticoli())) {
            c.getArticoli().remove(a);
            a.getCategorie().remove(c);
        }
        entityManager.remove(c);
    }

}
