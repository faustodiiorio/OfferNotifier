package it.offerNotifier.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.offerNotifier.dto.CategoriaDTO;
import it.offerNotifier.utils.Utils;

@Controller
@RequestMapping("/header")
public class HeaderController {
	
	@GetMapping(value = "/getSuperCategories", produces = "application/json")
	public @ResponseBody Set<String> getSuperCategories() {
		String nomeCategoria = "";
		Set<String> listaNomiCategorie = new HashSet<String>();
		String str = Utils.URL_CATEGORY + "?callname="+ Utils.GET_CATEGORY_INFO
				+ "&appid="+ "MYAPPID" + "&CategoryID=-1&IncludeSelector=ChildCategories&version="
				+ Utils.SERVICE_VERSION + "&siteid="+ Utils.SITE_ID + "&responseencoding=JSON";
		JSONObject wsResult = Utils.getJOFromUrl(str);
		JSONArray listCategory = wsResult.getJSONObject("CategoryArray").getJSONArray("Category");
		JSONObject objJson = null;
		Set<Integer> listaIDCategorie = new HashSet<Integer>();
		for (int i = 0; i < listCategory.length(); i++) {
			objJson = listCategory.getJSONObject(i);
			nomeCategoria=(objJson.getString("CategoryName"));
			if (!nomeCategoria.equalsIgnoreCase("Root")) {
				listaNomiCategorie.add(nomeCategoria);
				listaIDCategorie.add(objJson.getInt("CategoryID"));
			}
		}
		Utils.asSortedList(listaNomiCategorie);
		return listaNomiCategorie;
	}
}