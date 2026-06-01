import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        GerenciadorFinanceiro gerenciador = new GerenciadorFinanceiro();

        int opcao;

        do{
            System.out.println("===== Sistema FinTrack =====");
            System.out.println("Digite '1' para cadastrar transação");
            System.out.println("Digite '2' para exibir transações");
            System.out.println("Digite '3' para exibir saldo");
            System.out.println("Digite '4' para remover transação");
            System.out.println("Digite '0' para encerrar a aplicação");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Descrição: ");
                    String descricaoTransacao = scanner.nextLine();

                    System.out.println("Valor: ");
                    double valorTransacao = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Digite 'E' para Entrada ou 'S' para Saída");
                    String tipoTransacao = scanner.nextLine();
                    boolean entrada;

                    if (tipoTransacao.equalsIgnoreCase("E")) {
                        entrada = true;

                    } else if (tipoTransacao.equalsIgnoreCase("S")){
                        entrada = false;
                    } else{
                        System.out.println("Comando não reconhecido");
                        break;
                    }

                    Transacao novaTransacao = new Transacao(descricaoTransacao, valorTransacao, entrada) ;

                    novaTransacao.mostrarDados();

                    gerenciador.cadastrarTransacao(novaTransacao);
                    break;
                case 2:
                    gerenciador.listarTransacoes();
                    
                    break;
                case 3:
                    gerenciador.calcularSaldo();
                    
                    break;
                case 4:
                    System.out.println("Digite o Id da transação que deseja remover: ");
                    int idParaRemover = scanner.nextInt();
                    scanner.nextLine();

                    gerenciador.removerTransacao(idParaRemover);
                    
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
            
                default:
                    System.out.println("Comando não reconhecido");
                    break;
            }
        } while (opcao !=0);
    }
}
