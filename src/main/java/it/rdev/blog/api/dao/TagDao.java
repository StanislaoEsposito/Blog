package it.rdev.blog.api.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.rdev.blog.api.dao.entity.Categoria;
import it.rdev.blog.api.dao.entity.Tag;

public interface TagDao extends CrudRepository<Tag, Integer> {
	@Query("SELECT t From Tag t")
	Set<Tag> getAllTag();
}
