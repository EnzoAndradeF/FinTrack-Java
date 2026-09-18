# FinTrack - Gerenciador Financeiro

O **FinTrack** é uma aplicação desktop para controle e gerenciamento de transações financeiras pessoais.

---

## Funcionalidades

- **Listagem Dinâmica:** Exibição de transações em tempo real com atualização automática de saldo.
- **Cadastro de Transações:** Interface modal para inclusão de Entradas e Saídas.
- **Remoção de Itens:** Exclusão de transações diretamente na tabela com recalculagem do saldo total.
- **Cálculo Polimórfico de Saldo:** Processamento automatizado do impacto de cada tipo de transação no saldo consolidado.
- **Interface Dupla:** Suporte para interatividade via Terminal (CLI) e Interface Gráfica (GUI).
- **Acesso a banco de dados (JDBC & MySQL)**

---

## Conceitos Aplicados

- **Programação orientada a objetos**
- **Encapsulamento**
- **Polimiorfismo**
- **Tratamento de exceções**
- **Generics**
- **JavaFX - Interface Gráfica**
- **FXML e Scene Builder**
- **JDBC - Conexão com banco de dados**
- **Statement**
- **ResultSet**

## Estrutura do projeto
```text
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── fintrack/
│       │           ├── controller/
│       │           │   ├── FormTransacaoController.java
│       │           │   └── PrimaryController.java
│       │           ├── dao/
│       │           │   ├── TransacaoDAO.java
│       │           │   └── TransacaoDAOJBDC.java
│       │           ├── exception/
│       │           │   └── TransacaoNaoEncontradaException.java
│       │           ├── factory/
│       │           │   └── ConnectionFactory.java
│       │           ├── model/
│       │           │   ├── Entrada.java
│       │           │   ├── Saida.java
│       │           │   └── Transacao.java
│       │           ├── repository/
│       │           │   └── RepositorioGenerico.java
│       │           ├── service/
│       │           │   └── GerenciadorFinanceiro.java
│       │           ├── FinAppCLI.java
│       │           └── FinApp.java
│       └── resources/
│           └── com/
│               └── fintrack/
│                   ├── views/
│                   │   ├── form-transacao.fxml
│                   │   └── primary.fxml
│                   └── style.css
├── pom.xml
└── README.md
```

