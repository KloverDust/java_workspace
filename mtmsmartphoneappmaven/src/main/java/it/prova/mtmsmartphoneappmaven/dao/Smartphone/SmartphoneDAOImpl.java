package it.prova.mtmsmartphoneappmaven.dao.Smartphone;

import it.prova.mtmsmartphoneappmaven.model.App;
import it.prova.mtmsmartphoneappmaven.model.Smartphone;

import javax.persistence.EntityManager;
import java.util.List;

public class SmartphoneDAOImpl implements SmartphoneDAO{
    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Smartphone> list() throws Exception {
        return entityManager.createQuery("from Smartphone", Smartphone.class).getResultList();

    }

    @Override
    public Smartphone get(Long id) throws Exception {
        return entityManager.find(Smartphone.class, id);

    }

    @Override
    public void update(Smartphone o) throws Exception {

    }

    @Override
    public void insert(Smartphone input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Smartphone o) throws Exception {

    }

    @Override
    public void updateVersioneOS(Long idSmartphone, String nuovaVersioneOS) throws Exception {
        Smartphone s = entityManager.find(Smartphone.class, idSmartphone);
        if (s == null) {
            throw new Exception("Smartphone con id " + idSmartphone + " non trovato.");
        }
        s.setVersioneOS(nuovaVersioneOS);
    }

    @Override
    public void updateVersioneOS(Smartphone smartphoneInstance) throws Exception {
        entityManager.merge(smartphoneInstance);
    }



}
