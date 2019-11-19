package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMFBootstrapper {
    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("LocalflixPersistenceUnit");

    private EMFBootstrapper() {}

    public static EntityManager openEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
