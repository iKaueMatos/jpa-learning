package Dao;

import jakarta.persistence.EntityManager;
import model.Produto;
import java.util.List;

public class ProdutoDao {

    private EntityManager inicialize;

    public ProdutoDao(EntityManager inicialize) {
        this.inicialize = inicialize;
    }

    public void cadastrar(Produto cliente) {
        this.inicialize.persist(cliente);
    }

    public void atualizar(Produto cliente) {
        this.inicialize.merge(cliente);
    }

    //Faz a busca no banco de dados e retorna o dado para o usuario
    public Produto buscarPorid(Long id) {
       return inicialize.find(Produto.class,id);
    }

    public List<Produto> buscarTodos() {
        //JPQL -> Java persistece query language
        String jpql = "SELECT p FROM Produto AS p";
        //createquery so cria a query ele não dispara ela no banco de dados para obter o disparo da query utilizamos o getResultList
        return inicialize.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        //Consulta com WHERE -> utilizando um parametro no final
        String jpql = "SELECT p FROM Produto AS p WHERE p.nome = :nome";
        //createquery so cria a query ele não dispara ela no banco de dados para obter o disparo da query utilizamos o getResultList
        return inicialize.createQuery(jpql, Produto.class)
                .setParameter("nome",nome)
                .getResultList();
    }

    public int buscarPrecoProdutoLimit(String nome) {
        //Consulta com WHERE -> utilizando um parametro no final
        String jpql = "SELECT p.preco FROM Produto AS p WHERE p.nome = :nome";
        //createquery so cria a query ele não dispara ela no banco de dados para obter o disparo da query utilizamos o getResultList
        return inicialize.createQuery(jpql, Produto.class)
                .setParameter("nome",nome)
                .getSingleResult().getId();
    }

}



