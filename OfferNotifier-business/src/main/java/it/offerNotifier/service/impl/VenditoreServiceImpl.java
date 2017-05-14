package it.offerNotifier.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.offerNotifier.dao.VenditoreDao;
import it.offerNotifier.model.Venditore;
import it.offerNotifier.service.VenditoreService;

@Service
@Transactional
public class VenditoreServiceImpl implements VenditoreService {
	@Autowired
	private VenditoreDao venditoreDao;
	
	@Override
	public Set<Venditore> getAllSellers() {
		return venditoreDao.getAllSellers();
	}

	@Override
	public Venditore getSellerByName(String nomeVenditore) {
		return venditoreDao.getSellerByName(nomeVenditore);
	}

	@Override
	public Venditore getSellerByPK(int id) {
		return venditoreDao.getSellerByPK(id);
	}

	@Override
	public void persist(Venditore venditore) {
		venditoreDao.persist(venditore);
	}
}