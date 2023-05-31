package model.produtos;

import jakarta.persistence.Entity;
import model.Categoria;
import model.Produto;

import java.math.BigDecimal;

@Entity
public class Informatica extends Produto {

    private String marca;
    private String modelo;


    public Informatica(){

    }
    public Informatica(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Informatica(String nome, String descricao, BigDecimal preco, Categoria categoria, String marca, String modelo) {
        super(nome, descricao, preco, categoria);
        this.marca = marca;
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
