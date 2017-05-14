package it.offerNotifier.dao;

import java.util.Set;

import it.offerNotifier.model.Categoria;

public interface CategoriaDao {
	void persist(Categoria categoria);
	Categoria getCategoryByPK(int id);
	Set<Categoria> getAllCategories();
	Categoria getCategoryByName(String nomeCategoria);
	Set<Categoria> getCategoriesById(Integer idCategoria);
}