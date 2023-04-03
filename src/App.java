import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		
		//fazer uma conexão HTTP e buscar os top 250 filmes
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		URI endereco = URI.create(url);
		var client =  HttpClient.newHttpClient();
		var request =  HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		//extrair são os dados que interessam (titulo, poster, classificação)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);	
		
		var geradora = new GeradoraDeFigurinhas();
		// exibir e manipular os dados
		for(Map<String,String> filme: listaDeFilmes) {
			InputStream inputStream = new URL(filme.get("image")).openStream();
			String titulo = filme.get("title");
			String nomeArquivo = titulo.replace(":", "-")  + ".png";
			geradora.cria(inputStream, nomeArquivo);
			
			System.out.println("\u001b[35m"+titulo+"\u001b[m");
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
			//adicionar nessa linha posteriormente o sysout contendo os icons de estrelas
			System.out.println();
		}
	}
}
