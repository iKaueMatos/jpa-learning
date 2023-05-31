package model;

import jakarta.persistence.Embeddable;

//Extraindo dados da classe cliente
@Embeddable // classe embutida com a classe cliente
public class DadosPessoais {

    private String nome;
    private String cpf;

    public DadosPessoais(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public DadosPessoais() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
