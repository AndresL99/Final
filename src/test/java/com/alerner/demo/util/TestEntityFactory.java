package com.alerner.demo.util;

import com.alerner.demo.api.Covid19;
import com.alerner.demo.domain.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestEntityFactory
{
    public static Person getPerson()
    {
        return Person.builder().idPerson(1L).name("Andres").lastName("Lerner").build();
    }

    public static List<Person>getListPerson()
    {
        List<Person>personList = new ArrayList<>();
        personList.add(getPerson());
        return personList;
    }

    public static Covid19 getData()
    {
        Covid19 covid19 = new Covid19();
        covid19.setContinent("Argentina");
        covid19.setTotal(300000);
        covid19.setTime(LocalDateTime.now());
        return covid19;
    }




}
