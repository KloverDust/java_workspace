package it.prova.mtmsmartphoneappmaven.dao.App;

import it.prova.mtmsmartphoneappmaven.model.App;

import javax.persistence.EntityManager;
import java.util.List;

public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<App> list() throws Exception {
        return entityManager.createQuery("from App", App.class).getResultList();
    }

    @Override
    public App get(Long id) throws Exception {
        return entityManager.find(App.class, id);
    }

    @Override
    public void update(App o) throws Exception {

    }

    @Override
    public void insert(App input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(App o) throws Exception {

    }


    @Override
    public void updateVersioneEData(App appInstance) throws Exception {
        entityManager.merge(appInstance);
    }
}
