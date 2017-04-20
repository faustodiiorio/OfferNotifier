package it.offerNotifier.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import it.offerNotifier.dao.VenditoreDao;
import it.offerNotifier.model.Venditore;
import it.offerNotifier.service.VenditoreService;

@Service
public class VenditoreServiceImpl implements VenditoreService {
	private VenditoreDao venditoreDao;
	
	@Override
	public List<Venditore> getAllSellers() {
		return venditoreDao.getAllSellers();
	}

	@Override
	public Venditore getSellerByName(String nomeVenditore) {
		return venditoreDao.getSellerByName(nomeVenditore);
	}
}