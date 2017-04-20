package it.offerNotifier.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import it.offerNotifier.dao.UtenteDao;
import it.offerNotifier.model.Utente;
import it.offerNotifier.model.Prodotto;
import it.offerNotifier.service.UtenteService;

@Service
public class UtenteServiceImpl implements UtenteService {
	private UtenteDao utenteDao;
	
	@Override
	public List<Utente> getUsers() {
		return utenteDao.getUsers();
	}

	@Override
	public Utente getUserByEmail(String email) {
		return utenteDao.getUserByEmail(email);
	}

	@Override
	public List<Utente> getUserByProduct(Prodotto prodotto) {
		return utenteDao.getUsersByProduct(prodotto);
	}
}