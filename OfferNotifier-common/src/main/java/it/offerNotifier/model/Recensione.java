package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="recensioni")
@NamedQuery(name="Recensione.findAll", query="SELECT r FROM Recensione r")
public class Recensione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descrizione;

	private float feedback;

	private String tipologia;

	@Column(name="TITOLO_RECENSIONE")
	private String titoloRecensione;

	@Column(name="VIDEO_RECENSIONE")
	private String videoRecensione;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PRODOTTO")
	private Prodotto prodotto;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_Utente")
	private Utente utente;

	public Recensione() {
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

	public Prodotto getProdotto() {
		return this.prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
}