package it.rdev.blog.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.rdev.blog.api.config.JwtTokenUtil;
import it.rdev.blog.api.controller.dto.ArticoloDTO;
import it.rdev.blog.api.dao.ArticoloDao;
import it.rdev.blog.api.dao.entity.Articolo;
import it.rdev.blog.api.service.ArticoloService;

@RequestMapping(value = "/api")
@RestController
public class ArticoloController {
	@Autowired
	private ArticoloDao ad;
	
	@Autowired
	private ArticoloService artService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(value = "/articoli", method = RequestMethod.GET)
	public ResponseEntity<?> getArticoli() {
		Set<Articolo> lista = ad.findAll();
		return new ResponseEntity<Set<Articolo>>(lista, HttpStatus.OK);
	}
	//FindByid
	
	@RequestMapping(value = "/articoli/{id:\\d+}")
	public ResponseEntity<?> getArticoliById(@PathVariable final long id, @RequestHeader(name = "Authorization", required = false) String token) {
		ResponseEntity<ArticoloDTO> re = null;
		
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			String username = jwtTokenUtil.getUsernameFromToken(token);
			ArticoloDTO dto = artService.CercaId(id);
			
			if (dto != null && dto.getAutore().getUsername().equals(username)) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}else {
			ArticoloDTO dto = artService.CercaId(id);
			
			if (dto != null && dto.getStato().equalsIgnoreCase("bozza")) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}
		return re;
		
	}
	
	@RequestMapping(value = "/elimina/{id:\\d+}")
	public ResponseEntity<?> eliminaArticoliById(@PathVariable final long id, @RequestHeader(name = "Authorization", required = false) String token) {
		ResponseEntity<ArticoloDTO> re = null;
		System.err.println("elimato controller");
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			String username = jwtTokenUtil.getUsernameFromToken(token);
			ArticoloDTO dto = artService.EliminaId(id);
			
			if (dto != null && dto.getAutore().getUsername().equals(username)) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}else {
			re = new ResponseEntity<ArticoloDTO>( HttpStatus.NOT_FOUND);
		}
		return re;
		
	}
	
	@RequestMapping(value = "/articoliByCategoria/{categoria}")
	public ResponseEntity<?> getArticoliByCategoria(@PathVariable final String categoria, @RequestHeader(name = "Authorization", required = false) String token) {
		ResponseEntity<ArticoloDTO> re = null;
		System.err.println("Categoria");
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			String username = jwtTokenUtil.getUsernameFromToken(token);
			ArticoloDTO dto = artService.CercaCategoria(categoria);
			
			if (dto != null && dto.getAutore().getUsername().equals(username)) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}else {
			ArticoloDTO dto = artService.CercaCategoria(categoria);
			
			if (dto != null && dto.getStato().equalsIgnoreCase("bozza")) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}
		return re;
		
	}
	
}
