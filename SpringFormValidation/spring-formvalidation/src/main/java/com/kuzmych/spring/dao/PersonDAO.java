package com.kuzmych.spring.dao;

import org.springframework.stereotype.Component;

import com.kuzmych.spring.models.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/SpringJDBCAPI";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private static Connection connection;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public List<Person> index() {
		List<Person> persons = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");

			while (resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setAge(resultSet.getInt("age"));
				person.setName(resultSet.getString("name"));
				person.setEmail(resultSet.getString("email"));
				persons.add(person);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return persons;

	}

	/*
	 * public Person show(int id) { for (Person person : people) { if
	 * (person.getId() == id) { return person; } } return null; }
	 */

	public void save(Person person) {
		
		
	}

	/*
	 * public void update(int id, Person updatedPerson) { Person personToBeUpdated =
	 * show(id);
	 * 
	 * personToBeUpdated.setName(updatedPerson.getName());
	 * personToBeUpdated.setAge(updatedPerson.getAge());
	 * personToBeUpdated.setEmail(updatedPerson.getEmail());
	 * 
	 * }
	 */

	/*
	 * public void delete(int id) { Iterator<Person> iterator = people.iterator();
	 * while (iterator.hasNext()) { Person person = iterator.next(); if
	 * (person.getId() == id) { iterator.remove(); break; } } }
	 */
}
