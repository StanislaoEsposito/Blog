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
		
		public ArticoloDTO CercaCategoria(String categoria) {
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
		
		public ArticoloDTO cercaTag(String tag) {
			System.err.println("tag service");
			Articolo a = aDao.findByTag(tag);
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
		
		public ArticoloDTO cercaAutore(String username) {
			System.err.println("autore service");
			Articolo a = aDao.findByAutore(username);
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
		
		public ArticoloDTO insertArticolo(String titolo, String categoria, String stato, String sottotitolo, String testo, String autore) {
			System.err.println("insertArticolo service");
			Articolo a = aDao.insertArticolo(titolo, categoria, stato, sottotitolo, testo, autore);
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
		
		public ArticoloDTO deleteArticolo(long id) {
			System.err.println("deleteArticolo service");
			Articolo a = aDao.deleteArticolo(id);
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
		
		public ArticoloDTO updateArticolo(String titolo, String categoria, String stato, String sottotitolo, String testo, String autore) {
			System.err.println("updateArticolo service");
			Articolo a = aDao.updateArticolo(titolo, categoria, stato, sottotitolo, testo, autore);
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
