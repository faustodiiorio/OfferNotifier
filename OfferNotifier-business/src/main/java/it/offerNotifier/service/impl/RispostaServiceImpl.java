package it.offerNotifier.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import it.offerNotifier.dao.RispostaDao;
import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Risposta;
import it.offerNotifier.service.RispostaService;

@Service
public class RispostaServiceImpl implements RispostaService {
	private RispostaDao rispostaDao;

	@Override
	public List<Risposta> getAllAnswers() {
		return rispostaDao.getAllAnswers();
	}

	@Override
	public List<Risposta> getAnswersByQuestion(Domanda domanda) {
		return rispostaDao.getAnswersByQuestion(domanda);
	}
}