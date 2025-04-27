package it.atletasportmanytomany.dao;

import it.atletasportmanytomany.model.Sport;

import javax.persistence.EntityManager;
import java.util.List;

public class SportDAOImpl implements SportDAO{
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Sport> list() throws Exception {
        return entityManager
                .createQuery("SELECT s FROM Sport s", Sport.class)
                .getResultList();
    }

    @Override
    public Sport get(Long id) throws Exception {
        return entityManager.find(Sport.class, id);
    }

    @Override
    public void update(Sport o) throws Exception {
        if (o == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.merge(o);
    }

    @Override
    public void insert(Sport o) throws Exception {
        if(o == null){
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(o);
    }

    @Override
    public void delete(Sport o) throws Exception {
        if (o == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(o));
    }

}
