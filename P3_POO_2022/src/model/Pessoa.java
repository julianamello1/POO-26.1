package model;

import java.util.Objects;

public class Pessoa {

    private final long cpf;
    private String nome;
    private String endereco;

    public Pessoa(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public long getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return cpf == pessoa.cpf;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}