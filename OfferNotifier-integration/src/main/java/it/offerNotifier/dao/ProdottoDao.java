package it.offerNotifier.dao;

import java.util.List;

import it.offerNotifier.model.Categoria;
import it.offerNotifier.model.Prodotto;

public interface ProdottoDao {
	List<Prodotto> getAllProducts();
	Prodotto getProductByName(String nomeProdotto);
	Prodotto getProductByCategory(Categoria categoria);
}