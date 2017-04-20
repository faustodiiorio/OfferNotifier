package it.offerNotifier.dao;

import java.util.List;

import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Risposta;

public interface RispostaDao {
	List<Risposta> getAllAnswers();
	List<Risposta> getAnswersByQuestion(Domanda domanda);
}