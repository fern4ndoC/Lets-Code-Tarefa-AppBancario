package main.java.br.com.letscode.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

abstract public class Conta{

    protected static final String SALDO_INSUFICIENTE = "Não há saldo suficiente para realizar a operação.";
    protected static final double PJ_TAXA_SAQUE = 0.005;
    protected static final double PJ_TAXA_TRANSFERENCIA = 0.005;
    protected static final double PF_TAXA_RENDIMENTO = 0.005;
    protected static final double PJ_TAXA_RENDIMENTO = PF_TAXA_RENDIMENTO + 0.02;

    protected int numero;
    protected int agencia;
    protected Cliente titular;
    protected BigDecimal saldo;

    public Conta() {
    }

    public Conta(int numero, int agencia, Cliente titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        saldo = BigDecimal.valueOf(0d);
    }

    public void sacar(double valor){
        BigDecimal aux = BigDecimal.valueOf(valor);
        if (saldo.compareTo(aux) >= 0) {
            if (titular.getClass() == PessoaJuridica.class) {
                saldo.add(aux.multiply(BigDecimal.valueOf(1 + PJ_TAXA_SAQUE)));
            }else {
                saldo.subtract(aux);
            }
        }else {
            System.out.println(SALDO_INSUFICIENTE);
        }
    }

    public void transferir(double valor, Conta destino){
        BigDecimal aux = BigDecimal.valueOf(valor);
        if (saldo.compareTo(aux) >= 0) {
            if (titular.getClass() == PessoaJuridica.class) {
                saldo.add(aux.multiply(BigDecimal.valueOf(1 + PJ_TAXA_TRANSFERENCIA)));
            }else {
                saldo.subtract(aux);
            }
            destino.depositar(valor);
        }else {
            System.out.println(SALDO_INSUFICIENTE);
        }
    }

    public void depositar(double valor){
        saldo.add(BigDecimal.valueOf(valor));
    }

    public void consultarSaldo(Locale locale){
        System.out.println(NumberFormat.getCurrencyInstance(locale).format(saldo));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero == conta.numero && agencia == conta.agencia;
    }
}
