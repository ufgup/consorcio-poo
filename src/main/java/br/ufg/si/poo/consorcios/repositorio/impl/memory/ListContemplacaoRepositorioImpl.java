package br.ufg.si.poo.consorcios.repositorio.impl.memory;

import java.util.ArrayList;
import java.util.List;

import br.ufg.si.poo.consorcios.modelo.Contemplacao;
import br.ufg.si.poo.consorcios.repositorio.ContemplacaoRepositorio;

public class ListContemplacaoRepositorioImpl implements ContemplacaoRepositorio {

	private static ListContemplacaoRepositorioImpl instance;

	private List<Contemplacao> contemplacoes;

	private ListContemplacaoRepositorioImpl() {
		contemplacoes = new ArrayList<>();
	}

	public static ListContemplacaoRepositorioImpl getInstanceOf() {
		if(instance == null) {
			instance = new ListContemplacaoRepositorioImpl();
		}
		return instance;
	}

	@Override
	public void save(Contemplacao contemplacao) {
		contemplacoes.add(contemplacao);
	}

}
