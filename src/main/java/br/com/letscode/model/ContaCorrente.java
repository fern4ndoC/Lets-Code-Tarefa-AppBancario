package main.java.br.com.letscode.model;

public class ContaCorrente extends Conta{

    public ContaCorrente(){
        super();
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
