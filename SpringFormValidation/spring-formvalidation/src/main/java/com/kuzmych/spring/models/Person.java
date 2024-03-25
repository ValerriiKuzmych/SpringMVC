package com.kuzmych.spring.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

	private int id;

	@Min(value = 18, message = "Age should be greater tha 18")
	private int age;
	@NotEmpty(message = "Email should be not empty")
	@Email(message = "Email should be valid")
	private String email;
	@NotEmpty(message = "Name should not be empty")
	@Size(min = 2, max = 30, message = "Name shuld be between 2 and 30 characters")
	private String name;

	public Person() {

	}

	public Person(int id, int age, String email, String name) {

		this.id = id;
		this.age = age;
		this.email = email;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}