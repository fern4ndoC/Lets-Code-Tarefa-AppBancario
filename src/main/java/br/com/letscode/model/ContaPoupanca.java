package main.java.br.com.letscode.model;

import java.util.ArrayList;

public class ContaPoupanca extends Conta{

    public static ArrayList<ContaPoupanca> contas = new ArrayList<>();

    public ContaPoupanca(int numero, int agencia, Cliente titular) {
        super(numero, agencia, titular);
    }

    @Override
    public String toString() {
        return "Conta Poupança{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                ", titular=" + titular.getNome() +
                '}';
    }
}
