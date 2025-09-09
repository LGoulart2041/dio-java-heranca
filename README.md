# 🎬 Sistema de Ingressos de Cinema

Este projeto implementa uma hierarquia de classes para gerenciar diferentes tipos de ingressos de cinema, aplicando **Herança**, **Polimorfismo** e princípios do **SOLID**.

## 📌 Funcionalidades

- Cadastro de ingressos com:
    - Nome do filme
    - Valor base
    - Tipo de exibição: **Dublado** ou **Legendado**
- Tipos de ingresso:
    - **Ingresso Normal**
    - **Meia Entrada** (50% do valor base)
    - **Ingresso Família** (multiplicado pelo número de pessoas, com 5% de desconto se > 3 pessoas)

## 🏗️ Estrutura do Projeto

- `IIngresso` → Interface que define o contrato.
- `Ingresso` → Classe abstrata com propriedades comuns.
- `IngressoMeia` → Implementa a regra de meia entrada.
- `IngressoFamilia` → Implementa a regra para grupos familiares.

## 📖 Diagrama de Classes

![Diagrama de Classes](./src/img/diagrama-cinema.drawio.png)


- Java 17+
- UML (para modelagem)

## ▶️ Exemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        IIngresso ingressoNormal = new IngressoNormal(20.0, "Interestelar", true);
        IIngresso ingressoMeia = new IngressoMeia(20.0, "Matrix", false);
        IIngresso ingressoFamilia = new IngressoFamilia(15.0, "Toy Story", true, 4);

        System.out.println("Normal: R$ " + ingressoNormal.getValorReal());
        System.out.println("Meia: R$ " + ingressoMeia.getValorReal());
        System.out.println("Família: R$ " + ingressoFamilia.getValorReal());
    }
}
```

---

# 🎯 Sistema de Gerenciamento de Usuários

Este projeto implementa um **sistema de gerenciamento de usuários** para uma empresa, utilizando conceitos de **programação orientada a objetos** como **herança**, **polimorfismo**, **encapsulamento** e **interfaces**.

## 📝 Visão Geral

O sistema define diferentes tipos de usuários:

### 1. Gerente
- **Atributos:** `nome`, `email`, `senha`, `administrador` (sempre verdadeiro)
- **Métodos:**
    - `gerarRelatorioFinanceiro()`
    - `consultarVendas()`
    - `login()`
    - `logoff()`
    - `alterarDados()`
    - `alterarSenha()`

### 2. Vendedor
- **Atributos:** `nome`, `email`, `senha`, `quantidadeVendas`, `administrador` (sempre falso)
- **Métodos:**
    - `realizarVenda()`
    - `consultarVendas()`
    - `login()`
    - `logoff()`
    - `alterarDados()`
    - `alterarSenha()`

### 3. Atendente
- **Atributos:** `nome`, `email`, `senha`, `valorEmCaixa`, `administrador` (sempre falso)
- **Métodos:**
    - `receberPagamento()`
    - `fecharCaixa()`
    - `login()`
    - `logoff()`
    - `alterarDados()`
    - `alterarSenha()`

Todos os usuários implementam a **interface `IUser`** e herdam da classe abstrata **User**, que fornece atributos e métodos comuns.

---

## 📦 Estrutura do Projeto

```text
system/
│
├── IUser.java          # Interface definindo métodos comuns dos usuários
├── User.java           # Classe abstrata com atributos e métodos comuns
├── Manager.java        # Subclasse Gerente
├── Seller.java         # Subclasse Vendedor
├── Attendant.java      # Subclasse Atendente
└── Main.java           # Exemplo de uso

```
## ▶️ Exemplo de Uso

```java
package system;

public class Main {
    public static void main(String[] args) {

        // Criação dos usuários
        IUser manager = new Manager("Anna", "anna@company.com", "1234");
        IUser seller = new Seller("Charles", "charles@company.com", "abcd");
        IUser attendant = new Attendant("Mary", "mary@company.com", "xyz");

        // Array de usuários para demonstrar polimorfismo
        IUser[] users = { manager, seller, attendant };

        // Todos fazem login
        for (IUser user : users) {
            user.login();
        }

        System.out.println();

        // Operações específicas de cada tipo de usuário
        System.out.println("### Operações de Gerente ###");
        Manager m = (Manager) manager;
        m.generateFinancialReport();
        m.checkSales();
        m.updateData("Anna Silva", "anna.silva@company.com");
        m.changePassword("new1234");

        System.out.println("\n### Operações de Vendedor ###");
        Seller s = (Seller) seller;
        s.makeSale();
        s.makeSale();
        s.checkSales();
        s.updateData("Charles Brown", "charles.brown@company.com");
        s.changePassword("newabcd");

        System.out.println("\n### Operações de Atendente ###");
        Attendant a = (Attendant) attendant;
        a.receivePayment(200.0);
        a.receivePayment(150.0);
        System.out.println("Valor em caixa antes de fechar: $" + a.getCashRegister());
        a.closeRegister();
        a.updateData("Mary Johnson", "mary.johnson@company.com");
        a.changePassword("newxyz");

        System.out.println();

        // Todos fazem logoff
        for (IUser user : users) {
            user.logoff();
        }
    }
}
```

## Exemplo de saída:

```text 
Anna logged in.
Charles logged in.
Mary logged in.
Financial report generated.
Sale completed! Total sales: 1
Payment received: $200.0 | Total in register: $200.0
Anna logged off.
Charles logged off.
Mary logged off.
```