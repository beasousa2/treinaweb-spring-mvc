package br.com.springmvc.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.springmvc.domains.Album;
import br.com.springmvc.repositories.AlbumRepositorie;

@Controller
@RequestMapping("/albuns")
public class AlbumController {
	
	@Autowired 
	private AlbumRepositorie repositorie;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listAlbum(Model model){
		List<Album> albuns = repositorie.findAll();
		model.addAttribute("albuns", albuns);
		return "album.listar.tiles";
	}
	
	@RequestMapping(value = "/alterar/(id)", method = RequestMethod.GET)
	public String changeAlbum(@PathVariable("id") Long id, Model model) {
		Optional<Album> albumToBeChanged = repositorie.findById(id);
		if(albumToBeChanged.isPresent()){
			model.addAttribute("album", albumToBeChanged.get());
			return "album.alterar.tiles";
		}
		else {//Se não achar o álbum, volta para listagem
			return "redirect:/albuns/listar";
		}
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public String changeAlbum(@ModelAttribute("album") @Valid Album changeAlbum, BindingResult result) {
		if(result.hasErrors()) {
			return "album.alterar.tiles";
		}
		repositorie.save(changeAlbum);
		return "redirect:/albuns/listar";
	}
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET )
	public String add(Model model) {
		model.addAttribute("album", new Album());
		return "album.adicionar.tiles";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST )
	public String add(@ModelAttribute("album") @Valid Album newAlbum, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "album.adicionar.tiles";
		}
		repositorie.save(newAlbum);
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value = "/excluir/(id)", method = RequestMethod.GET)
	public String deleteALbum(@PathVariable("id") Long id) {
		repositorie.deleteById(id);
		return "redirect:/albuns/listar";
	}
	
}
