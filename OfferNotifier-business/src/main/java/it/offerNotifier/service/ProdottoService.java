package it.offerNotifier.service;

import java.util.Set;

import it.offerNotifier.model.Categoria;
import it.offerNotifier.model.Prodotto;

public interface ProdottoService {
	void persist(Prodotto prodotto);
	Prodotto getProductByPK(int id);
	Set<Prodotto> getAllProducts();
	Prodotto getProductByName(String nomeProdotto);
	Prodotto getProductByCategory(Categoria categoria);
}