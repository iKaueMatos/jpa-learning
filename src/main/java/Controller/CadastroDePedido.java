package Controller;

import Dao.CategoriaDao;
import Dao.ClienteDao;
import Dao.PedidoDao;
import Dao.ProdutoDao;
import jakarta.persistence.EntityManager;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import util.JPAutil;
import model.Categoria;

import java.math.BigDecimal;


public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = util.JPAutil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		Produto produto = produtoDao.buscarPorId(2l);
		Cliente cliente = clienteDao.buscarPorId(1l);

		em.getTransaction().begin();

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));

		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);

		BigDecimal totalVendido = pedidoDao.ValorTotalVendas();
		System.out.println("Valor total de vendas:" + totalVendido);

		em.getTransaction().commit();

	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );

		Cliente cliente = new Cliente("Kaue de matos", "123456");

		EntityManager em = JPAutil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);

		em.getTransaction().commit();
		em.close();
	}

}
