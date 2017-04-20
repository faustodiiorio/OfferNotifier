package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import it.offerNotifier.model.Domanda;
import it.offerNotifier.model.Recensione;
import it.offerNotifier.model.Risposta;

import java.util.List;

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

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
			name="utenti_prodotti"
			, joinColumns={
				@JoinColumn(name="ID_UTENTE")
				}
			, inverseJoinColumns={
				@JoinColumn(name="ID_PRODOTTO")
				}
			)
	private List<Prodotto> listaProdotti;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "utente")
	private List<Recensione> listaRecensioni;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "utente")
	private List<Domanda> listaDomande;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "utente")
	private List<Risposta> listaRisposte;

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

	public List<Prodotto> getListaProdotti() {
		return this.listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
	public List<Recensione> getListaRecensioni() {
		return listaRecensioni;
	}

	public void setListaRecensioni(List<Recensione> listaRecensioni) {
		this.listaRecensioni = listaRecensioni;
	}

	public List<Domanda> getListaDomande() {
		return listaDomande;
	}

	public void setListaDomande(List<Domanda> listaDomande) {
		this.listaDomande = listaDomande;
	}

	public List<Risposta> getListaRisposte() {
		return listaRisposte;
	}

	public void setListaRisposte(List<Risposta> listaRisposte) {
		this.listaRisposte = listaRisposte;
	}
}