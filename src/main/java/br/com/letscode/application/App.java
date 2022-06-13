package main.java.br.com.letscode.application;

import main.java.br.com.letscode.model.Conta;
import main.java.br.com.letscode.model.ContaCorrente;
import main.java.br.com.letscode.model.PessoaFisica;

import java.util.Locale;
import java.util.Scanner;

public class App {

    private static final String INVALIDO = "Opção inválida!";
    private static final String OPCAO = "\nInforme a opção: ";
    private static final String VALOR = "\nInforme o valor: ";
    private static final String SALDO_ATUAL = "\nSaldo atual: ";

    private static int opcao = 1;
    private static double valor = 0.0d;
    private static Locale ptbr = new Locale("pt", "BR");
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        PessoaFisica.clientesPf.add(new PessoaFisica("Fulano", "123456789"));
        ContaCorrente.contas.add(new ContaCorrente(22, 22, PessoaFisica.clientesPf.get(0)));

        while (opcao > 0) {
            inicio();
        }

        sc.close();
    }

    public static void inicio(){
        System.out.printf("%n1 - Acessar conta.%n2 - Criar conta.%n3 - Cadastrar cliente.%n0 - Sair.%n");
        System.out.print(OPCAO);
        opcao = sc.nextInt();
        switch (opcao){
            case 1:
                menuConta();
                break;
            case 2:
                menuCriarConta();
                break;
            case 3:
                menuCadastrarCliente();
                break;
            case 0:
                opcao = 0;
                break;
            default:
                System.out.println(INVALIDO);
                inicio();
                break;
        }
    }

    private static void menuConta() {
        System.out.printf("%n1 - Conta Corrente.%n2 - Conta Poupança.%n3 - Conta Investimento.%n0 - Sair.%n");
        System.out.print(OPCAO);
        opcao = sc.nextInt();

        System.out.print("\nInforme a agência: ");
        int agencia = sc.nextInt();
        System.out.print("Informe o número da conta: ");
        int numero = sc.nextInt();
        switch (opcao){
            case 1:
                menuContaCorrente(agencia, numero);
                break;
            case 2:
                menuContaPoupanca(agencia, numero);
                break;
            case 3:
                menuContaInvestimento(agencia, numero);
                break;
            default:
                inicio();
                break;
        }
    }

    private static void menuCadastrarCliente() {
        opcao = 0;
    }

    private static void menuCriarConta() {
        opcao = 0;
    }

    private static void menuContaCorrente(int agencia, int numero) {
        ContaCorrente cc = new ContaCorrente(agencia,numero);
        int cIndex = ContaCorrente.contas.indexOf(cc);
        cc = ContaCorrente.contas.get(cIndex);
        while (opcao != 0) {
            System.out.printf("%n1 - Sacar.%n2 - Depositar.%n3 - Transferir.%n4 - Consultar saldo.%n0 - Sair.%n");
            System.out.print(OPCAO);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print(VALOR);
                    valor = sc.nextDouble();
                    cc.sacar(valor);
                    break;
                case 2:
                    System.out.print(VALOR);
                    valor = sc.nextDouble();
                    cc.depositar(valor);
                    break;
                case 4:
                    System.out.print(SALDO_ATUAL);
                    cc.consultarSaldo(ptbr);
                    break;
                default:
                    inicio();
                    break;
            }
        }
    }

    private static void menuContaInvestimento(int agencia, int numero) {
    }

    private static void menuContaPoupanca(int agencia, int numero) {
    }
}
