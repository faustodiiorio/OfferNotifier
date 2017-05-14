package it.offerNotifier.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.offerNotifier.dao.RispostaDao;
import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Risposta;

@Repository
public class RispostaDaoImpl implements RispostaDao {
	@PersistenceContext(unitName="offerNotifierDS")
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(RispostaDaoImpl.class);
	
	@Override
	public Set<Risposta> getAllAnswers() {
		logger.info("STARTING getAllAnswers");
		return (Set<Risposta>) entityManager.createNamedQuery("getAllAnswers").getResultList();
	}

	@Override
	public Set<Risposta> getAnswersByQuestion(Domanda domanda) {
		logger.info("STARTING getAnswersByQuestion");
		if(!domanda.getTitolo().equals("") && !domanda.getTitolo().isEmpty()){
			logger.info("getAnswersByQuestion SUCCESSFULLY RETURNING OBJECT");
			return (Set<Risposta>) entityManager.createNamedQuery("getAnswersByQuestion").setParameter("domanda", domanda).getResultList();
		}
		logger.info("getAnswersByQuestion UNSUCCESSFULLY RETURNING OBJECT");
		return null;
	}

	@Override
	public Risposta getAnswerByPK(int id) {
		return entityManager.find(Risposta.class, id);
	}

	@Override
	public void persist(Risposta risposta) {
		entityManager.persist(risposta);
	}
}