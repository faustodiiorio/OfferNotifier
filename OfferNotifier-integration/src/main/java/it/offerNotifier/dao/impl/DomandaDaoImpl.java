package it.offerNotifier.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.offerNotifier.dao.DomandaDao;
import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Prodotto;

@Repository
public class DomandaDaoImpl implements DomandaDao{
	@PersistenceContext(unitName="offerNotifierDS")
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(DomandaDaoImpl.class);
	
	@Override
	public Set<Domanda> getAllQuestions() {
		logger.info("STARTING getAllQuestions");
		return (Set<Domanda>) entityManager.createNamedQuery("getAllQuestions").getResultList();
	}

	@Override
	public Set<Domanda> getQuestionsByProduct(Prodotto prodotto) {
		logger.info("STARTING getQuestionsByProduct");
		if(!prodotto.getNomeProdotto().equals("") && !prodotto.getNomeProdotto().isEmpty()
				&& !prodotto.getNomeInserzione().equals("") && !prodotto.getNomeInserzione().isEmpty()){
			logger.info("getQuestionsByProduct SUCCESSFULLY RETURNING OBJECT");
			return (Set<Domanda>) entityManager.createNamedQuery("getQuestionsByProduct").setParameter("prodotto", prodotto).getResultList();
		}
		logger.info("getQuestionsByProduct UNSUCCESSFULLY RETURNING OBJECT");
		return null;
	}

	@Override
	public Domanda getQuestionByPK(int id) {
		return entityManager.find(Domanda.class, id);
	}

	@Override
	public void persist(Domanda domanda) {
		entityManager.persist(domanda);
	}
}