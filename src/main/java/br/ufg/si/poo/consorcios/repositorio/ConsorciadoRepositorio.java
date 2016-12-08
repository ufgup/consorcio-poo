package br.ufg.si.poo.consorcios.repositorio;

import br.ufg.si.poo.consorcios.modelo.Consorciado;

/**
 * Interface responsável por disponibilizar serviços de repositório para Consorciados.
 * @author bruno
 *
 */
public interface ConsorciadoRepositorio {

	/**
	 * Persiste o {@link Consorciado} recebido no parâmetro
	 *
	 * @param cons {@link Consorciado} a ser persistido
	 */
	void save(Consorciado cons);

}
