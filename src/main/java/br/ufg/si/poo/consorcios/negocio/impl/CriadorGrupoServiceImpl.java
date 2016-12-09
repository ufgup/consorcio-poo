package br.ufg.si.poo.consorcios.negocio.impl;

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

		repositorio.save(grupo);
	}

	private void validaDadosDoGrupo(Grupo grupo) throws GrupoInvalidoException {
		if(grupo.getResponsavel() == null) {
			throw new GrupoInvalidoException("Grupo sem consorciado responsável. Atribua um consorciado responsável.");
		}

		if(grupo.getMensalidadeInicial() == null) {
			throw new GrupoInvalidoException("Grupo sem mensalidade inicial. Atribua um valor para mensalidade inicial.");
		}
	}

}
