package it.offerNotifier.service;

import java.util.Set;

import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Risposta;

public interface RispostaService {
	void persist(Risposta risposta);
	Risposta getAnswerByPK(int id);
	Set<Risposta> getAllAnswers();
	Set<Risposta> getAnswersByQuestion(Domanda domanda);
}