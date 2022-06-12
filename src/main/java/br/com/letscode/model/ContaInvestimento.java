package main.java.br.com.letscode.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaInvestimento extends Conta{

    public static ArrayList<ContaInvestimento> contas = new ArrayList<>();

    public ContaInvestimento(int numero, int agencia, Cliente titular) {
        super(numero, agencia, titular);
    }

    public void investir(double valor){
        BigDecimal aux = BigDecimal.valueOf(valor);
        if (titular.getClass() == PessoaFisica.class) {
            saldo.add(aux.multiply(BigDecimal.valueOf(PF_TAXA_RENDIMENTO)));
        }
        if (titular.getClass() == PessoaJuridica.class){
            saldo.add(aux.multiply(BigDecimal.valueOf(PJ_TAXA_RENDIMENTO)));
        }
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
