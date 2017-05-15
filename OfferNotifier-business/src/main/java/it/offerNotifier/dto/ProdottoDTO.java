package it.offerNotifier.dto;

import java.util.Date;
import java.util.Set;

import it.offerNotifier.model.Categoria;
import it.offerNotifier.model.Spedizione;
import it.offerNotifier.model.Utente;

public class ProdottoDTO{
	private int id;
	private String descrizione;
	private String nomeInserzione;
	private Categoria categoria;
	private String urlSuEbay;
	private Set<String> tipologiaPagamento;
	private String locazione;
	private String nazione;
	private Set<Spedizione> listaSpedizioni;
	private String prezzo;
	private int numeroOfferte;
	private String statoVendita;
	private Date tempoRimasto;
	private boolean migliorOffertaAbilitata;
	private boolean compraloOraDisponibile;
	private Date dataInizio;
	private Date dataFine;
	private String tipologiaVendita;
	private boolean regalo;
	private String nomeProdotto;
	private String condizioneSecondoUtente;
//	campi in forse
	private int quantita;
	private String restituzione;
	private String venditore;
	private Set<Utente> listaUtenti;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getNomeInserzione() {
		return nomeInserzione;
	}
	public void setNomeInserzione(String nomeInserzione) {
		this.nomeInserzione = nomeInserzione;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getUrlSuEbay() {
		return urlSuEbay;
	}
	public void setUrlSuEbay(String urlSuEbay) {
		this.urlSuEbay = urlSuEbay;
	}
	public Set<String> getTipologiaPagamento() {
		return tipologiaPagamento;
	}
	public void setTipologiaPagamento(Set<String> tipologiaPagamento) {
		this.tipologiaPagamento = tipologiaPagamento;
	}
	public String getLocazione() {
		return locazione;
	}
	public void setLocazione(String locazione) {
		this.locazione = locazione;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public Set<Spedizione> getListaSpedizioni() {
		return listaSpedizioni;
	}
	public void setListaSpedizioni(Set<Spedizione> listaSpedizioni) {
		this.listaSpedizioni = listaSpedizioni;
	}
	public String getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}
	public int getNumeroOfferte() {
		return numeroOfferte;
	}
	public void setNumeroOfferte(int numeroOfferte) {
		this.numeroOfferte = numeroOfferte;
	}
	public String getStatoVendita() {
		return statoVendita;
	}
	public void setStatoVendita(String statoVendita) {
		this.statoVendita = statoVendita;
	}
	public Date getTempoRimasto() {
		return tempoRimasto;
	}
	public void setTempoRimasto(Date tempoRimasto) {
		this.tempoRimasto = tempoRimasto;
	}
	public boolean isMigliorOffertaAbilitata() {
		return migliorOffertaAbilitata;
	}
	public void setMigliorOffertaAbilitata(boolean migliorOffertaAbilitata) {
		this.migliorOffertaAbilitata = migliorOffertaAbilitata;
	}
	public boolean isCompraloOraDisponibile() {
		return compraloOraDisponibile;
	}
	public void setCompraloOraDisponibile(boolean compraloOraDisponibile) {
		this.compraloOraDisponibile = compraloOraDisponibile;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public String getTipologiaVendita() {
		return tipologiaVendita;
	}
	public void setTipologiaVendita(String tipologiaVendita) {
		this.tipologiaVendita = tipologiaVendita;
	}
	public boolean isRegalo() {
		return regalo;
	}
	public void setRegalo(boolean regalo) {
		this.regalo = regalo;
	}
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	public String getCondizioneSecondoUtente() {
		return condizioneSecondoUtente;
	}
	public void setCondizioneSecondoUtente(String condizioneSecondoUtente) {
		this.condizioneSecondoUtente = condizioneSecondoUtente;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public String getRestituzione() {
		return restituzione;
	}
	public void setRestituzione(String restituzione) {
		this.restituzione = restituzione;
	}
	public String getVenditore() {
		return venditore;
	}
	public void setVenditore(String venditore) {
		this.venditore = venditore;
	}
	public Set<Utente> getListaUtenti() {
		return listaUtenti;
	}
	public void setListaUtenti(Set<Utente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}
}