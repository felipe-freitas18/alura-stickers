package br.com.felipefreitas.cursoalura.stickers;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import com.felipefreitas.cursoalura.stickers.enums.API;

import br.com.felipefreitas.cursoalura.stickers.domain.Conteudo;
import br.com.felipefreitas.cursoalura.stickers.resource.ClienteHttp;
import br.com.felipefreitas.cursoalura.stickers.services.ExtratorDeConteudo;
import br.com.felipefreitas.cursoalura.stickers.services.GeradoraDeFigurinhas;

public class App {

	public static void main(String[] args) throws Exception {
		
		API api = API.LOCALHOST;
		
		String url = api.getUrl();
		
		ClienteHttp http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		// exibir e manipular os dados
		ExtratorDeConteudo extrator = api.getExtrator();
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
