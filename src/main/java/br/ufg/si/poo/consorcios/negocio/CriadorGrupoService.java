package br.ufg.si.poo.consorcios.negocio;

import java.util.List;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
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

	/**
	 * Adiciona um novo consorciado à lista de participantes de um grupo em formação
	 *
	 * @param grupo em formação que deverá ter o consorciado adicionado aos participantes
	 * @param novo consorciado que participara daquele grupo
	 */
	void adicionarParticipante(Grupo grupo, Consorciado novo);

	/**
	 * Adiciona vários consorciados à lista de participantes de um grupo em formação
	 *
	 * @param grupo em formação que deverá ter os consorciados adicionados aos participantes
	 * @param novos consorciados que participarão desse grupo
	 */
	void adicionarParticipantes(Grupo grupo, List<Consorciado> novos);

}
