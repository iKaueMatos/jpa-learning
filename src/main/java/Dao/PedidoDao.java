package Dao;

import jakarta.persistence.EntityManager;
import model.Pedido;
import model.Produto;

import java.util.List;

public class PedidoDao {
    private EntityManager inicialize;

    public PedidoDao(EntityManager inicialize) {
        this.inicialize = inicialize;
    }

    public void cadastrar(Pedido pedido) {
        this.inicialize.persist(pedido);
    }
}
