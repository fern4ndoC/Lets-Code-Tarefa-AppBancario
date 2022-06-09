package main.java.br.com.letscode.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

abstract public class Conta {
    protected int numero;
    protected int agencia;
    protected Cliente titular;
    protected double saldo;

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

    public void sacar(double valor){}

    public void depositar(double valor){}

    public void transferir(double valor){}

    public void consultarSaldo(Locale locale){}
}
