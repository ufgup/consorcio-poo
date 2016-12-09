package br.ufg.si.poo.consorcios.negocio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.modelo.Grupo;
import br.ufg.si.poo.consorcios.negocio.impl.CriadorGrupoServiceImpl;
import br.ufg.si.poo.consorcios.repositorio.GrupoRepositorio;

public class CriadorGrupoServiceImplTest {

	@Mock private GrupoRepositorio repositorioMock;

	private CriadorGrupoService sut;

	@Before
	public void init() throws Exception {
		// Inicializa os mocks.
		MockitoAnnotations.initMocks(this);

		// Cria a instancia de CriadorGrupoService para testes injetando as dependências necessárias
		sut = new CriadorGrupoServiceImpl(repositorioMock);
	}


	@Test
	public void deve_ser_possivel_criar_um_grupo_com_dados_validos() throws Exception {
		// Preparando o teste
		// Criando o usuário responsável pelo Grupo
		Consorciado cons = new Consorciado();
		cons.setNome("Jéssica Millene");
		cons.setEmail("jessica@email.com");
		cons.setCpf("34775164198");

		// Preparando o grupo com todos dados validos para ser criado;
		Grupo grupo = new Grupo();
		grupo.setResponsavel(cons);
		grupo.setMensalidadeInicial(200.0);
		grupo.setIncrementoMensal(4.0);
		grupo.setDiaPagamentoMensalidade(10);
		grupo.setDiaPagamentoContemplacao(15);

		// Executando a funcionalidade
		sut.criarNovo(grupo);

		// Verificando se vai chamar o método de salvar depois de fazer todas as validações
		verify(repositorioMock).save(grupo);
	}
}
