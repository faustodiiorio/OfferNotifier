package it.offerNotifier.dao;

import java.util.List;

import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Prodotto;

public interface DomandaDao {
	List<Domanda> getAllQuestions();
	List<Domanda> getQuestionsByProduct(Prodotto prodotto);
}