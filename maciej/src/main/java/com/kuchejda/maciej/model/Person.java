package com.kuchejda.maciej.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Person {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 
	 @Column(name="Person_Login")
	 private String userLogin;
	 
	 @Column(name="Person_Password")
	 private String userPassword;
	
	 @Column(name="FirstName")
	 private String firstName;
	 
	 @Column(name="LastName")
	 private String lastName;


	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
}
