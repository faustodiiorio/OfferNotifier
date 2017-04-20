package it.offerNotifier.dto;

import java.util.List;

public class SpedizioneDTO {
	private int id;
	private String costoSpedizione;
	private String tempoImpiegato;
	private String tipologiaSpedizione;
	private List<ProdottoDTO> listaProdotti;

	public SpedizioneDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCostoSpedizione() {
		return this.costoSpedizione;
	}

	public void setCostoSpedizione(String costoSpedizione) {
		this.costoSpedizione = costoSpedizione;
	}

	public String getTempoImpiegato() {
		return this.tempoImpiegato;
	}

	public void setTempoImpiegato(String tempoImpiegato) {
		this.tempoImpiegato = tempoImpiegato;
	}

	public String getTipologiaSpedizione() {
		return this.tipologiaSpedizione;
	}

	public void setTipologiaSpedizione(String tipologiaSpedizione) {
		this.tipologiaSpedizione = tipologiaSpedizione;
	}

	public List<ProdottoDTO> getListaProdotti() {
		return this.listaProdotti;
	}

	public void setListaProdotti(List<ProdottoDTO> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
}