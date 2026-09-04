package com.fintrack.model;

public class Saida extends Transacao {

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
