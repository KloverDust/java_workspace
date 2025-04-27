package it.atletasportjpa.dao;

import it.atletasportjpa.model.Atleta;
import it.atletasportjpa.model.Sport;

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

    @Override
    public List<Atleta> findAllBySport(Sport sport) throws Exception {
        return entityManager
                .createQuery(
                        "SELECT a FROM Atleta a JOIN a.sportPraticati s WHERE s = :sport",
                        Atleta.class)
                .setParameter("sport", sport)
                .getResultList();
    }

    @Override
    public Long sumMedaglieAtletiSportFiniti() throws Exception {
        return entityManager.createQuery(
                        "SELECT SUM(a.numeroMedaglieVinte) " +
                                "  FROM Atleta a JOIN a.sportPraticati s " +
                                " WHERE s.dataFine IS NOT NULL " +
                                "   AND s.dataFine < CURRENT_DATE", Long.class)
                .getSingleResult();
    }

}
