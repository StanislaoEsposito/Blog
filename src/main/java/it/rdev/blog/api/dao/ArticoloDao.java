package it.rdev.blog.api.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.rdev.blog.api.dao.entity.Articolo;

public interface ArticoloDao extends CrudRepository<Articolo, Integer> {
	Articolo findByTitolo(String titolo);
	@Query("SELECT a From Articolo a JOIN a.categoriaArticolo c")
	Set<Articolo> findAll();
	
	@Query("SELECT a From Articolo a where a.titolo like :titolo OR a.sottotitolo like :titolo OR a.testo like :titolo")
	Set<Articolo> ricercaPerTesto(@Param("titolo") String ricerca);

	@Query("SELECT a From Articolo a JOIN a.categoriaArticolo c where a.id = :id")
	Articolo findById(long id);
	
	@Query("delete From Articolo a where a.id = :id")
	Articolo DeleteById(long id);
	
	@Query("SELECT a From Articolo a JOIN a.categoriaArticolo c where a.categoriaArticolo = :categoria")
	Articolo findByCategoria(String categoria);

}
