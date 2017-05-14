package it.offerNotifier.dao;

import java.util.Set;

import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Utente;

public interface UtenteDao {
	void persist(Utente utente);
	Utente getUserByPK(int id);
	Set<Utente> getUsers();
	Utente getUserByEmail(String email);
	Set<Utente> getUsersByProduct(Prodotto prodotto);
}