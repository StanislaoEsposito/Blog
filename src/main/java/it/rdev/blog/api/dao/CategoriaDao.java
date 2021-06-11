package it.rdev.blog.api.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.rdev.blog.api.dao.entity.Articolo;
import it.rdev.blog.api.dao.entity.Categoria;

public interface CategoriaDao extends CrudRepository<Categoria, Integer>{
	@Query("SELECT c From Categoria c")
	Set<Categoria> getAllCategorie();
}
