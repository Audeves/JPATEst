/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persisntece;

import entity.Videogame;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lv1013
 */
public interface VideogameRepository extends Repository<Videogame> {

    List<Videogame> findByRating(int rating);

    List<Videogame> searchByName(String name);

}
