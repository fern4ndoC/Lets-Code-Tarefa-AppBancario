package main.java.br.com.letscode.model;

public class ContaPoupanca extends Conta{
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
