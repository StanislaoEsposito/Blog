package it.rdev.blog.api.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.rdev.blog.api.controller.dto.TagDTO;
import it.rdev.blog.api.service.TagService;

@RequestMapping(value = "/api")
@RestController
public class TagController {
	
	@Autowired
	private TagService ts;
	
	@RequestMapping(value = "/allTag", method = RequestMethod.GET)
	public ResponseEntity<Set<TagDTO>> getAllTag(){
		Set<TagDTO> tag = ts.getAllTag();
		return new ResponseEntity<Set<TagDTO>>(tag, HttpStatus.OK);
	}
	
	

}
