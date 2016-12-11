package br.ufg.si.poo.consorcios.repositorio.impl.memory;

import java.util.ArrayList;
import java.util.List;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.repositorio.ConsorciadoRepositorio;

public class ListConsorciadoRepositorioImpl implements ConsorciadoRepositorio {

	private static ListConsorciadoRepositorioImpl instance;

	private List<Consorciado> consorciados;

	private ListConsorciadoRepositorioImpl() {
		consorciados = new ArrayList<>();
	}

	public static ListConsorciadoRepositorioImpl getInstanceOf() {
		if(instance == null) {
			instance = new ListConsorciadoRepositorioImpl();
		}
		return instance;
	}

	@Override
	public void save(Consorciado cons) {
		consorciados.add(cons);
		System.out.println("Consorciado salvo com sucesso");
	}

	@Override
	public Consorciado findByEmail(String email) {
		for(Consorciado cons : consorciados) {
			if(cons.getEmail().equals(email)) {
				return cons;
			}
		}
		return null;
	}

	@Override
	public Consorciado findByCpf(String cpf) {
		for(Consorciado cons : consorciados) {
			if(cons.getCpf().equals(cpf)) {
				return cons;
			}
		}
		return null;
	}

	@Override
	public List<Consorciado> findAll() {
		return consorciados;
	}

}
