package org.example.simplecloudreadyapp.repository;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenericJpaRepository<T> {
    
    public static final String ADDRESS="OPENSHIFT_MYSQL_DB_HOST";
    public static final String PORT="OPENSHIFT_MYSQL_DB_PORT";
    public static final String USER="OPENSHIFT_MYSQL_DB_USERNAME";
    private static final String PASSWORD="OPENSHIFT_MYSQL_DB_PASSWORD";

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericJpaRepository.class);

    protected EntityManager em;

    public GenericJpaRepository() {
        Map<String, Object> configOverrides = new HashMap<>();
        configOverrides.put("javax.persistence.jdbc.url", String.format("jdbc:mysql://%s:%s/testdb", System.getenv(ADDRESS), System.getenv(PORT)));
        configOverrides.put("javax.persistence.jdbc.user", System.getenv(USER));
        configOverrides.put("javax.persistence.jdbc.password", System.getenv(PASSWORD));
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testDbPersistenceUnit", configOverrides);
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
