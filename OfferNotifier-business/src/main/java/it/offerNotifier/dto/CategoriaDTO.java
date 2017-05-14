package it.offerNotifier.dto;

import java.util.List;
import java.util.Set;

import it.offerNotifier.model.Prodotto;

public class CategoriaDTO {
	private int id;
	private int idCategoria;
	private String nomeCategoria;
	private Set<Prodotto> listaProdotti;

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

	public Set<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(Set<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
}