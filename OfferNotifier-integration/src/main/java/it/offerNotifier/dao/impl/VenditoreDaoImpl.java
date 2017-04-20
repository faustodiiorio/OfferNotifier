package it.offerNotifier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.offerNotifier.dao.VenditoreDao;
import it.offerNotifier.model.Venditore;

@Repository
public class VenditoreDaoImpl implements VenditoreDao {
	@PersistenceContext(unitName="offerNotifierDS")
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(VenditoreDaoImpl.class);;
	
	@Override
	public List<Venditore> getAllSellers() {
		logger.info("STARTING getAllSellers");
		return (List<Venditore>) entityManager.createNamedQuery("getAllSellers").getResultList();
	}

	@Override
	public Venditore getSellerByName(String nomeVenditore) {
		logger.info("STARTING getSellerByName");
		if(!nomeVenditore.equals("") && !nomeVenditore.isEmpty()){
			logger.info("getSellerByName SUCCESSFULLY RETURNING OBJECT");
			return (Venditore) entityManager.createNamedQuery("getSellerByName").setParameter("nomeVenditore", nomeVenditore).getSingleResult();
		}
		logger.info("getSellerByName UNSUCCESSFULLY returning object");
		return null;
	}

	public EntityManager getEntityManager() {
		if(!entityManager.equals(null) && !entityManager.isOpen()){
			logger.info("getEntityManager VenditoreDaoImpl SUCCESSFULLY returning object");
			return entityManager;
		}
		logger.info("getEntityManager VenditoreDaoImpl UNSUCCESSFULLY returning object");
		return null;
	}
}