package br.ufg.si.poo.consorcios.negocio.exceptions;

/**
 * Exceção de negócio genérica da aplicação
 *
 */
public class NegocioException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public NegocioException(String message) {
		super(message);
	}

}
