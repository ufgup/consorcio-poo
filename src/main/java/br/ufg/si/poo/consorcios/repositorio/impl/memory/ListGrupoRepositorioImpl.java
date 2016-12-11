package br.ufg.si.poo.consorcios.repositorio.impl.memory;

import java.util.ArrayList;
import java.util.List;

import br.ufg.si.poo.consorcios.modelo.Grupo;
import br.ufg.si.poo.consorcios.repositorio.GrupoRepositorio;

public class ListGrupoRepositorioImpl implements GrupoRepositorio {

	private static ListGrupoRepositorioImpl instance;

	private List<Grupo> grupos;

	private ListGrupoRepositorioImpl() {
		grupos = new ArrayList<>();
	}

	public static ListGrupoRepositorioImpl getInstanceOf() {
		if(instance == null) {
			instance = new ListGrupoRepositorioImpl();
		}
		return instance;
	}

	@Override
	public void save(Grupo grupo) {
		grupos.add(grupo);
	}

}
