package it.offerNotifier.service.impl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.offerNotifier.dao.ProdottoDao;
import it.offerNotifier.model.Categoria;
import it.offerNotifier.model.Prodotto;
import it.offerNotifier.service.ProdottoService;

@Service
@Transactional
public class ProdottoServiceImpl implements ProdottoService {
	@Autowired
	private ProdottoDao prodottoDao;
	
	@Override
	public Set<Prodotto> getAllProducts() {
		return prodottoDao.getAllProducts();
	}

	@Override
	public Prodotto getProductByName(String nomeProdotto) {
		return prodottoDao.getProductByName(nomeProdotto);
	}

	@Override
	public Prodotto getProductByCategory(Categoria categoria) {
		return prodottoDao.getProductByCategory(categoria);
	}

	@Override
	public Prodotto getProductByPK(int id) {
		return prodottoDao.getProductByPK(id);
	}

	@Override
	public void persist(Prodotto prodotto) {
		prodottoDao.persist(prodotto);
	}
}