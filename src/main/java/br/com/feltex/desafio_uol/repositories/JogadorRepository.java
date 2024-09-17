package br.com.feltex.desafio_uol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.feltex.desafio_uol.modelo.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}
