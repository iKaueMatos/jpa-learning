package model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Itens_pedido")
public class ItensPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal precoUnitario;

    private int quantidade;

    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Produto produto;

    public ItensPedido(){

    }

    public ItensPedido(int quantidade, Produto produto,Pedido pedido) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.precoUnitario = BigDecimal.valueOf(produto.getPreco());
        this.pedido = pedido;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
