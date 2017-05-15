package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Entity
@Table(name="spedizioni")
@NamedQuery(name="Spedizione.findAll", query="SELECT s FROM Spedizione s")
public class Spedizione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="COSTO_SPEDIZIONE")
	private String costoSpedizione;

	@Column(name="TEMPO_IMPIEGATO")
	private String tempoImpiegato;

	@Column(name="TIPOLOGIA_SPEDIZIONE")
	private String tipologiaSpedizione;
	
	@Column(name="PAESE_DESTINAZIONE")
	private String paeseDestinazione;

	//bi-directional many-to-one association to ProdottiSpedizioni
	@OneToMany(mappedBy="spedizione")
	private Set<ProdottiSpedizioni> listaProdottiSpedizioni;

	public Spedizione() {
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

	public String getPaeseDestinazione() {
		return paeseDestinazione;
	}

	public void setPaeseDestinazione(String paeseDestinazione) {
		this.paeseDestinazione = paeseDestinazione;
	}

	public Set<ProdottiSpedizioni> getListaProdottiSpedizioni() {
		return this.listaProdottiSpedizioni;
	}

	public void setListaProdottiSpedizioni(Set<ProdottiSpedizioni> listaProdottiSpedizioni) {
		this.listaProdottiSpedizioni = listaProdottiSpedizioni;
	}

	public ProdottiSpedizioni addListaProdottiSpedizioni(ProdottiSpedizioni prodottiSpedizioni) {
		getListaProdottiSpedizioni().add(prodottiSpedizioni);
		prodottiSpedizioni.setSpedizione(this);

		return prodottiSpedizioni;
	}

	public ProdottiSpedizioni removeListaProdottiSpedizioni(ProdottiSpedizioni prodottiSpedizioni) {
		getListaProdottiSpedizioni().remove(prodottiSpedizioni);
		prodottiSpedizioni.setSpedizione(null);

		return prodottiSpedizioni;
	}
}