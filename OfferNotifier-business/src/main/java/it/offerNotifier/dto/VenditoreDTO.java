package it.offerNotifier.dto;

import java.util.List;

public class VenditoreDTO {
	private int id;
	private float feedback;
	private String nomeVenditore;
	private List<ProdottoDTO> listaProdotti;

	public VenditoreDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getFeedback() {
		return this.feedback;
	}

	public void setFeedback(float feedback) {
		this.feedback = feedback;
	}

	public String getNomeVenditore() {
		return this.nomeVenditore;
	}

	public void setNomeVenditore(String nomeVenditore) {
		this.nomeVenditore = nomeVenditore;
	}

	public List<ProdottoDTO> getListaProdotti() {
		return this.listaProdotti;
	}

	public void setListaProdotti(List<ProdottoDTO> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public ProdottoDTO addProdotti(ProdottoDTO prodotto) {
		getListaProdotti().add(prodotto);
		prodotto.setVenditore(this);
		return prodotto;
	}

	public ProdottoDTO removeProdotti(ProdottoDTO prodotto) {
		getListaProdotti().remove(prodotto);
		prodotto.setVenditore(null);
		return prodotto;
	}
}