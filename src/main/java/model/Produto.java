package model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String nome;

    private String descricao;
    private int preco;

    //Muitos para 1
    @ManyToOne
    private Categoria categoria;

    private LocalDate dataCadastro = LocalDate.now();

    public Produto(String nome, String descricao, int preco,Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
