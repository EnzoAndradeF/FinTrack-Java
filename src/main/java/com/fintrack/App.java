package main.java.com.fintrack;

import main.java.com.fintrack.model.Transacao;
import main.java.com.fintrack.service.GerenciadorFinanceiro;
import main.java.com.fintrack.exception.TransacaoNaoEncontradaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GerenciadorFinanceiro gerenciador = new GerenciadorFinanceiro();
        int opcao = -1;

        do {
            try {
                System.out.println("");
                System.out.println("===== Sistema FinTrack =====");
                System.out.println("");
                System.out.println("Digite '1' para cadastrar transação");
                System.out.println("Digite '2' para exibir transações");
                System.out.println("Digite '3' para exibir saldo");
                System.out.println("Digite '4' para remover transação");
                System.out.println("Digite '0' para encerrar a aplicação");
                System.out.println("");
                System.out.println("============================");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("\n***** Cadastrar transação *****\n");

                        System.out.print("Descrição: ");
                        String descricaoTransacao = scanner.nextLine();

                        System.out.print("Valor: ");
                        double valorTransacao = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Digite 'E' para Entrada ou 'S' para Saída: ");
                        String tipoTransacao = scanner.nextLine();
                        boolean entrada;

                        if (tipoTransacao.equalsIgnoreCase("E")) {
                            entrada = true;
                        } else if (tipoTransacao.equalsIgnoreCase("S")){
                            entrada = false;
                        } else {
                            System.out.println("Comando não reconhecido. Cadastro cancelado.");
                            break;
                        }

                        Transacao novaTransacao = new Transacao(descricaoTransacao, valorTransacao, entrada);
                        System.out.println("");
                        novaTransacao.mostrarDados();

                        gerenciador.cadastrarTransacao(novaTransacao);
                        break;

                    case 2:
                        System.out.println("\n***** Exibir transações *****\n");
                        gerenciador.listarTransacoes();
                        break;

                    case 3:
                        System.out.println("\n***** Exibir Saldo *****\n");
                        gerenciador.calcularSaldo();
                        break;

                    case 4:
                        System.out.println("\n***** Remover transação *****\n");
                        System.out.print("Digite o Id da transação que deseja remover: ");
                        int idParaRemover = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            // Este método agora lança uma exceção se não achar o ID
                            gerenciador.removerTransacao(idParaRemover);
                        } catch (TransacaoNaoEncontradaException e) {
                            // Captura e mostra de forma limpa sem derrubar o app
                            System.err.println("Erro: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        break;
                
                    default:
                        System.out.println("Opção inválida. Digite um número de 0 a 4.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.err.println("Erro: Entrada inválida! Por favor, use apenas os números indicados.");
                scanner.nextLine();
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
}