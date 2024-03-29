package dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import models.Person;

@Component
public class PersonDAO {

	private static int PEOPLE_COUNT;

	private List<Person> people;

	{
		people = new ArrayList<>();

		people.add(new Person(++PEOPLE_COUNT, "Mike"));
		people.add(new Person(++PEOPLE_COUNT, "Din"));
		people.add(new Person(++PEOPLE_COUNT, "Bob"));
	}

	public List<Person> index() {
		return people;
	}

	public Person show(int id) {

		return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
	}

	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	};

	public void updatePersonName(int id, Person person) {

		Person updatePerson = show(id);
		updatePerson.setName(person.getName());
	};

	public void delete(int id) {

		people.removeIf(p -> p.getId() == id);
	};

}
