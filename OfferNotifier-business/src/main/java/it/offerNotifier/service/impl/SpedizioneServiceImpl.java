package it.offerNotifier.service.impl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.offerNotifier.dao.SpedizioneDao;
import it.offerNotifier.model.Spedizione;
import it.offerNotifier.service.SpedizioneService;

@Service
@Transactional
public class SpedizioneServiceImpl implements SpedizioneService {
	@Autowired
	private SpedizioneDao spedizioneDao;
	
	@Override
	public Set<Spedizione> getAllExpeditions() {
		return spedizioneDao.getAllExpeditions();
	}

	@Override
	public Spedizione getExpeditionByName(String nomeSpedizione) {
		return spedizioneDao.getExpeditionByName(nomeSpedizione);
	}

	@Override
	public Spedizione getExpeditionByCost(String costoSpedizione) {
		return spedizioneDao.getExpeditionByCost(costoSpedizione);
	}

	@Override
	public Spedizione getExpeditionByPK(int id) {
		return spedizioneDao.getExpeditionByPK(id);
	}

	@Override
	public void persist(Spedizione spedizione) {
		spedizioneDao.persist(spedizione);
	}
}