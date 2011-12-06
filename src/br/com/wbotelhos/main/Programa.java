package br.com.wbotelhos.main;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.EntityManager;

import br.com.wbotelhos.helper.JPAHelper;
import br.com.wbotelhos.model.Artista;
import br.com.wbotelhos.model.ArtistaFilme;
import br.com.wbotelhos.model.Filme;

/**
 * @author Washington Botelho
 * @article http://www.wbotelhos.com.br/2011/12/06/hibernate-relacionamento-manytomany-com-atributos
 */

public class Programa {

	public static void main(String[] args) {
		EntityManager manager = JPAHelper.getEntityManager();

		// Cria e salva o artista 1.
		Artista artista1 = new Artista();
		artista1.setNome("artista-1");
		artista1 = manager.merge(artista1);

		// Cria e salva o artista 2.
		Artista artista2 = new Artista();
		artista2.setNome("artista-2");
		artista2 = manager.merge(artista2);

		// Prepara o filme.
		Filme filme = new Filme();
		filme.setNome("filme");

		// Adiciona o artista 1 no elenco do filme que sera salvo.
		ArtistaFilme artistaFilme1 = new ArtistaFilme();
		artistaFilme1.setFilme(filme); // Referencia de memoria.
		artistaFilme1.setArtista(artista1);
		artistaFilme1.setNome("nome-artistico-1");

		// Adiciona o artista 2 no elenco do filme que sera salvo.
		ArtistaFilme artistaFilme2 = new ArtistaFilme();
		artistaFilme2.setFilme(filme); // Referencia de memoria.
		artistaFilme2.setArtista(artista2);
		artistaFilme2.setNome("nome-artistico-2");

		// Cria uma lista dos artistas formando o elenco.
		Collection<ArtistaFilme> elenco = Arrays.asList(artistaFilme1, artistaFilme2);

		// Adiciona o elenco ao filme.
		filme.setArtistaFilmeList(elenco);

		// Salva o filme e consequentemente o elenco por cascada.
		manager.merge(filme);

		JPAHelper.close();
	}

}
