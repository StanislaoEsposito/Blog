package it.rdev.blog.api.dao.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "articolo")
public class Articolo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToMany
	@JoinTable(
			name = "articolo_tag",
			joinColumns = @JoinColumn(name = "nome_tag"),
			inverseJoinColumns = @JoinColumn(name = "id_articolo")
			)
	private Set<Tag> tags;
	@Column
	private String titolo;
	@Column
	private String stato;
	@Column
	private String sottotitolo;
	@Column
	private String testo;
	@ManyToOne()
	@JoinColumn(name = "autore", referencedColumnName="username")
	private User autore;
	@Column
	private Date data_creazione;
	@Column
	private Date data_pubblicazione;
	@Column
	private Date data_modifica;
	@ManyToOne()
	@JoinColumn(name = "id_user", referencedColumnName="id")
	private User user;
	@ManyToOne()
	@JoinColumn(name = "categoria", referencedColumnName="nome")
	private Categoria categoriaArticolo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getSottotitolo() {
		return sottotitolo;
	}
	public void setSottotitolo(String sottotitolo) {
		this.sottotitolo = sottotitolo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public User getAutore() {
		return autore;
	}
	public void setAutore(User autore) {
		this.autore = autore;
	}
	public Date getData_creazione() {
		return data_creazione;
	}
	public void setData_creazione(Date data_creazione) {
		this.data_creazione = data_creazione;
	}
	public Date getData_pubblicazione() {
		return data_pubblicazione;
	}
	public void setData_pubblicazione(Date data_pubblicazione) {
		this.data_pubblicazione = data_pubblicazione;
	}
	public Date getData_modifica() {
		return data_modifica;
	}
	public void setData_modifica(Date data_modifica) {
		this.data_modifica = data_modifica;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Categoria getCategoriaArticolo() {
		return categoriaArticolo;
	}
	public void setCategoriaArticolo(Categoria categoriaArticolo) {
		this.categoriaArticolo = categoriaArticolo;
	}

	
}
