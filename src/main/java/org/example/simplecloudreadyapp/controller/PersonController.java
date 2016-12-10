package org.example.simplecloudreadyapp.controller;

import org.example.simplecloudreadyapp.model.Person;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.example.simplecloudreadyapp.facade.PersonFacade;

@Named(value = "personCtrl")
@RequestScoped
public class PersonController {
    
    @Inject
    private PersonFacade personFacade;
    
    public PersonController() {}
    
    public List<Person> getPersons() {
        //return new ArrayList<>(Arrays.asList(new Person("Peter", "Fastert", 42)));
        return personFacade.getAllPersons();
    }
}
