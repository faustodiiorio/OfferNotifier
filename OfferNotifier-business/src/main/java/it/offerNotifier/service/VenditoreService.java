package it.offerNotifier.service;

import java.util.Set;

import it.offerNotifier.model.Venditore;

public interface VenditoreService {
	void persist(Venditore venditore);
	Venditore getSellerByPK(int id);
	Set<Venditore> getAllSellers();
	Venditore getSellerByName(String nomeVenditore);
}