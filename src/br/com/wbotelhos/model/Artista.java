package br.com.wbotelhos.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2011/12/06/hibernate-relacionamento-manytomany-com-atributos
 */

@Entity
public class Artista {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	@OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
	private Collection<ArtistaFilme> artistaFilmeList;

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

	public Collection<ArtistaFilme> getArtistaFilmeList() {
		return artistaFilmeList;
	}

	public void setArtistaFilmeList(Collection<ArtistaFilme> artistaFilmeList) {
		this.artistaFilmeList = artistaFilmeList;
	}

}
