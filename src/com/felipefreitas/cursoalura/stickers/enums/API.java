package com.felipefreitas.cursoalura.stickers.enums;

import br.com.felipefreitas.cursoalura.stickers.services.ExtratorDeConteudo;
import br.com.felipefreitas.cursoalura.stickers.services.ExtratorDeConteudoDaNasa;
import br.com.felipefreitas.cursoalura.stickers.services.ExtratorDeConteudoDoIMDB;

public enum API {
	IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoDoIMDB() ),
	NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json", new ExtratorDeConteudoDaNasa());

	private String url;
	private ExtratorDeConteudo extrator;
	
	API(String url, ExtratorDeConteudo extrator) {
		this.url = url;
		this.extrator = extrator;
	}

	public String getUrl() {
		return url;
	}
	
	public ExtratorDeConteudo getExtrator() {
		return extrator;
	}
}
