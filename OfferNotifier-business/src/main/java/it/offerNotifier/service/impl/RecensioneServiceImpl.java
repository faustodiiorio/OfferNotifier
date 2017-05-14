package it.offerNotifier.service.impl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.offerNotifier.dao.RecensioneDao;
import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Recensione;
import it.offerNotifier.service.RecensioneService;

@Service
@Transactional
public class RecensioneServiceImpl implements RecensioneService {
	@Autowired
	private RecensioneDao recensioneDao;

	@Override
	public Set<Recensione> getAllReviews() {
		return recensioneDao.getAllReviews();
	}

	@Override
	public Set<Recensione> getReviewsByProduct(Prodotto prodotto) {
		return recensioneDao.getReviewsByProduct(prodotto);
	}

	@Override
	public Recensione getReviewByPK(int id) {
		return recensioneDao.getReviewByPK(id);
	}

	@Override
	public void persist(Recensione recensione) {
		recensioneDao.persist(recensione);
	}
}