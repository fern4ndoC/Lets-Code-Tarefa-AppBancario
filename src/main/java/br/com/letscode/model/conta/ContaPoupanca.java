package main.java.br.com.letscode.model.conta;

import main.java.br.com.letscode.model.cliente.Cliente;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaPoupanca extends Conta{

    public static ArrayList<ContaPoupanca> contas = new ArrayList<>();

    public ContaPoupanca(int numero, int agencia, Cliente titular) {
        super(numero, agencia, titular);
    }

    public ContaPoupanca(int numero, int agencia){
        this.numero = numero;
        this.agencia = agencia;
    }

    @Override
    public void depositar(double valor){
        if (valor > 0) {
            saldo = saldo.add(BigDecimal.valueOf(valor*(1 + PF_TAXA_POUPANCA)));
            System.out.println(SUCESSO);
        }else {
            System.out.println(VALOR_NEGATIVO);
        }
    }

    public static ContaPoupanca encontrar(int agencia, int conta){
        ContaPoupanca temp = new ContaPoupanca(conta, agencia);
        int indexConta = contas.indexOf(temp);
        if (indexConta >= 0) {
            return contas.get(indexConta);
        }else {
            System.out.println("Conta não encontrada!");
            return null;
        }
    }
}
