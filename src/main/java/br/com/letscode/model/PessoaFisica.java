package main.java.br.com.letscode.model;

import java.util.ArrayList;

public class PessoaFisica extends Cliente implements ClienteOperacoes{

    public static ArrayList<PessoaFisica> clientesPf = new ArrayList<>();

    private String cpf;

    public PessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public void abrirConta(TipoConta tipo, int numero, int agencia){

        PessoaFisica titular = new PessoaFisica(nome, cpf);

        switch (tipo){
            case CONTA_CORRENTE:
                ContaCorrente.contas.add(new ContaCorrente(numero, agencia, titular));
                break;
            case CONTA_INVESTIMENTO:
                ContaPoupanca.contas.add(new ContaPoupanca(numero, agencia, titular));
                break;
            case CONTA_POUPANCA:
                ContaInvestimento.contas.add(new ContaInvestimento(numero, agencia, titular));
                break;
            default:
                System.out.println(OPCAO_INVALIDA);
                break;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "main.java.br.com.letscode.model.PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

}
