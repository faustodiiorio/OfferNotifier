package it.offerNotifier.service;

import java.util.List;

import it.offerNotifier.model.Categoria;

public interface CategoriaService {
	List<Categoria> getAllCategories();
	Categoria getCategoryByName(String nomeCategoria);
	Categoria getCategoryById(int idCategoria);
}