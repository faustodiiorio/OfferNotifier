package it.offerNotifier.dto;

import java.util.List;

public class ProdottoDTO{
	private int id;
	private String descrizione;
	private String nomeInserzione;
	private String nomeProdotto;
	private String prezzo;
	private int quantita;
	private String restituzione;
	private String tipologiaVendita;
	private VenditoreDTO venditore;
	private List<UtenteDTO> listaUtenti;
	private List<SpedizioneDTO> listaSpedizioni;
	private CategoriaDTO categoria;

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public ProdottoDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNomeInserzione() {
		return this.nomeInserzione;
	}

	public void setNomeInserzione(String nomeInserzione) {
		this.nomeInserzione = nomeInserzione;
	}

	public String getNomeProdotto() {
		return this.nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getRestituzione() {
		return this.restituzione;
	}

	public void setRestituzione(String restituzione) {
		this.restituzione = restituzione;
	}

	public String getTipologiaVendita() {
		return this.tipologiaVendita;
	}

	public void setTipologiaVendita(String tipologiaVendita) {
		this.tipologiaVendita = tipologiaVendita;
	}

	public VenditoreDTO getVenditore() {
		return this.venditore;
	}

	public void setVenditore(VenditoreDTO venditore) {
		this.venditore = venditore;
	}

	public List<UtenteDTO> getListaUtenti() {
		return this.listaUtenti;
	}

	public void setListaUtenti(List<UtenteDTO> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}

	public List<SpedizioneDTO> getListaSpedizioni() {
		return this.listaSpedizioni;
	}

	public void setListaSpedizioni(List<SpedizioneDTO> listaSpedizioni) {
		this.listaSpedizioni = listaSpedizioni;
	}
}