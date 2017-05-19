package it.offerNotifier.dto;

import java.util.List;

import it.offerNotifier.model.Prodotto;

public class VenditoreDTO {
	private int id;
	private float feedback;
	private String nomeVenditore;
	private List<Prodotto> listaProdotti;

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

	public List<Prodotto> getListaProdotti() {
		return this.listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
}