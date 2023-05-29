package Dao;

import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
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
}
