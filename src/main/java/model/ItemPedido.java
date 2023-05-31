package model;

import jakarta.persistence.*;

import java.math.BigDecimal;

//ManyToOne -> muitos para 1
//oneToMany -> 1 para muitos
//oneToOne -> 1 para 1

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;

	private int quantidade;

	//Muitos para 1
	//ManyToOne esse tipo de relacionamento sempre tem que ter um fetch = FetchType.Lazy -> Significa que so sera carregado
	//Se for acessado,se tiver um metodo chamando ele!
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	//ManyToOne esse tipo de relacionamento sempre tem que ter um fetch = FetchType.Lazy -> Significa que so sera carregado
	//Se for acessado,se tiver um metodo chamando ele!
	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;

	public ItemPedido() {
	}

	public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.precoUnitario = produto.getPreco();
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getValor() {
		return precoUnitario.multiply(new BigDecimal(quantidade));
	}
}
