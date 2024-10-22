package br.com.adsts.util;

/**
 * Exceção: idade de cliente não aceita.
 * @author Sandro
 */
public class IdadeInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public static String MSG_IDADE_INVALIDA = "A idade do cliente deve ser de 18 até 65 anos.";
	
	public IdadeInvalidaException(String msg) {
		super(msg);
	}
}
