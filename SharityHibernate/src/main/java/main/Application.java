package main;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class Application {

    public static void main(String[] args) {

        Usuario akiraUser = new Usuario("Akira", "notapassword");
        Usuario stanleyUser = new Usuario("Stanley", "madremia");
        Evento caridadPerros = new Evento("Caridad perros","Calle 41 no.10");
        Evento caridadGatos = new Evento("Caridad Gatos","Calle 23 no.12");
        Recurso comidaPerros = new Recurso("Croquetas para perros KG",15);
        Recurso comidaGatos = new Recurso("Croquetas para gatos KG",45);
        Recurso ropaPerros = new Recurso("Ropa para perros en temporada de frio",145);
        caridadPerros.setUser(akiraUser);
        caridadGatos.setUser(stanleyUser);
        comidaPerros.setEvent(caridadPerros);
        ropaPerros.setEvent(caridadPerros);
        comidaGatos.setEvent(caridadGatos);


       
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(comidaPerros);
            manager.persist(comidaGatos);
            manager.persist(ropaPerros);
            transaction.commit();
        }
        catch(PersistenceException e) {
            transaction.rollback();
            throw e;
        }
        finally {
            manager.close();
        }
    }
}
