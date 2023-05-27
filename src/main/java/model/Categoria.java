package model;

import jakarta.persistence.*;

@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;


    public Categoria(){

    }

    private String nome;


    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
