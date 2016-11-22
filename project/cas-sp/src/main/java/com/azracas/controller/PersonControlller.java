package com.azracas.controller;

/**
 * Created by arabbani on 11/19/16.
 */

import com.azracas.data.Person;
import com.azracas.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class PersonControlller {
    @Autowired
    private PersonRepo personRepository;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getAllPerson() {
        final List<Person> persons = new ArrayList<>();
        Iterable<Person> personIterable =  personRepository.findAll();
        for (Person p : personIterable) {
            persons.add(p);
        }
        return persons;
    }


    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseBody
    public String savePerson(@RequestBody Person p) {
        personRepository.save(p);
        return "OK";
    }
}