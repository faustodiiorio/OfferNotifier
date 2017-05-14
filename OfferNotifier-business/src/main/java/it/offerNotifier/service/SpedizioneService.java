package it.offerNotifier.service;

import java.util.Set;

import it.offerNotifier.model.Spedizione;

public interface SpedizioneService {
	void persist(Spedizione spedizione);
	Spedizione getExpeditionByPK(int id);
	Set<Spedizione> getAllExpeditions();
	Spedizione getExpeditionByName(String nomeSpedizione);
	Spedizione getExpeditionByCost(String costoSpedizione);
}