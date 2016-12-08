package br.ufg.si.poo.consorcios.negocio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.negocio.impl.CadastroConsorciadoServiceImpl;
import br.ufg.si.poo.consorcios.repositorio.ConsorciadoRepositorio;

public class CadastroConsorciadoServiceImplTest {

	@Mock private ConsorciadoRepositorio repositorioMock;

	private CadastroConsorciadoService sut;

	@Before
	public void init() throws Exception {
		// Inicia os Mocks das classes que não precisam de execução de lógica para esse teste
		MockitoAnnotations.initMocks(this);

		// Instância a implementação de CadastroConsorciadoService
		sut = new CadastroConsorciadoServiceImpl(repositorioMock);
	}

	@Test
	public void deve_possibilitar_cadastrar_novo_consorciado() throws Exception {
		// Preparando o teste. Criando um consorciado para submeter.
		Consorciado cons = new Consorciado();
		cons.setNome("Jéssica Millene");
		cons.setEmail("jessica@email.com");
		cons.setCpf("34775164198");

		// Executando método
		sut.cadastrarNovo(cons);

		// Verifica se, na execução da lógica de CadastroConsorciadoServiceImpl
		// o método save de ConsorciadoRepositorio será chamado.
		// Como ConsorciadoRepositorio é um mock, nenhuma lógica será efetivamente executada.
		verify(repositorioMock).save(cons);
	}

}
