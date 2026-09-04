package com.fintrack.controller;

import com.fintrack.model.Entrada;
import com.fintrack.model.Saida;
import com.fintrack.model.Transacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PrimaryController {

    @FXML
    private javafx.scene.control.Label lblSaldo;

    @FXML
    private TableView<Transacao> tabelaTransacoes;

    @FXML
    private TableColumn<Transacao, Integer> colId;

    @FXML
    private TableColumn<Transacao, String> colDescricao;

    @FXML
    private TableColumn<Transacao, Double> colValor;

    @FXML
    private TableColumn<Transacao, LocalDate> colData;

    private ObservableList<Transacao> listaTransacoes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Mapeia os atributos/getters da classe Transacao
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colData.setCellValueFactory(new PropertyValueFactory<>("dataTransacao"));

        tabelaTransacoes.setItems(listaTransacoes);

    }



    private void atualizarSaldo() {
        double saldoTotal = listaTransacoes.stream().mapToDouble(Transacao::getImpactoSaldo).sum();

        lblSaldo.setText(String.format("R$ %.2f", saldoTotal));
    }

    @FXML
    private void abrirFormularioCadastro() {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(
                    getClass().getResource("/com/fintrack/views/form-transacao.fxml"));
            javafx.scene.Parent root = loader.load();

            FormTransacaoController controller = loader.getController();

            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Nova Transação");
            stage.setScene(new javafx.scene.Scene(root));
            stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
            stage.showAndWait();

            if (controller.isSalvou() && controller.getTransacaoCriada() != null) {
                listaTransacoes.add(controller.getTransacaoCriada());
                atualizarSaldo();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void removerTransacao() {
        Transacao selecionada = tabelaTransacoes.getSelectionModel().getSelectedItem();

        if (selecionada != null) {
            listaTransacoes.remove(selecionada);
            atualizarSaldo();
            System.out.println("Transação removida: " + selecionada.getDescricao());
        }
    }
}
