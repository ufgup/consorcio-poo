package br.ufg.si.poo.consorcios.repositorio;

import br.ufg.si.poo.consorcios.modelo.Contemplacao;

/**
 * Interface que disponibiliza métodos de persistência para a entidade {@link Contemplacao}
 *
 */
public interface ContemplacaoRepositorio {

	/**
	 * Salva uma contemplacao.
	 *
	 * @param contemplacao
	 */
	void save(Contemplacao contemplacao);


}
