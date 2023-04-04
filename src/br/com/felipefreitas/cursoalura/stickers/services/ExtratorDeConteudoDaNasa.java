package br.com.felipefreitas.cursoalura.stickers.services;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.felipefreitas.cursoalura.stickers.domain.Conteudo;
import br.com.felipefreitas.cursoalura.stickers.utils.JsonParser;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

	public List<Conteudo> extraiConteudos(String json){
		
		//extrair são os dados que interessam (titulo, poster, classificação)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);	
		
		return listaDeAtributos.stream().map((atributo) -> new Conteudo(atributo.get("title"), atributo.get("url"))).collect(Collectors.toList());
	}
}
