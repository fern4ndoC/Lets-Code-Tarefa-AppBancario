package main.java.br.com.letscode.model.conta;

import main.java.br.com.letscode.model.cliente.Cliente;

import java.util.ArrayList;

public class ContaCorrente extends Conta{

    public static ArrayList<ContaCorrente> contas = new ArrayList<>();

    public ContaCorrente(int numero, int agencia){
        super(numero, agencia);
    }

    public ContaCorrente(int numero, int agencia, Cliente titular) {
        super(numero, agencia, titular);
    }

    public static ContaCorrente encontrar(int agencia, int conta){
        ContaCorrente temp = new ContaCorrente(conta, agencia);
        int indexConta = contas.indexOf(temp);
        if (indexConta >= 0) {
            return contas.get(indexConta);
        }else {
            System.out.println("Conta não encontrada!");
            return null;
        }
    }

}
