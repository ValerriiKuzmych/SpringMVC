package com.kuzmych.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kuzmych.spring.models.Person;

import java.util.List;

@Component
public class PersonDAO {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PersonDAO(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Person> index() {

		return jdbcTemplate.query("SELECT * FROM Persons", new BeanPropertyRowMapper<>(Person.class));

	}

	public Person show(int id) {

		return jdbcTemplate.query("SELECT * FROM Persons WHERE id=?", new Object[] { id },
				new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);

	}

	public void save(Person person) {

		jdbcTemplate.update("INSERT INTO Persons VALUES (1, ?, ?, ?)", person.getAge(), person.getName(), person.getEmail());

	}

	public void update(int id, Person updatedPerson) {

		jdbcTemplate.update("UPDATE Persons SET age=?, name=?, email=? WHERE id=?", updatedPerson.getAge(), updatedPerson.getName(), updatedPerson.getEmail(), id );

	}

	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM Persons WHERE id=?", id);

	}

}
