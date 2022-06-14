package main.java.br.com.letscode.application;

import main.java.br.com.letscode.model.cliente.PessoaFisica;
import main.java.br.com.letscode.model.cliente.PessoaJuridica;
import main.java.br.com.letscode.model.conta.*;

public class App {

    private static final String ORIGEM = "Saldo na conta de origem: ";
    private static final String DESTINO = "Saldo na conta de destino: ";
    private static final String NEGATIVO = "Sacar valor negativo: ";
    private static final String INSUFICIENTE = "Sacar com saldo insuficiente: ";

    private static ContaCorrente cc1;
    private static ContaCorrente cc2;
    private static ContaCorrente cc3;

    private static ContaPoupanca cp;

    private static ContaInvestimento ci1;
    private static ContaInvestimento ci2;

    public static void main(String[] args) {

        PessoaFisica pf = new PessoaFisica("Alberto", "123456789");
        PessoaFisica.criarCliente(pf);
        pf = new PessoaFisica("Daniela", "845796312");
        PessoaFisica.criarCliente(pf);
        PessoaJuridica pjTemp = new PessoaJuridica("Let's Code", "24861255000107");
        PessoaJuridica.criarCliente(pjTemp);

        // Teste de método para encontrar por uma chave
        PessoaFisica pf1 = PessoaFisica.encontrar("123456789");
        System.out.println("Tentativa de encontrar cliente por chave não existente: ");
        PessoaFisica pf2 = PessoaFisica.encontrar("547942157");
        System.out.println("Retorna Null: " + pf2);
        pf2 = PessoaFisica.encontrar("845796312");
        PessoaJuridica pj = PessoaJuridica.encontrar("24861255000107");

        PessoaFisica.abrirConta(TipoConta.CONTA_CORRENTE, 22, 22, pf1);
        PessoaFisica.abrirConta(TipoConta.CONTA_CORRENTE, 23, 22, pf2);
        PessoaFisica.abrirConta(TipoConta.CONTA_POUPANCA, 24, 22, pf1);
        PessoaFisica.abrirConta(TipoConta.CONTA_INVESTIMENTO, 25, 22, pf1);
        PessoaJuridica.abrirConta(TipoConta.CONTA_CORRENTE, 33, 33, pj);
        System.out.println("Tentativa de criação de conta poupança por PJ: ");
        PessoaJuridica.abrirConta(TipoConta.CONTA_POUPANCA, 34, 33, pj);
        System.out.println("...............................\n");
        PessoaJuridica.abrirConta(TipoConta.CONTA_INVESTIMENTO, 34, 33, pj);

        cc1 = ContaCorrente.encontrar(22, 22);
        cc2 = ContaCorrente.encontrar(22, 23);
        cc3 = ContaCorrente.encontrar(33, 33);
        cp = ContaPoupanca.encontrar(22, 24);
        ci1 = ContaInvestimento.encontrar(22, 25);
        ci2 = ContaInvestimento.encontrar(33, 34);

        //Teste Conta Corrente - PF
        //contaCorrentePf();

        //Teste Conta Corrente - PJ
        //contaCorrentePj();

        //Teste Conta Poupança
        //contaPoupanca();

        //Teste Conta Investimento - PF
        //contaInvestimentoPf();

        //Teste Conta Investimento - PJ
        //contaInvestimentoPj();
    }


    private static void contaCorrentePf(){

        System.out.println("--- Conta Corrente - PF ---");
        System.out.println("Dados: ");
        System.out.println(cc1.toString());
        System.out.println("Depositar R$ 100: ");
        cc1.depositar(100);
        cc1.consultarSaldo();
        System.out.println("Transferir R$ 50: ");
        cc1.transferir(50, cc2);
        System.out.println(ORIGEM);
        cc1.consultarSaldo();
        System.out.println(DESTINO);
        cc2.consultarSaldo();
        System.out.println("Sacar R$ 20: ");
        cc1.sacar(20);
        cc1.consultarSaldo();
        System.out.println(INSUFICIENTE);
        cc2.sacar(100);
        cc2.consultarSaldo();
        System.out.println(NEGATIVO);
        cc2.sacar(-10);
        cc2.consultarSaldo();
    }

    private static void contaCorrentePj() {
        System.out.println("--- Conta Corrente - PJ ---");
        System.out.println("Dados: ");
        System.out.println(cc3.toString());
        System.out.println("Depositar R$ 100: ");
        cc3.depositar(100);
        cc3.consultarSaldo();
        System.out.println("Transferir R$ 50: ");
        cc3.transferir(50, cc2);
        System.out.println(ORIGEM);
        cc3.consultarSaldo();
        System.out.println(DESTINO);
        cc2.consultarSaldo();
        System.out.println("Sacar R$ 20: ");
        cc3.sacar(20);
        cc3.consultarSaldo();
        System.out.println(INSUFICIENTE);
        cc3.sacar(100);
        cc3.consultarSaldo();
        System.out.println(NEGATIVO);
        cc3.sacar(-10);
        cc3.consultarSaldo();
    }

    private static void contaPoupanca() {
        System.out.println("--- Conta Poupança ---");
        System.out.println("Dados: ");
        System.out.println(cp.toString());
        System.out.println("Depositar R$ 1000: ");
        cp.depositar(1000);
        cp.consultarSaldo();
        System.out.println("Transferir R$ 100:");
        cp.transferir(100, cc2);
        System.out.println(ORIGEM);
        cp.consultarSaldo();
        System.out.println(DESTINO);
        cc2.consultarSaldo();
        System.out.println("Sacar R$ 20: ");
        cp.sacar(20);
        cp.consultarSaldo();
    }

    private static void contaInvestimentoPf() {
        System.out.println("--- Conta Investimento - PF ---");
        System.out.println("Dados: ");
        System.out.println(ci1.toString());
        System.out.println("Depositar R$ 1000: ");
        ci1.depositar(1000);
        ci1.consultarSaldo();
        System.out.println("Investir R$ 100");
        ci1.investir(100);
        ci1.consultarSaldo();
        System.out.println("Transferir R$ 100");
        ci1.transferir(100, ci2);
        System.out.println(ORIGEM);
        ci1.consultarSaldo();
        System.out.println(DESTINO);
        ci2.consultarSaldo();
        System.out.println("Sacar R$ 20: ");
        ci1.sacar(20);
        ci1.consultarSaldo();
    }

    private static void contaInvestimentoPj() {
        System.out.println("--- Conta Investimento - PJ ---");
        System.out.println("Dados: ");
        System.out.println(ci2.toString());
        System.out.println("Depositar R$ 1000: ");
        ci2.depositar(1000);
        ci2.consultarSaldo();
        System.out.println("Investir R$ 100");
        ci2.investir(100);
        ci2.consultarSaldo();
        System.out.println("Transferir R$ 100");
        ci2.transferir(100, ci1);
        System.out.println(ORIGEM);
        ci2.consultarSaldo();
        System.out.println(DESTINO);
        ci1.consultarSaldo();
        System.out.println("Sacar R$ 20: ");
        ci2.sacar(20);
        ci2.consultarSaldo();
    }
}
