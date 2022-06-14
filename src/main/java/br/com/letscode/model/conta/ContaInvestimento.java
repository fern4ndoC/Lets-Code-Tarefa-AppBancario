package main.java.br.com.letscode.model.conta;

import main.java.br.com.letscode.model.cliente.Cliente;
import main.java.br.com.letscode.model.cliente.PessoaFisica;
import main.java.br.com.letscode.model.cliente.PessoaJuridica;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaInvestimento extends Conta{

    public static ArrayList<ContaInvestimento> contas = new ArrayList<>();

    public ContaInvestimento(int numero, int agencia, Cliente titular) {
        super(numero, agencia, titular);
    }

    public ContaInvestimento(int numero, int agencia){
        this.numero = numero;
        this.agencia = agencia;
    }

    // Recebe um valor, aplica a taxa de rendimento e soma ao saldo.
    public void investir(double valor){
        BigDecimal aux = BigDecimal.valueOf(valor);
        if (aux.compareTo(saldo) <= 0 && valor >= 0) {
            if (titular instanceof PessoaFisica) {
                saldo = saldo.add(aux.multiply(BigDecimal.valueOf(PF_TAXA_RENDIMENTO_INVESTIMENTO)));
            }
            if (titular instanceof PessoaJuridica) {
                saldo = saldo.add(aux.multiply(BigDecimal.valueOf(PJ_TAXA_RENDIMENTO_INVESTIMENTO)));
            }
            System.out.println(SUCESSO);
        }
        if (aux.compareTo(saldo) > 0){
            System.out.println(SALDO_INSUFICIENTE);
        }
        if (valor < 0){
            System.out.println(VALOR_NEGATIVO);
        }

    }

    public static ContaInvestimento encontrar(int agencia, int conta){
        ContaInvestimento temp = new ContaInvestimento(conta, agencia);
        int indexConta = contas.indexOf(temp);
        if (indexConta >= 0) {
            return contas.get(indexConta);
        }else {
            System.out.println("Conta não encontrada!");
            return null;
        }
    }
}
