package br.ufg.si.poo.consorcios.negocio.exceptions;

/**
 * Instância de exceção de negócio para Grupos inválidos.
 * @author bruno
 *
 */
public class GrupoInvalidoException extends NegocioException {

	private static final long serialVersionUID = -9204777231108141968L;

	/**
	 * Construtor padrão que recebe a mensagem da causa da exceção por default.
	 * @param message
	 */
	public GrupoInvalidoException(String message) {
		super(message);
	}
}
