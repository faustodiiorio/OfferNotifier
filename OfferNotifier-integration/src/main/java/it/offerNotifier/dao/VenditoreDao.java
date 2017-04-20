package it.offerNotifier.dao;

import java.util.List;

import it.offerNotifier.model.Venditore;

public interface VenditoreDao {
	List<Venditore> getAllSellers();
	Venditore getSellerByName(String nomeVenditore);
}