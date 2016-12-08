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
		validarDadosConsorciado(cons);

		verificaUnicidadeDeConsorciadoPorEmail(cons);

		verificaUnicidadeDeConsorciadoPorCPF(cons);

		repositorio.save(cons);
	}

	private void verificaUnicidadeDeConsorciadoPorCPF(Consorciado cons) throws NegocioException {
		Consorciado doBanco = repositorio.findByCpf(cons.getCpf());
		if(doBanco != null) {
			throw new NegocioException(String.format("Já existe outro usuário cadastrado com o CPF '%s'", cons.getCpf()));
		}
	}

	private void verificaUnicidadeDeConsorciadoPorEmail(Consorciado cons) throws NegocioException {
		Consorciado doBanco = repositorio.findByEmail(cons.getEmail());
		if(doBanco != null) {
			throw new NegocioException(String.format("Já existe outro usuário cadastrado com o email '%s'", cons.getEmail()));
		}
	}

	private void validarDadosConsorciado(Consorciado cons) throws ConsorciadoInvalidoException {
		if(cons.getNome() == null
				|| "".equals(cons.getNome())) {
			throw new ConsorciadoInvalidoException("Consorciado sem nome. Informe um nome válido");
		}

		if(cons.getEmail() == null
				|| "".equals(cons.getEmail())) {
			throw new ConsorciadoInvalidoException("Consorciado sem email. Informe um email válido");
		}

		if(cons.getCpf() == null
				|| "".equals(cons.getCpf())) {
			throw new ConsorciadoInvalidoException("Consorciado sem CPF. Informe um CPF válido");
		}
	}

}
