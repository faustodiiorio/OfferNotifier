package it.offerNotifier.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.offerNotifier.dao.RecensioneDao;
import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Recensione;

@Repository
public class RecensioneDaoImpl implements RecensioneDao {
	@PersistenceContext(unitName="offerNotifierDS")
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(RecensioneDaoImpl.class);
	
	@Override
	public Set<Recensione> getAllReviews() {
		logger.info("STARTING getAllReviews");
		return (Set<Recensione>) entityManager.createNamedQuery("getAllReviews").getResultList();
	}

	@Override
	public Set<Recensione> getReviewsByProduct(Prodotto prodotto) {
		logger.info("STARTING getReviewsByProduct");
		if(!prodotto.getNomeProdotto().equals("") && !prodotto.getNomeProdotto().isEmpty()
				&& !prodotto.getNomeInserzione().equals("") && !prodotto.getNomeInserzione().isEmpty()){
			logger.info("getReviewsByProduct SUCCESSFULLY RETURNING OBJECT");
			return (Set<Recensione>) entityManager.createNamedQuery("getReviewsByProduct").setParameter("prodotto", prodotto).getResultList();
		}
		logger.info("getReviewsByProduct UNSUCCESSFULLY RETURNING OBJECT");
		return null;
	}

	@Override
	public Recensione getReviewByPK(int id) {
		return entityManager.find(Recensione.class, id);
	}

	@Override
	public void persist(Recensione recensione) {
		entityManager.persist(recensione);
	}
}