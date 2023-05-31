package Dao;

import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import Vo.RelatorioDeVendasVo;

import model.Pedido;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}


    public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}


	public  BigDecimal ValorTotalVendas() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}

	public BigDecimal MaiorValorDaColuna() {
		String jpql = "SELECT MAX(p.valorTotal) FROM Pedido p"; // query pedindo a media da tabela de pedido da coluna valorTotal
		return em.createQuery(jpql, BigDecimal.class).getSingleResult(); // getSingleResult -> Esperando apenas um resultado
	}

	public List<RelatorioDeVendasVo> relatorioDeVendas() { //Object -> significa que e um array de objetos onde retornara 3 tipos de dados
		String jpqlRelatorio = "SELECT new Vo.RelatorioDeVendasVo(produto.nome,SUM(item.quantidade),MAX(pedido.data)) FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto GROUP BY produto.nome ORDER BY item.quantidade DESC";
		return em.createQuery(jpqlRelatorio,RelatorioDeVendasVo.class).getResultList();
	}

	public Pedido buscarPedidoComCliente(Long id) {
		//Join Fetch so ira fazer a consulta quando for necessario e estiuver naquela tela
		String jpqlBuscarPedido = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id";
		return em.createQuery(jpqlBuscarPedido,Pedido.class).setParameter("id", id)
				.getSingleResult();
	}
}
