package br.ufg.si.poo.consorcios.telas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class CriarConsorciadoTela extends AbstractTelaApp {

	@Override
	protected String setTituloTela() {
		return "Criar Consorciado";
	}

	@Override
	protected void montarTela(Stage primaryStage) {
		Label nomeLabel = new Label();
		nomeLabel.setText("Digite o nome completo:");
		nomeLabel.setAlignment(Pos.CENTER_LEFT);
		grid.add(nomeLabel, 0, 0);

		TextField nomeText = new TextField();
		grid.add(nomeText, 1, 0);

		Label emailLabel = new Label();
		emailLabel.setText("Digite o email:");
		emailLabel.setAlignment(Pos.CENTER_LEFT);
		grid.add(emailLabel, 0, 1);

		TextField emailText = new TextField();
		grid.add(emailText, 1, 1);

		Label cpfLabel = new Label();
		cpfLabel.setText("Digite o CPF sem máscara:");
		cpfLabel.setAlignment(Pos.CENTER_LEFT);
		grid.add(cpfLabel, 0, 2);

		TextField cpfText = new TextField();
		grid.add(cpfText, 1, 2);

		Button btn = new Button();
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO: Chamar servico de cadastro de consorciados
			}
		});
	}

}
