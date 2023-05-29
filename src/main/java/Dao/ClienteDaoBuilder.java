package Dao;

import jakarta.persistence.EntityManager;

public class ClienteDaoBuilder {
    private EntityManager em;

    public ClienteDaoBuilder setEm(EntityManager em) {
        this.em = em;
        return this;
    }

    public ClienteDao createClienteDao() {
        return new ClienteDao(em);
    }
}