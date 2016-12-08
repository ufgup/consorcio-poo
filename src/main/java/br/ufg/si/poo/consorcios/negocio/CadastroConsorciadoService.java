package br.ufg.si.poo.consorcios.negocio;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.negocio.exceptions.NegocioException;

/**
 * Interface responsável por definir serviço de cadastro de consorciado.
 *
 */
public interface CadastroConsorciadoService {

	/**
	 * Método responsável por cadastrar novo consorciado;
	 *
	 * @param cons {@link Consorciado} a ser cadastrado
	 * @throws NegocioException
	 */
	void cadastrarNovo(Consorciado cons) throws NegocioException;

}
