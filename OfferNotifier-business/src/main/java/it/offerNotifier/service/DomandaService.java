package it.offerNotifier.service;

import java.util.List;

import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Prodotto;

public interface DomandaService {
	List<Domanda> getAllQuestions();
	List<Domanda> getQuestionsByProduct(Prodotto prodotto);
}