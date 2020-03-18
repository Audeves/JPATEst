/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persisntece;

import entity.Videogame;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lv1013
 */
public class VideogameRepository extends RepositoryBase<Videogame>{

    public VideogameRepository(EntityManager entityManager, Class<Videogame> cls) {
        super(entityManager, cls);
    }

    @Override
    public Videogame find(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Videojuegos");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        return entityManager.find(Videogame.class, id);
    }

    @Override
    public Videogame save(Videogame entity) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Videojuegos");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
         entityManager.persist(entity);
         entityManager.getTransaction().commit();
         System.out.println("El videojuego se ha guardado");
        return entity;
    }

    @Override
    public void delete(Videogame entity) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Videojuegos");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Videogame videogame = entityManager.find(Videogame.class, entity);
        if (videogame != null) {
            entityManager.remove(videogame);
        } else {
            System.out.println("El videojuego no fue encontrado");
           
        }

        entityManager.getTransaction().commit();
        System.out.println("El videojuego fue eliminado");
        
    }

    @Override
    public void commit() {
        
    }
    
}
