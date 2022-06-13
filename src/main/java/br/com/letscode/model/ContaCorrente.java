package main.java.br.com.letscode.model;

import java.util.ArrayList;

public class ContaCorrente extends Conta{

    public static ArrayList<ContaCorrente> contas = new ArrayList<>();

    public ContaCorrente(){
        super();
    }

    public ContaCorrente(int numero, int agencia){
        super(numero, agencia);
    }

    public ContaCorrente(int numero, int agencia, Cliente titular) {
        super(numero, agencia, titular);
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                ", titular=" + titular.getNome() +
                '}';
    }
}
