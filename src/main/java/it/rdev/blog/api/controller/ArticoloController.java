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
	
	@RequestMapping(value = "/articoliByCategoria/{categoria}")
	public ResponseEntity<?> getArticoliByCategoria(@PathVariable final String categoria, @RequestHeader(name = "Authorization", required = false) String token) {
		ResponseEntity<ArticoloDTO> re = null;
		System.err.println("Categoria");
		//Utente che ha effettuato l'accesso
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			String username = jwtTokenUtil.getUsernameFromToken(token);
			ArticoloDTO dto = artService.CercaCategoria(categoria);
			//Controllo che l'tente loggato sia l'autore dell'articolo
			if (dto != null && dto.getAutore().getUsername().equals(username)) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}else {
			//Utente che non ha effettuato l'accesso
			ArticoloDTO dto = artService.CercaCategoria(categoria);
			//L'articolo da visualizzare non deve essere una bozza
			if (dto != null && dto.getStato().equalsIgnoreCase("bozza")) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}
		return re;
		
	}
	
	@RequestMapping(value = "/articoliByAutore/{autore}")
	public ResponseEntity<?> getArticoliByAutore(@PathVariable final String autore, @RequestHeader(name = "Authorization", required = false) String token) {
		ResponseEntity<ArticoloDTO> re = null;
		System.err.println("Categoria");
		//Utente che ha effettuato l'accesso
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			String username = jwtTokenUtil.getUsernameFromToken(token);
			ArticoloDTO dto = artService.cercaAutore(autore);
			//Controllo che l'tente loggato sia l'autore dell'articolo
			if (dto != null && dto.getAutore().getUsername().equals(username)) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}else {
			//Utente che non ha effettuato l'accesso
			ArticoloDTO dto = artService.cercaAutore(autore);
			//L'articolo da visualizzare non deve essere una bozza
			if (dto != null && dto.getStato().equalsIgnoreCase("bozza")) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}
		return re;
		
	}
	
	@RequestMapping(value = "/inserisciArticolo/{titolo}/{categoria}/{stato}/{sottotitolo}/{testo}/{autore}/", method = RequestMethod.POST)
	public ResponseEntity<?> inserisciArticolo(@PathVariable final String titolo, final String categoria,final String stato,final String sottotitolo,final String testo,final String autore,@RequestHeader(name = "Authorization", required = false) String token) {
		//String titolo, String categoria, String stato, String sottotitolo, String testo, String autore
		ResponseEntity<ArticoloDTO> re = null;
		System.err.println("Categoria");
		//Utente che ha effettuato l'accesso
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			String username = jwtTokenUtil.getUsernameFromToken(token);
			ArticoloDTO dto = artService.insertArticolo(titolo, categoria, stato, sottotitolo, testo, autore);
			//Controllo che l'tente loggato sia l'autore dell'articolo
			if (dto != null && dto.getAutore().getUsername().equals(username)) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}
		return re;
		
	}
	
	@RequestMapping(value = "/eliminaArticolo/{id:\\d+}", method = RequestMethod.POST)
	public ResponseEntity<?> eliminaArticolo(@PathVariable final long id, @RequestHeader(name = "Authorization", required = false) String token) {
		//String titolo, String categoria, String stato, String sottotitolo, String testo, String autore
		ResponseEntity<ArticoloDTO> re = null;
		System.err.println("Categoria");
		//Utente che ha effettuato l'accesso
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			String username = jwtTokenUtil.getUsernameFromToken(token);
			ArticoloDTO dto = artService.deleteArticolo(id);
			//Controllo che l'tente loggato sia l'autore dell'articolo
			if (dto != null && dto.getAutore().getUsername().equals(username)) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}
		return re;	
	}
	
	@RequestMapping(value = "/aggiornaArticolo/{titolo}/{categoria}/{stato}/{sottotitolo}/{testo}/{autore}/", method = RequestMethod.POST)
	public ResponseEntity<?> aggiornaArticolo(@PathVariable final String titolo, final String categoria,final String stato,final String sottotitolo,final String testo,final String autore,@RequestHeader(name = "Authorization", required = false) String token) {
		//String titolo, String categoria, String stato, String sottotitolo, String testo, String autore
		ResponseEntity<ArticoloDTO> re = null;
		System.err.println("Categoria");
		//Utente che ha effettuato l'accesso
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			String username = jwtTokenUtil.getUsernameFromToken(token);
			ArticoloDTO dto = artService.updateArticolo(titolo, categoria, stato, sottotitolo, testo, autore);
			//Controllo che l'tente loggato sia l'autore dell'articolo
			if (dto != null && dto.getAutore().getUsername().equals(username)) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}
		return re;
		
	}
	
}
