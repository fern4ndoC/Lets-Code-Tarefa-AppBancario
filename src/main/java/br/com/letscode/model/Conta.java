package main.java.br.com.letscode.model;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

abstract public class Conta {

    protected static final String NAO_PODE_CRIAR = "Este cliente não pode criar o tipo de conta solicitado.";
    protected static final String OPCAO_INVALIDA = "A opção selecionada é inválida.";
    protected static final String SALDO_INSUFICIENTE = "Não há saldo suficiente para realizar a operação.";
    protected static final double PJ_TAXA_SAQUE_TRANSFERENCIA = 0.005;

    protected int numero;
    protected int agencia;
    protected Cliente titular;
    protected double saldo;

    public Conta() {
    }

    public Conta(int numero, int agencia, Cliente titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        saldo = 0d;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public void sacar(double valor){
        if (saldo >= valor) {
            if (titular.getClass() == PessoaJuridica.class) {
                saldo -= valor * (1 + PJ_TAXA_SAQUE_TRANSFERENCIA);
            } else {
                saldo -= valor;
            }
        }else {
            System.out.println(SALDO_INSUFICIENTE);
        }
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public void transferir(double valor, Conta destino){
        if (saldo >= valor) {
            if (titular.getClass() == PessoaJuridica.class) {
                saldo -= valor * (1 + PJ_TAXA_SAQUE_TRANSFERENCIA);
            } else {
                saldo -= valor;
            }
            destino.depositar(valor);
        }else {
            System.out.println(SALDO_INSUFICIENTE);
        }
    }

    public void consultarSaldo(Locale locale){
        System.out.println(NumberFormat.getCurrencyInstance(locale).format(saldo));
    }

    public static Conta abrirConta(int tipo, Cliente titular, int numero, int agencia){
        switch (tipo){
            case 1:
                return new ContaCorrente(numero, agencia, titular);
            case 2:
                if (titular.getClass() == PessoaFisica.class) {
                    return new ContaPoupanca(numero, agencia, titular);
                }else{
                    System.out.println(NAO_PODE_CRIAR);
                    return null;
                }
            case 3:
                return new ContaInvestimento(numero, agencia, titular);
            default:
                System.out.println(OPCAO_INVALIDA);
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero == conta.numero && agencia == conta.agencia;
    }
}
