package it.offerNotifier.dao.impl;

import java.util.List;

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
	public List<Risposta> getAllAnswers() {
		logger.info("STARTING getAllAnswers");
		return (List<Risposta>) entityManager.createNamedQuery("getAllAnswers").getResultList();
	}

	@Override
	public List<Risposta> getAnswersByQuestion(Domanda domanda) {
		logger.info("STARTING getAnswersByQuestion");
		if(!domanda.getTitolo().equals("") && !domanda.getTitolo().isEmpty()){
			logger.info("getAnswersByQuestion SUCCESSFULLY RETURNING OBJECT");
			return (List<Risposta>) entityManager.createNamedQuery("getAnswersByQuestion").setParameter("domanda", domanda).getResultList();
		}
		logger.info("getAnswersByQuestion UNSUCCESSFULLY RETURNING OBJECT");
		return null;
	}
}