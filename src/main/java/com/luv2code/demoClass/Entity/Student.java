package com.luv2code.demoClass.Entity;

public class Student {
   private int StudentId;
   private String firstName;
   private String lastName;
   
   public Student(int StudentId,String firstName,String lastName) {
	   setStudentId(StudentId);
	   setFirstName(firstName);
	   setLastName(lastName);
   }
   
   
public int getStudentId() {
	return StudentId;
}


public void setStudentId(int studentId) {
	StudentId = studentId;
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
