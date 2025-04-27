package it.prova.proprietarioautomobilejpa.dao.automobile;

import it.prova.proprietarioautomobilejpa.model.Automobile;
import it.prova.proprietarioautomobilejpa.model.Proprietario;

import javax.persistence.EntityManager;
import java.util.List;

public class AutomobileDAOImpl implements AutomobileDAO{
    private EntityManager entityManager;

    @Override
    public List<Automobile> list() throws Exception {
        return entityManager.createQuery("from Automobile", Automobile.class).getResultList();

    }

    @Override
    public Automobile get(Long id) throws Exception {
        return entityManager.find(Automobile.class, id);
    }

    @Override
    public void update(Automobile o) throws Exception {
        if (o == null) {
            throw new Exception("Problema valore in input");
        }

        o = entityManager.merge(o);
    }

    @Override
    public void insert(Automobile o) throws Exception {
        if (o == null) {
            throw new Exception("Problema valore in input");
        }

        entityManager.persist(o);
    }

    @Override
    public void delete(Automobile o) throws Exception {
        if(o == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(o));
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
