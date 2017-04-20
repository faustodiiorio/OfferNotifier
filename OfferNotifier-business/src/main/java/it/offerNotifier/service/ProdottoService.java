package it.offerNotifier.service;

import java.util.List;

import it.offerNotifier.model.Categoria;
import it.offerNotifier.model.Prodotto;

public interface ProdottoService {
	List<Prodotto> getAllProducts();
	Prodotto getProductByName(String nomeProdotto);
	Prodotto getProductByCategory(Categoria categoria);
}