package it.offerNotifier.dao;

import java.util.Set;

import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Risposta;

public interface RispostaDao {
	void persist(Risposta risposta);
	Risposta getAnswerByPK(int id);
	Set<Risposta> getAllAnswers();
	Set<Risposta> getAnswersByQuestion(Domanda domanda);
}