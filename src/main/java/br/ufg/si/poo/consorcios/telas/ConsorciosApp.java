package br.ufg.si.poo.consorcios.telas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class ConsorciosApp extends AbstractTelaApp {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	protected String setTituloTela() {
		return "Sistema de Consorcios";
	}

	@Override
	protected void montarTela(Stage primaryStage) {
		Button criarConsorciadoBtn = new Button();
		criarConsorciadoBtn.setText("Criar Consorciado");
		criarConsorciadoBtn.setOnAction(new EventoCriarConsorciadosTela(primaryStage));
		grid.add(criarConsorciadoBtn, 0, 0);

		Button criarConsorcioBtn = new Button();
		criarConsorcioBtn.setText("Criar consorcio");
		criarConsorcioBtn.setOnAction(new EventoCriarGruposTela(primaryStage));
		grid.add(criarConsorcioBtn, 0, 1);
	}

	private class EventoCriarGruposTela implements EventHandler<ActionEvent> {

		private Stage primaryStage;

		public EventoCriarGruposTela(Stage primaryStage) {
			this.primaryStage = primaryStage;
		}

		@Override
		public void handle(ActionEvent event) {
			CriarGrupoTela criarGrupoTela = new CriarGrupoTela();
			try {
				criarGrupoTela.start(primaryStage);
			} catch (Exception e) {
				System.err.println("Deu ruim ao abrir tela de criar grupos");
			}

		}

	}

	private class EventoCriarConsorciadosTela implements EventHandler<ActionEvent> {

		private Stage primaryStage;

		public EventoCriarConsorciadosTela(Stage primaryStage) {
			this.primaryStage = primaryStage;
		}

		@Override
		public void handle(ActionEvent event) {
			CriarConsorciadoTela criarConsorciadoTela = new CriarConsorciadoTela();
			try {
				criarConsorciadoTela.start(primaryStage);
			} catch (Exception e) {
				System.err.println("Deu ruim ao abrir tela de criar consorciado");
			}
		}

	}

}
