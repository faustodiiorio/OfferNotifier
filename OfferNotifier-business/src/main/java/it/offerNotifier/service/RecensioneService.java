package it.offerNotifier.service;

import java.util.Set;

import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Recensione;

public interface RecensioneService {
	void persist(Recensione recensione);
	Recensione getReviewByPK(int id);
	Set<Recensione> getAllReviews();
	Set<Recensione> getReviewsByProduct(Prodotto prodotto);
}