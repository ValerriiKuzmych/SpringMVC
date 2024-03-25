package com.kuzmych.spring.dao;

import org.springframework.stereotype.Component;

import com.kuzmych.spring.models.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	public Person show(int id) {

		Person person = null;

		PreparedStatement preparedStatement;

		try {

			preparedStatement = connection.prepareStatement("SELECT * FROM Persons WHERE id = ?");

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			person = new Person();

			person.setId(resultSet.getInt("id"));
			person.setAge(resultSet.getInt("age"));
			person.setName(resultSet.getString("name"));
			person.setEmail(resultSet.getString("email"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;

	}

	public void save(Person person) {

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO Persons VALUES (?, ?, ?, ?)");

			preparedStatement.setInt(2, person.getAge());
			preparedStatement.setString(3, person.getName());
			preparedStatement.setString(4, person.getEmail());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(int id, Person updatedPerson) {

		PreparedStatement preparedStatement;

		try {

			preparedStatement = connection.prepareStatement("UPDATE Persons SET age=?, name=?, email=? WHERE id=?");

			preparedStatement.setInt(1, updatedPerson.getAge());
			preparedStatement.setString(2, updatedPerson.getName());
			preparedStatement.setString(3, updatedPerson.getEmail());
			preparedStatement.setInt(4, updatedPerson.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		PreparedStatement preparedStatement;

		try {

			preparedStatement = connection.prepareStatement("DELETE FROM Persons WHERE id=?");

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
