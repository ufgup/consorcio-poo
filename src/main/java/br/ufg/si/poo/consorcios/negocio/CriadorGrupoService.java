package br.ufg.si.poo.consorcios.negocio;

import br.ufg.si.poo.consorcios.modelo.Grupo;

/**
 * Interface responsável por definir a interface pública para criação de grupo.
 */
public interface CriadorGrupoService {

	/**
	 * Valida o grupo recebido por parâmetro e o cria se estiver ok.
	 *
	 * @param grupo a ser criado;
	 */
	void criarNovo(Grupo grupo);

}
