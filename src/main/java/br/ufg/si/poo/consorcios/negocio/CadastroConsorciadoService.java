package br.ufg.si.poo.consorcios.negocio;

import br.ufg.si.poo.consorcios.modelo.Consorciado;

/**
 * Interface responsável por definir serviço de cadastro de consorciado.
 *
 */
public interface CadastroConsorciadoService {

	/**
	 * Método responsável por cadastrar novo consorciado;
	 *
	 * @param cons {@link Consorciado} a ser cadastrado
	 */
	void cadastrarNovo(Consorciado cons);

}
