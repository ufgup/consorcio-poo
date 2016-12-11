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
		criarConsorciadoBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				CriarConsorciadoTela criarConsorciadoTela = new CriarConsorciadoTela();
				try {
					criarConsorciadoTela.start(primaryStage);
				} catch (Exception e) {
					System.err.println("Deu ruim ao abrir tela de criar consorciado");
				}
			}
		});
		grid.add(criarConsorciadoBtn, 0, 0);



		Button criarConsorcioBtn = new Button();
		criarConsorcioBtn.setText("Criar consorcio");
		criarConsorcioBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Mandar para tela de criar consorcio

			}
		});
		grid.add(criarConsorcioBtn, 0, 1);
	}

}
