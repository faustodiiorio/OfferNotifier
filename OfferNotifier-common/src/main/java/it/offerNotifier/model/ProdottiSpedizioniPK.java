package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class ProdottiSpedizioniPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PRODOTTO", insertable=false, updatable=false)
	private int idProdotto;

	@Column(name="ID_SPEDIZIONE", insertable=false, updatable=false)
	private int idSpedizione;

	public ProdottiSpedizioniPK() {
	}
	public int getIdProdotto() {
		return this.idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	public int getIdSpedizione() {
		return this.idSpedizione;
	}
	public void setIdSpedizione(int idSpedizione) {
		this.idSpedizione = idSpedizione;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProdottiSpedizioniPK)) {
			return false;
		}
		ProdottiSpedizioniPK castOther = (ProdottiSpedizioniPK)other;
		return 
			(this.idProdotto == castOther.idProdotto)
			&& (this.idSpedizione == castOther.idSpedizione);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProdotto;
		hash = hash * prime + this.idSpedizione;
		
		return hash;
	}
}