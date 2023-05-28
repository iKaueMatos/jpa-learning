package Controller;

import Dao.ClienteDao;
import Dao.PedidoDao;
import Dao.ProdutoDao;
import jakarta.persistence.EntityManager;
import model.Cliente;
import model.ItensPedido;
import model.Pedido;
import model.Produto;
import util.JPAutil;

public class CadastrarPedido {
   
    public static void main(String[] args) {
        CadastrarProduto.cadatrarProduto();
         //Recuperando o produto o banco de dados
        EntityManager insertPedido = JPAutil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(insertPedido);
        ClienteDao clienteDao = new ClienteDao(insertPedido);

        Produto produto = produtoDao.buscarPorid(1l);
        Cliente cliente = new Cliente("igor","47777111");
        clienteDao.cadastrar(cliente);

        insertPedido.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItensPedido(10, produto, pedido));
        PedidoDao pedidoDao = new PedidoDao(insertPedido);
        pedidoDao.cadastrar(pedido);

        insertPedido.getTransaction().commit();

    }
}
