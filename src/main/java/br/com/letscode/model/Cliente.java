package main.java.br.com.letscode.model;

abstract public class Cliente {

    protected static final String OPCAO_INVALIDA = "A opção selecionada é inválida.";

    protected String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
