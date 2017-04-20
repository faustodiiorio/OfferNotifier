package it.offerNotifier.dto;

import java.util.Date;
import java.util.List;

public class DomandaDTO {
	private int id;
	private Date data;
	private String testo;
	private String titolo;
	private UtenteDTO utente;
	private List<RispostaDTO> listaRisposte;
	private ProdottoDTO prodotto;
	
	public DomandaDTO() {
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

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public UtenteDTO getUtente() {
		return this.utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public List<RispostaDTO> getListaRisposte() {
		return this.listaRisposte;
	}

	public void setListaRisposte(List<RispostaDTO> listaRisposte) {
		this.listaRisposte = listaRisposte;
	}

	public RispostaDTO addRisposta(RispostaDTO risposta) {
		getListaRisposte().add(risposta);
		risposta.setDomanda(this);
		return risposta;
	}

	public RispostaDTO removeRisposta(RispostaDTO risposta) {
		getListaRisposte().remove(risposta);
		risposta.setDomanda(null);
		return risposta;
	}

	public ProdottoDTO getProdotto() {
		return prodotto;
	}

	public void setProdotto(ProdottoDTO prodotto) {
		this.prodotto = prodotto;
	}
}