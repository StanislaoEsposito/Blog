package it.rdev.blog.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rdev.blog.api.controller.dto.ArticoloDTO;
import it.rdev.blog.api.dao.ArticoloDao;
import it.rdev.blog.api.dao.entity.Articolo;

@Service
public class ArticoloService {
	@Autowired
	private ArticoloDao aDao;
	
	//Con questo metodo ritorniamo la lista di articoli di tipo ArticoloDTO convertita da una lista di tipo Articolo
	public Set<ArticoloDTO> findAll() {
		//riempio la lista di tipo Articolo
		Set<Articolo> lista = aDao.findAll();
		//creo la lista di tipo ArticoloDTO
		Set<ArticoloDTO> listaDto = new HashSet<>();
		//Per ogni articolo della lista di tipo articolo creo un nuovo object di tipo ArticoloDTO e gli setto gli attributi dell'articolo di tipo Articolo
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
		return listaDto;
	}
		
		//Con questo metodo ritono un object di tipo ArticoloDTO convertito da un object di tipo Articolo filtrato tramite l'id
		public ArticoloDTO CercaId(long id){
			//Recupero l'object tramite il metodo findById
	        Articolo a = aDao.findById(id);
	        //creo l'object di tipo ArticoloDTO
	        ArticoloDTO dto = new ArticoloDTO();
	        //setto il valore degli attributi dell' object di tipo ArticoloDTO tramite gli attributi dell'object di tipo Articolo
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
		
		//Con questo metodo ritono un object di tipo ArticoloDTO convertito da un object di tipo Articolo filtrato tramite la categoria
		public ArticoloDTO CercaCategoria(String categoria) {
			//Recupero l'object tramite il metodo findByCategoria
	        Articolo a = aDao.findByCategoria(categoria);
	        //creo l'object di tipo ArticoloDTO
	        ArticoloDTO dto = new ArticoloDTO();
	        //setto il valore degli attributi dell' object di tipo ArticoloDTO tramite gli attributi dell'object di tipo Articolo
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
		
		//Con questo metodo ritono un object di tipo ArticoloDTO convertito da un object di tipo Articolo filtrato tramite il tag
		public ArticoloDTO cercaTag(String tag) {
			//Recupero l'object tramite il metodo findByTag
			Articolo a = aDao.findByTag(tag);
			//creo l'object di tipo ArticoloDTO
			ArticoloDTO dto = new ArticoloDTO();
	        //setto il valore degli attributi dell' object di tipo ArticoloDTO tramite gli attributi dell'object di tipo Articolo
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
		
		//Con questo metodo ritono un object di tipo ArticoloDTO convertito da un object di tipo Articolo filtrato tramite il tag
		public ArticoloDTO cercaAutore(String username) {
			//Recupero l'object tramite il metodo findByAutore
			Articolo a = aDao.findByAutore(username);
			//creo l'object di tipo ArticoloDTO
			ArticoloDTO dto = new ArticoloDTO();
			//setto il valore degli attributi dell' object di tipo ArticoloDTO tramite gli attributi dell'object di tipo Articolo
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
		
		public void insertArticolo(String titolo, String categoria, String stato, String sottotitolo, String testo, String autore) {
			aDao.insertArticolo(titolo, categoria, stato, sottotitolo, testo, autore);
		}
		
		public void deleteArticolo(long id) {
			aDao.deleteArticolo(id);
		}
		
		public void updateArticolo(String titolo, String categoria, String stato, String sottotitolo, String testo, String autore) {
			aDao.updateArticolo(titolo, categoria, stato, sottotitolo, testo, autore);
		}
	
}
