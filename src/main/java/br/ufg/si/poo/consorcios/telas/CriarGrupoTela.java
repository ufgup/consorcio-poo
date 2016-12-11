package br.ufg.si.poo.consorcios.telas;

import br.ufg.si.poo.consorcios.modelo.Consorciado;
import br.ufg.si.poo.consorcios.repositorio.impl.memory.ListConsorciadoRepositorioImpl;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class CriarGrupoTela extends AbstractTelaApp {

	@Override
	protected String setTituloTela() {
		return "Criar grupos";
	}

	@Override
	protected void montarTela(Stage primaryStage) {
		Label responsavelLabel = new Label();
		responsavelLabel.setText("Responsavel");
		grid.add(responsavelLabel, 0, 0);

		ChoiceBox<Consorciado> choiceResponsavel = new ChoiceBox<Consorciado>();
		choiceResponsavel
				.setItems(FXCollections.observableArrayList(ListConsorciadoRepositorioImpl.getInstanceOf().findAll()));
		grid.add(choiceResponsavel, 1, 0);

		Label mensalidadeInicialLabel = new Label();
		mensalidadeInicialLabel.setText("Mensalidade Inicial");
		grid.add(mensalidadeInicialLabel, 0, 1);

		TextField mensalidadeInicialText = new TextField();
		grid.add(mensalidadeInicialText, 1, 1);

		Label incrementoMensalLabel = new Label();
		incrementoMensalLabel.setText("Incremento mensal");
		grid.add(incrementoMensalLabel, 0, 2);

		TextField incrementoMensalText = new TextField();
		grid.add(incrementoMensalText, 1, 2);

		Label diaPagamentoMensalidadeLabel = new Label();
		diaPagamentoMensalidadeLabel.setText("Dia pagamento mensalidade");
		grid.add(diaPagamentoMensalidadeLabel, 0, 3);

		ChoiceBox<Integer> choiceDiaPagamentoMensalidade = new ChoiceBox<Integer>();
		choiceDiaPagamentoMensalidade.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28));
		grid.add(choiceDiaPagamentoMensalidade, 1, 3);

		Label diaPagamentoContemplacaoLabel = new Label();
		diaPagamentoContemplacaoLabel.setText("Dia pagamento contemplação");
		grid.add(diaPagamentoContemplacaoLabel, 0, 4);

		ChoiceBox<Integer> choiceDiaPagamentoContemplacao = new ChoiceBox<Integer>();
		choiceDiaPagamentoContemplacao.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28));
		grid.add(choiceDiaPagamentoContemplacao, 1, 4);

		Button btnSalvar = new Button();
		btnSalvar.setText("Salvar");
		btnSalvar.setOnAction(new EventoSalvarGrupo());
		grid.add(btnSalvar, 1, 5);
	}

	private class EventoSalvarGrupo implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {


		}

	}

}
