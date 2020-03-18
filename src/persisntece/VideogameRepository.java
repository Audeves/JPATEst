/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persisntece;

import entity.Videogame;
import javax.persistence.EntityManager;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Videogame save(Videogame entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Videogame entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
