package it.offerNotifier.service;

import java.util.Set;

import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Utente;

public interface UtenteService {
	void persist(Utente utente);
	Utente getUserByPK(int id);
	Set<Utente> getUsers();
	Utente getUserByEmail(String email);
	Set<Utente> getUserByProduct(Prodotto prodotto);
}