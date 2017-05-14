package it.offerNotifier.service.impl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.offerNotifier.dao.UtenteDao;
import it.offerNotifier.model.Prodotto;
import it.offerNotifier.model.Utente;
import it.offerNotifier.service.UtenteService;

@Service
@Transactional
public class UtenteServiceImpl implements UtenteService {
	@Autowired
	private UtenteDao utenteDao;
	
	@Override
	public Set<Utente> getUsers() {
		return utenteDao.getUsers();
	}

	@Override
	public Utente getUserByEmail(String email) {
		return utenteDao.getUserByEmail(email);
	}

	@Override
	public Set<Utente> getUserByProduct(Prodotto prodotto) {
		return utenteDao.getUsersByProduct(prodotto);
	}

	@Override
	public Utente getUserByPK(int id) {
		return utenteDao.getUserByPK(id);
	}

	@Override
	public void persist(Utente utente) {
		utenteDao.persist(utente);
	}
}