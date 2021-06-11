package it.rdev.blog.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import it.rdev.blog.api.controller.dto.ArticoloDTO;
import it.rdev.blog.api.dao.ArticoloDao;
import it.rdev.blog.api.dao.entity.Articolo;

@Service
public class ArticoloService {
	@Autowired
	private ArticoloDao aDao;
	
	public Set<ArticoloDTO> findAll() {
		Set<Articolo> lista = aDao.findAll();
		
		Set<ArticoloDTO> listaDto = new HashSet<>();
		for (Articolo a : lista) {
			ArticoloDTO dto = new ArticoloDTO();
			dto.setId(a.getId());
			dto.setTag(a.getTags());
			dto.setTitolo(a.getTitolo());
			dto.setCategoria(a.getCategoriaArticolo());
			dto.setStato(a.getStato());
			dto.setSottotitolo(a.getSottotitolo());
			dto.setTesto(a.getTesto());
			dto.setAutore(a.getAutore());
			dto.setDataCreazione(a.getData_creazione());
			dto.setDataPubblicazione(a.getData_pubblicazione());
			dto.setDataModifica(a.getData_modifica());
			listaDto.add(dto);
		}
		for (ArticoloDTO articoloDTO : listaDto) {
			System.out.println(articoloDTO.getTitolo());
		}
		
		return listaDto;
	}
		
		
		public ArticoloDTO CercaId(long id){
	        Articolo a = aDao.findById(id);
	        ArticoloDTO dto = new ArticoloDTO();
	        if (a != null) {
	            	dto.setId(a.getId());
	        		dto.setTag(a.getTags());
	        		dto.setTitolo(a.getTitolo());
	        		dto.setCategoria(a.getCategoriaArticolo());
	        		dto.setStato(a.getStato());
	        		dto.setSottotitolo(a.getSottotitolo());
	        		dto.setTesto(a.getTesto());
	        		dto.setAutore(a.getAutore());
	        		dto.setDataCreazione(a.getData_creazione());
	        		dto.setDataPubblicazione(a.getData_pubblicazione());
	        		dto.setDataModifica(a.getData_modifica());
	        }
	        return dto;
	}
		
		public ArticoloDTO EliminaId(long id) {
			System.err.println("elimato service");
	        Articolo a = aDao.DeleteById(id);
	        ArticoloDTO dto = new ArticoloDTO();
	        if (a != null) {
	            	dto.setId(a.getId());
	        		dto.setTag(a.getTags());
	        		dto.setTitolo(a.getTitolo());
	        		dto.setCategoria(a.getCategoriaArticolo());
	        		dto.setStato(a.getStato());
	        		dto.setSottotitolo(a.getSottotitolo());
	        		dto.setTesto(a.getTesto());
	        		dto.setAutore(a.getAutore());
	        		dto.setDataCreazione(a.getData_creazione());
	        		dto.setDataPubblicazione(a.getData_pubblicazione());
	        		dto.setDataModifica(a.getData_modifica());
	        }
	        return dto;
		}
		
		public ArticoloDTO CercaCategoria(String categoria) {
			System.err.println("elimato service");
	        Articolo a = aDao.findByCategoria(categoria);
	        ArticoloDTO dto = new ArticoloDTO();
	        if (a != null) {
	            	dto.setId(a.getId());
	        		dto.setTag(a.getTags());
	        		dto.setTitolo(a.getTitolo());
	        		dto.setCategoria(a.getCategoriaArticolo());
	        		dto.setStato(a.getStato());
	        		dto.setSottotitolo(a.getSottotitolo());
	        		dto.setTesto(a.getTesto());
	        		dto.setAutore(a.getAutore());
	        		dto.setDataCreazione(a.getData_creazione());
	        		dto.setDataPubblicazione(a.getData_pubblicazione());
	        		dto.setDataModifica(a.getData_modifica());
	        }
	        return dto;
		}
	
}
