package br.ufg.si.poo.consorcios.negocio.impl;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.negocio.CadastroConsorciadoService;
import br.ufg.si.poo.consorcios.negocio.exceptions.ConsorciadoInvalidoException;
import br.ufg.si.poo.consorcios.negocio.exceptions.NegocioException;
import br.ufg.si.poo.consorcios.repositorio.ConsorciadoRepositorio;

/**
 * Classe de serviços responsável por manter a lógica de Cadastro de Consorciados
 *
 */
public class CadastroConsorciadoServiceImpl implements CadastroConsorciadoService {

	private ConsorciadoRepositorio repositorio;

	/**
	 * Construtor padrão da classe {@link CadastroConsorciadoService}.
	 *
	 * Recebe todas as dependências necessárias para a execução do funcionamento dessa classe.
	 *
	 * @param repositorio Instância de {@link ConsorciadoRepositorio} que oferece serviços de persistências.
	 */
	public CadastroConsorciadoServiceImpl(ConsorciadoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void cadastrarNovo(Consorciado cons) throws NegocioException {

		if(cons.getNome() == null
				|| "".equals(cons.getNome())) {
			throw new ConsorciadoInvalidoException("Consorciado sem nome. Informe um nome válido");
		}

		repositorio.save(cons);
	}

}
