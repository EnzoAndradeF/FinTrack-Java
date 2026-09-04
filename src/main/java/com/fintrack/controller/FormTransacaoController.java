package com.fintrack.controller;

import com.fintrack.model.Entrada;
import com.fintrack.model.Saida;
import com.fintrack.model.Transacao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormTransacaoController {

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtValor;

    private Transacao transacaoCriada;
    private boolean salvou = false;

    @FXML
    public void initialize() {
        cbTipo.setItems(FXCollections.observableArrayList("Entrada", "Saída"));
        cbTipo.getSelectionModel().selectFirst();
    }

    @FXML
    private void salvar() {
        try {
            String tipo = cbTipo.getValue();
            String descricao = txtDescricao.getText();
            double valor = Double.parseDouble(txtValor.getText());

            if ("Entrada".equals(tipo)) {
                transacaoCriada = new Entrada(descricao, valor);
            } else {
                transacaoCriada = new Saida(descricao, valor);
            }

            salvou = true;
            fecharJanela();
        } catch (NumberFormatException e) {
            System.out.println("Por favor, informe um valor numérico válido.");
        }
    }

    @FXML
    private void cancelar() {
        fecharJanela();
    }

    private void fecharJanela() {
        Stage stage = (Stage) cbTipo.getScene().getWindow();
        stage.close();
    }

    public Transacao getTransacaoCriada() {
        return transacaoCriada;
    }

    public boolean isSalvou() {
        return salvou;
    }
}
