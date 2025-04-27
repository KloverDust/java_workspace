package it.atletasportmanytomany.dao;

import it.atletasportmanytomany.model.Atleta;

import javax.persistence.EntityManager;
import java.util.List;

public class AtletaDAOImpl implements AtletaDAO{
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Atleta> list() throws Exception {
        return entityManager
                .createQuery("SELECT a FROM Atleta a", Atleta.class)
                .getResultList();
    }

    @Override
    public Atleta get(Long id) throws Exception {
        return entityManager.find(Atleta.class, id);
    }

    @Override
    public void update(Atleta o) throws Exception {
        if (o == null) {
            throw new Exception("Problema valore in input");
        }
        // merge aggiorna lo stato dell'entità nel persistence context
        entityManager.merge(o);
    }

    @Override
    public void insert(Atleta o) throws Exception {
        if (o == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(o);
    }

    @Override
    public void delete(Atleta o) throws Exception {
        if(o == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(o));
    }

}
