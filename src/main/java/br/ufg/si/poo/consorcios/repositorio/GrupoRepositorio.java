package br.ufg.si.poo.consorcios.repositorio;

import br.ufg.si.poo.consorcios.modelo.Grupo;

/**
 * Interface publica que define os métodos de persistência de grupos.
 *
 */
public interface GrupoRepositorio {

	/**
	 * Persiste um grupo no repositório
	 * @param grupo a ser persistido
	 */
	void save(Grupo grupo);

}
