import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa {

	public List<Conteudo> extraiConteudos(String json){
		
		//extrair s�o os dados que interessam (titulo, poster, classifica��o)
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
