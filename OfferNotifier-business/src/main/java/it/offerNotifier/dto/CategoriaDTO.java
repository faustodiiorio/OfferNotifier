package it.offerNotifier.dto;

import java.util.List;

public class CategoriaDTO {
	private int id;
	private int idCategoria;
	private String nomeCategoria;
	private List<ProdottoDTO> listaProdotti;

	public CategoriaDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<ProdottoDTO> getListaProdotti() {
		return this.listaProdotti;
	}

	public void setListaProdotti(List<ProdottoDTO> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public ProdottoDTO addListaProdotti(ProdottoDTO prodotto) {
		getListaProdotti().add(prodotto);
		prodotto.setCategoria(this);

		return prodotto;
	}

	public ProdottoDTO removeListaProdotti(ProdottoDTO prodotto) {
		getListaProdotti().remove(prodotto);
		prodotto.setCategoria(null);

		return prodotto;
	}
}