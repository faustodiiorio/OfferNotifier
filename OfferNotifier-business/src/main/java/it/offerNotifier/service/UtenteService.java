package it.offerNotifier.service;

import java.util.List;

import it.offerNotifier.model.Utente;
import it.offerNotifier.model.Prodotto;

public interface UtenteService {
	List<Utente> getUsers();
	Utente getUserByEmail(String email);
	List<Utente> getUserByProduct(Prodotto prodotto);
}