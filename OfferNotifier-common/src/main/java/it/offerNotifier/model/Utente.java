package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Entity
@Table(name="utenti")
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String bannato;

	private String email;

	private String password;

	@OneToMany(mappedBy="utente")
	private Set<Domanda> listaDomande;

	@OneToMany(mappedBy="utente")
	private Set<Recensione> listaRecensioni;

	@OneToMany(mappedBy="utente")
	private Set<Risposta> listaRisposte;

	//bi-directional many-to-many association to Prodotto
	@ManyToMany
	@JoinTable(
		name="utenti_prodotti"
		, joinColumns={
			@JoinColumn(name="ID_UTENTE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_PRODOTTO")
			}
		)
	private Set<Prodotto> listaProdotti;

	//bi-directional many-to-one association to UtentiProdotti
	@OneToMany(mappedBy="utente")
	private Set<UtentiProdotti> listaUtentiProdotti;

	public Utente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBannato() {
		return this.bannato;
	}

	public void setBannato(String bannato) {
		this.bannato = bannato;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Domanda> getListaDomande() {
		return this.listaDomande;
	}

	public void setListaDomande(Set<Domanda> listaDomande) {
		this.listaDomande = listaDomande;
	}

	public Domanda addListaDomande(Domanda listaDomande) {
		getListaDomande().add(listaDomande);
		listaDomande.setUtente(this);

		return listaDomande;
	}

	public Domanda removeListaDomande(Domanda listaDomande) {
		getListaDomande().remove(listaDomande);
		listaDomande.setUtente(null);

		return listaDomande;
	}

	public Set<Recensione> getListaRecensioni() {
		return this.listaRecensioni;
	}

	public void setListaRecensioni(Set<Recensione> listaRecensioni) {
		this.listaRecensioni = listaRecensioni;
	}

	public Recensione addListaRecensioni(Recensione recensione) {
		getListaRecensioni().add(recensione);
		recensione.setUtente(this);

		return recensione;
	}

	public Recensione removeListaRecensioni(Recensione recensione) {
		getListaRecensioni().remove(recensione);
		recensione.setUtente(null);

		return recensione;
	}

	public Set<Risposta> getListaRisposte() {
		return this.listaRisposte;
	}

	public void setListaRisposte(Set<Risposta> listaRisposte) {
		this.listaRisposte = listaRisposte;
	}

	public Risposta addListaRisposte(Risposta risposta) {
		getListaRisposte().add(risposta);
		risposta.setUtente(this);

		return risposta;
	}

	public Risposta removeListaRisposte(Risposta risposta) {
		getListaRisposte().remove(risposta);
		risposta.setUtente(null);

		return risposta;
	}

	public Set<Prodotto> getListaProdotti() {
		return this.listaProdotti;
	}

	public void setListaProdotti(Set<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public Set<UtentiProdotti> getListaUtentiProdotti() {
		return this.listaUtentiProdotti;
	}

	public void setListaUtentiProdotti(Set<UtentiProdotti> listaUtentiProdotti) {
		this.listaUtentiProdotti = listaUtentiProdotti;
	}

	public UtentiProdotti addListaUtentiProdotti(UtentiProdotti utentiProdotti) {
		getListaUtentiProdotti().add(utentiProdotti);
		utentiProdotti.setUtente(this);

		return utentiProdotti;
	}

	public UtentiProdotti removeListaUtentiProdotti(UtentiProdotti utentiProdotti) {
		getListaUtentiProdotti().remove(utentiProdotti);
		utentiProdotti.setUtente(null);

		return utentiProdotti;
	}
}