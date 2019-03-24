package com.aws.codestart.projecttemplates.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Client {
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private String birthday;
	
	public Client(){
		id=0;
	}

	public Client(long id, String firstName, String lastName, String birthday,int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.birthday = birthday;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	

}
