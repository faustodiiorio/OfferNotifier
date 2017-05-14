package it.offerNotifier.dao;

import java.util.Set;

import it.offerNotifier.model.Venditore;

public interface VenditoreDao {
	void persist(Venditore venditore);
	Venditore getSellerByPK(int id);
	Set<Venditore> getAllSellers();
	Venditore getSellerByName(String nomeVenditore);
}