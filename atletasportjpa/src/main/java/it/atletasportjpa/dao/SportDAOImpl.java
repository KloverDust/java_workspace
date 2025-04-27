package it.atletasportjpa.dao;

import it.atletasportjpa.model.Atleta;
import it.atletasportjpa.model.NomiSport;
import it.atletasportjpa.model.Sport;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<Sport> findByDescrizione(String descrizione) throws Exception {
        if (descrizione == null || descrizione.isBlank()) {
            throw new Exception("Descrizione non valida");
        }

        NomiSport nomeEnum = NomiSport.valueOf(descrizione.toUpperCase());
        try {
            return entityManager
                    .createQuery("SELECT s FROM Sport s WHERE s.descrizione = :desc", Sport.class)
                    .setParameter("desc", nomeEnum)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addSportToAthlete(Atleta atleta) throws Exception {
        if (atleta == null || atleta.getId() == null) {
            throw new Exception("Problema valore in input: atleta o id null");
        }

        Atleta managedAtleta = entityManager.find(Atleta.class, atleta.getId());
        if (managedAtleta == null) {
            throw new Exception("Atleta non trovato con id: " + atleta.getId());
        }

        for (Sport s : atleta.getSportPraticati()) {
            Sport managedSport = entityManager.find(Sport.class, s.getId());
            if (managedSport == null) {
                throw new Exception("Sport non trovato con id: " + s.getId());
            }
            if (!managedAtleta.getSportPraticati().contains(managedSport)) {
                managedAtleta.getSportPraticati().add(managedSport);
            }
        }
        entityManager.merge(managedAtleta);
    }

    @Override
    public void removeSportFromAthlete(Atleta atleta) throws Exception {
        if (atleta == null || atleta.getId() == null) {
            throw new Exception("Problema valore in input: atleta o id null");
        }
        Atleta managedAtleta = entityManager.find(Atleta.class, atleta.getId());
        if (managedAtleta == null) {
            throw new Exception("Atleta non trovato con id: " + atleta.getId());
        }

        for (Sport s : atleta.getSportPraticati()) {
            Sport managedSport = entityManager.find(Sport.class, s.getId());
            if (managedSport != null) {
                managedAtleta.getSportPraticati().remove(managedSport);
            }
        }
        entityManager.merge(managedAtleta);
    }

//    @Override
//    public void removeAthleteAfterRemovalFromSport(Atleta atleta) throws Exception {
//        if (atleta == null || atleta.getId() == null) {
//            throw new Exception("Problema valore in input: atleta o id null");
//        }
//
//        Atleta managedAtleta = entityManager.find(Atleta.class, atleta.getId());
//        if (managedAtleta == null) {
//            throw new Exception("Atleta non trovato con id: " + atleta.getId());
//        }
//
//        Set<Sport> sports = new HashSet<>(managedAtleta.getSportPraticati());
//        for (Sport s : sports) {
//            // rimuovo singolarmente l'associazione
//            managedAtleta.getSportPraticati().remove(s);
//            // flush per far partire subito il DELETE sulla join-table per questa singola riga
//            entityManager.flush();
//        }
//        entityManager.remove(managedAtleta);
//    }

    @Override
    public void removeAthleteAfterRemovalFromSport(Atleta atleta) throws Exception {
        if (atleta == null || atleta.getId() == null) {
            throw new Exception("Problema valore in input: atleta o id null");
        }

        Atleta managedAtleta = entityManager.find(Atleta.class, atleta.getId());
        if (managedAtleta == null) {
            throw new Exception("Atleta non trovato con id: " + atleta.getId());
        }

        entityManager.createNativeQuery(
                        "DELETE FROM atleta_sport WHERE atleta_id = :aid")
                .setParameter("aid", atleta.getId())
                .executeUpdate();

        entityManager.remove(managedAtleta);
    }

    @Override
    public List<Sport> findByIncoherentDates() throws Exception {
        return entityManager.createQuery(
                        "SELECT s FROM Sport s WHERE s.dataInizio > s.dataFine", Sport.class)
                .getResultList();
    }





}
