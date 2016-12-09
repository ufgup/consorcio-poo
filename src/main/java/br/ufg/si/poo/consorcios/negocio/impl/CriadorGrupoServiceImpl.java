package br.ufg.si.poo.consorcios.negocio.impl;

import java.util.Arrays;
import java.util.List;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.modelo.Grupo;
import br.ufg.si.poo.consorcios.negocio.CriadorGrupoService;
import br.ufg.si.poo.consorcios.negocio.exceptions.GrupoInvalidoException;
import br.ufg.si.poo.consorcios.negocio.exceptions.NegocioException;
import br.ufg.si.poo.consorcios.repositorio.GrupoRepositorio;

/**
 * Instância de {@link CriadorGrupoService} que implementa a funcionalidade de criação de grupo;
 *
 */
public class CriadorGrupoServiceImpl implements CriadorGrupoService {

	private GrupoRepositorio repositorio;

	public CriadorGrupoServiceImpl(GrupoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void criarNovo(Grupo grupo) throws NegocioException {
		validaDadosDoGrupo(grupo);

		grupo.getParticipantes().add(grupo.getResponsavel());

		repositorio.save(grupo);
	}

	@Override
	public void adicionarParticipante(Grupo grupo, Consorciado novo) {
		adicionarParticipantes(grupo, Arrays.asList(novo));
	}

	@Override
	public void adicionarParticipantes(Grupo grupo, List<Consorciado> novos) {
		grupo.getParticipantes().addAll(novos);

		repositorio.save(grupo);
	}

	private void validaDadosDoGrupo(Grupo grupo) throws GrupoInvalidoException {
		if(grupo.getResponsavel() == null) {
			throw new GrupoInvalidoException("Grupo sem consorciado responsável. Atribua um consorciado responsável.");
		}

		if(grupo.getMensalidadeInicial() == null
				|| grupo.getMensalidadeInicial() == 0.0) {
			throw new GrupoInvalidoException("Grupo sem mensalidade inicial. Atribua um valor para mensalidade inicial.");
		}

		if(grupo.getMensalidadeInicial() < 0.0) {
			throw new GrupoInvalidoException("Grupo com mensalidade inicial invalida. Atribua um valor maior que 0 para mensalidade inicial.");
		}

		if(grupo.getIncrementoMensal() == null) {
			throw new GrupoInvalidoException("Grupo sem incremento mensal. Atribua um valor para incremento mensal.");
		}

		if(grupo.getIncrementoMensal() < 0.0) {
			throw new GrupoInvalidoException("Grupo com incremento mensal negativo. Atribua um valor positivo para incremento mensal.");
		}

		if(grupo.getDiaPagamentoContemplacao() < 1
				|| grupo.getDiaPagamentoContemplacao() > 28) {
			throw new GrupoInvalidoException("Grupo com dia para contemplação inválido. Atribua um dia entre 1 e 28");
		}

		if(grupo.getDiaPagamentoMensalidade() < 1
				|| grupo.getDiaPagamentoMensalidade() > 28) {
			throw new GrupoInvalidoException("Grupo com dia para pagamento da mensalidade inválido. Atribua um dia entre 1 e 28");
		}

		if(grupo.getDiaPagamentoContemplacao() < grupo.getDiaPagamentoMensalidade()) {
			throw new GrupoInvalidoException("Dia para contemplação menor que dia para pagamento da mensalidade. Favor, atribuir dia da contemplação maior que dia do pagamento da mensalidade");
		}
	}

}
