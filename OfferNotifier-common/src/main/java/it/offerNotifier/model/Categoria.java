package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name="categorie")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="ID_CATEGORIA")
	private int idCategoria;

	@Column(name="NOME_CATEGORIA")
	private String nomeCategoria;

	//bi-directional many-to-one association to Prodotti
	@OneToMany(mappedBy="categoria", cascade={CascadeType.ALL})
	private List<Prodotto> listaProdotti;

	public Categoria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<Prodotto> getListaProdotti() {
		return this.listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public Prodotto addListaProdotti(Prodotto prodotto) {
		getListaProdotti().add(prodotto);
		prodotto.setCategoria(this);

		return prodotto;
	}

	public Prodotto removeListaProdotti(Prodotto prodotto) {
		getListaProdotti().remove(prodotto);
		prodotto.setCategoria(null);

		return prodotto;
	}
}