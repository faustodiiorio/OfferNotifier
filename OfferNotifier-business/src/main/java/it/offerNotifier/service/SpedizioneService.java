package it.offerNotifier.service;

import java.util.List;

import it.offerNotifier.model.Spedizione;

public interface SpedizioneService {
	List<Spedizione> getAllExpeditions();
	Spedizione getExpeditionByName(String nomeSpedizione);
	Spedizione getExpeditionByCost(String costoSpedizione);
}