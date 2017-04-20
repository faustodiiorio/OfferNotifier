package it.offerNotifier.service;

import java.util.List;

import it.offerNotifier.model.Venditore;

public interface VenditoreService {
	List<Venditore> getAllSellers();
	Venditore getSellerByName(String nomeVenditore);
}