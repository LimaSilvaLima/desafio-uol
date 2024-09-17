package br.com.feltex.desafio_uol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.feltex.desafio_uol.modelo.JogadorRequest;
import br.com.feltex.desafio_uol.service.JogadorService;
import jakarta.persistence.metamodel.Bindable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;





import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Controller
@AllArgsConstructor
public class JogadorController {
	
	private JogadorService service;
	
	@PostMapping("/salvarJogador")
	public String salvar(@Valid JogadorRequest jogadorRequest , BindingResult bindResult, Model model) {
		
		if (bindResult.hasErrors()) {
			return "jogador-form";
		}
		
		service.salvar(jogadorRequest);
		return "redirect:/";
	}
	
	@GetMapping
	public String mostrarJogadorForm(JogadorRequest jogadorRequest) {
		return "jogador-form";
		//return "jogador-lista";
		
	}
	
}