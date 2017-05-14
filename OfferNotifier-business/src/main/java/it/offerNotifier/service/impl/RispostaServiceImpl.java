package it.offerNotifier.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.offerNotifier.dao.RispostaDao;
import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Risposta;
import it.offerNotifier.service.RispostaService;

@Service
@Transactional
public class RispostaServiceImpl implements RispostaService {
	@Autowired
	private RispostaDao rispostaDao;

	@Override
	public Set<Risposta> getAllAnswers() {
		return rispostaDao.getAllAnswers();
	}

	@Override
	public Set<Risposta> getAnswersByQuestion(Domanda domanda) {
		return rispostaDao.getAnswersByQuestion(domanda);
	}

	@Override
	public Risposta getAnswerByPK(int id) {
		return rispostaDao.getAnswerByPK(id);
	}

	@Override
	public void persist(Risposta risposta) {
		rispostaDao.persist(risposta);
	}
}