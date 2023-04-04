package br.com.felipefreitas.cursoalura.stickers.services;
import java.util.List;

import br.com.felipefreitas.cursoalura.stickers.domain.Conteudo;

public interface ExtratorDeConteudo {

	public List<Conteudo> extraiConteudos(String json);
	
}
