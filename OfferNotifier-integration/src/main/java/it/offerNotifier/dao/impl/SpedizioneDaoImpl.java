package it.offerNotifier.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.offerNotifier.dao.SpedizioneDao;
import it.offerNotifier.model.Spedizione;

@Repository
public class SpedizioneDaoImpl implements SpedizioneDao {
	@PersistenceContext(unitName="offerNotifierDS")
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(SpedizioneDaoImpl.class);
	
	@Override
	public Set<Spedizione> getAllExpeditions() {
		logger.info("STARTING getAllExpeditions");
		return (Set<Spedizione>) entityManager.createNamedQuery("getAllExpeditions").getResultList();
	}

	@Override
	public Spedizione getExpeditionByName(String nomeSpedizione) {
		logger.info("STARTING getExpeditionByName");
		if(!nomeSpedizione.equals("") && !nomeSpedizione.isEmpty()){
			logger.info("getExpeditionByName SUCCESSFULLY returning object");
			return (Spedizione) entityManager.createNamedQuery("getExpeditionByName").setParameter("nomeSpedizione", nomeSpedizione).getSingleResult();
		}
		logger.info("getExpeditionByName UNSUCCESSFULLY returning object");
		return null;
	}

	@Override
	public Spedizione getExpeditionByCost(String costoSpedizione) {
		logger.info("STARTING getExpeditionByCost");
		if(!costoSpedizione.equals("") && !costoSpedizione.isEmpty()){
			logger.info("getExpeditionByCost SUCCESSFULLY returning object");
			return (Spedizione) entityManager.createNamedQuery("getExpeditionByCost").setParameter("costoSpedizione", costoSpedizione).getSingleResult();
		}
		logger.info("getExpeditionByCost UNSUCCESSFULLY returning object");
		return null;
	}

	public EntityManager getEntityManager() {
		if(!entityManager.equals(null) && !entityManager.isOpen()){
			logger.info("getEntityManager SpedizioneDaoImpl SUCCESSFULLY returning object");
			return entityManager;
		}
		logger.info("getEntityManager SpedizioneDaoImpl UNSUCCESSFULLY returning object");
		return null;
	}

	@Override
	public Spedizione getExpeditionByPK(int id) {
		return entityManager.find(Spedizione.class, id);
	}

	@Override
	public void persist(Spedizione spedizione) {
		entityManager.persist(spedizione);
	}
}