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
import it.rdev.blog.api.controller.dto.TagDTO;
import it.rdev.blog.api.service.ArticoloService;
import it.rdev.blog.api.service.TagService;

@RequestMapping(value = "/api")
@RestController
public class TagController {
	
	@Autowired
	private TagService ts;
	
	@Autowired
	private ArticoloService artService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(value = "/allTag", method = RequestMethod.GET)
	public ResponseEntity<Set<TagDTO>> getAllTag(){
		Set<TagDTO> tag = ts.getAllTag();
		return new ResponseEntity<Set<TagDTO>>(tag, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/articoliByTag/{tag}")
	public ResponseEntity<?> getArticoliByTag(@PathVariable final String tag, @RequestHeader(name = "Authorization", required = false) String token) {
		ResponseEntity<ArticoloDTO> re = null;
		System.err.println("tag");
		String tag2 = tag.replaceAll(" ", "");
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			String username = jwtTokenUtil.getUsernameFromToken(token);
			ArticoloDTO dto = artService.cercaTag(tag2);
			
			if (dto != null && dto.getAutore().getUsername().equals(username)) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}else {
			ArticoloDTO dto = artService.cercaTag(tag2);
			
			if (dto != null && dto.getStato().equalsIgnoreCase("bozza")) {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.OK);
			}else {
				re = new ResponseEntity<ArticoloDTO>(dto, HttpStatus.NOT_FOUND);
			}
		}
		return re;
		
	}

}
