package br.ufg.si.poo.consorcios.telas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public abstract class AbstractTelaApp extends Application {

	protected GridPane grid;

	@Override
	public void start(Stage primaryStage) throws Exception {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		montarTela(primaryStage);

		// Criando a cena para executar
		Scene scene = new Scene(grid, 600, 500);

		primaryStage.setTitle(setTituloTela());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	protected abstract String setTituloTela() ;

	protected abstract void montarTela(Stage primaryStage);

}
