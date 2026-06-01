# FinTrack Java

## Funcionalidades

- Cadastro de receitas (entradas)
- Cadastro de despesas (saídas)
- Listagem de transações
- Cálculo de saldo
- Remoção de transações por ID

## Conceitos utilizados

- Classes e Objetos
- Encapsulamento
- Construtores
- ArrayList
- Métodos
- Getters e Setters
- Manipulação de datas com LocalDate
- Estruturas de repetição
- Estruturas condicionais

## Estrutura do Projeto

### Transacao

Representa uma movimentação financeira contendo:

- ID
- Descrição
- Valor
- Tipo (Entrada ou Saída)
- Data da transação

### GerenciadorFinanceiro

Responsável por:

- Armazenar transações
- Listar transações
- Remover transações
- Calcular saldo

### App

Menu principal da aplicação e interação com o usuário.
