package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class UtentiProdottiPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ID_UTENTE", insertable=false, updatable=false)
	private int idUtente;

	@Column(name="ID_PRODOTTO", insertable=false, updatable=false)
	private int idProdotto;

	public UtentiProdottiPK() {
	}
	public int getIdUtente() {
		return this.idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public int getIdProdotto() {
		return this.idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UtentiProdottiPK)) {
			return false;
		}
		UtentiProdottiPK castOther = (UtentiProdottiPK)other;
		return 
			(this.idUtente == castOther.idUtente)
			&& (this.idProdotto == castOther.idProdotto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUtente;
		hash = hash * prime + this.idProdotto;
		
		return hash;
	}
}