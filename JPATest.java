/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpatest;

import entities.Achievement;
import entities.Videogame;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistence.VideoGameRepository;
import persistence.VideoGameRepositoryImpl;

/**
 *
 * @author Axel
 */
public class JPATest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JPATestPU");
        EntityManager entityManager = managerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
        Videogame videogame = new Videogame();
        videogame.setName("God of War");
        videogame.setRating(5);
        
        Achievement a = new Achievement();
        a.setName("Level 1");
        a.setVideogame(videogame);
        videogame.getAchievements().add(a);
        
//        entityManager.persist(a);
//        entityManager.persist(videogame);

//        entityManager.getTransaction().commit();
        
        VideoGameRepository repository = new VideoGameRepositoryImpl(entityManager);
        repository.save(videogame);
        repository.commit();
        
        List<Videogame> rating4 = repository.findByRating(4);
        List<Videogame> god = repository.searchByName("god");
//                
//        VideoGame videogame2 = new VideoGame();
//        videogame2.setName("Gears of War");
//        videogame2.setRating(4);
//        repository.save(videogame2);
//        repository.commit();
    }
    
}
