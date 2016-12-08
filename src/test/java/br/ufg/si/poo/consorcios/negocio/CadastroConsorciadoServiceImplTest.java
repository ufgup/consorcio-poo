package br.ufg.si.poo.consorcios.negocio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.negocio.exceptions.ConsorciadoInvalidoException;
import br.ufg.si.poo.consorcios.negocio.impl.CadastroConsorciadoServiceImpl;
import br.ufg.si.poo.consorcios.repositorio.ConsorciadoRepositorio;

public class CadastroConsorciadoServiceImplTest {

	@Mock private ConsorciadoRepositorio repositorioMock;

	// Inicia uma Rule. Uma rule é uma regra verificada ao final da execução de cada
	// teste, verificando se uma exceção foi lançada ou não.
	// Inicialmente é configurado para não experar nenhuma exceção
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// SUT - Stub under test
	// Interface que possui as interfaces públicas a serem testadas
	private CadastroConsorciadoService sut;

	private Consorciado cons;

	@Before
	public void init() throws Exception {
		// Inicia os Mocks das classes que não precisam de execução de lógica para esse teste
		MockitoAnnotations.initMocks(this);

		// Instância a implementação de CadastroConsorciadoService
		sut = new CadastroConsorciadoServiceImpl(repositorioMock);

		cons = new Consorciado();
		cons.setNome("Jéssica Millene");
		cons.setEmail("jessica@email.com");
		cons.setCpf("34775164198");
	}

	@Test
	public void deve_possibilitar_cadastrar_novo_consorciado_com_todos_os_dados_validos() throws Exception {
		// Executando método
		sut.cadastrarNovo(cons);

		// Verifica se, na execução da lógica de CadastroConsorciadoServiceImpl
		// o método save de ConsorciadoRepositorio será chamado.
		// Como ConsorciadoRepositorio é um mock, nenhuma lógica será efetivamente executada.
		verify(repositorioMock).save(cons);
	}

	@Test
	public void nao_deve_persistir_consorciado_caso_nao_tenha_nome_informado() throws Exception {
		// Preparando o teste. Setando null no nome do consorciado
		cons.setNome(null);

		// Configurando exceção esperada
		expectedException.expect(ConsorciadoInvalidoException.class); // Exception esperada na execução
		expectedException.expectMessage("Consorciado sem nome. Informe um nome válido"); // Mensagem experada na exception

		// Execução da funcionalidade
		sut.cadastrarNovo(cons);
	}

	@Test
	public void nao_deve_persistir_consorciado_caso_nome_esteja_vazio() throws Exception {
		// Preparando o teste. Setando nome do consorciado vazio
		cons.setNome("");

		// Configurando exceção esperada
		expectedException.expect(ConsorciadoInvalidoException.class); // Exception esperada na execução
		expectedException.expectMessage("Consorciado sem nome. Informe um nome válido"); // Mensagem experada na exception

		// Execução da funcionalidade
		sut.cadastrarNovo(cons);

	}

	@Test
	public void nao_deve_persistir_consorciado_com_email_nulo() throws Exception {
		// Preparando o teste. Setando null no email do consorciado
		cons.setEmail(null);

		// Configurando exceção esperada
		expectedException.expect(ConsorciadoInvalidoException.class); // Exception esperada na execução
		expectedException.expectMessage("Consorciado sem email. Informe um email válido"); // Mensagem experada na exception

		// Executando a funcionalidade
		sut.cadastrarNovo(cons);
	}

	@Test
	public void nao_deve_persistir_consorciado_com_email_vazio() throws Exception {
		// Preparando o teste. Setando vazio no campo de email
		cons.setEmail("");

		// Configurando exceção esperada
		expectedException.expect(ConsorciadoInvalidoException.class); // Exception esperada na execução
		expectedException.expectMessage("Consorciado sem email. Informe um email válido"); // Mensagem experada na exception

		// Executando a funcionalidade
		sut.cadastrarNovo(cons);
	}

	@Test
	public void nao_deve_persistir_consorciado_com_cpf_nulo() throws Exception {
		// Preparando o teste. Setando null no CPF do consorciado
		cons.setCpf(null);

		// Configurando exceção esperada
		expectedException.expect(ConsorciadoInvalidoException.class); // Exception esperada na execução
		expectedException.expectMessage("Consorciado sem CPF. Informe um CPF válido"); // Mensagem experada na exception

		// Executando a funcionalidade
		sut.cadastrarNovo(cons);
	}

	@Test
	public void nao_deve_persistir_consorciado_com_cpf_vazio() throws Exception {
		// Preparando o teste. Setando vazio no CPF
		cons.setCpf("");

		// Configurando exceção esperada
		expectedException.expect(ConsorciadoInvalidoException.class); // Exception esperada na execução
		expectedException.expectMessage("Consorciado sem CPF. Informe um CPF válido"); // Mensagem experada na exception

		// Executando a funcionalidade
		sut.cadastrarNovo(cons);
	}

}
