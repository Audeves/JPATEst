/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persisntece;

import entity.EntityBase;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author lv1013
 * @param <T>
 */
public abstract class RepositoryBase<T extends EntityBase> implements Repository<T> {

    protected final EntityManager entityManager;
    protected final Class<T> cls;

    protected RepositoryBase(EntityManager entityManager, Class<T> cls) {
        this.entityManager = entityManager;
        this.cls = cls;
    }

    @Override
    public T find(int id) {
        T entity = this.entityManager.find(cls, id);
        return entity;

    }

    @Override
    public T save(T entity) {
        this.ensureTransaction();
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
            return entity;
        } else {
            return this.entityManager.merge(entity);
        }
    }

    @Override
    public void delete(T entity) {
        this.ensureTransaction();
        this.entityManager.remove(entity);
    }

    @Override
    public void commit() {
        EntityTransaction transaction = this.entityManager.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }

    protected void ensureTransaction() {
        EntityTransaction transaction = this.entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }
}
