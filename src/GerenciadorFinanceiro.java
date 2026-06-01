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
                System.out.println("Transação Id: " + idRemovido + " removido com sucesso");
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Transação não encontrada");
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

        System.out.println("Saldo da conta: " + saldo);

        return saldo;
    }
}
