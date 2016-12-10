package org.example.simplecloudreadyapp.facade;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.example.simplecloudreadyapp.model.Person;
import org.example.simplecloudreadyapp.repository.PersonJpaRepository;

@Named
public class PersonFacade {
    @Inject
    private PersonJpaRepository personJpaRepository;
    
    public List<Person> getAllPersons() {
        return personJpaRepository.getAll();
    }
}
