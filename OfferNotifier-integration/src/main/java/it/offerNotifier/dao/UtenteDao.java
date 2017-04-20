package it.offerNotifier.dao;

import java.util.List;

import it.offerNotifier.model.Utente;
import it.offerNotifier.model.Prodotto;

public interface UtenteDao {
	List<Utente> getUsers();
	Utente getUserByEmail(String email);
	List<Utente> getUsersByProduct(Prodotto prodotto);
}