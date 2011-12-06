package br.com.wbotelhos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2011/12/06/hibernate-relacionamento-manytomany-com-atributos
 */

@Entity
public class ArtistaFilme {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;

	@ManyToOne
	@JoinColumn(name = "artista_id")
	private Artista artista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

}
