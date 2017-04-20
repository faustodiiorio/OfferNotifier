package it.offerNotifier.dto;

import java.util.List;

import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Recensione;
import it.offerNotifier.model.Risposta;

public class UtenteDTO {
	private int id;
	private String bannato;
	private String email;
	private String password;
	private List<ProdottoDTO> listaProdotti;
	private List<Recensione> listaRecensioni;
	private List<Domanda> listaDomande;
	private List<Risposta> listaRisposte;

	public UtenteDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBannato() {
		return this.bannato;
	}

	public void setBannato(String bannato) {
		this.bannato = bannato;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ProdottoDTO> getListaProdotti() {
		return this.listaProdotti;
	}

	public void setListaProdotti(List<ProdottoDTO> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public List<Recensione> getListaRecensioni() {
		return listaRecensioni;
	}

	public void setListaRecensioni(List<Recensione> listaRecensioni) {
		this.listaRecensioni = listaRecensioni;
	}

	public List<Domanda> getListaDomande() {
		return listaDomande;
	}

	public void setListaDomande(List<Domanda> listaDomande) {
		this.listaDomande = listaDomande;
	}

	public List<Risposta> getListaRisposte() {
		return listaRisposte;
	}

	public void setListaRisposte(List<Risposta> listaRisposte) {
		this.listaRisposte = listaRisposte;
	}
}