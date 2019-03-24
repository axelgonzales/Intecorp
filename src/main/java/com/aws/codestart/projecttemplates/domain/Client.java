package com.aws.codestart.projecttemplates.domain;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Valid
public class Client {
	
	@JsonIgnore
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private String birthDay;
	
	public Client(){
		id=0;
	}

	public Client(long id, String firstName, String lastName, String birthday,int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.birthDay = birthDay;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}



	
	
	

}
