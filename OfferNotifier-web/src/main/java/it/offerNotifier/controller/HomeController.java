package it.offerNotifier.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.offerNotifier.dto.CategoriaDTO;
import it.offerNotifier.model.Categoria;
import it.offerNotifier.service.CategoriaService;

@RequestMapping("/home")
@Controller
public class HomeController {
	@Autowired
	private ApplicationContext context;
	private Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String showHome() {
		logger.info("Starting/Ending controller method showHome");
		return ("/views/home.html");
	}
	
	@GetMapping(value = "/getSuperCategories", produces = "application/json")
	public @ResponseBody Set<CategoriaDTO> getSuperCategories(){
		logger.info("Starting service getSuperCategories");
		Set<Categoria> listaCategorie = categoriaService.getCategoriesById(0);
		logger.info("named query SUCCESSFULLY RETURNING OBJECT");
		Set<CategoriaDTO> listaDTO = new HashSet<CategoriaDTO>();
		CategoriaDTO dto;
		for(Categoria c : listaCategorie){
			if(!c.getListaProdotti().equals(null) && !c.getListaProdotti().isEmpty()){
				dto = new CategoriaDTO();
				dto.setId(c.getId());
				dto.setIdCategoria(c.getIdCategoria());
				dto.setNomeCategoria(c.getNomeCategoria());
				listaDTO.add(dto);
			}
		}
		logger.info("Ending service getSuperCategories");
		return listaDTO;
	}
	
	@GetMapping(value="/tryCat", produces="application/json")
	public @ResponseBody Set<CategoriaDTO> tryCat(){
		NodeList nomiCategorie;
		List<String> listaNomiCategorie = new ArrayList<String>();
		CategoriaDTO dto = new CategoriaDTO();
		Set<CategoriaDTO> listaDTO = new HashSet<CategoriaDTO>();
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new URL("http://open.api.ebay.com/Shopping?callname=GetCategoryInfo&appid=FaustoDi-OfferNot-PRD-908fa563f-53b506fd&CategoryID=-1&IncludeSelector=ChildCategories&version=967&siteid=101").openStream());
			nomiCategorie = doc.getElementsByTagName("CategoryName");
			String tempNomi = "";
			for(int i = 0; i < nomiCategorie.getLength(); i++){
				tempNomi = nomiCategorie.item(i).toString();
				listaNomiCategorie.add(tempNomi);
			}
		} catch(MalformedURLException malformedURLException){
			malformedURLException.printStackTrace();
		} catch(IOException ioException){
			ioException.printStackTrace();
		} catch (SAXException saxException) {
			saxException.printStackTrace();
		} catch (ParserConfigurationException parserConfigurationException) {
			parserConfigurationException.printStackTrace();
		}
		for (String nomeCategoria : listaNomiCategorie) {
			dto.setNomeCategoria(nomeCategoria);
			listaDTO.add(dto);
		}
		return listaDTO;
	}
}