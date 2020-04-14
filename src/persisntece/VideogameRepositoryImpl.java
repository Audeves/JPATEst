/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persisntece;

import entity.Videogame;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Desktop
 */
public class VideogameRepositoryImpl extends RepositoryBase<Videogame> implements VideogameRepository{

    public VideogameRepositoryImpl(EntityManager entityManager, Class<Videogame> cls) {
        super(entityManager, cls);
    }

    @Override
    public List<Videogame> findByRating(int rating) {
        TypedQuery<Videogame> q = this.entityManager.createQuery("SELECT v FROM Videogame v WHERE v.rating = :rating", this.cls);
        q.setParameter("rating", rating);
        return q.getResultList();
    }

    @Override
    public List<Videogame> searchByName(String name) {
        if (name == null || name.isEmpty()) {
            // ""
        }

        TypedQuery<Videogame> q = this.entityManager.createQuery("SELECT v FROM Videogame v WHERE v.name LIKE :name", this.cls);
        q.setParameter("name", "%" + name + "%");
        return q.getResultList();
    }
    
}
