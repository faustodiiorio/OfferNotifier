package it.offerNotifier.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.offerNotifier.dao.CategoriaDao;
import it.offerNotifier.model.Categoria;
import it.offerNotifier.service.CategoriaService;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public Set<Categoria> getAllCategories() {
		return categoriaDao.getAllCategories();
	}

	@Override
	public Categoria getCategoryByName(String nomeCategoria) {
		return categoriaDao.getCategoryByName(nomeCategoria);
	}

	@Override
	public Set<Categoria> getCategoriesById(Integer idCategoria) {
		return categoriaDao.getCategoriesById(idCategoria);
	}

	@Override
	public Categoria getCategoryByPK(int id) {
		return categoriaDao.getCategoryByPK(id);
	}

	@Override
	public void persist(Categoria categoria) {
		categoriaDao.persist(categoria);
	}
}