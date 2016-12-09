package br.ufg.si.poo.consorcios.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.modelo.Grupo;
import br.ufg.si.poo.consorcios.negocio.exceptions.GrupoInvalidoException;
import br.ufg.si.poo.consorcios.negocio.impl.CriadorGrupoServiceImpl;
import br.ufg.si.poo.consorcios.repositorio.ContemplacaoRepositorio;
import br.ufg.si.poo.consorcios.repositorio.GrupoRepositorio;

public class CriadorGrupoServiceImplTest {

	@Mock private GrupoRepositorio repositorioMock;
	@Mock private ContemplacaoRepositorio contemplacaoRepositorioMock;

	// Inicia uma Rule. Uma rule é uma regra verificada ao final da execução de cada
	// teste, verificando se uma exceção foi lançada ou não.
	// Inicialmente é configurado para não experar nenhuma exceção
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// SUT - Stub Under Test - Interface que terá funcionalidade testada
	private CriadorGrupoService sut;

	private Consorciado cons;
	private Grupo grupo;

	@Before
	public void init() throws Exception {
		// Inicializa os mocks.
		MockitoAnnotations.initMocks(this);

		// Cria a instancia de CriadorGrupoService para testes injetando as dependências necessárias
		sut = new CriadorGrupoServiceImpl(repositorioMock, contemplacaoRepositorioMock);

		// Criando entidades de modelo para serem usadas no teste
		// Criando o usuário responsável pelo Grupo
		cons = new Consorciado();
		cons.setNome("Jéssica Millene");
		cons.setEmail("jessica@email.com");
		cons.setCpf("34775164198");

		// Preparando o grupo com todos dados validos para ser criado;
		grupo = new Grupo();
		grupo.setResponsavel(cons);
		grupo.setMensalidadeInicial(200.0);
		grupo.setIncrementoMensal(4.0);
		grupo.setDiaPagamentoMensalidade(10);
		grupo.setDiaPagamentoContemplacao(15);
	}


	@Test
	public void deve_ser_possivel_criar_um_grupo_com_dados_validos() throws Exception {
		// Executando a funcionalidade
		sut.criarNovo(grupo);

		// Verificando se vai chamar o método de salvar depois de fazer todas as validações
		verify(repositorioMock).save(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_sem_consorciado_responsavel_atribuido() throws Exception {
		// Preparando o teste
		// Preparando o grupo sem atribuir consorciado responsavel
		grupo.setResponsavel(null);

		// Configurando exceção esperada na execução do teste
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo sem consorciado responsável. Atribua um consorciado responsável.");

		// Executando funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_sem_definir_mensalidade_inicial() throws Exception {
		// Preparando o teste
		// Retirando mensalidade inicial do grupo
		grupo.setMensalidadeInicial(null);

		// Configurando exceção esperada na execução do teste
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo sem mensalidade inicial. Atribua um valor para mensalidade inicial.");

		// Executando funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_com_mensalidade_inicial_zerada() throws Exception {
		// Preparando o testes
		// Setando 0 na mensalidade inicial do grupo
		grupo.setMensalidadeInicial(0.0);

		// Configurando exceção esperada na execução do teste
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo sem mensalidade inicial. Atribua um valor para mensalidade inicial.");

		// Executando funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_com_mensalidade_inicial_negativa() throws Exception {
		// Preparando o testes
		// Setando valor negativo na mensalidade inicial do grupo
		grupo.setMensalidadeInicial(-10.0);

		// Configurando exceção esperada na execução do teste
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo com mensalidade inicial invalida. Atribua um valor maior que 0 para mensalidade inicial.");

		// Executando funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_sem_incremento_mensal() throws Exception {
		// Preparando o teste
		// Setando null no incremento mensal
		grupo.setIncrementoMensal(null);

		// Configurando a exceção esperada
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo sem incremento mensal. Atribua um valor para incremento mensal.");

		// Executando funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_com_incremento_mensal_negativo() throws Exception {
		// Preparando o testes
		// Setando valor negativo para o incremento mensal
		grupo.setIncrementoMensal(-1.0);

		// Configurando a exceção esperada
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo com incremento mensal negativo. Atribua um valor positivo para incremento mensal.");

		// Executando funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_com_dia_da_contemplacao_com_valor_menor_que_1() throws Exception {
		// Preparando testes
		// Setando dia inválido para contemplação
		grupo.setDiaPagamentoContemplacao(0);

		// Configurando a exceção esperada
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo com dia para contemplação inválido. Atribua um dia entre 1 e 28");

		// Executando a funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_com_dia_da_contemplacao_com_valor_maior_que_28() throws Exception {
		// Preparando testes
		// Setando dia inválido para contemplação
		grupo.setDiaPagamentoContemplacao(29);

		// Configurando a exceção esperada
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo com dia para contemplação inválido. Atribua um dia entre 1 e 28");

		// Executando a funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_com_dia_da_pagamento_mensalidade_com_valor_menor_que_1() throws Exception {
		// Preparando testes
		// Setando dia inválido para contemplação
		grupo.setDiaPagamentoMensalidade(0);

		// Configurando a exceção esperada
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo com dia para pagamento da mensalidade inválido. Atribua um dia entre 1 e 28");

		// Executando a funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_com_dia_da_pagamento_mensalidade_com_valor_maior_que_28() throws Exception {
		// Preparando testes
		// Setando dia inválido para contemplação
		grupo.setDiaPagamentoMensalidade(29);

		// Configurando a exceção esperada
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Grupo com dia para pagamento da mensalidade inválido. Atribua um dia entre 1 e 28");

		// Executando a funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void nao_deve_salvar_grupo_caso_dia_da_contemplacao_for_menor_que_dia_pagamento_mensalidade() throws Exception {
		// Preparando testes.
		// Configurando datas inconsistente
		grupo.setDiaPagamentoContemplacao(5);
		grupo.setDiaPagamentoMensalidade(15);

		// Configurando excecao esperada
		expectedException.expect(GrupoInvalidoException.class);
		expectedException.expectMessage("Dia para contemplação menor que dia para pagamento da mensalidade. Favor, atribuir dia da contemplação maior que dia do pagamento da mensalidade");

		// Executando funcionalidade
		sut.criarNovo(grupo);
	}

	@Test
	public void ao_criar_um_grupo_o_responsavel_deve_ser_atribuido_como_participante() throws Exception {
		// Executando funcionalidade
		sut.criarNovo(grupo);

		// Verifica se o responsável está na lista de Participantes.
		assertTrue(grupo.getParticipantes().contains(cons));
	}

	@Test
	public void deve_ser_possivel_inserir_novo_participante_em_grupo_aberto_existente() throws Exception {
		// Criando novos participante
		Consorciado novo = new Consorciado();
		novo.setNome("Leticia");
		novo.setEmail("leticia@email.com");
		novo.setCpf("83432536801");

		// Executando funcionalidade
		sut.adicionarParticipante(grupo, novo);

		// Validando se consorciado foi adicionado ao grupo
		assertTrue(grupo.getParticipantes().contains(novo));

		// Verificando se consorcio será salvo
		verify(repositorioMock).save(grupo);
	}

	@Test
	public void deve_ser_possivel_inserir_varios_participantes_em_grupo_aberto_existente() throws Exception {
		// Criando novos participante
		Consorciado novo = new Consorciado();
		novo.setNome("Leticia");
		novo.setEmail("leticia@email.com");
		novo.setCpf("83432536801");

		Consorciado novo2 = new Consorciado();
		novo2.setNome("Amanda");
		novo2.setEmail("amanda@email.com");
		novo2.setCpf("95815455814");

		Consorciado novo3 = new Consorciado();
		novo3.setNome("Fernanda");
		novo3.setEmail("fernanda@email.com");
		novo3.setCpf("14656216879");

		// executando funcionalidades
		sut.adicionarParticipantes(grupo, Arrays.asList(novo, novo2, novo3));

		// Validando se consorciados foram adicionados à lista de participantes
		assertTrue(grupo.getParticipantes().contains(novo));
		assertTrue(grupo.getParticipantes().contains(novo2));
		assertTrue(grupo.getParticipantes().contains(novo3));

		// Verificando se o grupo será salvo
		verify(repositorioMock).save(grupo);
	}

	@Test
	public void deve_ser_possivel_finalizar_criacao_grupo_gerando_as_contemplacoes() throws Exception {
		// Criando participantes
		Consorciado novo = new Consorciado();
		novo.setNome("Leticia");
		novo.setEmail("leticia@email.com");
		novo.setCpf("83432536801");

		Consorciado novo2 = new Consorciado();
		novo2.setNome("Amanda");
		novo2.setEmail("amanda@email.com");
		novo2.setCpf("95815455814");

		Consorciado novo3 = new Consorciado();
		novo3.setNome("Fernanda");
		novo3.setEmail("fernanda@email.com");
		novo3.setCpf("14656216879");

		// Adicionando participantes ao grupo
		grupo.getParticipantes().add(cons);
		grupo.getParticipantes().add(novo);
		grupo.getParticipantes().add(novo2);
		grupo.getParticipantes().add(novo3);

		// Executando funcionalidade
		sut.iniciar(grupo);

		// Verificando se contemplacoes criadas foram salvas
		verify(contemplacaoRepositorioMock).save(grupo.getContemplacoes().get(0));
		verify(contemplacaoRepositorioMock).save(grupo.getContemplacoes().get(1));
		verify(contemplacaoRepositorioMock).save(grupo.getContemplacoes().get(2));
		verify(contemplacaoRepositorioMock).save(grupo.getContemplacoes().get(3));


		// Verificando criação das contemplações
		assertEquals("Jéssica Millene", grupo.getContemplacoes().get(0).getContemplado().getNome());
		assertEquals(200.0, grupo.getContemplacoes().get(0).getMensalidade(), 0.0001);
		assertEquals(600.0, grupo.getContemplacoes().get(0).getTotalContemplacao(), 0.00001);

		assertEquals("Leticia", grupo.getContemplacoes().get(1).getContemplado().getNome());
		assertEquals(204.0, grupo.getContemplacoes().get(1).getMensalidade(), 0.0001);
		assertEquals(612.0, grupo.getContemplacoes().get(1).getTotalContemplacao(), 0.00001);

		assertEquals("Amanda", grupo.getContemplacoes().get(2).getContemplado().getNome());
		assertEquals(208.0, grupo.getContemplacoes().get(2).getMensalidade(), 0.0001);
		assertEquals(624.0, grupo.getContemplacoes().get(2).getTotalContemplacao(), 0.00001);

		assertEquals("Fernanda", grupo.getContemplacoes().get(3).getContemplado().getNome());
		assertEquals(212.0, grupo.getContemplacoes().get(3).getMensalidade(), 0.0001);
		assertEquals(636.0, grupo.getContemplacoes().get(3).getTotalContemplacao(), 0.00001);
	}
}
