package main.java.com.fintrack.service;

import java.util.List;
import main.java.com.fintrack.exception.TransacaoNaoEncontradaException;
import main.java.com.fintrack.model.Transacao;
import main.java.com.fintrack.repository.RepositorioGenerico;

public class GerenciadorFinanceiro {

    private RepositorioGenerico<Transacao> repositorio = new RepositorioGenerico<>();

    public void cadastrarTransacao(Transacao transacao) {
        repositorio.adicionar(transacao);
        System.out.println("Transação cadastrada com sucesso!");
    }

    public void cadastrarLote(List<? extends Transacao> lote) {
        repositorio.adicionarTodos(lote);
        System.out.println("Lote de transação cadastrado!");
    }

    public void listarTransacoes() {
        List<Transacao> lista = repositorio.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma transação cadastrada ate o momento");
            return;
        }

        for (Transacao transacao : lista) {
            transacao.mostrarDados();
            System.out.println("===============");
        }
    }

    public void removerTransacao(int idRemovido) {
        Transacao encontrada = null;
        for (Transacao t : repositorio.listarTodos()) {
            if (t.getId() == idRemovido) {
                encontrada = t;
                break;
            }
        }

        if (encontrada != null) {
            repositorio.remover(encontrada);
            System.out.println("Transação Id: " + idRemovido + " removido com sucesso");
        } else {
            throw new TransacaoNaoEncontradaException(
                    "Não foi possível remover, a transação de id: " + idRemovido + " não existe");
        }
    }

    public double calcularSaldo() {
        double saldo = 0;
        for (Transacao t : repositorio.listarTodos()) {
            saldo += t.getImpactoSaldo();
        }

        System.out.println("Saldo da conta: R$ " + saldo);
        return saldo;
    }
}
