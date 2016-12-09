package br.ufg.si.poo.consorcios.negocio;

import br.ufg.si.poo.consorcios.modelo.Grupo;
import br.ufg.si.poo.consorcios.negocio.exceptions.NegocioException;

/**
 * Interface responsável por definir a interface pública para criação de grupo.
 */
public interface CriadorGrupoService {

	/**
	 * Valida o grupo recebido por parâmetro e o cria se estiver ok.
	 *
	 * @param grupo a ser criado;
	 * @throws NegocioException caso ocorra alguma exceção na regra de negócio
	 */
	void criarNovo(Grupo grupo) throws NegocioException;

}
