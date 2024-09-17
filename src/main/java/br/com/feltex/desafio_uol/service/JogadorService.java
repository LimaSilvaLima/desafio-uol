package br.com.feltex.desafio_uol.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.feltex.desafio_uol.modelo.Jogador;
import br.com.feltex.desafio_uol.modelo.JogadorRequest;
import br.com.feltex.desafio_uol.repositories.JogadorRepository;
import lombok.AllArgsConstructor;




@Service
@AllArgsConstructor
public class JogadorService {
	
	private JogadorRepository repository;
	private GrupoService grupoService;
	
	public Jogador salvar(JogadorRequest jogadorRequest) {
		
		final var jogador = new Jogador(jogadorRequest);
		
		var codinome = grupoService.getCodinome(jogadorRequest.grupo());
		
		jogador.setCodinome(codinome);
		return repository.save(jogador);
	}
	
	
	
	public List<Jogador> buscarTodos() {
		return repository.findAll();
	}
		
}
