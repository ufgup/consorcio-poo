package br.ufg.si.poo.consorcios.telas;

import java.util.List;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.modelo.Contemplacao;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class ContemplacoesGrupoTela extends AbstractTelaApp {

	private TableView<Contemplacao> table = new TableView<Contemplacao>();
	private List<Contemplacao> contemplacoesGrupo;

	@Override
	protected String setTituloTela() {
		return "Contemplações do Grupo";
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void montarTela(Stage primaryStage) {
		Label label = new Label("Contemplações");
		label.setFont(new Font("Arial", 20));
		grid.add(label, 0, 0);

		table.setEditable(false);

		TableColumn<Contemplacao, Consorciado> contempladoColumn = new TableColumn<Contemplacao, Consorciado>("Contemplado");
		contempladoColumn.setMinWidth(100);
		contempladoColumn.setCellValueFactory(new PropertyValueFactory<Contemplacao, Consorciado>("contemplado"));

		TableColumn<Contemplacao, Double> mensalidadeColumn = new TableColumn<Contemplacao, Double>("Mensalidade");
		mensalidadeColumn.setMinWidth(50);
		mensalidadeColumn.setCellValueFactory(new PropertyValueFactory<Contemplacao, Double>("mensalidade"));

		TableColumn<Contemplacao, Double> totalContemplacaoColumn = new TableColumn<Contemplacao, Double>("Total Contemplação");
		totalContemplacaoColumn.setMinWidth(70);
		totalContemplacaoColumn.setCellValueFactory(new PropertyValueFactory<Contemplacao, Double>("totalContemplacao"));

		table.setItems(FXCollections.observableArrayList(contemplacoesGrupo));
		table.getColumns().addAll(contempladoColumn, mensalidadeColumn, totalContemplacaoColumn);

		grid.add(table, 0, 1);

	}

	void setContemplacoes(List<Contemplacao> contemplacoesGrupo) {
		this.contemplacoesGrupo = contemplacoesGrupo;
	}

}
