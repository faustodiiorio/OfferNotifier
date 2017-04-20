package it.offerNotifier.dao;

import java.util.List;

import it.offerNotifier.model.Categoria;

public interface CategoriaDao {
	List<Categoria> getAllCategories();
	Categoria getCategoryByName(String nomeCategoria);
	Categoria getCategoryById(Integer idCategoria);
}