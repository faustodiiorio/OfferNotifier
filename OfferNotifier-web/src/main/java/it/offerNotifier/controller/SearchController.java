package it.offerNotifier.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

import it.offerNotifier.dto.ProdottoDTO;
import it.offerNotifier.model.Categoria;
import it.offerNotifier.model.ItemFilter;
import it.offerNotifier.utils.Utils;

@Controller
@RequestMapping("/search")
public class SearchController {
	@Autowired
	private ApplicationContext context;
	private Logger logger = Logger.getLogger(SearchController.class);
	private String myAppId = "FaustoDi-OfferNot-PRD-908fa563f-53b506fd";
	
	@GetMapping(value="/getProducts", produces="application/json")
	public @ResponseBody Set<ProdottoDTO> getProducts(ItemFilter[] filtri, String categoryName, String sortOrder, String... keywords){
		Set<ProdottoDTO> listaProdotti = new HashSet<ProdottoDTO>();
		ProdottoDTO prodottoDTO;
		String url= "http://svcs.ebay.com/services/search/FindingService/v1?OPERATION-NAME=findItemsAdvanced&SERVICE-VERSION=967&SECURITY-APPNAME=" + myAppId +
				"&GLOBAL-ID=EBAY-IT&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD=true&paginationInput.entriesPerPage=50";
		if(!keywords.equals("") && keywords.length != 0){
			url = url + "&keywords=";
			for(int i = 0; i < keywords.length; i++){
				if(keywords.length == 1 && keywords[i].length() > 1){
					url = url + keywords[i];
				} else if(keywords.length > 1 && i != (keywords.length-1) && keywords[i].length() > 1){
					url = url + keywords[i] +"%20";
				} else if(keywords.length > 1 && i == (keywords.length-1) && keywords[i].length() > 1){
					url = url + keywords[i];
				} else{
					logger.info("it.offerNotifier.SearchController.getProducts(): CASISTICA NON TRATTATA");
				}
			}
		}
		if(!categoryName.equals("") && categoryName.length() != 0){
			int categoryId = parseCategoryName(categoryName);
			url = url + "&categoryId=" + categoryId;
		}
		JSONObject wsResult = Utils.getJOFromUrl(url);
		prodottoDTO = new ProdottoDTO();
		JSONArray item = wsResult.getJSONArray("findItemsAdvancedResponse")
				.getJSONObject(0).getJSONArray("searchResult").getJSONObject(0).getJSONArray("item");
		for(int i = 0; i < item.length(); i++){
			Set<String> tipologiePagamento = new HashSet<String>();
			 prodottoDTO.setNomeInserzione(item.getJSONObject(i).getString("title"));
			 prodottoDTO.setCategoria(new Categoria());
			 prodottoDTO.getCategoria().setNomeCategoria(item.getJSONObject(i).getJSONArray("primaryCategory").getJSONObject(0).getString("categoryName"));;
			 tipologiePagamento.add(item.getJSONObject(i).getString("paymentMethod"));
			 prodottoDTO.setTipologiaPagamento(tipologiePagamento);
			 prodottoDTO.setLocazione(item.getJSONObject(i).getString("location"));
			 prodottoDTO.setNazione(item.getJSONObject(i).getString("country"));
			 
			 listaProdotti.add(prodottoDTO);
		}
		return listaProdotti;
	}
	public Integer parseCategoryName(String categoryName){
		
		
		
		return 1;
	}
	
	@GetMapping(value="/prepareList", produces="application/json")
	public @ResponseBody Map<String, String> prepareList(){
		String categoryId = "-1";
		String url ="http://open.api.ebay.com/Shopping?callname=GetCategoryInfo&appid=" + myAppId +
				"&IncludeSelector=ChildCategories&version=967&siteid=101&responseencoding=JSON&callbackname=jsonpcallback&CategoryID=" + categoryId;
		JSONObject wsResult = Utils.getJOFromUrl(url);
		JSONObject item1 = wsResult.getJSONObject("CategoryArray");
		JSONObject item = item1.getJSONObject("Category");
		Map<String, String> listaIDCategorie= new HashMap<String, String>();
		for(int i = 0; i < item.length(); i++){
			if(!item.getJSONObject(i).get("CategoryID").equals("-1")){
				listaIDCategorie.put((String)item.getJSONObject(i).get("CategoryID"), (String)item.getJSONObject(i).get("CategoryName"));
			}
		}
		JSONObject wsNested;
		for(int i = 0; i < listaIDCategorie.size(); i++){
			url = "http://open.api.ebay.com/Shopping?callname=GetCategoryInfo&appid=" + myAppId +
					"&IncludeSelector=ChildCategories&version=967&siteid=101&responseencoding=JSON&callbackname=jsonpcallback&CategoryID=" + listaIDCategorie.get(i);
			wsNested = Utils.getJOFromUrl(url);
			for(int j = 0; j < wsNested.length(); j++){
				listaIDCategorie.put((String)item.getJSONObject(i).get("CategoryID"), (String)item.getJSONObject(i).get("CategoryName"));
			}
		}
		return listaIDCategorie;
	}
}