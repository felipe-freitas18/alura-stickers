package br.com.felipefreitas.cursoalura.stickers.resource.exceptions;

public class ClienteHttpException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ClienteHttpException(String mensagem) {
		super(mensagem);
	}

}
