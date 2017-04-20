package it.offerNotifier.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Entity
@Table(name="risposte")
@NamedQuery(name="Risposta.findAll", query="SELECT r FROM Risposta r")
public class Risposta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Lob
	private String testo;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_DOMANDA")
	private Domanda domanda;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_UTENTE")
	private Utente utente;

	public Risposta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTesto() {
		return this.testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Domanda getDomanda() {
		return this.domanda;
	}

	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
}