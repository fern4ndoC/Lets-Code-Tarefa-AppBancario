package main.java.br.com.letscode.model;

public class ContaInvestimento extends Conta{

    private static final double PJ_TAXA_RENDIMENTO = 0.02;

    public ContaInvestimento(int numero, int agencia, Cliente titular) {
        super(numero, agencia, titular);
    }

    @Override
    public String toString() {
        return "Conta Investimento{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                ", titular=" + titular.getNome() +
                '}';
    }
}
