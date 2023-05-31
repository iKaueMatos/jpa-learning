package Controller;

import Dao.CategoriaDao;
import Dao.ClienteDao;
import Dao.PedidoDao;
import Dao.ProdutoDao;
import Vo.RelatorioDeVendasVo;
import jakarta.persistence.EntityManager;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import util.JPAutil;
import model.Categoria;

import java.math.BigDecimal;
import java.util.List;


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

		BigDecimal MaiorValorDaColuna = pedidoDao. MaiorValorDaColuna();
		System.out.println("Maior valor da coluna: " +  MaiorValorDaColuna);

		//Método de busca RelatorioDeVendasVo
		List<RelatorioDeVendasVo> relatorioDeDados = pedidoDao.relatorioDeVendas();
		relatorioDeDados.forEach(System.out::println); // exibindo dados do relatorio

		//Query buscando pedido do cliente
		PedidoDao BuscarPedidoDoCliente = new PedidoDao(em);
		Pedido pedido1 = pedidoDao.buscarPedidoComCliente(3l);
		System.out.println(pedido1.getCliente().getNome());

		//Teste criteria
		PedidoDao BuscarParametrosComCriteria = new PedidoDao(em);
		List<Produto> pedido2 = pedidoDao.buscaPorParametrosComCriteria("Macbook",null,null);
		pedido2.forEach(System.out::println);

		em.getTransaction().commit();

	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria notebooks = new Categoria("NOTEBOOKS");
		Categoria videoGames = new Categoria("VIDEO GAMES");
		Categoria carros = new Categoria("Carros");

		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
		Produto notebook = new Produto("Macbook","Otimo",new BigDecimal("1000"),notebooks);
		Produto videoGame = new Produto("PS5","muito ruim",new BigDecimal("5000"),videoGames);
		Produto carro = new Produto("Fusca de brinquedo","Otimo",new BigDecimal("10000000"),carros);

		Cliente cliente = new Cliente("Kaue de matos", "123456");

		EntityManager em = JPAutil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(notebooks);
		categoriaDao.cadastrar(videoGames);
		categoriaDao.cadastrar(carros);
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(notebook);
		produtoDao.cadastrar(videoGame);
		produtoDao.cadastrar(carro);
		clienteDao.cadastrar(cliente);

		em.getTransaction().commit();
		em.close();
	}

}
