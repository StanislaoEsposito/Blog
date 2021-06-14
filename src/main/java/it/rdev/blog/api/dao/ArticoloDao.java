package it.rdev.blog.api.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.rdev.blog.api.dao.entity.Articolo;

public interface ArticoloDao extends CrudRepository<Articolo, Integer> {
	Articolo findByTitolo(String titolo);
	
	//Query jpa che restituisce tutti gli articoli
	@Query("SELECT a From Articolo a JOIN a.categoriaArticolo c")
	Set<Articolo> findAll();

//	@Query("SELECT a From Articolo a where a.titolo like :titolo OR a.sottotitolo like :titolo OR a.testo like :titolo")
//	Set<Articolo> ricercaPerTesto(@Param("titolo") String ricerca);

	//Query jpa che restituisce l'articolo in base all'id
	@Query("SELECT a From Articolo a JOIN a.categoriaArticolo c where a.id = :id")
	Articolo findById(long id);
	//Query jpa che restituisce l'articolo in base alla categoria
	@Query("SELECT a From Articolo a JOIN a.categoriaArticolo c where c.nome = :categoria")
	Articolo findByCategoria(String categoria);
	//Query jpa che restituisce l'articolo in base al tag
	@Query("SELECT a From Articolo a JOIN a.tags t where t.nome = :tag")
	Articolo findByTag(String tag);
	//Query jpa che restituisce l'articolo in base all'autore
	@Query("SELECT a From Articolo a JOIN a.autore u where u.username = :username")
	Articolo findByAutore(String username);
	
	//Query jpa che permette di inserire un nuovo articolo
	@Query("INSERT INTO Articolo VALUES(0, :titolo , :categoria , :stato , :sottotitolo, :testo , :autore , CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)")
	Articolo insertArticolo(String titolo, String categoria, String stato, String sottotitolo, String testo, String autore);
	//Query jpa che elimina l'articolo in base all'id
	@Query("DELETE FROM Articolo a where a.id = :id")
	Articolo deleteArticolo(long id);
	//Query jpa che permette di modificare un articolo
	@Query("Update articolo set titolo = :titolo , categoria = :categoria , stato = :stato , sottotitolo = :sottotitolo , testo = :testo , autore = :autore , data_modifica = CURRENT_TIMESTAMP")
	Articolo updateArticolo(String titolo, String categoria, String stato, String sottotitolo, String testo, String autore);
}
