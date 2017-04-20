package it.offerNotifier.service;

import java.util.List;

import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Risposta;

public interface RispostaService {
	List<Risposta> getAllAnswers();
	List<Risposta> getAnswersByQuestion(Domanda domanda);
}