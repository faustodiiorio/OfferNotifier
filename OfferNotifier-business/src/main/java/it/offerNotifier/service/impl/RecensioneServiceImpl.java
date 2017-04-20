package it.offerNotifier.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Recensione;
import it.offerNotifier.service.RecensioneService;

@Service
public class RecensioneServiceImpl implements RecensioneService {
	private RecensioneService recensioneService;

	@Override
	public List<Recensione> getAllReviews() {
		return recensioneService.getAllReviews();
	}

	@Override
	public List<Recensione> getReviewsByProduct(Prodotto prodotto) {
		return recensioneService.getReviewsByProduct(prodotto);
	}
}