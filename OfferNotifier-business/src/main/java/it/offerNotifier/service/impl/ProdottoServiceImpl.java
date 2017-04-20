package it.offerNotifier.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import it.offerNotifier.dao.ProdottoDao;
import it.offerNotifier.model.Categoria;
import it.offerNotifier.model.Prodotto;
import it.offerNotifier.service.ProdottoService;

@Service
public class ProdottoServiceImpl implements ProdottoService {
	private ProdottoDao prodottoDao;
	
	@Override
	public List<Prodotto> getAllProducts() {
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
}