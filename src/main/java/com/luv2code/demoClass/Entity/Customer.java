package com.luv2code.demoClass.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
   public Customer() {
	   
   }	
	
   @Id
   // key是由資料表自動遞增產生的
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
   private int id;
   
   @Column(name="first_name")
   private String firstName;
   
   @Column(name="last_name")
   private String lastName;
   
   @Column(name="email")
   private String email;
   

public int getId() {
	return id;
}
public void setId(int id) {
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
   


   
}
