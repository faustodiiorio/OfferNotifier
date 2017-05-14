package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="utenti_prodotti")
@NamedQuery(name="UtentiProdotti.findAll", query="SELECT u FROM UtentiProdotti u")
public class UtentiProdotti implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UtentiProdottiPK id;

	//bi-directional many-to-one association to Prodotto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PRODOTTO", insertable = false, updatable = false)
	private Prodotto prodotto;

	//bi-directional many-to-one association to Utente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_UTENTE", insertable = false, updatable = false)
	private Utente utente;

	public UtentiProdotti() {
	}

	public UtentiProdottiPK getId() {
		return this.id;
	}

	public void setId(UtentiProdottiPK id) {
		this.id = id;
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