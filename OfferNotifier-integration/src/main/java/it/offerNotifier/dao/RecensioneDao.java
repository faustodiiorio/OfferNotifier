package it.offerNotifier.dao;

import java.util.List;

import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Recensione;

public interface RecensioneDao {
	List<Recensione> getAllReviews();
	List<Recensione> getReviewsByProduct(Prodotto prodotto);
}