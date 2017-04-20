package it.offerNotifier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.offerNotifier.dao.UtenteDao;
import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Utente;

@Repository
public class UtenteDaoImpl implements UtenteDao {
	@PersistenceContext(unitName="offerNotifierDS")
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(UtenteDaoImpl.class);
	
	@Override
	public List<Utente> getUsers() {
		logger.info("STARTING getUsers");
		return (List<Utente>) entityManager.createNamedQuery("getUsers").getResultList();
	}

	@Override
	public Utente getUserByEmail(String email) {
		logger.info("STARTING getUserByEmail");
		if(!email.equals("") && !email.isEmpty()){
			logger.info("getUserByEmail SUCCESSFULLY returning object");
			return (Utente) entityManager.createNamedQuery("getUserByEmail").getSingleResult();
		}
		logger.info("getUserByEmail UNSUCCESSFULLY returning object");
		return null;
	}

	@Override
	public List<Utente> getUsersByProduct(Prodotto prodotto) {
		logger.info("STARTING getUsersByProduct");
		if(!prodotto.getNomeInserzione().equals("") && !prodotto.getNomeInserzione().isEmpty()
				&& !prodotto.getNomeProdotto().equals("") && !prodotto.getNomeProdotto().isEmpty()){
			logger.info("getUsersByProduct SUCCESSFULLY returning object");
			Query query = entityManager.createNamedQuery("getUsersByProduct");
			query.setParameter("nomeInserzione", prodotto.getNomeInserzione());
			query.setParameter("nomeProdotto", prodotto.getNomeProdotto());
			return (List<Utente>) query.getResultList();
		}
		logger.info("getUsersByProduct UNSUCCESSFULLY returning object");
		return null;
	}

	public EntityManager getEntityManager() {
		if(!entityManager.equals(null) && !entityManager.isOpen()){
			logger.info("getEntityManager UtenteDaoImpl SUCCESSFULLY returning object");
			return entityManager;
		}
		logger.info("getEntityManager UtenteDaoImpl UNSUCCESSFULLY returning object");
		return null;
	}
}