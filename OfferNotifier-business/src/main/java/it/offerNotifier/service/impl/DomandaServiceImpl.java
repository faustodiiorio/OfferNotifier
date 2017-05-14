package it.offerNotifier.service.impl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.offerNotifier.dao.DomandaDao;
import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Prodotto;
import it.offerNotifier.service.DomandaService;

@Service
@Transactional
public class DomandaServiceImpl implements DomandaService {
	@Autowired
	private DomandaDao domandaDao;

	@Override
	public Set<Domanda> getAllQuestions() {
		return domandaDao.getAllQuestions();
	}

	@Override
	public Set<Domanda> getQuestionsByProduct(Prodotto prodotto) {
		return domandaDao.getQuestionsByProduct(prodotto);
	}

	@Override
	public Domanda getQuestionByPK(int id) {
		return domandaDao.getQuestionByPK(id);
	}

	@Override
	public void persist(Domanda domanda) {
		domandaDao.persist(domanda);
	}
}