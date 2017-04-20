package it.offerNotifier.dto;

import java.util.Date;

public class RispostaDTO {

	private int id;
	private Date data;
	private String testo;
	private DomandaDTO domanda;
	private UtenteDTO utente;

	public RispostaDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTesto() {
		return this.testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public DomandaDTO getDomanda() {
		return this.domanda;
	}

	public void setDomanda(DomandaDTO domanda) {
		this.domanda = domanda;
	}

	public UtenteDTO getUtente() {
		return this.utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}
}