package main.java.br.com.letscode.model.cliente;

import java.util.Objects;

abstract public class Cliente {

    protected static final String NAO_ENCONTRADO = "Cliente não encontrado!";

    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome);
    }
}
