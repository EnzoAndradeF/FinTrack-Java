# FinTrack - Gerenciador Financeiro

O **FinTrack** é uma aplicação desktop para controle e gerenciamento de transações financeiras pessoais.

---

## Funcionalidades

- **Listagem Dinâmica:** Exibição de transações em tempo real com atualização automática de saldo.
- **Cadastro de Transações:** Interface modal para inclusão de Entradas e Saídas.
- **Remoção de Itens:** Exclusão de transações diretamente na tabela com recalculagem do saldo total.
- **Cálculo Polimórfico de Saldo:** Processamento automatizado do impacto de cada tipo de transação no saldo consolidado.
- **Interface Dupla:** Suporte para interatividade via Terminal (CLI) e Interface Gráfica (GUI).

---

## Conceitos Aplicados

- **Programação orientada a objetos**
- **Encapsulamento**
- **Polimiorfismo**
- **Tratamento de exceções**
- **Generics**
- **JavaFX - Interface Gráfica**
- **FXML e Scene Builder**

## Estrutura do projeto
```text
├── pom.xml
├── README.md
└── src
    └── main
        ├── java
        │   └── com
        │       └── fintrack
        │           ├── controller
        │           │   ├── FormTransacaoController.java
        │           │   └── PrimaryController.java
        │           ├── exception
        │           │   └── TransacaoNaoEncontradaException.java
        │           ├── FinAppCLI.java
        │           ├── FinApp.java
        │           ├── model
        │           │   ├── Entrada.java
        │           │   ├── Saida.java
        │           │   └── Transacao.java
        │           ├── repository
        │           │   └── RepositorioGenerico.java
        │           └── service
        │               └── GerenciadorFinanceiro.java
        └── resources
            └── com
                └── fintrack
                    ├── style.css
                    └── views
                        ├── form-transacao.fxml
                        └── primary.fxml
```

