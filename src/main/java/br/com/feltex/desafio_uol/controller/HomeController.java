package br.com.feltex.desafio_uol.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import br.com.feltex.desafio_uol.service.JogadorService;


@RestController
@AllArgsConstructor
public class HomeController {
	
	private JogadorService jogadorService;
	
	@RequestMapping("/")
	//@GetMapping("/")
	public ModelAndView jogadores() {
		final var modelAndView = new ModelAndView();
		modelAndView.setViewName("jogador-lista.html");
		final var jogadores = jogadorService.buscarTodos();
		modelAndView.getModel().put("jogadores", jogadores.isEmpty()? null : jogadores);
		return modelAndView;
	}
	
}
