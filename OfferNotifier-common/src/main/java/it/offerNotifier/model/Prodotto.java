package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Entity
@Table(name="prodotti")
@NamedQuery(name="Prodotto.findAll", query="SELECT p FROM Prodotto p")
public class Prodotto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String descrizione;

	@Column(name="NOME_INSERZIONE")
	private String nomeInserzione;

	@Column(name="NOME_PRODOTTO")
	private String nomeProdotto;

	private String prezzo;

	private int quantita;

	private String restituzione;

	@Column(name="TIPOLOGIA_VENDITA")
	private String tipologiaVendita;

	@OneToMany(mappedBy="prodotto")
	private Set<Domanda> listaDomande;

	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CATEGORIA")
	private Categoria categoria;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_VENDITORE")
	private Venditore venditore;

	@OneToMany(mappedBy="prodotto")
	private Set<Recensione> listaRecensioni;

	//bi-directional many-to-many association to Utente
	@ManyToMany(mappedBy="listaProdotti")
	private Set<Utente> listaUtenti;

	//bi-directional many-to-one association to ProdottiSpedizioni
	@OneToMany(mappedBy="prodotto")
	private Set<ProdottiSpedizioni> listaProdottiSpedizioni;

	//bi-directional many-to-one association to UtentiProdotti
	@OneToMany(mappedBy="prodotto")
	private Set<UtentiProdotti> listaUtentiProdotti;

	public Prodotto() {
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

	public String getNomeInserzione() {
		return this.nomeInserzione;
	}

	public void setNomeInserzione(String nomeInserzione) {
		this.nomeInserzione = nomeInserzione;
	}

	public String getNomeProdotto() {
		return this.nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getRestituzione() {
		return this.restituzione;
	}

	public void setRestituzione(String restituzione) {
		this.restituzione = restituzione;
	}

	public String getTipologiaVendita() {
		return this.tipologiaVendita;
	}

	public void setTipologiaVendita(String tipologiaVendita) {
		this.tipologiaVendita = tipologiaVendita;
	}

	public Set<Domanda> getListaDomande() {
		return this.listaDomande;
	}

	public void setListaDomande(Set<Domanda> listaDomande) {
		this.listaDomande = listaDomande;
	}

	public Domanda addListaDomande(Domanda domanda) {
		getListaDomande().add(domanda);
		domanda.setProdotto(this);

		return domanda;
	}

	public Domanda removeListaDomande(Domanda domanda) {
		getListaDomande().remove(domanda);
		domanda.setProdotto(null);

		return domanda;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Venditore getVenditore() {
		return this.venditore;
	}

	public void setVenditore(Venditore venditore) {
		this.venditore = venditore;
	}

	public Set<Recensione> getListaRecensioni() {
		return this.listaRecensioni;
	}

	public void setListaRecensioni(Set<Recensione> listaRecensioni) {
		this.listaRecensioni = listaRecensioni;
	}

	public Recensione addListaRecensioni(Recensione recensione) {
		getListaRecensioni().add(recensione);
		recensione.setProdotto(this);

		return recensione;
	}

	public Recensione removeListaRecensioni(Recensione recensione) {
		getListaRecensioni().remove(recensione);
		recensione.setProdotto(null);

		return recensione;
	}

	public Set<Utente> getUtentis() {
		return this.listaUtenti;
	}

	public void setUtentis(Set<Utente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}

	public Set<ProdottiSpedizioni> getListaProdottiSpedizioni() {
		return this.listaProdottiSpedizioni;
	}

	public void setListaProdottiSpedizioni(Set<ProdottiSpedizioni> listaProdottiSpedizioni) {
		this.listaProdottiSpedizioni = listaProdottiSpedizioni;
	}

	public ProdottiSpedizioni addListaProdottiSpedizioni(ProdottiSpedizioni prodottiSpedizioni) {
		getListaProdottiSpedizioni().add(prodottiSpedizioni);
		prodottiSpedizioni.setProdotto(this);

		return prodottiSpedizioni;
	}

	public ProdottiSpedizioni removeListaProdottiSpedizioni(ProdottiSpedizioni prodottiSpedizioni) {
		getListaProdottiSpedizioni().remove(prodottiSpedizioni);
		prodottiSpedizioni.setProdotto(null);

		return prodottiSpedizioni;
	}

	public Set<UtentiProdotti> getListaUtentiProdotti() {
		return this.listaUtentiProdotti;
	}

	public void setListaUtentiProdotti(Set<UtentiProdotti> listaUtentiProdotti) {
		this.listaUtentiProdotti = listaUtentiProdotti;
	}

	public UtentiProdotti addListaUtentiProdotti(UtentiProdotti utentiProdotti) {
		getListaUtentiProdotti().add(utentiProdotti);
		utentiProdotti.setProdotto(this);

		return utentiProdotti;
	}

	public UtentiProdotti removeListaUtentiProdotti(UtentiProdotti utentiProdotti) {
		getListaUtentiProdotti().remove(utentiProdotti);
		utentiProdotti.setProdotto(null);

		return utentiProdotti;
	}
}