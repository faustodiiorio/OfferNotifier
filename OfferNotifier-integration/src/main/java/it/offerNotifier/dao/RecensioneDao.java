package it.offerNotifier.dao;

import java.util.Set;

import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Recensione;

public interface RecensioneDao {
	void persist(Recensione recensione);
	Recensione getReviewByPK(int id);
	Set<Recensione> getAllReviews();
	Set<Recensione> getReviewsByProduct(Prodotto prodotto);
}