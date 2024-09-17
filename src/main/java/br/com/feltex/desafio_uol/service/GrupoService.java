package br.com.feltex.desafio_uol.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;



import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.feltex.desafio_uol.modelo.Grupo;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.xml.parsers.DocumentBuilderFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.core.env.Environment;





@Service
@Slf4j
@AllArgsConstructor
public class GrupoService {
	
	private List<String> vingadores;
	private List<String> ligaDaJustica;
	private Environment environment;
	private ObjectMapper objectMapper;
	
	
	
	
	@PostConstruct
	private void lerVingadores() {
		
		try {
			var uri = URI.create(Objects.requireNonNull(environment.getProperty("app.vingadores.url")));
			final var jsonMode = objectMapper.readTree(uri.toURL());
			final var listaVingadores = (arrayMode) jsonMode.get("vingaores");
			
			for (jsonMode item = listaVingadores) {
				this.vingadores.add(item.get("codinome").asText());
				
			}
			
			
		} catch (Exception e) {
			log.error("Não foi possível ler o arquivo Liga da Justiça", e);
		}
	}
	
	
	
	@PostConstruct
	private void lerLigaJustica() {
		try {
			
			final var factory = DocumentBuilderFactory.newInstance();
			final var builder = factory.newDocumentBuilder();
			final var document = builder.parse(environment.getProperty("app.liga.da.justica.url"));
			
			NodeList listaCodinomes = document.getElementByTagName("codinome");
			
			for (int i = 0; i < listaCodinomes.getLength(); i++) {
				Element codinomeElement = (Element) listaCodinomes.item(i);
				this.ligaDaJustica.add(listaCodinomes.item(i).getTextContent());
				
			}
			
		} catch (Exception e) {
			log.error("Não foi possível ler o arquivo Liga da Justiça", e);
		}
		
	}
	
	public String getCodinome(Grupo grupo) {
		
		if (Grupo.VINGADORES.equals(grupo)) {
			final var vingadorMembro = this.vingadores.stream().findFirst()
					.orElseThrow(()-> new NoSuchElementException("Não ha mais elementos para a lista" + Grupo.VINGADORES));
					this.vingadores.remove(vingadorMembro);
					
				
		}
		final var ligaJusticaMembro = this.vingadores.stream().findFirst()
				.orElseThrow(()-> new NoSuchElementException("Não ha mais elementos para a lista" + Grupo.VINGADORES));
		
		
		return "vingadores";
	}

}
