package it.rdev.blog.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rdev.blog.api.controller.dto.TagDTO;
import it.rdev.blog.api.dao.TagDao;
import it.rdev.blog.api.dao.entity.Tag;

@Service
public class TagService {
	@Autowired
	TagDao td;
	
	public Set<TagDTO> getAllTag(){
		Set<Tag> lista = td.getAllTag();
		Set<TagDTO> listaDto = new HashSet<>();
		for (Tag t : lista) {
			TagDTO dto = new TagDTO();
			dto.setNome(t.getNome());
			listaDto.add(dto);
		}
		return listaDto;
	}
}
