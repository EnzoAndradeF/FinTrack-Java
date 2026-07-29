package main.java.com.fintrack.service;

import main.java.com.fintrack.model.Transacao;
import main.java.com.fintrack.exception.TransacaoNaoEncontradaException;
import java.util.ArrayList;

public class GerenciadorFinanceiro {

    private ArrayList<Transacao> transacoes;

    public GerenciadorFinanceiro() {
        transacoes = new ArrayList<>();
    }
    
    public void cadastrarTransacao(Transacao transacao){
        transacoes.add(transacao);
        System.out.println("Transação cadastrada com sucesso!");
    }

    public void listarTransacoes(){
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação cadastrada até o momento.");
            return;
        }
        for (Transacao transacao : transacoes) {
            transacao.mostrarDados();
            System.out.println("===============");
        }
    }

    public void removerTransacao(int idRemovido){
        boolean encontrou = false;

        for (int i = 0; i < transacoes.size(); i++) {
            Transacao transacao = transacoes.get(i);
            
            if (idRemovido == transacao.getId()) {
                transacoes.remove(i);
                encontrou = true;
                System.out.println("Transação Id: " + idRemovido + " removida com sucesso");
                break;
            }
        }
        
        if (!encontrou) {
            throw new TransacaoNaoEncontradaException("Não foi possível remover: O ID " + idRemovido + " não existe no sistema.");
        }
    }

    public double calcularSaldo(){
        double saldo = 0;
        for (Transacao transacao : transacoes) {
            if (transacao.isEntrada()) {
                saldo = saldo + transacao.getValor();
            } else {
                saldo = saldo - transacao.getValor();
            }
        }
        System.out.println("Saldo da conta: R$ " + saldo);
        return saldo;
    }
}