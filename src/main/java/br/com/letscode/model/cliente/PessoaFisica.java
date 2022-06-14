package main.java.br.com.letscode.model.cliente;

import main.java.br.com.letscode.model.conta.ContaCorrente;
import main.java.br.com.letscode.model.conta.ContaInvestimento;
import main.java.br.com.letscode.model.conta.ContaPoupanca;
import main.java.br.com.letscode.model.conta.TipoConta;

import java.util.ArrayList;
import java.util.Objects;


import static main.java.br.com.letscode.model.conta.Conta.INVALIDO;

public class PessoaFisica extends Cliente{

    public static ArrayList<PessoaFisica> clientesPf = new ArrayList<>();

    private String cpf;

    private PessoaFisica(String cpf){
        super();
        this.cpf = cpf;
    }

    public PessoaFisica(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public static void abrirConta(TipoConta tipo, int numero, int agencia, PessoaFisica titular){

        switch (tipo){
            case CONTA_CORRENTE:
                ContaCorrente.contas.add(new ContaCorrente(numero, agencia, titular));
                break;
            case CONTA_POUPANCA:
                ContaPoupanca.contas.add(new ContaPoupanca(numero, agencia, titular));
                break;
            case CONTA_INVESTIMENTO:
                ContaInvestimento.contas.add(new ContaInvestimento(numero, agencia, titular));
                break;
            default:
                System.out.println(INVALIDO);
                break;
        }
    }

    public static PessoaFisica encontrar(String chave) {
        PessoaFisica temp = new PessoaFisica(chave);
        int indexCliente = clientesPf.indexOf(temp);
        if(indexCliente >= 0) {
            return clientesPf.get(indexCliente);
        }else {
            System.out.println(NAO_ENCONTRADO);
            return null;
        }
    }

    public static void criarCliente(PessoaFisica cliente){
        clientesPf.add(cliente);
    }

    @Override
    public String toString() {
        return "main.java.br.com.letscode.model.cliente.PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(cpf, that.cpf);
    }

}
