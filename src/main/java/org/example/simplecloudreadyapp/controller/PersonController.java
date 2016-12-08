package org.example.simplecloudreadyapp.controller;

import org.example.simplecloudreadyapp.model.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "personCtrl")
@RequestScoped
public class PersonController {
    
    public PersonController() {}
    
    public List<Person> getPersons() {
        return new ArrayList<>(Arrays.asList(new Person("Peter", "Fastert", 42)));
    }
}
