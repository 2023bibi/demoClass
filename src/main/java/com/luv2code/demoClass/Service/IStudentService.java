package com.luv2code.demoClass.Service;

import java.util.List;

import com.luv2code.demoClass.Entity.Student;

public interface IStudentService {

	public List<Student> getStudents();
	
	public Student getStudent(int studentId);
   
	public String  delStudent(int studentId);
	
	public String  addStudent(Student student);
	
	public String  updStudent(Student student,int studentId);
	   
}
