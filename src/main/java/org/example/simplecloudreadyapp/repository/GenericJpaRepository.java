package org.example.simplecloudreadyapp.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericJpaRepository<T> {
    
    protected EntityManager em;
    
    public GenericJpaRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testDbPersistenceUnit");
        em = emf.createEntityManager();
    }
    
    public void persist(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    
    public void remove(T entity) {
        em.remove(entity);
    }
}
