package model.produtos;

import jakarta.persistence.Entity;
import model.Categoria;
import model.Produto;

import java.math.BigDecimal;

//Livro um herança de produto -> onde sera mapeado no banco de dados
@Entity
public class Livro extends Produto {

    private String autor;
    private Integer numeroDePaginas;

    public Livro(){

    }
    public Livro(String autor, Integer numeroDePaginas) {
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    public Livro(String nome, String descricao, BigDecimal preco, Categoria categoria, String autor, Integer numeroDePaginas) {
        super(nome, descricao, preco, categoria);
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
}
