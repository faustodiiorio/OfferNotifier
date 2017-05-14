package it.offerNotifier.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.offerNotifier.dto.CategoriaDTO;
import it.offerNotifier.service.CategoriaService;
import it.offerNotifier.utils.Utils;

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
	public @ResponseBody Set<CategoriaDTO> getSuperCategories() {
		CategoriaDTO dto;
		Set<CategoriaDTO> listaDTO = new HashSet<CategoriaDTO>();
		String str = "http://open.api.ebay.com/Shopping?callname=GetCategoryInfo&appid=FaustoDi-OfferNot-PRD-908fa563f-53b506fd&CategoryID=-1&IncludeSelector=ChildCategories&version=967&siteid=101&responseencoding=JSON";
		Utils utils = new Utils();
		JSONObject wsResult = utils.getJOFromUrl(str);
		JSONArray listCategory = wsResult.getJSONObject("CategoryArray").getJSONArray("Category");
		JSONObject objJson = null;
		for (int i = 0; i < listCategory.length(); i++) {
			dto = new CategoriaDTO();
			objJson = listCategory.getJSONObject(i);
			dto.setNomeCategoria(objJson.getString("CategoryName"));
			if (!dto.getNomeCategoria().equalsIgnoreCase("Root")) {
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}
}