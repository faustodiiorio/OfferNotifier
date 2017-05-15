package it.offerNotifier.controller;

import java.util.ArrayList;
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
	
	@GetMapping(value="/getProducts", produces="application/json")
	public @ResponseBody Set<ProdottoDTO> getProducts(ItemFilter[] filtri, int categoryId, String sortorder, String... keywords){
		Set<ProdottoDTO> listaProdotti;
		ProdottoDTO prodottoDTO;
		String url= Utils.URL_SEARCH + Utils.FINDING_SERVICE + "?OPERATION-NAME=" + Utils.FIND_ITEMS_ADVANCED +
				"&SERVICE-VERSION=" + Utils.SERVICE_VERSION + "&SECURITY-APPNAME=" + Utils.MY_APP_ID +
				"&GLOBAL-ID=" + Utils.GLOBAL_ID + "&RESPONSE-DATA-FORMAT=" + Utils.RESPONSE_DATA_FORMAT + 
				"&REST-PAYLOAD=true&paginationInput.entriesPerPage=50";
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
					logger.info("it.offerNotifier.SearchController.getProducts(): CASISISTICA NON TRATTATA");
				}
			}
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
			 
		}
	}
}