package com.fintrack.model;

import java.time.LocalDate;

public class Entrada extends Transacao {



    public Entrada(int id, String descricao, double valor, LocalDate dataTransacao) {
        super(id, descricao, valor, dataTransacao);
    }

    public Entrada(String descricao, double valor) {
        super(descricao, valor);
    }

    @Override
    public double getImpactoSaldo() {
        return getValor();
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Tipo: Entrada");
    }


}
