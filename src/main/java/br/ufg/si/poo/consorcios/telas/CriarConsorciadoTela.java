package br.ufg.si.poo.consorcios.telas;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.negocio.CadastroConsorciadoService;
import br.ufg.si.poo.consorcios.negocio.exceptions.NegocioException;
import br.ufg.si.poo.consorcios.negocio.impl.CadastroConsorciadoServiceImpl;
import br.ufg.si.poo.consorcios.repositorio.impl.memory.ListConsorciadoRepositorioImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class CriarConsorciadoTela extends AbstractTelaApp {


	private Label nomeLabel;
	private TextField nomeText;

	private Label emailLabel;
	private TextField emailText;

	private Label cpfLabel;
	private TextField cpfText;

	private Button btnSalvar;
	private Button btnVoltar;

	@Override
	protected String setTituloTela() {
		return "Criar Consorciado";
	}

	@Override
	protected void montarTela(Stage primaryStage) {
		nomeLabel = new Label();
		nomeLabel.setText("Digite o nome completo:");
		nomeLabel.setAlignment(Pos.CENTER_LEFT);
		grid.add(nomeLabel, 0, 0);

		nomeText = new TextField();
		grid.add(nomeText, 1, 0);

		emailLabel = new Label();
		emailLabel.setText("Digite o email:");
		emailLabel.setAlignment(Pos.CENTER_LEFT);
		grid.add(emailLabel, 0, 1);

		emailText = new TextField();
		grid.add(emailText, 1, 1);

		cpfLabel = new Label();
		cpfLabel.setText("Digite o CPF sem máscara:");
		cpfLabel.setAlignment(Pos.CENTER_LEFT);
		grid.add(cpfLabel, 0, 2);

		cpfText = new TextField();
		grid.add(cpfText, 1, 2);

		btnVoltar = new Button();
		btnVoltar.setText("Voltar");
		btnVoltar.setOnAction(new EventoVoltarPrincipal(primaryStage));
		grid.add(btnVoltar, 0, 3);

		btnSalvar = new Button();
		btnSalvar.setText("Salvar");
		btnSalvar.setOnAction(new EventoSalvarConsorciado());
		grid.add(btnSalvar, 1, 3);
	}


	private class EventoSalvarConsorciado implements EventHandler<ActionEvent>  {
		@Override
		public void handle(ActionEvent event) {
			CadastroConsorciadoService service = new CadastroConsorciadoServiceImpl(ListConsorciadoRepositorioImpl.getInstanceOf());

			Consorciado cons = new Consorciado();
			cons.setNome(nomeText.getText());
			cons.setEmail(emailText.getText());
			cons.setCpf(cpfText.getText());

			try {
				service.cadastrarNovo(cons);

				limparCaixasTextos(nomeText, emailText, cpfText);
			} catch (NegocioException e) {
				System.err.println("Ocorreu um erro ao tentar salvar consorciado: " + e.getMessage());
			}
		}

		private void limparCaixasTextos(TextField nomeText, TextField emailText, TextField cpfText) {
			nomeText.clear();
			emailText.clear();
			cpfText.clear();
		}
	}

	private class EventoVoltarPrincipal implements EventHandler<ActionEvent> {

		private Stage primaryStage;

		public EventoVoltarPrincipal(Stage primaryStage) {
			this.primaryStage = primaryStage;
		}

		@Override
		public void handle(ActionEvent event) {
			ConsorciosApp app = new ConsorciosApp();
			try {
				app.start(primaryStage);
			} catch (Exception e) {
				System.out.println("Deu erro ao tentar voltar para a pagina inicial");
			}
		}

	}

}
