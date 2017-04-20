package it.offerNotifier.service;

import java.util.List;

import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Recensione;

public interface RecensioneService {
	List<Recensione> getAllReviews();
	List<Recensione> getReviewsByProduct(Prodotto prodotto);
}