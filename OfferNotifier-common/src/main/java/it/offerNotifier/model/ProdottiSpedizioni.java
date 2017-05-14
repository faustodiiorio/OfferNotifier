package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="prodotti_spedizioni")
@NamedQuery(name="ProdottiSpedizioni.findAll", query="SELECT p FROM ProdottiSpedizioni p")
public class ProdottiSpedizioni implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProdottiSpedizioniPK id;

	//bi-directional many-to-one association to Prodotto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PRODOTTO", insertable = false, updatable = false)
	private Prodotto prodotto;

	//bi-directional many-to-one association to Spedizione
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SPEDIZIONE", insertable = false, updatable = false)
	private Spedizione spedizione;

	public ProdottiSpedizioni() {
	}

	public ProdottiSpedizioniPK getId() {
		return this.id;
	}

	public void setId(ProdottiSpedizioniPK id) {
		this.id = id;
	}

	public Prodotto getProdotto() {
		return this.prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public Spedizione getSpedizione() {
		return this.spedizione;
	}

	public void setSpedizione(Spedizione spedizione) {
		this.spedizione = spedizione;
	}
}