package it.offerNotifier.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import it.offerNotifier.dao.SpedizioneDao;
import it.offerNotifier.model.Spedizione;
import it.offerNotifier.service.SpedizioneService;

@Service
public class SpedizioneServiceImpl implements SpedizioneService {
	private SpedizioneDao spedizioneDao;
	
	@Override
	public List<Spedizione> getAllExpeditions() {
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
}