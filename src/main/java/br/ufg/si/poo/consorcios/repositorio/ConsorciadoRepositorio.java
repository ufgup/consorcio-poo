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

	/**
	 * Verifica se existe algum {@link Consorciado} no repositorio com o email recebido por parâmetro
	 *
	 * @param email a ser usado na busca
	 * @return uma instância de {@link Consorciado} com aquele email ou <code>null</code> caso não exista
	 */
	Consorciado findByEmail(String email);

	/**
	 * Busca um consorciado no repositório usando o CPF como parâmetro de busca
	 *
	 * @param cpf a ser procurado no repositório
	 * @return uma instância de {@link Consorciado} com aquele CPF ou <code>null</code> caso não exista
	 */
	Consorciado findByCpf(String cpf);

}
