package com.kuzmych.spring.dao;

import org.springframework.stereotype.Component;

import com.kuzmych.spring.models.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, 32, "tom@gmail.com", "Tom"));
        people.add(new Person(++PEOPLE_COUNT, 24, "bob@gmail.com", "Bob"));
        people.add(new Person(++PEOPLE_COUNT, 29, "mike@gmail.com", "Mike"));
        people.add(new Person(++PEOPLE_COUNT, 28, "katy@gmail.com", "Katy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
        
    }

    public void delete(int id) {
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getId() == id) {
                iterator.remove();
                break; 
            }
        }
    }
}
