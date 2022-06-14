package main.java.br.com.letscode.model.cliente;

import main.java.br.com.letscode.model.conta.ContaCorrente;
import main.java.br.com.letscode.model.conta.ContaInvestimento;
import main.java.br.com.letscode.model.conta.TipoConta;

import java.util.ArrayList;
import java.util.Objects;


import static main.java.br.com.letscode.model.conta.Conta.INVALIDO;

public class PessoaJuridica extends Cliente {

    public static ArrayList<PessoaJuridica> clientesPj = new ArrayList<>();

    private String cnpj;

    private PessoaJuridica(String cnpj){
        this.cnpj = cnpj;
    }

    public PessoaJuridica(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public static void abrirConta(TipoConta tipo, int numero, int agencia, PessoaJuridica titular) {

        switch (tipo) {
            case CONTA_CORRENTE:
                ContaCorrente.contas.add(new ContaCorrente(numero, agencia, titular));
                break;
            case CONTA_INVESTIMENTO:
                ContaInvestimento.contas.add(new ContaInvestimento(numero, agencia, titular));
                break;
            default:
                System.out.println(INVALIDO);
                break;
        }
    }

    public static PessoaJuridica encontrar(String chave) {
        PessoaJuridica temp = new PessoaJuridica(chave);
        int indexCliente = clientesPj.indexOf(temp);
        if (indexCliente >= 0) {
            return clientesPj.get(indexCliente);
        }else {
            System.out.println(NAO_ENCONTRADO);
            return null;
        }
    }

    public static void criarCliente(PessoaJuridica cliente){
        clientesPj.add(cliente);
    }

    @Override
    public String toString() {
        return "main.java.br.com.letscode.model.cliente.PessoaJuridica{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaJuridica that = (PessoaJuridica) o;
        return Objects.equals(cnpj, that.cnpj);
    }
}
