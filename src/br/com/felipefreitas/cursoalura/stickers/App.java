package br.com.felipefreitas.cursoalura.stickers;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import br.com.felipefreitas.cursoalura.stickers.domain.Conteudo;
import br.com.felipefreitas.cursoalura.stickers.resource.ClienteHttp;
import br.com.felipefreitas.cursoalura.stickers.services.ExtratorDeConteudo;
import br.com.felipefreitas.cursoalura.stickers.services.ExtratorDeConteudoDaNasa;
import br.com.felipefreitas.cursoalura.stickers.services.ExtratorDeConteudoDoIMDB;
import br.com.felipefreitas.cursoalura.stickers.services.GeradoraDeFigurinhas;

public class App {

	public static void main(String[] args) throws Exception {
		
		//fazer uma conex�o HTTP e buscar os top 250 filmes
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		String urlNasa = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
		
		ClienteHttp http = new ClienteHttp();
		String json = http.buscaDados(urlNasa);
		
		// exibir e manipular os dados
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
		List<Conteudo> conteudos  = extrator.extraiConteudos(json);
		
		var geradora = new GeradoraDeFigurinhas();

		for( Conteudo conteudo : conteudos ) {
			
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = conteudo.getTitulo().replace(":", "-")  + ".png";
			geradora.cria(inputStream, nomeArquivo);
	
			System.out.println(conteudo.getTitulo());
			System.out.println();
		}
	}
}
