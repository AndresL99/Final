package com.alerner.demo.service;

import com.alerner.demo.domain.Person;
import com.alerner.demo.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

import static com.alerner.demo.util.TestEntityFactory.getListPerson;
import static com.alerner.demo.util.TestEntityFactory.getPerson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = PersonService.class)
class PersonServiceTest
{
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    public void setUp()
    {
        personRepository = mock(PersonRepository.class);
        personService = mock(PersonService.class);
    }

    @Test
    void addPersonTestOk()
    {
        //doNothing().when(personRepository).save(getPerson());
        personService.addPerson(getPerson());
        verify(personRepository,times(1)).save(getPerson());
    }

    @Test
    void getPersonByIdTestOk()
    {
        when(personRepository.findById(getPerson().getIdPerson())).thenReturn(Optional.of(getPerson()));
        Person person = getPerson();
        assertEquals(getPerson(),person);
    }

    @Test
    void getPersonByIdTestException()
    {
        when(personRepository.findById(anyLong())).thenThrow(HttpClientErrorException.class);
        assertThrows(HttpClientErrorException.class,()->personService.getPersonById(anyLong()));
    }

    @Test()
    void getPersonLisTok()
    {
        when(personRepository.findAll()).thenReturn(getListPerson());
        List<Person>list = personService.getAllPerson();
        assertEquals(getListPerson().size(),list.size());
    }


}
