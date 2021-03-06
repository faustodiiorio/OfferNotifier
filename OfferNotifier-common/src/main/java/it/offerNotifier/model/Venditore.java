package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Entity
@Table(name="venditori")
@NamedQuery(name="Venditore.findAll", query="SELECT v FROM Venditore v")
public class Venditore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private float feedback;

	@Column(name="NOME_VENDITORE")
	private String nomeVenditore;

	@OneToMany(mappedBy="venditore")
	private Set<Prodotto> listaProdotti;

	public Venditore() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getFeedback() {
		return this.feedback;
	}

	public void setFeedback(float feedback) {
		this.feedback = feedback;
	}

	public String getNomeVenditore() {
		return this.nomeVenditore;
	}

	public void setNomeVenditore(String nomeVenditore) {
		this.nomeVenditore = nomeVenditore;
	}

	public Set<Prodotto> getListaProdotti() {
		return this.listaProdotti;
	}

	public void setListaProdotti(Set<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public Prodotto addListaProdotti(Prodotto prodotto) {
		getListaProdotti().add(prodotto);
		prodotto.setVenditore(this);

		return prodotto;
	}

	public Prodotto removeListaProdotti(Prodotto prodotto) {
		getListaProdotti().remove(prodotto);
		prodotto.setVenditore(null);

		return prodotto;
	}
}