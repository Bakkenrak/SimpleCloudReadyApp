package org.example.simplecloudreadyapp.controller;

import org.example.simplecloudreadyapp.model.Person;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.example.simplecloudreadyapp.facade.PersonFacade;
import org.example.simplecloudreadyapp.repository.GenericJpaRepository;

@Named(value = "personCtrl")
@RequestScoped
public class PersonController {
    
    @Inject
    private PersonFacade personFacade;
    
    public PersonController() {}
    
    public List<Person> getPersons() {
        return personFacade.getAllPersons();
    }
    
    public String getDbConnection() {
        return String.format("Connecting to DB at %s:%s as user %s", 
                System.getenv(GenericJpaRepository.ADDRESS), System.getenv(GenericJpaRepository.PORT), System.getenv(GenericJpaRepository.USER));
    }
}
