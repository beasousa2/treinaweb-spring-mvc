package br.com.springmvc.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/message")
	public String message() {
		return "hello";
	}
	
	@RequestMapping("/serverMessage")
	public String serverMessage(Model model){
		model.addAttribute("mensagem", "Olá, TreinaWeb");
		return "serverMessage";
	}
	
	@RequestMapping("/serverMessageV2")
	public ModelAndView serverMessageV2() {
	return new ModelAndView("serverMessage", "mensagem", new Date().toString()); 
	}
	
	@RequestMapping("/receberMensagem/{mensagem}")
	public String receberMensagem(Model model, @PathVariable("mensagem") String msg) {	
		model.addAttribute("mensagem", msg);
		return "serverMessage";
	}
	
	@RequestMapping("/receberMensagemV2")
	public String receberMensagemV2(Model model, @RequestParam(value="mensagem") String msg) {
		model.addAttribute("mensagem", msg);
		return "serverMessage";
	}
}
