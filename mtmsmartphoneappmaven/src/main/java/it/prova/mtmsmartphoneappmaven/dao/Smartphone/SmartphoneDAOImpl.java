package it.prova.mtmsmartphoneappmaven.dao.Smartphone;

import it.prova.mtmsmartphoneappmaven.model.App;
import it.prova.mtmsmartphoneappmaven.model.Smartphone;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    public void update(Smartphone input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        input = entityManager.merge(input);
    }

    @Override
    public void insert(Smartphone input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Smartphone input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(input));
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

    @Override
    public void installaAppEsistente(Long idSmartphone, Long idApp) throws Exception {
        Smartphone s = entityManager.find(Smartphone.class, idSmartphone);
        if (s == null) {
            throw new Exception("Smartphone non trovato: " + idSmartphone);
        }
        App a = entityManager.find(App.class, idApp);
        if (a == null) {
            throw new Exception("App non trovata: " + idApp);
        }
        s.getApps().add(a); // Adesso s è dirty e quindi viene aggiornato automaticamente
    }

    @Override
    public void disinstallaAppEsistente(Long idSmartphone, Long idApp) throws Exception {
        Smartphone s = entityManager.find(Smartphone.class, idSmartphone);
        if (s == null) {
            throw new Exception("Smartphone non trovato: " + idSmartphone);
        }
        App a = entityManager.find(App.class, idApp);
        if (a == null) {
            throw new Exception("App non trovata: " + idApp);
        }
        s.getApps().remove(a); // Questo è quello realmente necessario per scollegare la riga di join. Perché è owner della many-to-many
        // JPA provvederà a cancellare la riga di join
        a.getSmartphones().remove(s); // Questo incide solo sulla rappresentazione in memoria
    }

    @Override
    public void deleteSmartphoneAndUnlinkApps(Long idSmartphone) throws Exception {
        Smartphone phone = entityManager.find(Smartphone.class, idSmartphone);
        if (phone == null) {
            throw new Exception("Smartphone not found: " + idSmartphone);
        }

        phone.getApps().forEach(app -> app.getSmartphones().remove(phone));
        phone.getApps().clear();

        entityManager.remove(phone);
    }

    @Override
    public Smartphone findByIdFetchingApps(Long idSmartphone) throws Exception {
        TypedQuery<Smartphone> query = entityManager.createQuery(
                "select s from Smartphone s left join fetch s.apps a where s.id = :idSmartphone", Smartphone.class);
        query.setParameter("idSmartphone", idSmartphone);

        return query.getResultList().stream().findFirst().orElse(null);
    }



}
