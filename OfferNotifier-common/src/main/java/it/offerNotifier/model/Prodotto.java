package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.List;

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

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ID_VENDITORE")
	private Venditore venditore;

	@ManyToMany(cascade={CascadeType.ALL}, mappedBy="listaProdotti")
	private List<Utente> listaUtenti;

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
		name="prodotti_spedizioni"
		, joinColumns={
			@JoinColumn(name="ID_PRODOTTO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_SPEDIZIONE")
			}
		)
	private List<Spedizione> listaSpedizioni;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ID_CATEGORIA")
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

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

	public Venditore getVenditore() {
		return this.venditore;
	}

	public void setVenditore(Venditore venditore) {
		this.venditore = venditore;
	}

	public List<Utente> getListaUtenti() {
		return this.listaUtenti;
	}

	public void setListaUtenti(List<Utente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}

	public List<Spedizione> getListaSpedizioni() {
		return this.listaSpedizioni;
	}

	public void setListaSpedizioni(List<Spedizione> listaSpedizioni) {
		this.listaSpedizioni = listaSpedizioni;
	}
}