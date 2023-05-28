package Controller;


import Dao.CategoriaDao;
import Dao.ClienteDao;
import Dao.PedidoDao;
import Dao.ProdutoDao;
import jakarta.persistence.EntityManager;
import model.Categoria;
import model.Cliente;
import model.Produto;
import util.JPAutil;

import java.util.List;


public class CadastrarProduto {

    public static void main(String[] args) {
        cadatrarProduto();
        EntityManager insert = JPAutil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(insert);

        Produto p = produtoDao.buscarPorid(1l);
        Produto p2 = produtoDao.buscarPorid(252l);
        System.out.println("\n------------");
        System.out.println("Consulta no banco de dados:\n");
        System.out.println(p.getNome());

        System.out.println("Buscando todos os produtos da tabela do banco de dados \n ");
        List<Produto> ConsultaTodosDados = produtoDao.buscarTodos();
        ConsultaTodosDados.forEach(consultaTodos -> System.out.println(p.getNome()));

        System.out.println("Buscando por nome: \n ");
        List<Produto> BuscaPorNome = produtoDao.buscarPorNome("felipe");
        BuscaPorNome.forEach(ConsultaNome -> System.out.println(p2.getNome()));

        System.out.println("Buscando por Preco: \n ");
        int BuscaPorPreco = produtoDao.buscarPrecoProdutoLimit("kaue");
        System.out.println(p2.getPreco());

    }
    public static void cadatrarProduto() {

        Categoria celulares = new Categoria("Celulares");

        Produto produto = new Produto("felipe","Otimo",10, celulares);


        EntityManager insert = JPAutil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(insert);
        CategoriaDao categoriaDao = new CategoriaDao(insert);
        ClienteDao clienteDao = new ClienteDao(insert);

            insert.getTransaction().begin();
            produtoDao.cadastrar(produto);
            categoriaDao.cadastrar(celulares);

            insert.getTransaction().commit();
            insert.close();

    }
}
