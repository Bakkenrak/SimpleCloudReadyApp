package org.example.simplecloudreadyapp.repository;

import java.util.List;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.example.simplecloudreadyapp.model.Person;

/**
 *
 * @author christian
 */
@Named
public class PersonJpaRepository extends GenericJpaRepository<Person> {

    public List<Person> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        CriteriaQuery<Person> query = cq.select(cq.from(Person.class));
        
        return em.createQuery(query).getResultList();
    }
    
}
