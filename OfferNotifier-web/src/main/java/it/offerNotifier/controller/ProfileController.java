package it.offerNotifier.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.offerNotifier.service.DomandaService;
import it.offerNotifier.service.RecensioneService;
import it.offerNotifier.service.RispostaService;
import it.offerNotifier.dto.RispostaDTO;
import it.offerNotifier.dto.ProdottoDTO;
import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Recensione;
import it.offerNotifier.model.Risposta;
//import it.offerNotifier.dto.PartialReviewDTO;
import it.offerNotifier.dto.DomandaDTO;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private DomandaService domandaService;
	@Autowired
	private RecensioneService recensioneService;
	@Autowired
	private RispostaService rispostaService;
	private Logger logger = Logger.getLogger(ProfileController.class);
	
/*	
	@RequestMapping(value = "/getQuestionsByUser", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<DomandaDTO> getQuestionsByUser(@RequestParam(value = "username") String username){
		logger.info("Starting service getQuestionsByUser");
		List<DomandaDTO> listaDTO = new ArrayList<DomandaDTO>();
		if(!username.isEmpty() && !username.equals("")){
			DomandaDTO dto;
			List<Domanda> listaDomande = new ArrayList<Domanda>();
			listaDomande = domandaService.getQuestionsByUser(username);
			ProdottoDTO gameDTO;
			for(Domanda d : listaDomande){
				dto = new DomandaDTO();
				gameDTO = new ProdottoDTO();
				dto.setData(d.getData());
				dto.setDescrizione(d.getTesto());
				dto.setTitolo(d.getTitolo());
				gameDTO.setConsole(d.getConsole().getNomeConsole());
				gameDTO.setTitolo(d.getGioco().getTitoloGioco());
				dto.setGameDTO(gameDTO);
				listaDTO.add(dto);
			}
		}
		logger.info("Starting service getQuestionsByUser");
		return listaDTO;
	}
	
	@RequestMapping(value = "/getPartialReviewsByUser", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<PartialReviewDTO> getPartialReviewsByUser(@RequestParam(value = "username") String username){
		logger.info("Starting service getPartialReviewsByUser");
		List<PartialReviewDTO> listaDTO = new ArrayList<PartialReviewDTO>();
		if(!username.isEmpty() && !username.equals("")){
			PartialReviewDTO dto;
			List<Recensione> listaRecensioni = new ArrayList<Recensione>();
			listaRecensioni = recensioneService.getReviewsByUser(username);
			for(Recensione r : listaRecensioni){
				dto = new PartialReviewDTO();
				dto.setNomeConsole(r.getConsole().getNomeConsole());
				dto.setNomeGioco(r.getGioco().getTitoloGioco());
				dto.setTitoloRecensione(r.getTitoloRecensione());
				dto.setImg(r.getGioco().getCopertina());
				dto.setTipologia(r.getTipologia());
				listaDTO.add(dto);
			}
		}
		logger.info("Ending service getPartialReviewsByUser");
		return listaDTO;
	}
	
	@RequestMapping(value = "/getAnswersByUser", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<RispostaDTO> getAnswersByUser(@RequestParam(value = "username") String username){
		logger.info("Starting service getAnswersByUser");
		List<RispostaDTO> listaDTO = new ArrayList<RispostaDTO>();
		if(!username.isEmpty() && !username.equals("")){
			RispostaDTO dto;
			ProdottoDTO gameDto;
			List<Risposta> listaRisposte = new ArrayList<Risposta>();
			listaRisposte = rispostaService.getAnswersByUser(username);
			for(Risposta r : listaRisposte){
				dto = new RispostaDTO();
				gameDto = new ProdottoDTO();
				dto.setTitoloDomanda(r.getDomanda().getTitolo());
				dto.setTestoRisposta(r.getTesto());
				dto.setData(r.getData());
				gameDto.setTitolo(r.getDomanda().getGioco().getTitoloGioco());
				gameDto.setConsole(r.getDomanda().getConsole().getNomeConsole());
				dto.setGameDTO(gameDto);
				listaDTO.add(dto);
			}
		}
		logger.info("Ending service getAnswersByUser");
		return listaDTO;
	}*/
}