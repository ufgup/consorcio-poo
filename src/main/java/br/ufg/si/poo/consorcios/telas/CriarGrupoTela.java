package br.ufg.si.poo.consorcios.telas;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.modelo.Grupo;
import br.ufg.si.poo.consorcios.negocio.CriadorGrupoService;
import br.ufg.si.poo.consorcios.negocio.exceptions.NegocioException;
import br.ufg.si.poo.consorcios.negocio.impl.CriadorGrupoServiceImpl;
import br.ufg.si.poo.consorcios.repositorio.impl.memory.ListConsorciadoRepositorioImpl;
import br.ufg.si.poo.consorcios.repositorio.impl.memory.ListContemplacaoRepositorioImpl;
import br.ufg.si.poo.consorcios.repositorio.impl.memory.ListGrupoRepositorioImpl;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class CriarGrupoTela extends AbstractTelaApp {

	private Label responsavelLabel;
	private ChoiceBox<Consorciado> choiceResponsavel;
	private Label mensalidadeInicialLabel;
	private TextField mensalidadeInicialText;
	private Label incrementoMensalLabel;
	private TextField incrementoMensalText;
	private Label diaPagamentoMensalidadeLabel;
	private ChoiceBox<Integer> choiceDiaPagamentoMensalidade;
	private Label diaPagamentoContemplacaoLabel;
	private ChoiceBox<Integer> choiceDiaPagamentoContemplacao;
	private Label adicionarParticipanteLabel;
	private ChoiceBox<Consorciado> choiceParticipantes;
	private Button btnAdicionarParticipante;
	private Button btnVoltar;
	private Button btnSalvar;

	private Grupo grupo = new Grupo();

	@Override
	protected String setTituloTela() {
		return "Criar grupos";
	}

	@Override
	protected void montarTela(Stage primaryStage) {
		responsavelLabel = new Label();
		responsavelLabel.setText("Responsavel");
		grid.add(responsavelLabel, 0, 0);

		choiceResponsavel = new ChoiceBox<Consorciado>();
		choiceResponsavel
				.setItems(FXCollections.observableArrayList(ListConsorciadoRepositorioImpl.getInstanceOf().findAll()));
		grid.add(choiceResponsavel, 1, 0);

		mensalidadeInicialLabel = new Label();
		mensalidadeInicialLabel.setText("Mensalidade Inicial");
		grid.add(mensalidadeInicialLabel, 0, 1);

		mensalidadeInicialText = new TextField();
		grid.add(mensalidadeInicialText, 1, 1);

		incrementoMensalLabel = new Label();
		incrementoMensalLabel.setText("Incremento mensal");
		grid.add(incrementoMensalLabel, 0, 2);

		incrementoMensalText = new TextField();
		grid.add(incrementoMensalText, 1, 2);

		diaPagamentoMensalidadeLabel = new Label();
		diaPagamentoMensalidadeLabel.setText("Dia pagamento mensalidade");
		grid.add(diaPagamentoMensalidadeLabel, 0, 3);

		choiceDiaPagamentoMensalidade = new ChoiceBox<Integer>();
		choiceDiaPagamentoMensalidade.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28));
		grid.add(choiceDiaPagamentoMensalidade, 1, 3);

		diaPagamentoContemplacaoLabel = new Label();
		diaPagamentoContemplacaoLabel.setText("Dia pagamento contemplação");
		grid.add(diaPagamentoContemplacaoLabel, 0, 4);

		choiceDiaPagamentoContemplacao = new ChoiceBox<Integer>();
		choiceDiaPagamentoContemplacao.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28));
		grid.add(choiceDiaPagamentoContemplacao, 1, 4);

		adicionarParticipanteLabel = new Label();
		adicionarParticipanteLabel.setText("Adicionar Participante");
		grid.add(adicionarParticipanteLabel, 0, 5);

		choiceParticipantes = new ChoiceBox<Consorciado>();
		choiceParticipantes
				.setItems(FXCollections.observableArrayList(ListConsorciadoRepositorioImpl.getInstanceOf().findAll()));
		grid.add(choiceParticipantes, 1, 5);

		btnAdicionarParticipante = new Button();
		btnAdicionarParticipante.setText("Adicionar");
		btnAdicionarParticipante.setOnAction(new EventoAdicionarParticipante());
		grid.add(btnAdicionarParticipante, 2, 5);

		btnVoltar = new Button();
		btnVoltar.setText("Voltar");
		btnVoltar.setOnAction(new EventoVoltar(primaryStage));
		grid.add(btnVoltar, 0, 6);

		btnSalvar = new Button();
		btnSalvar.setText("Salvar");
		btnSalvar.setOnAction(new EventoSalvarGrupo(primaryStage));
		grid.add(btnSalvar, 1, 6);
	}

	private class EventoSalvarGrupo implements EventHandler<ActionEvent> {

		private Stage primaryStage;

		public EventoSalvarGrupo(Stage primaryStage) {
			this.primaryStage = primaryStage;
		}

		@Override
		public void handle(ActionEvent event) {
			CriadorGrupoService service = new CriadorGrupoServiceImpl(ListGrupoRepositorioImpl.getInstanceOf(), ListContemplacaoRepositorioImpl.getInstanceOf());

			grupo.setResponsavel(choiceResponsavel.getSelectionModel().getSelectedItem());
			grupo.setMensalidadeInicial(new Double(mensalidadeInicialText.getText()));
			grupo.setIncrementoMensal(new Double(incrementoMensalText.getText()));
			grupo.setDiaPagamentoMensalidade(new Integer(choiceDiaPagamentoMensalidade.getSelectionModel().getSelectedItem()));
			grupo.setDiaPagamentoContemplacao(new Integer(choiceDiaPagamentoContemplacao.getSelectionModel().getSelectedItem()));

			try {
				service.criarNovo(grupo);
				service.iniciar(grupo);

				System.out.println("Grupo criado com sucesso");

				System.out.println("Total de contemplações desse grupo: " + grupo.getContemplacoes().size());

				ContemplacoesGrupoTela contemplacoesTela = new ContemplacoesGrupoTela();
				contemplacoesTela.setContemplacoes(grupo.getContemplacoes());
				contemplacoesTela.start(primaryStage);

			} catch (NegocioException e) {
				System.err.println("Deu erro na hora de criar o grupo: " + e.getMessage());
			} catch (Exception e) {
				System.err.println("Deu erro na hora de mostrar a tela de contemplacoes: " + e.getMessage());
			}
		}

	}

	private class EventoVoltar implements EventHandler<ActionEvent> {

		private Stage primaryStage;

		public EventoVoltar(Stage primaryStage) {
			this.primaryStage = primaryStage;
		}

		@Override
		public void handle(ActionEvent event) {
			ConsorciosApp app = new ConsorciosApp();
			try {
				app.start(primaryStage);
			} catch (Exception e) {
				System.err.println("Deu ruim ao voltar para página inicial");
			}
		}

	}

	private class EventoAdicionarParticipante implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			Consorciado selecionado = choiceParticipantes.getSelectionModel().getSelectedItem();
			if(selecionado != null) {
				grupo.getParticipantes().add(selecionado);
				System.out.println("Participante adicionado com sucesso: " + selecionado);
			}
			choiceParticipantes.getSelectionModel().clearSelection();
		}

	}

}
