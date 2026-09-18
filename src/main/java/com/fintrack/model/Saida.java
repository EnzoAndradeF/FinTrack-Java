package com.fintrack.model;

import java.time.LocalDate;

public class Saida extends Transacao {



    public Saida(int id, String descricao, double valor, LocalDate dataTransacao) {
        super(id, descricao, valor, dataTransacao);
    }

    public Saida(String descricao, double valor) {
        super(descricao, valor);
    }

    @Override
    public double getImpactoSaldo() {
        return -getValor();
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Tipo: Saída");
    }


}
