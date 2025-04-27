package it.prova.proprietarioautomobilejpa.dao.proprietario;

import it.prova.proprietarioautomobilejpa.model.Proprietario;

import javax.persistence.EntityManager;
import java.util.List;

public class ProprietarioDAOImpl implements ProprietarioDAO{
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Proprietario get(Long id) throws Exception {
        return entityManager.find(Proprietario.class, id);
    }

    @Override
    public List<Proprietario> list() throws Exception {
        return entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();
    }

    @Override
    public void update(Proprietario proprietarioDaAggiornare) throws Exception {
        if (proprietarioDaAggiornare == null) {
            throw new Exception("Problema valore in input");
        }

         proprietarioDaAggiornare = entityManager.merge(proprietarioDaAggiornare);
    }

    @Override
    public void insert(Proprietario proprietarioDaInserire) throws Exception {
        if (proprietarioDaInserire == null) {
            throw new Exception("Problema valore in input");
        }

        entityManager.persist(proprietarioDaInserire);
    }

    @Override
    public void delete(Proprietario proprietarioDaEliminare) throws Exception {
        if(proprietarioDaEliminare == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(proprietarioDaEliminare));
    }

}
