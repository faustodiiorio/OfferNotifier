package it.offerNotifier.dao;

import java.util.Set;

import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Prodotto;

public interface DomandaDao {
	void persist(Domanda domanda);
	Domanda getQuestionByPK(int id);
	Set<Domanda> getAllQuestions();
	Set<Domanda> getQuestionsByProduct(Prodotto prodotto);
}