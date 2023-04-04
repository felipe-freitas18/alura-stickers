package br.com.felipefreitas.cursoalura.stickers.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.felipefreitas.cursoalura.stickers.domain.Conteudo;
import br.com.felipefreitas.cursoalura.stickers.utils.JsonParser;

public class ExtratorDeConteudoDaNasa {

	public List<Conteudo> extraiConteudos(String json){
		
		//extrair são os dados que interessam (titulo, poster, classificação)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);	
		
		List<Conteudo> conteudos = new ArrayList<>();
		
		//popular a lista de atributos
		for (Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String urlImagem = atributos.get("url");
			conteudos.add(new Conteudo(titulo, urlImagem));
		}
		
		return conteudos;
	}
}
