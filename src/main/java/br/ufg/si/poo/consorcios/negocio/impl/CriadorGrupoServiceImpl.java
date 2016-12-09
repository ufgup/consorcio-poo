package br.ufg.si.poo.consorcios.negocio.impl;

import br.ufg.si.poo.consorcios.modelo.Grupo;
import br.ufg.si.poo.consorcios.negocio.CriadorGrupoService;
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
	public void criarNovo(Grupo grupo) {
		repositorio.save(grupo);
	}

}
