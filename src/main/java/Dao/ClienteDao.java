package Dao;

import jakarta.persistence.EntityManager;
import model.Cliente;
import model.Pedido;
import model.Produto;

public class ClienteDao {

    private EntityManager inicialize;

    public ClienteDao(EntityManager inicialize) {
        this.inicialize = inicialize;
    }

    public void cadastrar(Cliente cliente) {
        this.inicialize.persist(cliente);
    }

    public Cliente buscarPorid(Long id) {
        return inicialize.find(Cliente.class,id);
    }

}
