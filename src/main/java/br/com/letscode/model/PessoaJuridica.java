package main.java.br.com.letscode.model;

import java.util.ArrayList;

public class PessoaJuridica extends Cliente {

    public static ArrayList<PessoaJuridica> clientesPj = new ArrayList<>();

    private String cnpj;

    public PessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    public void abrirConta(TipoConta tipo, int numero, int agencia){

        PessoaJuridica titular = new PessoaJuridica(nome, cnpj);

        switch (tipo){
            case CONTA_CORRENTE:
                ContaCorrente.contas.add(new ContaCorrente(numero, agencia, titular));
                break;
            case CONTA_INVESTIMENTO:
                ContaPoupanca.contas.add(new ContaPoupanca(numero, agencia, titular));
                break;
            default:
                System.out.println(OPCAO_INVALIDA);
                break;
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "main.java.br.com.letscode.model.PessoaJuridica{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
