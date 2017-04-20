package it.offerNotifier.dto;

public class RecensioneDTO {
	private int id;
	private String descrizione;
	private float feedback;
	private String tipologia;
	private String titoloRecensione;
	private String videoRecensione;
	private ProdottoDTO prodotto;
	private UtenteDTO utente;

	public RecensioneDTO() {
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

	public float getFeedback() {
		return this.feedback;
	}

	public void setFeedback(float feedback) {
		this.feedback = feedback;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getTitoloRecensione() {
		return this.titoloRecensione;
	}

	public void setTitoloRecensione(String titoloRecensione) {
		this.titoloRecensione = titoloRecensione;
	}

	public String getVideoRecensione() {
		return this.videoRecensione;
	}

	public void setVideoRecensione(String videoRecensione) {
		this.videoRecensione = videoRecensione;
	}

	public ProdottoDTO getProdotto() {
		return this.prodotto;
	}

	public void setProdotto(ProdottoDTO prodotto) {
		this.prodotto = prodotto;
	}

	public UtenteDTO getUtente() {
		return this.utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}
}