package com.uca.capas.domain;

import java.util.Date;

public class Student {
	private String name;
	private String lastName;
	private String bDate;
	private String career;
	private String experience;
	
	
	public Student() {
		super();
	}

	

	public Student(String name, String lastName, String bDate, String career, String experience) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.bDate = bDate;
		this.career = career;
		this.experience = experience;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getbDate() {
		return bDate;
	}


	public void setbDate(String bDate) {
		this.bDate = bDate;
	}


	public String getCareer() {
		return career;
	}


	public void setCareer(String career) {
		this.career = career;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	
	
}
