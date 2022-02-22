package com.alerner.demo.service;

import com.alerner.demo.domain.Person;
import com.alerner.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonService
{
    private PersonRepository personRepository;

    /*public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
*/
    public void addPerson(Person person)
    {
        personRepository.save(person);
    }

    public Person getPersonById(Long id)
    {
        return personRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Person>getAllPerson()
    {
        return personRepository.findAll();
    }

    public void deletePersonById(Long id)
    {
        personRepository.deleteById(id);
    }
}
