package it.rdev.blog.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.rdev.blog.api.controller.dto.CategoriaDTO;
import it.rdev.blog.api.dao.CategoriaDao;
import it.rdev.blog.api.dao.entity.Categoria;

@RequestMapping(value = "/api")
@RestController
public class CategorieController {
	@Autowired
	CategoriaDao cd;
	
	@RequestMapping(value = "/categoria", method = RequestMethod.GET)
	public ResponseEntity<?> getCategorie(@RequestBody CategoriaDTO categoria) throws Exception {
		Set<Categoria> lista = cd.getAllCategorie();
		return new ResponseEntity<Set<Categoria>>(lista, HttpStatus.OK);
	}
	
}
