package br.ufg.si.poo.consorcios.negocio.exceptions;

/**
 * Classe de exceção de Consorciado Inválido
 *
 */
public class ConsorciadoInvalidoException extends NegocioException{

	/**
	 *
	 */
	private static final long serialVersionUID = 2926635891742997161L;

	/**
	 * Construtor padrão de {@link ConsorciadoInvalidoException}.
	 * @param message contem a mensagem de causa da exceção.
	 */
	public ConsorciadoInvalidoException(String message) {
		super(message);
	}
}
