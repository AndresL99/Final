package com.alerner.demo.controller;

import com.alerner.demo.domain.Person;
import com.alerner.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController
{
    @Autowired
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person)
    {
        personService.addPerson(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person>getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>>getAll(){

        return ResponseEntity.ok(personService.getAllPerson());
    }


    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id)
    {
        personService.deletePersonById(id);
    }


}
