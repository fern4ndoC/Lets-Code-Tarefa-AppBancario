package main.java.br.com.letscode.application;

import main.java.br.com.letscode.model.cliente.PessoaFisica;
import main.java.br.com.letscode.model.cliente.PessoaJuridica;
import main.java.br.com.letscode.model.conta.ContaCorrente;
import main.java.br.com.letscode.model.conta.ContaInvestimento;
import main.java.br.com.letscode.model.conta.ContaPoupanca;
import main.java.br.com.letscode.model.conta.TipoConta;

import java.util.Locale;
import java.util.Scanner;

    public class Teste {
/*
        public static final String INVALIDO = "\nOpção inválida!";
        private static final String OPCAO = "\nInforme a opção: ";
        private static final String VALOR = "\nInforme o valor: ";
        private static final String SALDO_ATUAL = "\nSaldo atual: ";

        private static int opcao = 1;
        private static double valor = 0.0d;
        private static Locale ptbr = new Locale("pt", "BR");
        private static final Scanner sc = new Scanner(System.in);
        private static PessoaFisica clientePf;
        private static PessoaJuridica clientePj;
        private static int agenciaDestino, contaDestino;

        public static void main(String[] args) {

            PessoaFisica.clientesPf.add(new PessoaFisica("Alberto", "123456789"));
            PessoaJuridica.clientesPj.add(new PessoaJuridica("Amazon", "12345678912"));
            ContaCorrente.contas.add(new ContaCorrente(22, 22, PessoaFisica.clientesPf.get(0)));
            ContaCorrente.contas.add(new ContaCorrente(33, 33, PessoaJuridica.clientesPj.get(0)));
            ContaPoupanca.contas.add(new ContaPoupanca(23, 22, PessoaFisica.clientesPf.get(0)));
            ContaInvestimento.contas.add(new ContaInvestimento(24, 22, PessoaFisica.clientesPf.get(0)));
            ContaInvestimento.contas.add(new ContaInvestimento(24, 22, PessoaJuridica.clientesPj.get(0)));

            while (opcao > 0) {
                inicio();
            }

            sc.close();
        }

        public static void inicio() {
            System.out.println("\n##########################################################\n" +
                    "#                       Bemvindo!                        #\n" +
                    "##########################################################"
            );
            System.out.printf("1 - Acessar conta.%n2 - Criar conta.%n3 - Cadastrar cliente.%n0 - Sair.%n");
            System.out.print(OPCAO);
            opcao = sc.nextInt();
            switch (opcao) {
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
            divisor();
            System.out.printf("%n1 - Conta Corrente.%n2 - Conta Poupança.%n3 - Conta Investimento.%n0 - Sair.%n");
            System.out.print(OPCAO);
            opcao = sc.nextInt();

            System.out.print("\nInforme a agência: ");
            int agencia = sc.nextInt();
            System.out.print("Informe o número da conta: ");
            int numero = sc.nextInt();
            switch (opcao) {
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
            divisor();
            System.out.printf("1 -Pessoa Física.%n2 - Pessoa Jurídica.%n0 - Cancelar.%n");
            System.out.print(OPCAO);
            int pessoaTipo = sc.nextInt();

            System.out.print("Informe o nome: ");
            String nome = sc.nextLine();

            switch (pessoaTipo) {
                case 1:
                    System.out.print("Informe o CPF (somente numeros): ");
                    int cpf = sc.nextInt();
                    PessoaFisica.clientesPf.add(new PessoaFisica(nome, String.valueOf(cpf)));
                    break;
                case 2:
                    System.out.print("Informe o cnpj (somente numeros): ");
                    int cnpj = sc.nextInt();
                    PessoaJuridica.clientesPj.add(new PessoaJuridica(nome, String.valueOf(cnpj)));
                    break;
                case 0:
                    inicio();
                    break;
                default:
                    System.out.println(INVALIDO);
                    menuCadastrarCliente();
                    break;
            }
        }

        private static void menuCriarConta() {
            divisor();
            System.out.println("\nQuem irá criar a conta?");
            System.out.printf("1 - Pessoa Física.%n2 - Pessoa Jurídica.%n0 - Cancelar.%n");
            System.out.print(OPCAO);
            int pessoaTipo = sc.nextInt();
            int tipoConta, conta, agencia;

            divisor();

            System.out.println("\nTIPO DE CONTA");
            System.out.printf("%n1 - Conta Corrente.%n2 - Conta Poupança.%n3 - Conta Investimento.%n0 - Cancelar.%n");
            System.out.print(OPCAO);
            tipoConta = sc.nextInt();
            TipoConta tipo = TipoConta.tipo(tipoConta);

            switch (pessoaTipo) {
                case 1:
                    System.out.print("Informe o CPF (somente números): ");
                    int cpf = sc.nextInt();
                    clientePf = PessoaFisica.encontrar(String.valueOf(cpf));
                    if (clientePf != null) {
                        System.out.print("Informe o número da agência: ");
                        agencia = sc.nextInt();
                        System.out.print("Informe um número para a conta: ");
                        conta = sc.nextInt();

                        if (tipoConta > 0) {
                            PessoaFisica.abrirConta(tipo, conta, agencia, clientePf);
                        } else if (tipoConta == 0) {
                            inicio();
                        } else {
                            System.out.println(INVALIDO);
                            menuCriarConta();
                        }
                    } else {
                        menuCriarConta();
                    }
                    break;
                case 2:
                    System.out.print("Informe o CNPJ (somente números): ");
                    long cnpj = sc.nextLong();
                    clientePj = PessoaJuridica.encontrar(String.valueOf(cnpj));
                    if (clientePj != null) {
                        System.out.print("Informe o número da agência: ");
                        agencia = sc.nextInt();
                        System.out.print("Informe um número para a conta: ");
                        conta = sc.nextInt();
                        if (tipoConta > 0) {
                            PessoaJuridica.abrirConta(tipo, conta, agencia, clientePj);
                        } else if (tipoConta == 0) {
                            inicio();
                        } else {
                            System.out.println(INVALIDO);
                            menuCriarConta();
                        }
                    } else {
                        menuCriarConta();
                    }
                    break;
                default:
                    menuCriarConta();
                    break;
            }
        }

        private static void menuContaCorrente(int agencia, int numero) {
            divisor();
            ContaCorrente cc = ContaCorrente.encontrar(agencia, numero);
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
                    case 3:
                        System.out.print("Informe a agência de destino: ");
                        agenciaDestino = sc.nextInt();
                        System.out.print("Informe a conta de destino: ");
                        contaDestino = sc.nextInt();
                        System.out.print("Informe o valor a ser transferido: ");
                        valor = sc.nextDouble();
                        ContaCorrente destino = ContaCorrente.encontrar(agenciaDestino, contaDestino);
                        cc.transferir(valor, destino);
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
            divisor();
            ContaInvestimento cc = ContaInvestimento.encontrar(agencia, numero);
            while (opcao != 0) {
                System.out.printf("%n1 - Investir.%n2 - Transferir.%n3 - Consultar saldo.%n0 - Sair.%n");
                System.out.print(OPCAO);
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Informe o valor a ser investido: ");
                        valor = sc.nextDouble();
                        cc.investir(valor);
                        break;
                    case 2:
                        System.out.print("Informe a agência de destino: ");
                        agenciaDestino = sc.nextInt();
                        System.out.print("Informe a conta de destino: ");
                        contaDestino = sc.nextInt();
                        System.out.print("Informe o valor a ser transferido: ");
                        valor = sc.nextDouble();
                        ContaCorrente destino = ContaCorrente.encontrar(agenciaDestino, contaDestino);
                        cc.transferir(valor, destino);
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

        private static void menuContaPoupanca(int agencia, int numero) {
            divisor();
            ContaPoupanca cc = ContaPoupanca.encontrar(agencia, numero);
            while (opcao != 0) {
                System.out.printf("%n1 - Depositar.%n2 - Transferir.%n3 - Consultar saldo.%n0 - Sair.%n");
                System.out.print(OPCAO);
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print(VALOR);
                        valor = sc.nextDouble();
                        cc.depositar(valor);
                        break;
                    case 2:
                        System.out.print("Informe a agência de destino: ");
                        agenciaDestino = sc.nextInt();
                        System.out.print("Informe a conta de destino: ");
                        contaDestino = sc.nextInt();
                        System.out.print("Informe o valor a ser transferido: ");
                        valor = sc.nextDouble();
                        ContaCorrente destino = ContaCorrente.encontrar(agenciaDestino, contaDestino);
                        cc.transferir(valor, destino);
                        break;
                    case 3:
                        System.out.print(SALDO_ATUAL);
                        cc.consultarSaldo(ptbr);
                        break;
                    default:
                        inicio();
                        break;
                }
            }
        }

        private static void divisor() {
            System.out.println("\n##########################################################");
        }

 */
    }
