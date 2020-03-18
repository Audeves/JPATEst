/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persisntece;

import entity.EntityBase;
import javax.persistence.EntityManager;

/**
 *
 * @author lv1013
 * @param <T>
 */
public abstract class RepositoryBase<T extends EntityBase>
        implements Repository<T> {

    private final EntityManager entityManager;
    private final Class<T> cls;

    protected RepositoryBase(EntityManager entityManager, Class<T> cls) {
        this.entityManager = entityManager;
        this.cls = cls;
    }

    @Override
    public T find(int id) {
        return (T) entityManager.find(cls, id);

    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public void commit() {
        
    }

}
