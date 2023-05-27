package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAutil {

    private static final EntityManagerFactory FACTORY = Persistence.
            createEntityManagerFactory("curso");

    //Meto que sera chamado em qualquer lugar do projeto se for necessario
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
