package dao;

import java.util.ArrayList;


import java.util.List;

import org.springframework.stereotype.Component;

import models.Person;


@Component
public class PersonDAO {
	
private List<Person> people;
	
	
	{
		people = new ArrayList<>();
		
		people.add(new Person(0, "Mike"));
		people.add(new Person(1, "Din"));
		people.add(new Person(2, "Bob"));
	}


	public List<Person> index() {
		return people;
	}


	public Person show(int id) {
		
		return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
	}

}
