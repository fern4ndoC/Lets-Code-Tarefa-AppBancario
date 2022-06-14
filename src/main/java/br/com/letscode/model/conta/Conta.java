package main.java.br.com.letscode.model.conta;

import main.java.br.com.letscode.model.cliente.Cliente;
import main.java.br.com.letscode.model.cliente.PessoaJuridica;

import java.math.BigDecimal;
import java.text.NumberFormat;

abstract public class Conta{

    protected static final String SALDO_INSUFICIENTE = "Não há saldo suficiente para realizar a operação.";
    public static final String SUCESSO = "Operação realizada com sucesso!";
    protected static final String VALOR_NEGATIVO = "Valor informado não pode ser negativo";
    public static final String INVALIDO = "Opção inválida!";

    protected static final double PJ_TAXA_SAQUE = 0.005;
    protected static final double PJ_TAXA_TRANSFERENCIA = 0.005;
    protected static final double PF_TAXA_POUPANCA = 0.005;
    protected static final double PF_TAXA_RENDIMENTO_INVESTIMENTO = 0.01;
    protected static final double PJ_TAXA_RENDIMENTO_INVESTIMENTO = PF_TAXA_RENDIMENTO_INVESTIMENTO + 0.02;

    protected int numero;
    protected int agencia;
    protected Cliente titular;
    protected BigDecimal saldo;

    public Conta() {
    }

    public Conta(int numero, int agencia) {
        this.numero = numero;
        this.agencia = agencia;
    }

    public Conta(int numero, int agencia, Cliente titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        saldo = BigDecimal.valueOf(0d);
    }

    public void sacar(double valor){
        if (valor >= 0) {
            BigDecimal aux = BigDecimal.valueOf(valor);
            if (saldo.compareTo(aux) >= 0) {
                if (titular instanceof PessoaJuridica) {
                    saldo = saldo.subtract(aux.multiply(BigDecimal.valueOf(1 + PJ_TAXA_SAQUE)));
                } else {
                    saldo = saldo.subtract(aux);
                }
                System.out.println(SUCESSO);
            } else {
                System.out.println(SALDO_INSUFICIENTE);
            }
        }else{
            System.out.println(VALOR_NEGATIVO);
        }
    }

    public void transferir(double valor, Conta destino){
        BigDecimal aux = BigDecimal.valueOf(valor);
        if (saldo.compareTo(aux) >= 0) {
            if (titular instanceof PessoaJuridica) {
                saldo = saldo.subtract(aux.multiply(BigDecimal.valueOf(1 + PJ_TAXA_TRANSFERENCIA)));
            }else {
                saldo =  saldo.subtract(aux);
            }
            destino.depositar(valor);
        }else {
            System.out.println(SALDO_INSUFICIENTE);
        }
    }

    public void depositar(double valor){
        if (valor > 0) {
            saldo = saldo.add(BigDecimal.valueOf(valor));
            System.out.println(SUCESSO);
        }else {
            System.out.println(VALOR_NEGATIVO);
        }
    }

    public void consultarSaldo(){
        String saldoString = NumberFormat.getCurrencyInstance().format(saldo);
        System.out.printf("Saldo atual: %s.%n%n", saldoString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero == conta.numero && agencia == conta.agencia;
    }

    @Override
    public String toString() {
        return "Tipo de conta: " + this.getClass().getSimpleName() +
                "\nAgência: " + agencia +
                ", Conta: " + numero +
                ".\nTitular: " + titular.getNome() +
                ".\nSaldo: " + NumberFormat.getCurrencyInstance().format(saldo) +
                "\n";
    }
}
