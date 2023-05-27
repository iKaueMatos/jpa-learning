package Dao;

import jakarta.persistence.EntityManager;
import model.Categoria;


public class CategoriaDao {
    private EntityManager inicialize;



    public CategoriaDao(EntityManager inicialize) {
        this.inicialize = inicialize;
    }

    public void cadastrar(Categoria categoria) {
        this.inicialize.persist(categoria);
    }

}
