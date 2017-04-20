package it.offerNotifier.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import it.offerNotifier.dao.DomandaDao;
import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Prodotto;
import it.offerNotifier.service.DomandaService;

@Service
public class DomandaServiceImpl implements DomandaService {
	private DomandaDao domandaDao;

	@Override
	public List<Domanda> getAllQuestions() {
		return domandaDao.getAllQuestions();
	}

	@Override
	public List<Domanda> getQuestionsByProduct(Prodotto prodotto) {
		return domandaDao.getQuestionsByProduct(prodotto);
	}
}