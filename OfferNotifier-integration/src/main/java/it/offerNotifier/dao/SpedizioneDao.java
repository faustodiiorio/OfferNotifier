package it.offerNotifier.dao;

import java.util.List;

import it.offerNotifier.model.Spedizione;

public interface SpedizioneDao {
	List<Spedizione> getAllExpeditions();
	Spedizione getExpeditionByName(String nomeSpedizione);
	Spedizione getExpeditionByCost(String costoSpedizione);
}