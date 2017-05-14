package it.offerNotifier.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {
	@Autowired
	private ApplicationContext context;
	
	private Logger logger = Logger.getLogger(SearchController.class);
	
	/*@GetMapping(value = "/getSuperCategories", produces = "application/json")
	public @ResponseBody List<CategoriaDTO> getSuperCategories(){
		logger.info("Starting service getSuperCategories");
			List<Categoria> listaCategorie = categoriaService.getCategoriesById(0);
			logger.info("named query SUCCESSFULLY RETURNING OBJECT");
			List<CategoriaDTO> listaDTO = new ArrayList<CategoriaDTO>();
			CategoriaDTO dto;
			for(Categoria c : listaCategorie){
				if(!c.getListaProdotti().equals(null) && !c.getListaProdotti().isEmpty()){
//			Categoria cat = listaCategorie.get(0);
					dto = new CategoriaDTO();
					dto.setId(c.getId());
					dto.setIdCategoria(c.getIdCategoria());
					dto.setListaProdotti(c.getListaProdotti());
					dto.setNomeCategoria(c.getNomeCategoria());
					listaDTO.add(dto);
				}
			}
			logger.info("Ending service getSuperCategories");
			return listaDTO;
	}*/
	
}