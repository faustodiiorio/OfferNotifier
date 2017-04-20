package it.offerNotifier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.offerNotifier.dao.CategoriaDao;
import it.offerNotifier.model.Categoria;
import it.offerNotifier.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public List<Categoria> getAllCategories() {
		return categoriaDao.getAllCategories();
	}

	@Override
	public Categoria getCategoryByName(String nomeCategoria) {
		return categoriaDao.getCategoryByName(nomeCategoria);
	}

	@Override
	public Categoria getCategoryById(int idCategoria) {
		return categoriaDao.getCategoryById(idCategoria);
	}
}