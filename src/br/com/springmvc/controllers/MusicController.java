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

import br.com.springmvc.domains.Music;
import br.com.springmvc.repositories.AlbumRepository;
import br.com.springmvc.repositories.MusicRepository;

@Controller
@RequestMapping("/musicas")
public class MusicController {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private MusicRepository musicRepository;

	private @Valid Music newMusic;
	
	@RequestMapping(value = "/listarMusica", method = RequestMethod.GET)
	public String listAll(Model model) {
		List<Music> musicList = musicRepository.findAll();
		model.addAttribute("musicas", musicList);
		return "music.listar.tiles";
	}
	
	@RequestMapping(value = "/adicionarMusica", method = RequestMethod.GET)
	public String addMusic(Model model) {
		model.addAttribute("musica", new Music());
		model.addAttribute("albuns", albumRepository.findAll());
		return "music.adicionar.tiles";
	}
	
	@RequestMapping(value = "/adicionarMusica", method = RequestMethod.POST)
	public String addMusic(@ModelAttribute("musica") @Valid Music addMusic, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			model.addAttribute("albuns", albumRepository.findAll());
			return "music.adicionar.tiles";
		}
		musicRepository.save(addMusic);
		return "redirect: /musicas/listarMusica";
	}
	
	@RequestMapping(value = "/alterarMusica/{id}", method = RequestMethod.GET)
	public String changeMusic(@PathVariable("id") Long id,  Model model) {
		Optional<Music> musicToBeChanged = musicRepository.findById(id);
		if(musicToBeChanged.isPresent()) {
			model.addAttribute("musica", musicToBeChanged.get());
			model.addAttribute("albuns", albumRepository.findAll());
			return "music.alterar.tiles";
		} else {
			return "redirect:/musicas/listarMusica";
		}
		
	}
	
	@RequestMapping(value = "/alterarMusica", method = RequestMethod.POST)
	public String changeMusic(@ModelAttribute("musica") @Valid Music changeMusic, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("albuns", albumRepository.findAll());
			return "music.alterar.tiles";
		}
		musicRepository.save(changeMusic);
		return "redirect:/musicas/listarMusica";
	}
	
	@RequestMapping(value = "/excluirMusica/{id}", method = RequestMethod.GET)
	public String deleteMusic(@PathVariable("id") Long id) {
		Optional<Music> music = musicRepository.findById(id);
		music.get().setAlbum(null);
		musicRepository.deleteById(id);
		return "redirect:/musicas/listarMusica";
	}
	
	
	
}
