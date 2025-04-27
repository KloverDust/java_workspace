package it.manytomanyjpamaven.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.manytomanyjpamaven.dao.EntityManagerUtil;
import it.manytomanyjpamaven.dao.RuoloDAO;
import it.manytomanyjpamaven.dao.UtenteDAO;
import it.manytomanyjpamaven.exception.UtenteConRuoliAssociatiException;
import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.Utente;

public class RuoloServiceImpl implements RuoloService {

	private RuoloDAO ruoloDAO;
	private UtenteDAO utenteDao;

	@Override
	public List<Ruolo> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ruolo caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ruoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ruoloDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Ruolo ruoloInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Ruolo ruoloInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ruoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ruoloDAO.insert(ruoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Long idRuoloToRemove) throws Exception {
		if (idRuoloToRemove == null) {
			throw new Exception("Problema valore in input");
		}

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			ruoloDAO.setEntityManager(entityManager);
			utenteDao.setEntityManager(entityManager);

			Ruolo ruoloToRemove = ruoloDAO.get(idRuoloToRemove);
			ruoloToRemove = entityManager.merge(ruoloToRemove);


			List <Utente> listaUtentiCollegatiARuolo = utenteDao.findAllByRuolo(ruoloToRemove);

			if (!listaUtentiCollegatiARuolo.isEmpty()) {
				throw new UtenteConRuoliAssociatiException("Impossibile eliminare il ruolo perché ci sono utenti associati.");
			}

			for (Utente utenteItem : listaUtentiCollegatiARuolo) {
				utenteItem.getRuoli().remove(ruoloToRemove);
				entityManager.merge(utenteItem);
			}

			ruoloDAO.delete(ruoloToRemove);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

//	@Override
//	public void rimuovi(Long idRuoloToRemove) throws Exception {
//		if (idRuoloToRemove == null) {
//			throw new Exception("Problema valore in input");
//		}
//
//		EntityManager entityManager = EntityManagerUtil.getEntityManager();
//
//		try {
//			entityManager.getTransaction().begin();
//			ruoloDAO.setEntityManager(entityManager);
//			utenteDao.setEntityManager(entityManager);
//
//			Ruolo ruoloToRemove = ruoloDAO.get(idRuoloToRemove);
//
//			List<Utente> utentiAssociati = utenteDao.findAllByRuolo(ruoloToRemove);
//			if (utentiAssociati != null && !utentiAssociati.isEmpty()) {
//				throw new UtenteConRuoliAssociatiException("Impossibile rimuovere: ruolo ancora associato ad utenti");
//			}
//
//			ruoloDAO.delete(ruoloToRemove);
//			entityManager.getTransaction().commit();
//
//		} catch (UtenteConRuoliAssociatiException e) {
//			entityManager.getTransaction().rollback();
//			throw e;
//		} catch (Exception e) {
//			entityManager.getTransaction().rollback();
//			e.printStackTrace();
//			throw e;
//		} finally {
//			EntityManagerUtil.closeEntityManager(entityManager);
//		}
//	}

	@Override
	public void setRuoloDAO(RuoloDAO ruoloDAO) {
		this.ruoloDAO = ruoloDAO;
	}

	@Override
	public void setUtenteDAO(UtenteDAO utenteDao) {
		this.utenteDao = utenteDao;
	}

	@Override
	public Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ruoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ruoloDAO.findByDescrizioneAndCodice(descrizione, codice);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

}
