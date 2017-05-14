package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Entity
@Table(name="recensioni")
@NamedQuery(name="Recensione.findAll", query="SELECT r FROM Recensione r")
public class Recensione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String descrizione;

	private BigDecimal feedback;

	@Column(name="TITOLO_RECENSIONE")
	private String titoloRecensione;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PRODOTTO")
	private Prodotto prodotto;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_UTENTE")
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

	public BigDecimal getFeedback() {
		return this.feedback;
	}

	public void setFeedback(BigDecimal feedback) {
		this.feedback = feedback;
	}

	public String getTitoloRecensione() {
		return this.titoloRecensione;
	}

	public void setTitoloRecensione(String titoloRecensione) {
		this.titoloRecensione = titoloRecensione;
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