package it.prova.gestioneordiniarticolicategorie.dao.Ordine;

import it.prova.gestioneordiniarticolicategorie.model.Ordine;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdineDAOImpl implements OrdineDAO{
    private EntityManager entityManager;

    @Override
    public List<Ordine> list() throws Exception {
        return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
    }

    @Override
    public Ordine get(Long id) throws Exception {
        return entityManager.find(Ordine.class, id);
    }

    @Override
    public void update(Ordine input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        input = entityManager.merge(input);
    }

    @Override
    public void insert(Ordine input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Ordine input) throws Exception {
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
    public Long countArticoliByOrdineId(Long idOrdine) throws Exception {
        return entityManager
                .createQuery("SELECT COUNT(a) FROM Articolo a WHERE a.ordine.id = :id", Long.class)
                .setParameter("id", idOrdine)
                .getSingleResult();
    }

    @Override
    public Ordine findLatestByCategoriaId(Long idCategoria) throws Exception {
        List<Ordine> list = entityManager.createQuery(
                        "SELECT DISTINCT o " + "FROM Ordine o " + " JOIN o.articoli a " + " JOIN a.categorie c " + "WHERE c.id = :idCategoria " + "ORDER BY o.dataSpedizione DESC", Ordine.class)
                .setParameter("idCategoria", idCategoria)
                .setMaxResults(1)
                .getResultList();
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<String> findDistinctIndirizziBySerialeLike(String seriale) throws Exception {
        return entityManager.createQuery(
                        "SELECT DISTINCT o.indirizzoSpedizione " + "FROM Ordine o " + " JOIN o.articoli a " + "WHERE a.numeroSeriale LIKE :pattern", String.class)
                .setParameter("pattern", "%" + seriale + "%")
                .getResultList();
    }


}
