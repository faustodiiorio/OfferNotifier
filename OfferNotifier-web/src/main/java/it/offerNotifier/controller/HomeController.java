package it.offerNotifier.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class HomeController {
	@Autowired
	private ApplicationContext context;
	private Logger logger = Logger.getLogger(HomeController.class);

	@GetMapping
	public String showHome() {
		logger.info("Starting/Ending controller method showHome");
		return ("/views/home.html");
	}
}