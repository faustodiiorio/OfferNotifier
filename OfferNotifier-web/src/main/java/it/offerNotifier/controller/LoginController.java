package it.offerNotifier.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.offerNotifier.service.UtenteService;
import it.offerNotifier.model.Utente;
import it.offerNotifier.dto.UtenteDTO;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private UtenteService utenteService;
	private Logger logger = Logger.getLogger(LoginController.class);
	
	/*
	@RequestMapping(value = "/getUserByUsernameAndPassword", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UtenteDTO getUserByUsernameAndPassword(@RequestParam(value = "username") String username, @RequestParam(value="password") String password) {
		logger.info("Starting service getUserByUsernameAndPassword");
		UtenteDTO dto = new UtenteDTO();
		Utente utente = new Utente();
//		controllo null safe
		if (!username.equals("") && !username.isEmpty() && !password.equals("") && !password.isEmpty()){
			utente = utenteService.getUserByUsernameAndPassword(username, password);
				dto.setUsername(utente.getUsername());
				dto.setPassword(utente.getPassword());
		}
		logger.info("Ending service getUserByUsernameAndPassword");
		return dto;
	}*/
}