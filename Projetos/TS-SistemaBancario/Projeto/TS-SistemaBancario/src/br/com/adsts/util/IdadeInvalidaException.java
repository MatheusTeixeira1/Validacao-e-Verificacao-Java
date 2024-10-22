package br.com.adsts.util;

/**
 * Exce��o: idade de cliente n�o aceita.
 * @author Sandro
 */
public class IdadeInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public static String MSG_IDADE_INVALIDA = "A idade do cliente deve ser de 18 at� 65 anos.";
	
	public IdadeInvalidaException(String msg) {
		super(msg);
	}
}
