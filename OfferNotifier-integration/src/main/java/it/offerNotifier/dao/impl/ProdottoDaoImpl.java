package it.offerNotifier.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.offerNotifier.dao.ProdottoDao;
import it.offerNotifier.model.Categoria;
import it.offerNotifier.model.Prodotto;

@Repository
public class ProdottoDaoImpl implements ProdottoDao {
	@PersistenceContext(unitName="offerNotifierDS")
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(ProdottoDaoImpl.class);
	
	@Override
	public Set<Prodotto> getAllProducts() {
		logger.info("STARTING getAllSellers");
		return (Set<Prodotto>) entityManager.createNamedQuery("getAllProducts").getResultList();
	}

	@Override
	public Prodotto getProductByName(String nomeProdotto) {
		logger.info("STARTING getProductByName");
		if(!nomeProdotto.equals("") && !nomeProdotto.isEmpty()){
			logger.info("getProductByName SUCCESSFULLY RETURNING OBJECT");
			return (Prodotto) entityManager.createNamedQuery("getProductByName").setParameter("nomeProdotto", nomeProdotto).getSingleResult();
		}
		logger.info("getProductByName UNSUCCESSFULLY RETURNING OBJECT");
		return null;
	}

	@Override
	public Prodotto getProductByCategory(Categoria categoria) {
		logger.info("STARTING getProductByCategory");
		if(!categoria.getNomeCategoria().equals("") && !categoria.getNomeCategoria().isEmpty()){
			logger.info("getProductByCategory SUCCESSFULLY RETURNING OBJECT");
			return (Prodotto) entityManager.createNamedQuery("getProductByCategory").setParameter("nomeCategoria", categoria.getNomeCategoria()).getSingleResult();
		}
		logger.info("getProductByCategory UNSUCCESSFULLY RETURNING OBJECT");
		return null;
	}

	public EntityManager getEntityManager() {
		if(!entityManager.equals(null) && !entityManager.isOpen()){
			logger.info("getEntityManager ProdottoDaoImpl SUCCESSFULLY returning object");
			return entityManager;
		}
		logger.info("getEntityManager ProdottoDaoImpl UNSUCCESSFULLY returning object");
		return null;
	}

	@Override
	public Prodotto getProductByPK(int id) {
		return entityManager.find(Prodotto.class, id);
	}

	@Override
	public void persist(Prodotto prodotto) {
		entityManager.persist(prodotto);
	}
}