package main.java.com.fintrack.model;

import java.time.LocalDate;

public abstract class Transacao {
    private static int proximoId = 1;
    private int id;
    private String descricao;
    private double valor;
    private LocalDate dataTransacao;

    public Transacao(String descricao, double valor) {
        this.id = proximoId++;
        this.descricao = descricao;
        this.valor = valor;
        this.dataTransacao = LocalDate.now();
    }

    public abstract double getImpactoSaldo();

    public void mostrarDados() {
        System.out.println("ID: " + id);
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Data: " + dataTransacao);
    }

    public static int getProximoId() {
        return proximoId;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

}
